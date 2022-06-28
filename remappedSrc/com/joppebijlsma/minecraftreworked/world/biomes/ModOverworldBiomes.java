package com.joppebijlsma.minecraftreworked.world.biomes;

import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.*;
import net.minecraft.sound.BiomeMoodSound;
import Biome;
import javax.annotation.Nullable;

public class ModOverworldBiomes {
    @Nullable
    private static final MusicSound NORMAL_MUSIC = null;

    protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = MathHelper.clamp($$1, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, SpawnSettings.Builder spawnBuilder, GenerationSettings.Builder biomeBuilder, @Nullable MusicSound music)
    {
        return biome(precipitation, temperature, downfall, spawnBuilder, biomeBuilder, music);
    }

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, SpawnSettings.Builder spawnBuilder, GenerationSettings.Builder biomeBuilder, @Nullable MusicSound music)
    {
        return (new Biome.Builder()).precipitation(precipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).moodSound(BiomeMoodSound.CAVE).music(music).build()).SpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalOverworldGeneration(GenerationSettings.Builder builder)
    {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome hotRed()
    {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addDesertMobs(spawnBuilder);

        GenerationSettings.Builder biomeBuilder = new GenerationSettings.Builder();
        DefaultBiomeFeatures.addFossils(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultFlowers(biomeBuilder);
        DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
        DefaultBiomeFeatures.addDesertVegetation(biomeBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDesertVegetation(biomeBuilder);
        DefaultBiomeFeatures.addDesertFeatures(biomeBuilder);
        return biome(Biome.Precipitation.NONE,  2.0F, 0.0F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }

    public static Biome coldBlue()
    {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.GOAT, 5, 1, 3));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.Builder biomeBuilder = new GenerationSettings.Builder();
        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addFrozenLavaSpring(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        DefaultBiomeFeatures.addEmeraldOre(biomeBuilder);
        DefaultBiomeFeatures.addInfestedStone(biomeBuilder);
        return biome(Biome.Precipitation.SNOW, -0.7F, 0.9F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
    }
}
