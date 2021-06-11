package org.sandboxpowered.api.extensions

import org.sandboxpowered.api.addon.SandboxAPI
import org.sandboxpowered.api.addon.service.CreationService
import org.sandboxpowered.api.engine.Game
import org.sandboxpowered.api.engine.Platform
import org.sandboxpowered.api.entity.Component
import org.sandboxpowered.api.entity.Entity
import org.sandboxpowered.api.network.Packet
import org.sandboxpowered.api.network.PacketBuffer
import org.sandboxpowered.api.registry.DeferredRegistrar
import org.sandboxpowered.api.registry.RegistryEntry
import org.sandboxpowered.api.registry.RegistryObject
import org.sandboxpowered.api.util.Identifier
import java.util.*
import kotlin.properties.ReadOnlyProperty
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

@JvmSynthetic
inline fun <reified T : Packet> Game.registerPacket(side: Platform.Type, noinline reader: (buffer: PacketBuffer) -> T) =
    registerPacket(T::class.java, reader, side)

@JvmSynthetic
inline fun <reified C : Component> Entity.hasComponent(): Boolean = hasComponent(C::class.java)

@JvmSynthetic
inline fun <reified C : Component> Entity.getComponent(): C? = getComponent(C::class.java)

@JvmInline
private value class RegistryObjectSafeDelegate<T : RegistryEntry<T>>(val registryObject: RegistryObject<T>) :
    ReadOnlyProperty<Any?, T?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
        if (registryObject.isPresent) registryObject.get() else null
}

@JvmSynthetic
inline fun <reified S : CreationService> SandboxAPI.getCreationService(): Optional<S> {
    return getCreationService(S::class.java)
}

@JvmSynthetic
inline fun <reified S : CreationService> SandboxAPI.useCreationService(noinline block: (S) -> Unit) {
    getCreationService(S::class.java).ifPresent {
        block(it)
    }
}