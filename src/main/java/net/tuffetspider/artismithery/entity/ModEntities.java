package net.tuffetspider.artismithery.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tuffetspider.artismithery.Artismithery;
import net.tuffetspider.artismithery.entity.custom.RockShardProjectileEntity;



public class ModEntities {

    public static final EntityType<RockShardProjectileEntity> ROCKITEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Artismithery.MOD_ID, "rockitem"), FabricEntityTypeBuilder.<RockShardProjectileEntity>create(SpawnGroup.MISC, RockShardProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());



}
