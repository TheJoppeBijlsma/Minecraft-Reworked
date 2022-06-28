package com.joppebijlsma.minecraftreworked;

import com.joppebijlsma.minecraftreworked.block.ModBlocks;
import com.joppebijlsma.minecraftreworked.block.ModBlocksItemless;
import com.joppebijlsma.minecraftreworked.gui.AlphaGameplayHud;
import com.joppebijlsma.minecraftreworked.item.ModItems;
import com.joppebijlsma.minecraftreworked.world.ModRegion;
import com.joppebijlsma.minecraftreworked.world.ModSurfaceRuleData;
import com.joppebijlsma.minecraftreworked.world.biomes.ModBiomes;
import com.joppebijlsma.minecraftreworked.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class MinecraftReworked implements ModInitializer, TerraBlenderApi {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger MINECRAFTREWORKED = LoggerFactory.getLogger("minecraftreworked");
	public static final String MOD_ID = "minecraftreworked";

	@Override
	public void onInitialize() {
		ModDimensions.register();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlocksItemless.registerModBlocks();
		AlphaGameplayHud.AlphaGameplayHudEvent();
		ModBiomes.registerBiomes();
	}

	@Override
	public void onTerraBlenderInitialized()
	{
		// Given we only add two biomes, we should keep our weight relatively low.
		Regions.register(new ModRegion(new Identifier(MOD_ID, "overworld"), 2));

		// Register our surface rules
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
	}
}
