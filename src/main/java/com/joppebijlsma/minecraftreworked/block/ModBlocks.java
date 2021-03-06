package com.joppebijlsma.minecraftreworked.block;

import com.joppebijlsma.minecraftreworked.MinecraftReworked;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.ToIntFunction;

public class ModBlocks {


    public static final Block SCULK_CAMPFIRE = registerBlock("sculk_campfire",
            new CampfireBlock(false, 3, FabricBlockSettings.of(Material.WOOD).strength(2.0F).luminance(createLightLevelFromLitBlockState(5)).nonOpaque()));

    public static final Block SCULK_TORCH = registerBlock("sculk_torch", new TorchBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().breakInstantly().luminance((state) -> {
        return 5;
    }).sounds(BlockSoundGroup.WOOD), ParticleTypes.SOUL_FIRE_FLAME));

    public static final Block SCULK_LANTERN = registerBlock("sculk_lantern", new LanternBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
        return 5;
    }).nonOpaque()));

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MinecraftReworked.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MinecraftReworked.MINECRAFTREWORKED.debug("registering blocks for " + MinecraftReworked.MOD_ID);

        BlockRenderLayerMap.INSTANCE.putBlock(SCULK_CAMPFIRE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SCULK_TORCH, RenderLayer.getCutout());
    }

    //Functions
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> {
            return (Boolean)state.get(Properties.LIT) ? litLevel : 0;
        };
    }
}
