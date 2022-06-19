package com.joppebijlsma.minecraftreworked;

import com.joppebijlsma.minecraftreworked.block.ModBlocks;
import com.joppebijlsma.minecraftreworked.block.ModBlocksItemless;
import com.joppebijlsma.minecraftreworked.gui.AlphaGameplayHud;
import com.joppebijlsma.minecraftreworked.item.ModItems;
import com.joppebijlsma.minecraftreworked.world.dimension.ModDimensions;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class MinecraftReworked implements ModInitializer {
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
	}
}
