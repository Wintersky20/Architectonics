package wintersky20.arch.reference;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds
{
    public static KeyBinding nightvision;
    
    public static void register()
    {
    	nightvision = new KeyBinding("key.nightvision", Keyboard.KEY_N, "key.categories.Architectonics");
        ClientRegistry.registerKeyBinding(nightvision);

    }
}