package wintersky20.arch;

import net.java.games.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wintersky20.arch.init.ModBlocks;
import wintersky20.arch.init.ModCrafting;
import wintersky20.arch.init.ModItems;
import wintersky20.arch.init.ModOreGen;
import wintersky20.arch.proxy.CommonProxy;
import wintersky20.arch.reference.KeyInputHandler;
import wintersky20.arch.reference.Keybinds;
import wintersky20.arch.reference.OreDictionaryHandler;
import wintersky20.arch.reference.Reference;
import wintersky20.arch.reference.archTab;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class arch {
	
	@Instance
	public static arch instance;
	
	@SidedProxy(clientSide = Reference.CLINET_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs CREATIVE_TAB = new archTab();
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) 
	{
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
		
		Keybinds.register();
	    MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event) 
	{
		
		OreDictionaryHandler.registerOreDictionary();
		proxy.init();
		
		ModCrafting.register();
		
		//WorldGen
		GameRegistry.registerWorldGenerator(new ModOreGen(ModBlocks.OreQuartz.getDefaultState(), 15, 10), 5);

	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) 
	{
		
	}

}
