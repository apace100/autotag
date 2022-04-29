package io.github.apace100.autotag.tags;

import io.github.apace100.autotag.AutoTagRegistry;
import io.github.apace100.autotag.TagIdentifiers;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public final class AutoBiomeTags {

    public static void register() {
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, TagIdentifiers.PRECIPITATION_NONE),
            biome -> biome.getPrecipitation() == Biome.Precipitation.NONE);
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, TagIdentifiers.PRECIPITATION_RAIN),
            biome -> biome.getPrecipitation() == Biome.Precipitation.RAIN);
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, TagIdentifiers.PRECIPITATION_SNOW),
            biome -> biome.getPrecipitation() == Biome.Precipitation.SNOW);
    }
}
