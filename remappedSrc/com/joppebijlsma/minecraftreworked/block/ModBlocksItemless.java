package com.joppebijlsma.minecraftreworked.block;

import com.joppebijlsma.minecraftreworked.MinecraftReworked;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocksItemless extends ModBlocks {

    public static final Block SCULK_FIRE = registerBlock("sculk_fire",
            new SculkFireBlock(FabricBlockSettings.of(Material.FIRE, MapColor.DARK_AQUA).noCollision().breakInstantly().luminance((state) -> {
                return 10;
            }).sounds(BlockSoundGroup.WOOL)));

    public static final Block SCULK_WALL_TORCH = registerBlock("sculk_wall_torch", new WallTorchBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().breakInstantly().luminance((state) -> {
        return 5;
    }).sounds(BlockSoundGroup.WOOD).dropsLike(SCULK_TORCH), ParticleTypes.SOUL_FIRE_FLAME));

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MinecraftReworked.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        MinecraftReworked.MINECRAFTREWORKED.debug("registering blocks without blockitems for " + MinecraftReworked.MOD_ID);

        BlockRenderLayerMap.INSTANCE.putBlock(SCULK_FIRE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SCULK_WALL_TORCH, RenderLayer.getCutout());
    }
}
