package com.AEMineCon.PowerOrbs.Items;

import com.AEMineCon.PowerOrbs.Reference;
import com.AEMineCon.PowerOrbs.Powerorbs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemOrb extends Item{

    private String nameThing;
    private int maxValue;

    public ItemOrb(String name, int maxValue){
        super();
        nameThing = name;
        this.maxValue = maxValue;
        setUnlocalizedName("Orb" + name);
        setCreativeTab(Powerorbs.PWTab);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        if (stack.stackTagCompound == null){
            return false;
        } else {
            boolean isActive = stack.stackTagCompound.getBoolean("showsEffect");
            return isActive;
        }
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setBoolean("showsEffect", false);
            stack.stackTagCompound.setInteger("countdown", maxValue);
        } else {
            boolean isActive = stack.stackTagCompound.getBoolean("showsEffect");
            boolean active = stack.stackTagCompound.getBoolean("activated");
            if (!isActive) {
                stack.stackTagCompound.setBoolean("showsEffect", true);
            } else {
                stack.stackTagCompound.setBoolean("showsEffect", false);
            }
        }
        return stack;
    }

    public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
        if (stack.stackTagCompound != null){
            if (player instanceof EntityPlayer) {
                boolean isActive = stack.stackTagCompound.getBoolean("showsEffect");
                int countdown = stack.stackTagCompound.getInteger("countdown");
                if (isActive) {
                    if (countdown > 0) {
                        if (nameThing.contains("Red")) {
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.jump.id, 0, 5, true));
                            ((EntityPlayer)player).addPotionEffect (new PotionEffect(Potion.moveSpeed.id, 0, 6, true));
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 7, true));
                       } else if (nameThing.contains("Gold")) {
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.jump.id, 0, 3, true));
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 5, true));
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 0, 4, true));
                        } else if (nameThing.contains("Green")) {
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 4, true));
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 0, 2, true));
                        } else if (nameThing.contains("Blue")) {
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 0, 2, true));
                            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 0, 1, true));
                            /*Vec3 look = player.getLookVec();
                            EntityLivingBase creeper = new EntitySquid(world);
                            creeper.posX = player.posX;
                            creeper.posY = player.posY;
                            creeper.posZ = player.posZ;
                            creeper.motionX = look.xCoord*2;
                            creeper.motionY = look.yCoord*2;
                            creeper.motionZ = look.zCoord*2;
                            if (!world.isRemote) {
                                world.spawnEntityInWorld(creeper);
                            }*/
                        }
                        stack.stackTagCompound.setInteger("countdown", countdown-1);
                    } else {
                        --stack.stackSize;
                    }
                }
            } else {
                world.createExplosion(player, player.posX, player.posY, player.posZ, 3, false);
            }
        }
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool1) {
        if (stack.stackTagCompound == null){
            list.add(StatCollector.translateToLocal("tooltip.inactive"));
        } else {
            boolean isActive = stack.stackTagCompound.getBoolean("showsEffect");
            int countdown = stack.stackTagCompound.getInteger("countdown");
            list.add("Active:" + isActive);
            list.add("" + countdown);
        }
    }


    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.Id.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.Id.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
