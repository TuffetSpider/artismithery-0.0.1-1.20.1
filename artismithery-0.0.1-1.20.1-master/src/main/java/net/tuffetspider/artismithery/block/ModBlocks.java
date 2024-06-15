package net.tuffetspider.artismithery.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tuffetspider.artismithery.Artismithery;
import net.tuffetspider.artismithery.block.custom.TeleporterBlock;

public class ModBlocks {
    public static final Block ARTISAN_TABLE = registerBlock("artisan_table",
            new Block(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)));
    public static final Block TELEPORTER = registerBlock("teleporter",
            new TeleporterBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Artismithery.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Artismithery.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings()));


}

    public static void registerModBlocks() {
        Artismithery.LOGGER.info("Registering blocks for "+Artismithery.MOD_ID);
    }











}
