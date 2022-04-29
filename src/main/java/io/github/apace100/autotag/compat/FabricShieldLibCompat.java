package io.github.apace100.autotag.compat;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import io.github.apace100.autotag.AutoTagRegistry;
import io.github.apace100.autotag.TagIdentifiers;
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
