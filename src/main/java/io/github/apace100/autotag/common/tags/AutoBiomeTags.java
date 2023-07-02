package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public final class AutoBiomeTags {

    public static void register() {
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.Biomes.PRECIPITATION_NONE),
            biome -> biome.getPrecipitation(BlockPos.ORIGIN) == Biome.Precipitation.NONE);
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.Biomes.PRECIPITATION_RAIN),
            biome -> biome.getPrecipitation(BlockPos.ORIGIN) == Biome.Precipitation.RAIN);
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.Biomes.PRECIPITATION_SNOW),
            biome -> biome.getPrecipitation(BlockPos.ORIGIN) == Biome.Precipitation.SNOW);
    }
}
