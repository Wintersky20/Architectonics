package wintersky20.arch.init;

import java.awt.Image;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wintersky20.arch.items.ItemArcJetpack;
import wintersky20.arch.items.ItemArcCompass;
import wintersky20.arch.items.ItemArcMultiTool;



public class ModItems {

	
	public static Item ArcMultiTool;
	public static Item ArcCompass;
	public static Item ArcJet;
	
	
	public static void init() {
		ArcMultiTool = new ItemArcMultiTool();
		ArcCompass = new ItemArcCompass();
		ArcJet = new ItemArcJetpack();



	}

	public static void register() {
		GameRegistry.register(ArcMultiTool);
		GameRegistry.register(ArcCompass);
		GameRegistry.register(ArcJet);

	}
	
	public static void registerRenders() {
		registerRender(ArcMultiTool);
		registerRender(ArcCompass);
		registerRender(ArcJet);

	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		
	}
}
