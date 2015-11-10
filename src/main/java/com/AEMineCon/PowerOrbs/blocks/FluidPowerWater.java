package com.AEMineCon.PowerOrbs.blocks;

import net.minecraftforge.fluids.Fluid;

public class FluidPowerWater extends Fluid{
    public FluidPowerWater(String string) {
        super(string);
        this.setDensity(2000);
        this.setTemperature(22);
        this.setViscosity(2600);
        this.setGaseous(false);
    }
}
