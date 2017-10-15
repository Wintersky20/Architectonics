package wintersky20.arch.init;

import com.jcraft.jorbis.Block;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModCrafting {

	public static void register() {
		
		//Misc Crafting Recipes
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.GLOWSTONE_DUST, 4), new Object[] {Blocks.GLOWSTONE}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.QUARTZ, 4), new Object[] {Blocks.QUARTZ_BLOCK}));
		
		//Misc Smelting Recipes
		
		GameRegistry.addSmelting(new ItemStack(ModBlocks.OreQuartz), new ItemStack(Items.QUARTZ, 2), 1F);

		// Crafting
			//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Hammer), " IO", " SI", "S ", 'I', "ingotIron", 'O', "obsidian", 'S', "stickWood"));

		// GameRegistry.addRecipe(new ShapelessOreRecipe(new
		// ItemStack(ModItems.EnderiumNugget, 9), new Object[] {"ingotEnderium"}));

		// Smelling
			//GameRegistry.addSmelting(new ItemStack(ModBlocks.OreQuartz), new ItemStack(Items.QUARTZ, 2), 1F);

		// Test
		//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.QUARTZ), "NN", " ", " ", 'N', "oreQuartz"));

	}
	
}
