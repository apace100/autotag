package io.github.apace100.autotag.api;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class AutoTagRegistry {

    private static final HashMap<Registry<?>, List<AutoTag<?>>> AUTO_TAGS = new HashMap<>();

    /**
     * Retrieves all registered "auto tags" for a certain registry.
     * @param registry The registry to retrieve auto tags for
     * @param <T> The entry type
     * @return A list of all auto tags registered for this registry
     */
    public static <T> List<AutoTag<?>> getAutoTags(Registry<T> registry) {
        if(AUTO_TAGS.containsKey(registry)) {
            return AUTO_TAGS.get(registry);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Registers an "auto tag" for a certain registry. All entries of that registry which fulfill the predicate
     * and are not part of a tag with the same namespace and the path prefixed with `prevent_` will be added
     * to the provided tag.
     * Entries added to the tag by actual datapacks won't be touched.
     * @param registry The registry for the tag
     * @param tagKey The tag which should be populated automatically
     * @param entryPredicate The condition which an entry needs to fulfill to be added to the tag
     * @param <T> The entry type
     */
    public static <T> void register(Registry<T> registry, TagKey<T> tagKey, Predicate<T> entryPredicate) {
        TagKey<T> preventTagKey = TagKey.of(tagKey.registry(), getPreventIdentifier(tagKey.id()));
        AutoTag<T> autoTag = new AutoTag<>(tagKey, preventTagKey, entryPredicate);
        if(AUTO_TAGS.containsKey(registry)) {
            AUTO_TAGS.get(registry).add(autoTag);
        } else {
            List<AutoTag<?>> autoTagList = new LinkedList<>();
            autoTagList.add(autoTag);
            put(registry, autoTagList);
        }
    }

    private static Identifier getPreventIdentifier(Identifier identifier) {
        return new Identifier(AutoTagApi.MODID,
            "prevent/" + identifier.getNamespace() + "/" + identifier.getPath());
    }

    private static void put(Registry<?> registry, List<AutoTag<?>> list) {
        AUTO_TAGS.put(registry, list);
    }

    public record AutoTag<T>(TagKey<T> tagKey, TagKey<T> preventTagKey, Predicate<T> predicate) {
    }
}
