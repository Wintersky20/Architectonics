package wintersky20.arch.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import wintersky20.arch.init.ModBlocks;
import wintersky20.arch.init.ModItems;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
		
		
		 	OreDictionary.registerOre("oreQuartz", ModBlocks.OreQuartz);
		 	OreDictionary.registerOre("toolCraftHammer", ModItems.ArcMultiTool);

	}

}
