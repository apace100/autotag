package io.github.apace100.autotag.common;

import io.github.apace100.autotag.common.compat.FabricShieldLibCompat;
import io.github.apace100.autotag.common.tags.AutoBiomeTags;
import io.github.apace100.autotag.common.tags.AutoBlockTags;
import io.github.apace100.autotag.common.tags.AutoEntityTypeTags;
import io.github.apace100.autotag.common.tags.AutoItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class AutoTagConvention implements ModInitializer {

	@Override
	public void onInitialize() {
		AutoItemTags.register();
		AutoBlockTags.register();
		AutoBiomeTags.register();
		AutoEntityTypeTags.register();
		if(FabricLoader.getInstance().isModLoaded("fabricshieldlib")) {
			FabricShieldLibCompat.register();
		}
	}

}
