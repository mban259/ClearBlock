package net.minecraft.src;

import java.io.File;
import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.Configuration;

public class mod_ClearBlock extends BaseMod {
	static Configuration configuration;
	public static Block block;
	public int blockID;
	public String fileToOverride;
	public String[] textureFilePath = new String[16];
	public static int[] imageID = new int[16];
	public static HashMap<Boolean, String> hashMap = new HashMap<Boolean, String>();

	public String getVersion() {
		return "1.1.0";
	}

	public void load() {
		hashMap.put(true, "1");
		hashMap.put(false, "0");
		configuration = new Configuration(new File(Minecraft.getMinecraftDir(), "config/mod_ClearBlock.cfg"));
		blockID = LoadConfig();
		fileToOverride = "/terrain.png";
		for (int i = 0; i < 16; i++) {
			imageID[i] = ModLoader.addOverride(fileToOverride, "texture/" + Integer.toBinaryString(i) + ".png");
		}
		block = new ClearBlock(blockID, ModLoader.addOverride(fileToOverride, "texture/0.png"));
		block.setBlockName("ClearBlock");
		block.setResistance(5f);
		block.setStepSound(Block.soundGlassFootstep);
		block.setLightValue(1f);
		block.setHardness(1f);
		ModLoader.registerBlock(block);
		ModLoader.addName(block, "ClearBlock");
		ModLoader.addRecipe(new ItemStack(block, 1), new Object[] { "XXX", "XYX", "XXX", Character.valueOf('X'),
				Block.glass, Character.valueOf('Y'), Item.diamond });
	}

	private int LoadConfig() {
		configuration.load();
		blockID = Integer.parseInt(configuration.getOrCreateBlockIdProperty("Clear Block", 800).value);
		configuration.save();
		return blockID;
	}

}