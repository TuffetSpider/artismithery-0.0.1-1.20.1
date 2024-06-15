package net.tuffetspider.artismithery;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.tuffetspider.artismithery.entity.ModEntities;

public class ArtismitheryClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.ROCKITEM, FlyingItemEntityRenderer::new);

    }
        }