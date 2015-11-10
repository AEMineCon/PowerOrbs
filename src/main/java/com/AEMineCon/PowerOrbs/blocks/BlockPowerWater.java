package com.AEMineCon.PowerOrbs.blocks;

import com.AEMineCon.PowerOrbs.Reference;
import com.AEMineCon.PowerOrbs.Powerorbs;
import com.AEMineCon.PowerOrbs.init.ModFluid;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockPowerWater extends BlockFluidClassic{

    public BlockPowerWater() {
        super(ModFluid.fluidPowerWater, Material.water);
        this.setBlockTextureName(Reference.Id + ":" + this.getUnlocalizedName());
        this.setCreativeTab(Powerorbs.PWTab);
    }

    @Override
    public boolean canDisplace(IBlockAccess iblockAccess, int x, int y, int z) {
        if (iblockAccess.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(iblockAccess, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }
}
