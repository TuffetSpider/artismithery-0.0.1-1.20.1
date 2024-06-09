package net.tuffetspider.artismithery.item.custom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.tuffetspider.artismithery.entity.custom.RockShardProjectileEntity;

public class RockItem extends Item {
    public RockItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            RockShardProjectileEntity rockShardProjectileEntity = new RockShardProjectileEntity(user, world);
            rockShardProjectileEntity.setItem(itemStack);
            rockShardProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 1.0f, 1.5f, 1.0f);
            world.spawnEntity(rockShardProjectileEntity);
        }

        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }}

