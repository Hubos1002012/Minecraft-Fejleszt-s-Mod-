package net.mcreator.minecraftreal.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.minecraftreal.MinecraftRealModElements;
import net.mcreator.minecraftreal.MinecraftRealMod;

import java.util.Map;

@MinecraftRealModElements.ModElement.Tag
public class BlodBlockAddedProcedure extends MinecraftRealModElements.ModElement {
	public BlodBlockAddedProcedure(MinecraftRealModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftRealMod.LOGGER.warn("Failed to load dependency x for procedure BlodBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftRealMod.LOGGER.warn("Failed to load dependency y for procedure BlodBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftRealMod.LOGGER.warn("Failed to load dependency z for procedure BlodBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftRealMod.LOGGER.warn("Failed to load dependency world for procedure BlodBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.WET_SPONGE.getDefaultState(), 3);
		}
	}
}
