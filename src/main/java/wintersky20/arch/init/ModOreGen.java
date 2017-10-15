package wintersky20.arch.init;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModOreGen extends WorldGenMinable implements IWorldGenerator {

	private int frequency;

	public ModOreGen(IBlockState state, int blockCount, int frequency) {
		super(state, blockCount);
		this.frequency = frequency;
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		for (int i = 0; i < frequency; i++) {
			int offsetX = random.nextInt(16);
			int offsetZ = random.nextInt(16);

			int posX = chunkX * 16 + offsetX;
			int posZ = chunkZ * 16 + offsetZ;

			int posY = random.nextInt(chunkProvider.getLoadedChunk(chunkX, chunkZ).getHeightValue(offsetX, offsetZ));
			generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}

}
