package wintersky20.arch.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;
import wintersky20.arch.arch;
import wintersky20.arch.reference.Reference;

public class ItemArcJetpack extends ItemArmor{

	public ItemArcJetpack() {
		super(EnumHelper.addArmorMaterial("ArcJet", "arch:jetpack", 4000, new int[]{4,14,10,6}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F), 2, EntityEquipmentSlot.CHEST);
		setUnlocalizedName(Reference.archItems.ARCJET.getUnlocalizedName());
		setRegistryName(Reference.archItems.ARCJET.getRegistryName());
		setCreativeTab(arch.CREATIVE_TAB);
		this.setMaxDamage(0);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(" ");
		tooltip.add("§7Double space for flight.§7");
		tooltip.add(" ");
		tooltip.add("§7Space for hovering.§7");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		
		
		player.fallDistance = 0;
		
		
		if (!player.capabilities.isFlying && arch.proxy.isJumpPressed())
        {
            player.motionY += 0.1;
        }

        if (!player.onGround)
        {
            if (player.motionY <= 0)
            {
                player.motionY *= 1.0;
            }
            if (!player.capabilities.isFlying)
            {
                if (player.moveForward < 0)
                {
                    player.motionX *= 0.9;
                    player.motionZ *= 0.9;
                } else if (player.moveForward > 0 && player.motionX * player.motionX + player.motionY * player.motionY + player.motionZ * player.motionZ < 3)
                {
                    player.motionX *= 1.1;
                    player.motionZ *= 1.1;
                }
            }
      }
        
    	if(true){
    		if(world.isRemote)
    	player.capabilities.allowFlying = true;
    	}
	}
}
