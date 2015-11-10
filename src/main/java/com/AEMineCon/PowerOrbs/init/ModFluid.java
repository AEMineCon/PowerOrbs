package com.AEMineCon.PowerOrbs.init;

import com.AEMineCon.PowerOrbs.blocks.BlockPowerWater;
import com.AEMineCon.PowerOrbs.blocks.FluidPowerWater;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluid extends Block {

    protected ModFluid(Material mat) {
        super(mat);
    }
    //Fluid
    public static Fluid fluidPowerWater;

    //Fluid Block
    public static Block blockPowerWater;

    public static void registerFluids() {
        fluidPowerWater = new FluidPowerWater("fluidPowerWater").setUnlocalizedName("fluidPowerWater");
        FluidRegistry.registerFluid(fluidPowerWater);

        blockPowerWater = new BlockPowerWater().setBlockName("powerWater");
        GameRegistry.registerBlock(blockPowerWater, "blockPowerWater");
    }

}
