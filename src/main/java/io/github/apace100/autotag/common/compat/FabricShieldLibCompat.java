package io.github.apace100.autotag.common.compat;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class FabricShieldLibCompat {

    public static void register() {
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SHIELDS),
            item -> item instanceof FabricShield);
    }
}
