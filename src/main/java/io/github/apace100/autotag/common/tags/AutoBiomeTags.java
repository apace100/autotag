package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;

public final class AutoBiomeTags {

    public static void register() {
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.PRECIPITATION_NONE),
            biome -> biome.getPrecipitation() == Biome.Precipitation.NONE);
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.PRECIPITATION_RAIN),
            biome -> biome.getPrecipitation() == Biome.Precipitation.RAIN);
        AutoTagRegistry.register(RegistryKeys.BIOME,
            TagKey.of(RegistryKeys.BIOME, TagIdentifiers.PRECIPITATION_SNOW),
            biome -> biome.getPrecipitation() == Biome.Precipitation.SNOW);
    }
}
