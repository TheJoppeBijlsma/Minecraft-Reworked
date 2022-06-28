package com.joppebijlsma.minecraftreworked.util;


import com.joppebijlsma.minecraftreworked.MinecraftReworked;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> SCULK_FIRE_BASE_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MinecraftReworked.MOD_ID, "sculk_fire_base_blocks"));
    }

    public static class Items {

    }
}
