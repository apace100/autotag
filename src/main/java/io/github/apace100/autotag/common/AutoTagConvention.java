package io.github.apace100.autotag.common;

import io.github.apace100.autotag.common.compat.FabricShieldLibCompat;
import io.github.apace100.autotag.common.tags.AutoBiomeTags;
import io.github.apace100.autotag.common.tags.AutoBlockTags;
import io.github.apace100.autotag.common.tags.AutoItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutoTagConvention implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger(AutoTagConvention.class);

	@Override
	public void onInitialize() {
		AutoItemTags.register();
		AutoBlockTags.register();
		AutoBiomeTags.register();
		if(FabricLoader.getInstance().isModLoaded("fabricshieldlib")) {
			FabricShieldLibCompat.register();
		}
	}

}
