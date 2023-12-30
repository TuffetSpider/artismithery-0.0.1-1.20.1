package net.tuffetspider.artismithery;

import net.fabricmc.api.ModInitializer;

import net.tuffetspider.artismithery.item.ModItemGroups;
import net.tuffetspider.artismithery.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Artismithery implements ModInitializer {
    public static final String MOD_ID = "artismithery";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();



	}
}