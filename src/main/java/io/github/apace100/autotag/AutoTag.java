package io.github.apace100.autotag;

import io.github.apace100.autotag.compat.FabricShieldLibCompat;
import io.github.apace100.autotag.tags.AutoBiomeTags;
import io.github.apace100.autotag.tags.AutoBlockTags;
import io.github.apace100.autotag.tags.AutoItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.HashMap;

public class AutoTag implements ModInitializer {

	public static final String MODID = "autotag";

	private static final HashMap<RegistryKey<?>, TagKey<?>> UNIVERSAL_PREVENT_TAGS_CACHE = new HashMap<>();

	@Override
	public void onInitialize() {
		AutoItemTags.register();
		AutoBlockTags.register();
		AutoBiomeTags.register();
		if(FabricLoader.getInstance().isModLoaded("fabricshieldlib")) {
			FabricShieldLibCompat.register();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> TagKey<T> getUniversalPreventTag(RegistryKey<? extends Registry<T>> registryKey) {
		return (TagKey<T>)UNIVERSAL_PREVENT_TAGS_CACHE.computeIfAbsent(registryKey, key -> {
			return TagKey.of(registryKey, new Identifier(MODID, "prevent/all"));
		});
	}
}
