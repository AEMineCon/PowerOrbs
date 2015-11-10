package com.AEMineCon.PowerOrbs.init;

import com.AEMineCon.PowerOrbs.Items.ItemBlade;
import com.AEMineCon.PowerOrbs.Items.ItemCrafting;
import com.AEMineCon.PowerOrbs.Items.ItemOrb;
import com.AEMineCon.PowerOrbs.Items.ItemPowerOrbBucket;
import com.AEMineCon.PowerOrbs.Powerorbs;
import com.AEMineCon.PowerOrbs.blocks.BlockPowerWater;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

    public static Item BlueOrb = new ItemOrb("Blue", 1200);
    public static Item GreenOrb = new ItemOrb("Green", 2400);
    public static Item GoldOrb = new ItemOrb("Gold", 4800);
    public static Item RedOrb = new ItemOrb("Red", 9600);

    public static Item.ToolMaterial blueblade = EnumHelper.addToolMaterial("BlueBlade", 2, 1600, 5f, 3.75f, 20);
    public static Item BluePowerSword = new ItemBlade(blueblade, "BladeBlue");

    public static Item.ToolMaterial greenblade = EnumHelper.addToolMaterial("GreenBlade", 2, 2000, 6f, 4f, 20);
    public static Item GreenPowerSword = new ItemBlade(greenblade, "BladeGreen");

    public static Item.ToolMaterial goldblade = EnumHelper.addToolMaterial("GoldBlade", 2, 2100, 7f, 6f, 20);
    public static Item GoldPowerSword = new ItemBlade(goldblade, "BladeGold");

    public static Item.ToolMaterial redblade = EnumHelper.addToolMaterial("Red Blade", 3, 2500, 8f, 11f, 25);
    public static Item RedPowerSword = new ItemBlade(redblade, "BladeRed");

    public static Item blankOrb = new ItemCrafting("blankOrb");
    public static Item blueWaterBucket = new ItemPowerOrbBucket("PowerWater", ModFluid.blockPowerWater).setCreativeTab(Powerorbs.PWTab);

    public static void init(){
        GameRegistry.registerItem(BlueOrb, "Blue Orb");
        GameRegistry.registerItem(GreenOrb, "Green Orb");
        GameRegistry.registerItem(GoldOrb, "Gold Orb");
        GameRegistry.registerItem(RedOrb, "Red Orb");

        GameRegistry.registerItem(BluePowerSword, "Blade Blue");
        GameRegistry.registerItem(GreenPowerSword, "Blade Green");
        GameRegistry.registerItem(GoldPowerSword, "Blade Gold");
        GameRegistry.registerItem(RedPowerSword, "Blade Red");

        GameRegistry.registerItem(blankOrb, "blankOrb");
        GameRegistry.registerItem(blueWaterBucket, "blueWaterBucket");
    }
}
