package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class AutoBlockTags {

    public static void register() {
        AutoTagRegistry.register(Registries.BLOCK,
            TagKey.of(RegistryKeys.BLOCK, TagIdentifiers.Blocks.ORES),
            block -> block instanceof ExperienceDroppingBlock || block instanceof RedstoneOreBlock);
        AutoTagRegistry.register(Registries.BLOCK,
            TagKey.of(RegistryKeys.BLOCK, TagIdentifiers.Blocks.SKULLS),
            block -> block instanceof AbstractSkullBlock);
    }
}
