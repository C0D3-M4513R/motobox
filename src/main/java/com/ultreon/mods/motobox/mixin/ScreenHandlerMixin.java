package com.ultreon.mods.motobox.mixin;

import com.ultreon.mods.motobox.screen.VehicleScreenHandlerContext;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {
    @Inject(
            method = "canUse(Lnet/minecraft/screen/ScreenHandlerContext;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/Block;)Z",
            at = @At("HEAD"), cancellable = true)
    private static void motobox$spoofVehicleAttachmentScreens(ScreenHandlerContext context, PlayerEntity player, Block block, CallbackInfoReturnable<Boolean> cir) {
        if (context instanceof VehicleScreenHandlerContext ctx) {
            boolean isClose = ctx.get((world, pos) -> (player.getBlockPos().getSquaredDistance(pos) < 64), true);
            if (isClose && ctx.getAttachmentBlockState().isOf(block)) {
                cir.setReturnValue(true);
            }
        }
    }
}
