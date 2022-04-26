package io.github.apace100.autotag.tags;

import io.github.apace100.autotag.AutoTagRegistry;
import net.minecraft.block.OreBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public final class AutoBiomeTags {

    public static void register() {
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, new Identifier("c", "precipitation_none")),
            biome -> biome.getPrecipitation() == Biome.Precipitation.NONE);
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, new Identifier("c", "precipitation_rain")),
            biome -> biome.getPrecipitation() == Biome.Precipitation.RAIN);
        AutoTagRegistry.register(BuiltinRegistries.BIOME,
            TagKey.of(Registry.BIOME_KEY, new Identifier("c", "precipitation_snow")),
            biome -> biome.getPrecipitation() == Biome.Precipitation.SNOW);
    }
}
