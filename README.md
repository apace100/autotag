# AutoTag

AutoTag is a Fabric mod which automatically populates common tags with entries that fulfill specific conditions.
The goal is to create easier inter-mod compatibility, since not all mod developers remember to add their content to common tags.
If you're a mod pack creator or a developer and you have any suggestions for new auto tags, feel free to create an issue on the issue tracker.

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

## List of Tags

### Items

| Tag ID                | Condition                                                  |
|:----------------------|:-----------------------------------------------------------|
| `c:tools`             | Item class extends `ToolItem`                              |
| `c:pickaxes`          | Item class extends `PickaxeItem`                           |
| `c:axes`              | Item class extends `AxeItem`                               |
| `c:shovels`           | Item class extends `ShovelItem`                            |
| `c:hoes`              | Item class extends `HoeItem`                               |
| `c:swords`            | Item class extends `SwordItem`                             |
| `c:armor`             | Item class extends `ArmorItem`                             |
| `c:helmets`           | Item class extends `ArmorItem` and is for the `HEAD` slot  |
| `c:chestplates`       | Item class extends `ArmorItem` and is for the `CHEST` slot |
| `c:leggings`          | Item class extends `ArmorItem` and is for the `LEGS` slot  |
| `c:boots`             | Item class extends `ArmorItem` and is for the `FEET` slot  |
| `c:head_equippables`  | Item can be equipped in the `HEAD` slot                    |
| `c:chest_equippables` | Item can be equipped in the `CHEST` slot                   |
| `c:legs_equippables`  | Item can be equipped in the `LEGS` slot                    |
| `c:feet_equippables`  | Item can be equipped in the `FEET` slot                    |
| `c:ores`              | Item represents a block that extends `OreBlock`            |
| `c:skulls`            | Item represents a block that extends `AbstractSkullBlock`  |
| `c:block_items`       | Item class extends `BlockItem` (i.e. is placeable)         |

### Blocks
| Tag ID              | Condition                                |
|:--------------------|:-----------------------------------------|
| `c:ores`            | Block class extends `OreBlock`           |
| `c:skulls`          | Block class extends `AbstractSkullBlock` |

### Biomes
| Tag ID                 | Condition                                |
|:-----------------------|:-----------------------------------------|
| `c:precipitation_none` | The biome's precipitation type is `NONE` |
| `c:precipitation_rain` | The biome's precipitation type is `RAIN` |
| `c:precipitation_snow` | The biome's precipitation type is `SNOW` |
