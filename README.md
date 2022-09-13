# AutoTag

AutoTag is a Fabric mod which automatically populates common tags with entries that fulfill specific conditions.
The goal is to create easier inter-mod compatibility, since not all mod developers remember to add their content to common tags.
If you're a mod pack creator or a developer and you have any suggestions for new auto tags, feel free to create an issue on the issue tracker.

## Modules

Beginning with 2.0.0+1.19, AutoTag is split into two modules:
 - AutoTag API (mod ID `autotag`, maven artifact `autotag-api`), which provides the API for populating tags.
 - AutoTag Convention (mod ID `autotag-convention`, maven artifact `autotag`), which uses AutoTag API to auto-fill some [convention tags](https://github.com/FabricMC/fabric/tree/1.19.2/fabric-convention-tags-v1).

## Integrations
AutoTag adds specific integrations for the following mods:

| Mod                                                                   | Description of the integration                      | Version introduced |
|:----------------------------------------------------------------------|:----------------------------------------------------|-------------------:|
| [FabricShieldLib](https://github.com/CrimsonDawn45/Fabric-Shield-Lib) | All custom shields are added to `c:shields` as well |              1.1.0 |

## Client vs Server
Clients receive their tag list from the server, thus when you install this mod on a server, the clients will receive the same (already automatically populated) tags upon joining the world.
However, if the tags are supposed to be automatically populated in a single-player environment, the client of course needs to have this mod installed.

## Configuration
There is no real configuration file, however sometimes this mod may produce "false-positives".
False-positives are entries which are added to a tag automatically by this mod even though they don't belong there.
If this happens in your mod / mod pack, you can add the item to a "prevent tag".
The prevent tag should always be in the namespace `autotag` and then the directory corresponding to the type of tag.
In there, create a `prevent` folder, and inside that a folder corresponding to the namespace of the automatically populated tag.
In that namespace folder, you can now create a tag file which you can add entries to. Those entries will no longer be added to the specific tag.

You may also create a tag file called `all.json` directly in the `prevent` folder.
Entries of that tag will not be added to any tag automatically.

**Examples:**

To prevent the item `minecraft:iron_helmet` from being added to `c:head_equippables` without preventing it to be added to `c:helmets`, create a file at `data/autotag/tags/items/prevent/c/head_equippables.json` with this content:
```json
{
  "replace": false,
  "values": [
    "minecraft:iron_helmet"
  ]
}
```

To prevent the item `minecraft:carved_pumpkin` from being added to ANY tags automatically (normally `c:block_items` and `c:head_equippables`), create a file at `data/autotag/tags/items/prevent/all.json` with this content:
```json
{
  "replace": false,
  "values": [
    "minecraft:carved_pumpkin"
  ]
}
```

## Using the API (for developers)

:warning: Autotag is not currently published on any maven repository.

Bring in the API as a dependency:

```groovy
dependencies {
    implementation include("com.github.apace100:autotag-api:${autotag_version}")
}
```

Then register your autotags:

```java
class MyMod implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoTagRegistry.register(
                Registry.BLOCK,  // The Registry for the tag
                TagKey.of(Registry.BLOCK_KEY, new Identifier("mymod:cakes")), // The TagKey for the tag
                block -> block instanceof CakeBlock // A predicate to determine if a registry object belongs in the tag
        );
    }
}
```

## List of Tags

### Items

| Tag ID                | Condition                                                                                         | Version introduced |
|:----------------------|:--------------------------------------------------------------------------------------------------|-------------------:|
| `c:tools`             | Item class extends `ToolItem`                                                                     |              1.0.0 |
| `c:mining_tools`      | Item class extends `MiningToolItem`                                                               |              1.1.0 |
| `c:pickaxes`          | Item class extends `PickaxeItem`                                                                  |              1.0.0 |
| `c:axes`              | Item class extends `AxeItem`                                                                      |              1.0.0 |
| `c:shovels`           | Item class extends `ShovelItem`                                                                   |              1.0.0 |
| `c:hoes`              | Item class extends `HoeItem`                                                                      |              1.0.0 |
| `c:shields`           | Item class extends `ShieldItem` or implements `FabricShield` if FabricShieldLib is installed      |              1.1.0 |
| `c:weapons`           | Item class extends `SwordItem`, `RangedWeaponItem` or `TridentItem`                               |              1.1.0 |
| `c:melee_weapons`     | Item class extends `SwordItem` or `TridentItem`                                                   |              1.1.0 |
| `c:ranged_weapons`    | Item class extends `RangedWeaponItem` or `TridentItem`                                            |              1.1.0 |
| `c:swords`            | Item class extends `SwordItem`                                                                    |              1.0.0 |
| `c:tridents`          | Item class extends `TridentItem`                                                                  |              1.1.0 |
| `c:bows`              | Item class extends `BowItem`                                                                      |              1.1.0 |
| `c:crossbows`         | Item class extends `CrossbowItem`                                                                 |              1.1.0 |
| `c:armor`             | Item class extends `ArmorItem`                                                                    |              1.0.0 |
| `c:helmets`           | Item class extends `ArmorItem` and is for the `HEAD` slot                                         |              1.0.0 |
| `c:chestplates`       | Item class extends `ArmorItem` and is for the `CHEST` slot                                        |              1.0.0 |
| `c:leggings`          | Item class extends `ArmorItem` and is for the `LEGS` slot                                         |              1.0.0 |
| `c:boots`             | Item class extends `ArmorItem` and is for the `FEET` slot                                         |              1.0.0 |
| `c:head_equippables`  | Item can be equipped in the `HEAD` slot                                                           |              1.0.0 |
| `c:chest_equippables` | Item can be equipped in the `CHEST` slot                                                          |              1.0.0 |
| `c:legs_equippables`  | Item can be equipped in the `LEGS` slot                                                           |              1.0.0 |
| `c:feet_equippables`  | Item can be equipped in the `FEET` slot                                                           |              1.0.0 |
| `c:ores`              | Item represents a block that extends `OreBlock`                                                   |              1.0.0 |
| `c:skulls`            | Item represents a block that extends `AbstractSkullBlock`                                         |              1.0.0 |
| `c:block_items`       | Item class extends `BlockItem` (i.e. is placeable)                                                |              1.0.0 |
| `c:food`              | Item class has a `FoodComponent`                                                                  |              1.1.0 |
| `c:snacks`            | Item class has a `FoodComponent` and is marked as a "snack" (consumption time halved)             |              1.1.0 |
| `c:food_with_effects` | Item class has a `FoodComponent` and has the possibility of inflicting one or more status effects |              1.1.0 |
| `c:drinks`            | Item has `DRINK` assigned as its use action                                                       |              1.1.0 |
| `c:potions`           | Item class extends `PotionItem`                                                                   |              1.1.0 |

### Blocks
| Tag ID              | Condition                                | Version introduced |
|:--------------------|:-----------------------------------------|:-------------------|
| `c:ores`            | Block class extends `OreBlock`           | 1.0.0              |
| `c:skulls`          | Block class extends `AbstractSkullBlock` | 1.0.0              |

### Biomes
| Tag ID                 | Condition                                | Version introduced |
|:-----------------------|:-----------------------------------------|:-------------------|
| `c:precipitation_none` | The biome's precipitation type is `NONE` | 1.0.0              |
| `c:precipitation_rain` | The biome's precipitation type is `RAIN` | 1.0.0              |
| `c:precipitation_snow` | The biome's precipitation type is `SNOW` | 1.0.0              |