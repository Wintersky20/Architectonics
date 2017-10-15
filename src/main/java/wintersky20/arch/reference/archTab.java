package wintersky20.arch.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import wintersky20.arch.init.ModItems;

public class archTab extends CreativeTabs {

	public archTab() {
		super("tabarch");
	}

	@Override
	public Item getTabIconItem() {
		return Items.BAKED_POTATO;
	}

}
