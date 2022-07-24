package net.amethyst.reworkedtools.item;

import net.amethyst.reworkedtools.ReworkedTools;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup HAMMER = FabricItemGroupBuilder.build(
            new Identifier(ReworkedTools.MOD_ID, "reworked_tools1"), () -> new ItemStack(ModItems.HAMMER));
    public static final ItemGroup EXCAVATOR = FabricItemGroupBuilder.build(
            new Identifier(ReworkedTools.MOD_ID, "reworked_tools2"), () -> new ItemStack(ModItems.EXCAVATOR));
}
