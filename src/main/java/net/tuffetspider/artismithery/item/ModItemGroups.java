package net.tuffetspider.artismithery.item;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tuffetspider.artismithery.Artismithery;
import net.minecraft.registry.Registry;
import net.tuffetspider.artismithery.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup Artismithery_Items = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Artismithery.MOD_ID, "rock_shard"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.artismithery"))
                    .icon(() -> new ItemStack(ModItems.ROCK_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ROCK_SHARD);
                        entries.add(ModBlocks.ARTISAN_TABLE);
                        entries.add(ModItems.STONE_CHISEL);


    }).build());


    public static void registerItemGroups() {
        Artismithery.LOGGER.info("Registering item groups for" + Artismithery.MOD_ID);
    }
}
