package com.joppebijlsma.minecraftreworked;

import com.joppebijlsma.minecraftreworked.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftReworked implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger MINECRAFTREWORKED = LoggerFactory.getLogger("minecraftreworked");
	public static final String MOD_ID = "minecraftreworked";

	@Override
	public void onInitialize() {
		ModDimensions.register();
	}
}
