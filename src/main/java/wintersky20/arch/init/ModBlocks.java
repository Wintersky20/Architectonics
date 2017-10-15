package wintersky20.arch.init;



import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wintersky20.arch.blocks.BlockOreQuartz;

public class ModBlocks {
	
		public static Block OreQuartz;

	
	
	public static void init() {
		OreQuartz = new BlockOreQuartz();

		
	}

	public static void register() {
		registerBlock(OreQuartz);

		
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
		
	}
	
	public static void registerRenders() {
		registerRender(OreQuartz);

		
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		
	}

}
