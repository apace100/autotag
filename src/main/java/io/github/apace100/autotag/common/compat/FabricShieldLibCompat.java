package io.github.apace100.autotag.common.compat;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public final class FabricShieldLibCompat {

    public static void register() {
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SHIELDS),
            item -> item instanceof FabricShield);
    }
}
