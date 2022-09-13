package io.github.apace100.autotag.impl;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.HashMap;

public class AutoTag {
    private static final HashMap<RegistryKey<?>, TagKey<?>> UNIVERSAL_PREVENT_TAGS_CACHE = new HashMap<>();
    public static String MODID = "autotag";

    @SuppressWarnings("unchecked")
    public static <T> TagKey<T> getUniversalPreventTag(RegistryKey<? extends Registry<T>> registryKey) {
        return (TagKey<T>)UNIVERSAL_PREVENT_TAGS_CACHE.computeIfAbsent(registryKey, key ->
                TagKey.of(registryKey, new Identifier(MODID, "prevent/all"))
        );
    }
}
