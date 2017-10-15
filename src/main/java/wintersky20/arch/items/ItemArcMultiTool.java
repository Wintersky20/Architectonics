package wintersky20.arch.items;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;

import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import wintersky20.arch.arch;
import wintersky20.arch.reference.Reference;

public class ItemArcMultiTool extends ItemPickaxe {

	protected float efficiencyOnProperMaterial;

	private static boolean hasEnchantment = true;

	private boolean shiftRotating;

	private static final Set<Block> EFFECTIVE_ON = com.google.common.collect.Sets
			.newHashSet(new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST,
					Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON,
					Blocks.WOODEN_PRESSURE_PLATE, Blocks.LEAVES, Blocks.LEAVES2, Blocks.WOOL, Blocks.WEB });

	public ItemArcMultiTool() {
		super(EnumHelper.addToolMaterial("PhBr", 8, 0, 40.0F, 19.0F, 37));
		setUnlocalizedName(Reference.archItems.ARCMULTITOOL.getUnlocalizedName());
		setRegistryName(Reference.archItems.ARCMULTITOOL.getRegistryName());
		setCreativeTab(arch.CREATIVE_TAB);
		this.attackSpeed = 0.9F;
		this.setHasSubtypes(true);
		efficiencyOnProperMaterial = 50;
		setContainerItem(this);
		

	}

	public boolean isEnchantable(ItemStack stack) {
		return true;
	}

	public boolean canHarvestBlock(Block par1Block) {
		return true;
	}

	public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
		return efficiencyOnProperMaterial;
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("pickaxe");
		hashSet.add("axe");
		hashSet.add("shovel");
		hashSet.add("shears");
		hashSet.add("hoe");
		return hashSet;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE && material != Material.CLOTH && material != Material.LEAVES 
		&& material != Material.WEB && material != Material.GLASS && material != Material.BARRIER && material != Material.DRAGON_EGG && material != Material.SPONGE
		&& material != Material.ICE && material != Material.GOURD
		
				? super.getStrVsBlock(stack, state)
				: this.efficiencyOnProperMaterial;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(" ");
		tooltip.add("§9Properties:§9");
		tooltip.add("§7Pickaxe VIII§7");
		tooltip.add("§7Axe VII§7");
		tooltip.add("§7Shovel V§7");
		tooltip.add("§7Shears (*just for entities)§7");
		tooltip.add("§7Hoe (*on right click on a block)§7");
		tooltip.add(" ");
		tooltip.add("§9Durability:§9 §5§kInfinite§k§5");
		tooltip.add(" ");
		tooltip.add("§9+37 Enchantability§9");
		tooltip.add(" ");
		tooltip.add("§9Enchants:§9");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
	
	// sheep shearing

	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player,
			EntityLivingBase entity, net.minecraft.util.EnumHand hand) {
		if (entity.worldObj.isRemote) {
			return false;
		}
		if (entity instanceof net.minecraftforge.common.IShearable) {
			net.minecraftforge.common.IShearable target = (net.minecraftforge.common.IShearable) entity;
			BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
			if (target.isShearable(itemstack, entity.worldObj, pos)) {
				java.util.List<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, pos,
						net.minecraft.enchantment.EnchantmentHelper
								.getEnchantmentLevel(net.minecraft.init.Enchantments.FORTUNE, itemstack));

				java.util.Random rand = new java.util.Random();
				for (ItemStack stack : drops) {
					net.minecraft.entity.item.EntityItem ent = entity.entityDropItem(stack, 1.0F);
					ent.motionY += rand.nextFloat() * 0.05F;
					ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
					ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
				}
				itemstack.damageItem(1, entity);
			}
			return true;
		}
		return false;
	}

	// hoe

	 @SuppressWarnings("incomplete-switch")
	    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
	        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, stack))
	        {
	            return EnumActionResult.FAIL;
	        }
	        else
	        {
	            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
	            if (hook != 0) return hook > 0 ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;

	            IBlockState iblockstate = worldIn.getBlockState(pos);
	            Block block = iblockstate.getBlock();

	            if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
	            {
	                if (block == Blocks.GRASS || block == Blocks.GRASS_PATH)
	                {
	                    this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
	                    return EnumActionResult.SUCCESS;
	                }

	                if (block == Blocks.DIRT)
	                {
	                    switch ((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT))
	                    {
	                        case DIRT:
	                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.FARMLAND.getDefaultState());
	                            return EnumActionResult.SUCCESS;
	                        case COARSE_DIRT:
	                            this.setBlock(stack, playerIn, worldIn, pos, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
	                            return EnumActionResult.SUCCESS;
	                    }
	                }
	            }

	            return EnumActionResult.PASS;
	        }
	    }


	    protected void setBlock(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
	    {
	        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

	        if (!worldIn.isRemote)
	        {
	            worldIn.setBlockState(pos, state, 11);
	        }
	    }

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/*
	 * @Override public boolean onBlockDestroyed(ItemStack stack, World worldIn,
	 * IBlockState state, BlockPos pos, EntityLivingBase entityLiving) { double up =
	 * pos.getY() + 1; double down = pos.getY() - 1; double left = pos.getX() - 1;
	 * double right = pos.getX() + 1; double leftZ = pos.getZ() - 1; double rightZ =
	 * pos.getZ() + 1;
	 * 
	 * switch(entityLiving.getHorizontalFacing()) { case DOWN:
	 * System.out.println("Mining at direction DOWN"); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, rightZ), true); break; case EAST:
	 * System.out.println("Mining at direction EAST"); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, rightZ), true); break; case NORTH:
	 * System.out.println("Mining at direction NORTH"); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, pos.getY(), pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, pos.getY(), pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, down, pos.getZ()), true); break; case SOUTH:
	 * System.out.println("Mining at direction SOUTH"); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, pos.getY(), pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, pos.getY(), pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(left, down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(right, down, pos.getZ()), true); break; case UP:
	 * System.out.println("Mining at direction UP"); break; case WEST:
	 * System.out.println("Mining at direction WEST"); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, pos.getZ()), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), pos.getY(), rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, leftZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), up, rightZ), true); worldIn.destroyBlock(new
	 * BlockPos(pos.getX(), down, leftZ), true); break; default: break;
	 * 
	 * } return true; }
	 */

}
