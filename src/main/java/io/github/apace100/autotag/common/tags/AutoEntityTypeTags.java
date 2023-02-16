package io.github.apace100.autotag.common.tags;

import io.github.apace100.autotag.api.AutoTagRegistry;
import io.github.apace100.autotag.common.TagIdentifiers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class AutoEntityTypeTags {

    public static void register() {
        AutoTagRegistry.register(
            Registries.ENTITY_TYPE,
            TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.LIVING),
            type -> type.create(null) instanceof LivingEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.ALIVE),
                type -> type != EntityType.ARMOR_STAND && type.create(null) instanceof LivingEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.OBJECTS),
                type -> type == EntityType.ARMOR_STAND || !(type.create(null) instanceof LivingEntity));
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.PROJECTILES),
                type -> type.create(null) instanceof ProjectileEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.BOATS),
                type -> type.create(null) instanceof BoatEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.MINECARTS),
                type -> type.create(null) instanceof MinecartEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.TAMEABLE),
                type -> type.create(null) instanceof TameableEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.AQUATIC),
                type -> type.create(null) instanceof WaterCreatureEntity || type.create(null) instanceof GuardianEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.ANIMALS),
                type -> type.create(null) instanceof AnimalEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.HORSES),
                type -> type.create(null) instanceof AbstractHorseEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.COWS),
                type -> type.create(null) instanceof CowEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.HOSTILE),
                type -> type.create(null) instanceof HostileEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.ZOMBIES),
                type -> type.create(null) instanceof ZombieEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.SKELETONS),
                type -> type.create(null) instanceof AbstractSkeletonEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.RAIDERS),
                type -> type.create(null) instanceof RaiderEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.SLIMES),
                type -> type.create(null) instanceof SlimeEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.PIGLINS),
                type -> type.create(null) instanceof AbstractPiglinEntity);
        AutoTagRegistry.register(
                Registries.ENTITY_TYPE,
                TagKey.of(RegistryKeys.ENTITY_TYPE, TagIdentifiers.EntityTypes.GOLEMS),
                type -> type.create(null) instanceof GolemEntity);
    }
}
