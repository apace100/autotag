package io.github.apace100.autotag.mixin;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.impl.AutoTag;
import net.minecraft.registry.MutableRegistry;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.*;
import java.util.function.Predicate;

@Mixin(SimpleRegistry.class)
public abstract class SimpleRegistryMixin<T> implements MutableRegistry<T> {

    @SuppressWarnings("unchecked")
    @ModifyVariable(method = "populateTags", at = @At("HEAD"), argsOnly = true)
    private Map<TagKey<T>, List<RegistryEntry<T>>> addAutomaticTagEntries(Map<TagKey<T>, List<RegistryEntry<T>>> tagEntries) {
        if(tagEntries instanceof HashMap<TagKey<T>, List<RegistryEntry<T>>>) {
            // This is true when populateTags is called on the logical client.
            // In that case, we don't want to modify the tags at all, since
            // that has already been done by the server.
            return tagEntries;
        }

        // Note: both the map itself and the values are immutable collections,
        // therefore we have to replace them with mutable variants.

        List<AutoTagRegistry.AutoTag<?>> autoTags = AutoTagRegistry.getAutoTags(this);

        if(autoTags.size() == 0) {
            // Skip all additional work because there are no automatic tags
            return tagEntries;
        }

        Map<TagKey<T>, List<RegistryEntry<T>>> returnMap = tagEntries;
        returnMap = Maps.newHashMap(returnMap);
        Map<TagKey<T>, List<RegistryEntry<T>>> finalReturnMap = returnMap;
        Set<TagKey<T>> madeListMutable = new HashSet<>();

        TagKey<T> universalPreventTag = AutoTag.getUniversalPreventTag(
            ((TagKey<T>)autoTags.get(0).preventTagKey()).registry()
        );

        this.streamEntries().forEach(entry -> {
            T value = entry.value();
            for(AutoTagRegistry.AutoTag<?> autoTag : autoTags) {
                Predicate<T> predicate = (Predicate<T>) autoTag.predicate();

                // Check whether the entry has been added to the SPECIFIC
                // prevent tag and abort adding it to the auto tag if so.
                TagKey<T> preventTagKey = (TagKey<T>) autoTag.preventTagKey();
                if(tagEntries.containsKey(preventTagKey)) {
                    if(tagEntries.get(preventTagKey).contains(entry)) {
                        continue;
                    }
                }

                // Check whether the entry has been added to the UNIVERSAL
                // prevent tag and abort adding it to the auto tag if so.
                if(tagEntries.containsKey(universalPreventTag)) {
                    if(tagEntries.get(universalPreventTag).contains(entry)) {
                        continue;
                    }
                }

                // If the item fulfills the condition, add it to the auto tag
                if(predicate.test(value)) {
                    TagKey<T> tagKey = (TagKey<T>) autoTag.tagKey();
                    List<RegistryEntry<T>> entryList;
                    if(finalReturnMap.containsKey(tagKey)) {
                        entryList = finalReturnMap.get(tagKey);
                        if(!madeListMutable.contains(tagKey)) {
                            entryList = Lists.newLinkedList(entryList);
                            finalReturnMap.put(tagKey, entryList);
                            madeListMutable.add(tagKey);
                        }
                    } else {
                        entryList = new LinkedList<>();
                        finalReturnMap.put(tagKey, entryList);
                        madeListMutable.add(tagKey);
                    }
                    entryList.add(entry);
                }
            }
        });

        // Remove all prevent tags
        autoTags.forEach(autoTag -> finalReturnMap.remove(autoTag.preventTagKey()));
        finalReturnMap.remove(universalPreventTag);

        return finalReturnMap;
    }
}
