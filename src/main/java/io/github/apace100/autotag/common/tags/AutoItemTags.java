package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;

public final class AutoItemTags {

    public static void register() {
        // TOOLS
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.TOOLS),
            item -> item instanceof ToolItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.MINING_TOOLS),
            item -> item instanceof MiningToolItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.PICKAXES),
            item -> item instanceof PickaxeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.AXES),
            item -> item instanceof AxeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.HOES),
            item -> item instanceof HoeItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SHOVELS),
            item -> item instanceof ShovelItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SHIELDS),
            item -> item instanceof ShieldItem);

        // WEAPONS
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem || item instanceof RangedWeaponItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.MELEE_WEAPONS),
            item -> item instanceof SwordItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.RANGED_WEAPONS),
            item -> item instanceof RangedWeaponItem || item instanceof TridentItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SWORDS),
            item -> item instanceof SwordItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.TRIDENTS),
            item -> item instanceof TridentItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.BOWS),
            item -> item instanceof BowItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.CROSSBOWS),
            item -> item instanceof CrossbowItem);

        // ARMOR
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.ARMOR),
            item -> item instanceof ArmorItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.HELMETS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.CHESTPLATES),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.LEGGINGS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.BOOTS),
            item -> item instanceof ArmorItem && ((ArmorItem)item).getSlotType() == EquipmentSlot.FEET);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.HEAD_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.HEAD);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.CHEST_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.CHEST);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.LEGS_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.LEGS);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.FEET_EQUIPPABLES),
            item -> MobEntity.getPreferredEquipmentSlot(item.getDefaultStack()) == EquipmentSlot.FEET);

        // CONSUMABLES
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.FOOD),
            Item::isFood);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SNACKS),
            item -> item.isFood() && item.getFoodComponent().isSnack());
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.FOOD_WITH_EFFECTS),
            item -> item.isFood() && !item.getFoodComponent().getStatusEffects().isEmpty());
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.DRINKS),
            item -> item.getUseAction(item.getDefaultStack()) == UseAction.DRINK);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.POTIONS),
            item -> item instanceof PotionItem);

        // MISC
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SPAWN_EGGS),
            item -> item instanceof SpawnEggItem);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.ORES),
            item -> item instanceof BlockItem blockItem && (blockItem.getBlock() instanceof OreBlock || blockItem.getBlock() instanceof RedstoneOreBlock));
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.SKULLS),
            item -> item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof AbstractSkullBlock);
        AutoTagRegistry.register(
            Registry.ITEM,
            TagKey.of(Registry.ITEM_KEY, TagIdentifiers.BLOCK_ITEMS),
            item -> item instanceof BlockItem);
    }
}
