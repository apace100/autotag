package io.github.apace100.autotag.tags;

import io.github.apace100.autotag.AutoTagRegistry;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class AutoItemTags {

    public static void register() {
        // TOOLS
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "tools")),
            item -> item instanceof ToolItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "pickaxes")),
            item -> item instanceof PickaxeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "axes")),
            item -> item instanceof AxeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "swords")),
            item -> item instanceof SwordItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "hoes")),
            item -> item instanceof HoeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "shovels")),
            item -> item instanceof ShovelItem);

        // ARMOR
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "armor")),
            item -> item instanceof ArmorItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "helmets")),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "chestplates")),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "leggings")),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "boots")),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.FEET);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "head_equippables")),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "chest_equippables")),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "legs_equippables")),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "feet_equippables")),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.FEET);

        // MISC
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "spawn_eggs")),
            item -> item instanceof SpawnEggItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "ores")),
            item -> item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof OreBlock);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "skulls")),
            item -> item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof AbstractSkullBlock);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, new Identifier("c", "block_items")),
            item -> item instanceof BlockItem);
    }
}
