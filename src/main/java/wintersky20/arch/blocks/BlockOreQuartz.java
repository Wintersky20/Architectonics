package wintersky20.arch.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wintersky20.arch.arch;
import wintersky20.arch.reference.Reference;

public class BlockOreQuartz extends Block {


	private static BlockOreQuartz block;

	public BlockOreQuartz() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.archBlocks.OREQUARTZ.getUnlocalizedName());
		setRegistryName(Reference.archBlocks.OREQUARTZ.getRegistryName());
		setHardness(2.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(arch.CREATIVE_TAB);
		
		
	}
	

	@Override
	public int quantityDropped(Random par1Random) {
		return 2;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
		return new ItemStack(Items.QUARTZ).getItem();
	}
	
}
