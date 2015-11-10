package com.AEMineCon.PowerOrbs;

import com.AEMineCon.PowerOrbs.init.ModFluid;
import com.AEMineCon.PowerOrbs.init.ModItems;
import com.AEMineCon.PowerOrbs.init.ModOreDictionary;
import com.AEMineCon.PowerOrbs.init.Recipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

@Mod(modid = Reference.Id, name = Reference.Name, version = Reference.Version)
public class Powerorbs {
    @Mod.Instance(Reference.Id)
    public static Powerorbs instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModFluid.registerFluids();
        ModOreDictionary.init();
        Recipes.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public static final CreativeTabs PWTab = new CreativeTabs(Reference.Id)
    {
        @Override
        public String getTranslatedTabLabel()
        {
            return StatCollector.translateToLocal("Powerorbs.tab.name");
        }

        @Override
        public Item getTabIconItem() {
            return ModItems.BlueOrb;
        }
    };
}
