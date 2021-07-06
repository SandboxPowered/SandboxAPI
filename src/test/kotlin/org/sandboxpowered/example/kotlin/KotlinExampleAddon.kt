package org.sandboxpowered.example.kotlin

import org.sandboxpowered.api.engine.Sandbox
import org.sandboxpowered.api.addon.SandboxAPI
import org.sandboxpowered.api.addon.service.resource.ResourceConstants
import org.sandboxpowered.api.addon.service.resource.ResourceService
import org.sandboxpowered.api.content.block.Block
import org.sandboxpowered.api.engine.Platform
import org.sandboxpowered.api.extensions.getValue
import org.sandboxpowered.api.extensions.registerNullable
import org.sandboxpowered.api.extensions.registerPacket
import org.sandboxpowered.api.extensions.useCreationService
import org.sandboxpowered.api.content.item.Item
import org.sandboxpowered.example.ExamplePacket
import org.sandboxpowered.example.ExplodingStaffItem

fun setup(api: SandboxAPI) {
    val itemRegistrar = api.getRegistrar(Item.REGISTRY)
    val blockRegistrar = api.getRegistrar(Block.REGISTRY)

    val exampleItem by itemRegistrar.register("example_item") {
        Item.create(Item.Properties.builder().build())
    }

    val explodingStaff by itemRegistrar.registerNullable("exploding_staff") {
        ExplodingStaffItem(Item.Properties.builder().setDurability(200).build(), exampleItem)
    }

    Sandbox.getGame().registerPacket(Platform.Type.SERVER, ::ExamplePacket)

    api.useCreationService<ResourceService> {
        it.add(ResourceConstants.COPPER, ResourceConstants.INGOT)
    }
}
