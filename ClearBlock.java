package net.minecraft.src;

import java.util.Random;

public class ClearBlock extends Block {
	public ClearBlock(int i, int j) {
		super(i, j, Material.rock);
	}

	public int isDropped(int i, Random random, int j) {
		return this.blockID;
	}

	public int quantityDropped(Random random) {
		return 1;
	}
}
