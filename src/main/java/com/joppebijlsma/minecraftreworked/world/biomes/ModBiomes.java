package com.joppebijlsma.minecraftreworked.world.biomes;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static void registerBiomes()
    {
        register(ModBiomeKeys.HOT_RED, ModOverworldBiomes.hotRed());
        register(ModBiomeKeys.COLD_BLUE, ModOverworldBiomes.coldBlue());
    }

    private static void register(RegistryKey<Biome> key, Biome biome)
    {
        BuiltinRegistries.add(BuiltinRegistries.BIOME, key, biome);
    }
}
