package io.github.apace100.autotag.tags;

import io.github.apace100.autotag.AutoTagRegistry;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class AutoBlockTags {

    public static void register() {
        AutoTagRegistry.register(Registry.BLOCK,
            TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "ores")),
            block -> block instanceof OreBlock);
        AutoTagRegistry.register(Registry.BLOCK,
            TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "skulls")),
            block -> block instanceof AbstractSkullBlock);
    }
}
