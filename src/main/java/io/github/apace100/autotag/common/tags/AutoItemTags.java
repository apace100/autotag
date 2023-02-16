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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.UseAction;

public final class AutoItemTags {

    public static void register() {
        // TOOLS
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.TOOLS),
            item -> item instanceof ToolItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.MINING_TOOLS),
            item -> item instanceof MiningToolItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.PICKAXES),
            item -> item instanceof PickaxeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.AXES),
            item -> item instanceof AxeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.HOES),
            item -> item instanceof HoeItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SHOVELS),
            item -> item instanceof ShovelItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SHIELDS),
            item -> item instanceof ShieldItem);

        // WEAPONS
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem || item instanceof RangedWeaponItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.MELEE_WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.RANGED_WEAPONS),
            item -> item instanceof RangedWeaponItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SWORDS),
            item -> item instanceof SwordItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.TRIDENTS),
            item -> item instanceof TridentItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.BOWS),
            item -> item instanceof BowItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.CROSSBOWS),
            item -> item instanceof CrossbowItem);

        // ARMOR
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.ARMOR),
            item -> item instanceof ArmorItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.HELMETS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.CHESTPLATES),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.LEGGINGS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.BOOTS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.FEET);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.HEAD_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.CHEST_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.LEGS_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.FEET_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.FEET);

        // CONSUMABLES
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.FOOD),
            Item::isFood);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SNACKS),
            item -> item.isFood() && item.getFoodComponent().isSnack());
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.FOOD_WITH_EFFECTS),
            item -> item.isFood() && !item.getFoodComponent().getStatusEffects().isEmpty());
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.DRINKS),
            item -> item.getUseAction(item.getDefaultStack()) == UseAction.DRINK);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.POTIONS),
            item -> item instanceof PotionItem);

        // MISC
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SPAWN_EGGS),
            item -> item instanceof SpawnEggItem);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.ORES),
            item -> item instanceof BlockItem blockItem && (blockItem.getBlock() instanceof ExperienceDroppingBlock || blockItem.getBlock() instanceof RedstoneOreBlock));
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.SKULLS),
            item -> item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof AbstractSkullBlock);
        AutoTagRegistry.register(
            Registries.ITEM,
            TagKey.of(RegistryKeys.ITEM, TagIdentifiers.Items.BLOCK_ITEMS),
            item -> item instanceof BlockItem);
    }
}
