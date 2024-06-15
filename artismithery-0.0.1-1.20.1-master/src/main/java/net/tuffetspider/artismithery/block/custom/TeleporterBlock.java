package net.tuffetspider.artismithery.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TeleporterBlock extends Block {
    public TeleporterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient) {
            // Define the paramaters of the target block
            final Predicate<BlockPos> predicate = blockPos -> world.getBlockState(blockPos).getBlock() == Blocks.REDSTONE_LAMP;

            // Find closest valid target block to teleport to
            Optional<BlockPos> teleportLocation = BlockPos.findClosest(pos, 15, 1, predicate);

            if (teleportLocation.isPresent()) {
                // Make sure that the optional is a location, and ensuring the player is teleported to the center of the block instead of the corner
                BlockPos teleportLocationPos = teleportLocation.get();
                double x = teleportLocationPos.getX() + 0.5;
                double y = teleportLocationPos.getY();
                double z = teleportLocationPos.getZ() + 0.5;
                Vec3d teleportLocationVec = new Vec3d(x, y, z);

                // Define the bounding box for entity search
                Box box = new Box(
                        teleportLocationVec.getX() - 1, teleportLocationVec.getY() - 1, teleportLocationVec.getZ() - 1,
                        teleportLocationVec.getX() + 1, teleportLocationVec.getY() + 3, teleportLocationVec.getZ() + 1
                );

                // Get entities within the box
                List<Entity> entityList = world.getEntitiesByClass(Entity.class, box, entity1 -> true);
                for (Entity nearbyEntity : entityList) {
                    nearbyEntity.damage(world.getDamageSources().cramming(), 20.0f);
                }

                // Teleport the player
                entity.teleport(x, y + 1, z);
                super.onSteppedOn(world, pos, state, entity);
            }
        }
    }
}
