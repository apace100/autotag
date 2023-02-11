package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.UseAction;

public final class AutoItemTags {

    public static void register() {
        // TOOLS
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.TOOLS),
            item -> item instanceof ToolItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.MINING_TOOLS),
            item -> item instanceof MiningToolItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.PICKAXES),
            item -> item instanceof PickaxeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.AXES),
            item -> item instanceof AxeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.HOES),
            item -> item instanceof HoeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SHOVELS),
            item -> item instanceof ShovelItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SHIELDS),
            item -> item instanceof ShieldItem);

        // WEAPONS
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem || item instanceof RangedWeaponItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.MELEE_WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.RANGED_WEAPONS),
            item -> item instanceof RangedWeaponItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SWORDS),
            item -> item instanceof SwordItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.TRIDENTS),
            item -> item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.BOWS),
            item -> item instanceof BowItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.CROSSBOWS),
            item -> item instanceof CrossbowItem);

        // ARMOR
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.ARMOR),
            item -> item instanceof ArmorItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.HELMETS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.CHESTPLATES),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.LEGGINGS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.BOOTS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.FEET);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.HEAD_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.CHEST_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.LEGS_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.FEET_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.FEET);

        // CONSUMABLES
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.FOOD),
            Item::isFood);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SNACKS),
            item -> item.isFood() && item.getFoodComponent().isSnack());
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.FOOD_WITH_EFFECTS),
            item -> item.isFood() && !item.getFoodComponent().getStatusEffects().isEmpty());
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.DRINKS),
            item -> item.getUseAction(item.getDefaultStack()) == UseAction.DRINK);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.POTIONS),
            item -> item instanceof PotionItem);

        // MISC
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SPAWN_EGGS),
            item -> item instanceof SpawnEggItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.ORES),
            item -> item instanceof BlockItem blockItem && (blockItem.getBlock() instanceof ExperienceDroppingBlock || blockItem.getBlock() instanceof RedstoneOreBlock));
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.SKULLS),
            item -> item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof AbstractSkullBlock);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.BLOCK_ITEMS),
            item -> item instanceof BlockItem);
    }
}
