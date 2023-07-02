package io.github.apace100.autotag.common.compat;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.AutoTagConvention;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class FabricShieldLibCompat {

    public static void register() {
        try {
            Class<?> fabricShieldInterface = Class.forName("com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield");
            AutoTagRegistry.register(
                    Registries.ITEM,
                    TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SHIELDS),
                    fabricShieldInterface::isInstance);
        } catch (ClassNotFoundException e) {
            AutoTagConvention.LOGGER.error("FabricShieldLib was loaded, but the interface could not be found. AutoTag might be outdated. FabricShieldLib compatibility will be disabled.");
        }
    }
}
