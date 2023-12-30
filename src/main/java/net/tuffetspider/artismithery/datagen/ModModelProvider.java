package net.tuffetspider.artismithery.datagen;

import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.tuffetspider.artismithery.item.ModItems;

public class ModModelProvider {

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.THROWING_ROCK, Models.GENERATED);
    }
}
