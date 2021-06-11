package org.sandboxpowered.api.extensions

import org.sandboxpowered.api.engine.Game
import org.sandboxpowered.api.engine.Platform
import org.sandboxpowered.api.network.Packet
import org.sandboxpowered.api.network.PacketBuffer
import org.sandboxpowered.api.registry.DeferredRegistrar
import org.sandboxpowered.api.registry.RegistryEntry
import org.sandboxpowered.api.registry.RegistryObject
import org.sandboxpowered.api.util.Identifier
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

@JvmSynthetic
operator fun <T : RegistryEntry<T>> RegistryObject<T>.getValue(thisRef: Any?, property: KProperty<*>): T = get()

@JvmSynthetic
fun <T : RegistryEntry<T>> DeferredRegistrar<T>.registerNullable(
    name: String,
    supplier: () -> T
): ReadOnlyProperty<Any?, T?> = RegistryObjectSafeDelegate(register(name, supplier))

@JvmSynthetic
fun <T : RegistryEntry<T>> DeferredRegistrar<T>.registerNullable(
    id: Identifier,
    supplier: () -> T
): ReadOnlyProperty<Any?, T?> = RegistryObjectSafeDelegate(register(id, supplier))

inline fun <reified T : Packet> Game.registerPacket(side: Platform.Type, noinline reader: (buffer: PacketBuffer) -> T) =
    registerPacket(T::class.java, reader, side)

@JvmInline
private value class RegistryObjectSafeDelegate<T : RegistryEntry<T>>(val registryObject: RegistryObject<T>) :
    ReadOnlyProperty<Any?, T?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
        if (registryObject.isPresent) registryObject.get() else null
}
