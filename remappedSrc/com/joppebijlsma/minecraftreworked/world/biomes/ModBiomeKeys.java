package com.joppebijlsma.minecraftreworked.world.biomes;

import com.joppebijlsma.minecraftreworked.MinecraftReworked;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {
    public static final RegistryKey<Biome> HOT_RED = register("hot_red");
    public static final RegistryKey<Biome> COLD_BLUE = register("cold_blue");

    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(MinecraftReworked.MOD_ID, name));
    }
}
