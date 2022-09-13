package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public final class AutoBlockTags {

    public static void register() {
        AutoTagRegistry.register(Registry.BLOCK,
            TagKey.of(Registry.BLOCK_KEY, TagIdentifiers.ORES),
            block -> block instanceof OreBlock);
        AutoTagRegistry.register(Registry.BLOCK,
            TagKey.of(Registry.BLOCK_KEY, TagIdentifiers.SKULLS),
            block -> block instanceof AbstractSkullBlock);
    }
}
