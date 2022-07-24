package net.amethyst.reworkedtools.item;

import net.amethyst.reworkedtools.ReworkedTools;
import net.amethyst.reworkedtools.item.custom.ExcavatorItem;
import net.amethyst.reworkedtools.item.custom.HammerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item HAMMER = registerItem( "hammer",
            new HammerItem(131,ModToolMaterials.STONE,2,
                    4,(new FabricItemSettings().group(ModItemGroup.HAMMER))));

    public static final Item IRON_HAMMER = registerItem( "iron_hammer",
            new HammerItem(1000, ModToolMaterials.IRON,2,
                    7f,(new FabricItemSettings().group(ModItemGroup.HAMMER))));
    public static final Item DIAMOND_HAMMER = registerItem( "diamond_hammer",
            new HammerItem(3122,ModToolMaterials.DIAMOND,3, 9f,
                    (new FabricItemSettings().group(ModItemGroup.HAMMER))));
    public static final Item NETHERITE_HAMMER = registerItem( "netherite_hammer",
            new HammerItem(4062,ModToolMaterials.NETHERITE,4, 10f,
                    (new FabricItemSettings().group(ModItemGroup.HAMMER))));
    public static final Item EXCAVATOR = registerItem( "excavator",
            new ExcavatorItem(131,ModToolMaterials.STONE,2,
                    4,(new FabricItemSettings().group(ModItemGroup.EXCAVATOR))));

    public static final Item IRON_EXCAVATOR = registerItem( "iron_excavator",
            new ExcavatorItem(1000, ModToolMaterials.IRON,2,
                    7f,(new FabricItemSettings().group(ModItemGroup.EXCAVATOR))));
    public static final Item DIAMOND_EXCAVATOR = registerItem( "diamond_excavator",
            new ExcavatorItem(3122,ModToolMaterials.DIAMOND,3, 9f,
                    (new FabricItemSettings().group(ModItemGroup.EXCAVATOR))));
    public static final Item NETHERITE_EXCAVATOR = registerItem( "netherite_excavator",
            new ExcavatorItem(4062,ModToolMaterials.NETHERITE,4, 10f,
                    (new FabricItemSettings().group(ModItemGroup.EXCAVATOR))));





    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ReworkedTools.MOD_ID, name), item);
    }
    public static void registerModItems(){
        ReworkedTools.LOGGER.debug("Registering Mod Items for " + ReworkedTools.MOD_ID);
    }

}
