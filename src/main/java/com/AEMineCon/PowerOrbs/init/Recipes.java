package com.AEMineCon.PowerOrbs.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {

    public static void init(){
        GameRegistry.addRecipe(new ItemStack(ModItems.GreenOrb), "BBB", "BBB", "BBB", 'B', new ItemStack(ModItems.BlueOrb));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BlueOrb, 9), new ItemStack(ModItems.GreenOrb));
        GameRegistry.addSmelting(ModItems.GreenOrb, new ItemStack(ModItems.GoldOrb), 3);
        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BlueOrb), "   ", " B ", "   ", 'B', new ItemStack(ModItems.BlueOrb)));
    }
}
