package com.joppebijlsma.minecraftreworked.world.dimension;

import com.joppebijlsma.minecraftreworked.MinecraftReworked;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> DEEPDARK_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(MinecraftReworked.MOD_ID, "deepdark"));

    public static final RegistryKey<DimensionType> DEEPDARK_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, DEEPDARK_DIMENSION_KEY.getValue());

    public static void register() {
        MinecraftReworked.MINECRAFTREWORKED.debug("Registering ModDimensions for " + MinecraftReworked.MOD_ID);

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .destDimID(DEEPDARK_DIMENSION_KEY.getValue())
                .tintColor(7, 245, 221)
                .lightWithItem(Items.ECHO_SHARD)
                .registerPortal();
    }
}
