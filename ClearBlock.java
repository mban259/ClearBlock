package net.minecraft.src;

import java.util.Random;

import net.minecraft.client.Minecraft;

public class ClearBlock extends Block {
	static Minecraft minecraft = ModLoader.getMinecraftInstance();
	World world;

	public ClearBlock(int i, int j) {
		super(i, j, Material.rock);
	}

	public int isDropped(int i, Random random, int j) {
		return this.blockID;
	}

	public int getBlockTexture(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
		boolean up, down, south, east, west, north;
		int texture;
		world = minecraft.theWorld;
		up = world.getBlockId(x, y + 1, z) == this.blockID;
		down = world.getBlockId(x, y - 1, z) == this.blockID;
		east = world.getBlockId(x + 1, y, z) == this.blockID;
		west = world.getBlockId(x - 1, y, z) == this.blockID;
		south = world.getBlockId(x, y, z + 1) == this.blockID;
		north = world.getBlockId(x, y, z - 1) == this.blockID;
		switch (side) {
		case 1:
		case 0:
			return mod_ClearBlock.imageID[Integer
					.parseInt((mod_ClearBlock.hashMap.get(west) + mod_ClearBlock.hashMap.get(north)
							+ mod_ClearBlock.hashMap.get(east) + mod_ClearBlock.hashMap.get(south)), 2)];
		case 2:
			return mod_ClearBlock.imageID[Integer
					.parseInt((mod_ClearBlock.hashMap.get(east) + mod_ClearBlock.hashMap.get(up)
							+ mod_ClearBlock.hashMap.get(west) + mod_ClearBlock.hashMap.get(down)), 2)];
		case 3:
			return mod_ClearBlock.imageID[Integer
					.parseInt((mod_ClearBlock.hashMap.get(west) + mod_ClearBlock.hashMap.get(up)
							+ mod_ClearBlock.hashMap.get(east) + mod_ClearBlock.hashMap.get(down)), 2)];
		case 4:
			return mod_ClearBlock.imageID[Integer
					.parseInt((mod_ClearBlock.hashMap.get(north) + mod_ClearBlock.hashMap.get(up)
							+ mod_ClearBlock.hashMap.get(south) + mod_ClearBlock.hashMap.get(down)), 2)];
		case 5:
			return mod_ClearBlock.imageID[Integer
					.parseInt((mod_ClearBlock.hashMap.get(south) + mod_ClearBlock.hashMap.get(up)
							+ mod_ClearBlock.hashMap.get(north) + mod_ClearBlock.hashMap.get(down)), 2)];
		default:
			return mod_ClearBlock.imageID[0];
		}

	}

	public int quantityDropped(Random random) {
		return 1;
	}
}