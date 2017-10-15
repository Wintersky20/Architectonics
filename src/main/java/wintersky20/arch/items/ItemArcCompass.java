package wintersky20.arch.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wintersky20.arch.arch;
import wintersky20.arch.init.ModItems;
import wintersky20.arch.reference.KeyInputHandler;
import wintersky20.arch.reference.Keybinds;
import wintersky20.arch.reference.Reference;

public class ItemArcCompass extends Item{
	
	public ItemArcCompass(){
	setUnlocalizedName(Reference.archItems.ARCCOMPASS.getUnlocalizedName());
	setRegistryName(Reference.archItems.ARCCOMPASS.getRegistryName());
	setCreativeTab(arch.CREATIVE_TAB);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };
	
    private void setImmunity(Entity entity, boolean immune) {
        ObfuscationReflectionHelper.setPrivateValue(Entity.class, entity, immune, IS_IMMUNE_TO_FIRE);
    }

    @Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		int i = (int) entity.posX;
		int j = (int) entity.posY;
		int k = (int) entity.posZ;
		//Random Feeding
		if ((Math.random() * 100) <= 5) {

			if ((Math.random() * 100) <= 5) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 100, 225, true, false));
			}

		}
		//water respiration
		if (entity.isInWater())
        {
			entity.setAir(300);
        }

		//Fire Clearing
		if (entity.isBurning()) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).extinguish();
			}
		//Additional States
		if (true) {
			if (entity instanceof EntityLivingBase)
				entity.stepHeight = 1F;
				entity.fallDistance = 0;
				setImmunity(entity, true);
		}
		
		//Potios Clearing
		if(!(entity instanceof EntityPlayer))
			return;
		EntityPlayer player = (EntityPlayer) entity;
		if(player.isPotionActive(MobEffects.WITHER)){
			player.removePotionEffect(MobEffects.WITHER);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.POISON)){
			player.removePotionEffect(MobEffects.POISON);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.NAUSEA)){
			player.removePotionEffect(MobEffects.NAUSEA);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.SLOWNESS)){
			player.removePotionEffect(MobEffects.SLOWNESS);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.BLINDNESS)){
			player.removePotionEffect(MobEffects.BLINDNESS);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.INSTANT_DAMAGE)){
			player.removePotionEffect(MobEffects.INSTANT_DAMAGE);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		if(player.isPotionActive(MobEffects.HUNGER)){
			player.removePotionEffect(MobEffects.HUNGER);
			for(int particles = 0; particles < 10; particles++) {
				double gauss1 = gaussian(world.rand);
				double gauss2 = gaussian(world.rand);
				world.spawnParticle(EnumParticleTypes.SPELL_MOB, player.posX + gauss1, player.posY + player.height / 2, player.posZ + gauss2, 0.0, 0.0, 1.0);
			}
		}
		
		//water and lava walking
		if (world.isRemote)
        {
            int x = (int) Math.floor(player.posX);
            int y = (int) (player.posY - player.getYOffset());
            int z = (int) Math.floor(player.posZ);
            BlockPos pos = new BlockPos(x, y, z);
            Block b = world.getBlockState(pos.down()).getBlock();

            if ((b == Blocks.WATER || b == Blocks.FLOWING_WATER) && world.isAirBlock(pos))
            {
                if (!player.isSneaking())
                {
                    player.motionY = 0.0d;
                    player.fallDistance = 0.0f;
                    player.onGround = true;
                }
            }
        }
		
		if (world.isRemote)
        {
            int x = (int) Math.floor(player.posX);
            int y = (int) (player.posY - player.getYOffset());
            int z = (int) Math.floor(player.posZ);
            BlockPos pos = new BlockPos(x, y, z);

            Block b = world.getBlockState(pos.down()).getBlock();

            if ((b == Blocks.LAVA || b == Blocks.FLOWING_LAVA) && world.isAirBlock(pos))
            {
                if (!player.isSneaking())
                {
                    player.motionY = 0.0d;
                    player.fallDistance = 0.0f;
                    player.onGround = true;
                }
            }
        }
		
		//active speed when i press space and sprint
		if (!player.onGround)
        {
            if (player.motionY <= 0)
            {
                player.motionY *= 0.90;
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
        
}	

		public double gaussian(Random rand) {
			return rand.nextGaussian() / 6;
		}


}
