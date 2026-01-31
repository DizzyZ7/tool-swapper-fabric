package com.dizzyz7.toolswapper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;

public class ToolSwapperMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // Слушаем начало атаки на блок
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!world.isClient) {
                SwapperLogic.trySwapToBestTool(player, world.getBlockState(pos));
            }
            return ActionResult.PASS;
        });
    }
}
