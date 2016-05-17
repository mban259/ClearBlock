package net.minecraft.src;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;

public class mod_ClearBlock extends BaseMod {
	static Configuration configuration;
	public static Block block;
	public int blockID;
	public String fileToOverride;
	public String textureFilePath;

	public String getVersion() {
		return "1.0.0";
	}

	public void load() {
		configuration = new Configuration(new File(Minecraft.getMinecraftDir(), "config/mod_ClearBlock.cfg"));
		blockID = LoadConfig();
		fileToOverride = "/terrain.png";
		textureFilePath = "texture/clearblock.png";
		block = new ClearBlock(blockID, ModLoader.addOverride(fileToOverride, textureFilePath));
		block.setBlockName("ClearBlock");
		block.setResistance(5f);
		block.setStepSound(Block.soundGlassFootstep);
		block.setLightValue(1f);
		block.setHardness(1f);
		ModLoader.registerBlock(block);
		ModLoader.addName(block, "ClearBlock");
		ModLoader.addRecipe(new ItemStack(block, 1), new Object[] { "XXX", "XYX", "XXX", Character.valueOf('X'),
				Block.glass, Character.valueOf('Y'), Item.diamond });
		// ModLoader.addRecipe(new ItemStack(block, 1), new Object[] { "X",
		// Character.valueOf('X'), Block.dirt });
	}

	private int LoadConfig() {
		configuration.load();
		blockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("Clear Block", 800).value);
		configuration.save();
		return blockID;
	}

}