package com.AEMineCon.PowerOrbs.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPowerOrbBucket extends ItemCrafting{

    private Block block;

    public ItemPowerOrbBucket(String liquid, Block block){
        super("Bucket" + liquid);
        setUnlocalizedName("Bucket" + liquid);
        setMaxStackSize(1);
        this.block = block;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        world.setBlock(x, y, z, block);
        player.inventory.consumeInventoryItem(this);
        player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
        return true;
    }
}
