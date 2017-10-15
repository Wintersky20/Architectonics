package wintersky20.arch.proxy;

import net.minecraftforge.fml.client.FMLClientHandler;
import wintersky20.arch.init.ModBlocks;
import wintersky20.arch.init.ModItems;

public class ClientProxy implements CommonProxy{

	public void init() {
		
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		
	}

	@Override
	public boolean isJumpPressed()
	{
		return FMLClientHandler.instance().getClient().gameSettings.keyBindJump.isKeyDown();
	}

	

}
