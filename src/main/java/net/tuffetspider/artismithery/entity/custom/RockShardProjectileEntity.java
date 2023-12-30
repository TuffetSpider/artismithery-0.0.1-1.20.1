package net.tuffetspider.artismithery.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.tuffetspider.artismithery.entity.ModEntities;
import net.tuffetspider.artismithery.item.ModItems;

public class RockShardProjectileEntity extends ThrownItemEntity {
    public RockShardProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public RockShardProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.ROCK_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
         return ModItems.THROWING_ROCK;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus( this, (byte)3);


        }
        this.discard();




        super.onBlockHit(blockHitResult);
    }
}
