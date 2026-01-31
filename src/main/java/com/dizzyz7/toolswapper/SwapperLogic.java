package com.dizzyz7.toolswapper;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class SwapperLogic {

    public static void trySwapToBestTool(PlayerEntity player, BlockState state) {
        if (player.isSpectator() || player.isCreative()) return;

        // Если текущий предмет в руке уже подходит (например, уже кирка для камня)
        if (player.getMainHandStack().isSuitableFor(state)) return;

        // Проверяем только хотбар (слоты 0-8)
        int bestSlot = -1;
        float maxSpeed = player.getMainHandStack().getMiningSpeedMultiplier(state);

        for (int i = 0; i < 9; i++) {
            ItemStack stack = player.getInventory().getStack(i);
            
            // Проверяем скорость добычи этим предметом
            float speed = stack.getMiningSpeedMultiplier(state);
            
            if (speed > maxSpeed && stack.isSuitableFor(state)) {
                maxSpeed = speed;
                bestSlot = i;
            }
        }

        // Если нашли инструмент лучше текущего — переключаемся
        if (bestSlot != -1) {
            player.getInventory().selectedSlot = bestSlot;
        }
    }
}
