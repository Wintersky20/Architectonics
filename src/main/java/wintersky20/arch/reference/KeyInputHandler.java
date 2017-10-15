package wintersky20.arch.reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import wintersky20.arch.init.ModItems;

public class KeyInputHandler {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			if (Keybinds.nightvision.isPressed()) {
				EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
				int i = (int) entity.posX;
				int j = (int) entity.posY;
				int k = (int) entity.posZ;
				MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
				World world = server.worldServers[0];

				if (true) {
					if (!entity.isPotionActive(MobEffects.NIGHT_VISION) && entity.inventory.hasItemStack(new ItemStack(ModItems.ArcCompass))) {

						if (true) {
							if (entity instanceof EntityLivingBase)
								((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
						}
					}
					else
					{
						entity.removePotionEffect(MobEffects.NIGHT_VISION);
					}
					
				}

			}
		}	
	}
}

