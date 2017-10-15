package wintersky20.arch.reference;

public class Reference {

	public static final String MOD_ID = "arch";
	public static final String NAME = "Architectonics";
	public static final String VERSION = "1.0.0";
	public static final String ACCEPTED_VERSION = "[1.10.2]";

	public static final String CLINET_PROXY_CLASS = "wintersky20.arch.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "wintersky20.arch.proxy.ServerProxy";

	public static enum archItems {
		ARCMULTITOOL("ArcMultiTool", "ItemArcMultiTool"),
		ARCCOMPASS("ArcCompass", "ItemArcCompass"),
		ARCJET("ArcJet", "ItemArcJetpack");


		private String unlocalizedName;
		private String registryName;

		archItems(String unlocalizedName, String registryName) {

			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;

		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

		public String getRegistryName() {
			return registryName;
		}

	}

	public static enum archBlocks {

		OREQUARTZ("OreQuartz", "BlockOreQuartz");

		private String unlocalizedName;
		private String registryName;

		archBlocks(String unlocalizedName, String registryName) {

			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;

		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

		public String getRegistryName() {
			return registryName;
		}

	}

}
