package net.tuffetspider.artismithery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.tuffetspider.artismithery.Artismithery;
import net.minecraft.registry.Registry;
import net.tuffetspider.artismithery.item.custom.RockItem;


public class ModItems {
    public static final Item STONE_CHISEL = registerItem("stone_chisel", new Item(new FabricItemSettings()));
    public static final Item ROCK_SHARD = registerItem("rock", new RockItem(new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(ROCK_SHARD);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Artismithery.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Artismithery.LOGGER.info("Registering items for " + Artismithery.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
