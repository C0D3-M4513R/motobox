package com.ultreon.mods.motobox.mixin;

import com.ultreon.mods.motobox.entity.AutomobileEntity;
import com.ultreon.mods.motobox.util.midnightcontrols.ControllerUtils;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Shadow
    public Input input;

    @Inject(method = "tickRiding", at = @At("TAIL"))
    public void automobility$setAutomobileInputs(CallbackInfo ci) {
        ClientPlayerEntity self = (ClientPlayerEntity)(Object)this;
        if (self.getVehicle() instanceof AutomobileEntity vehicle) {
            if (ControllerUtils.inControllerMode()) {
                vehicle.provideClientInput(
                        ControllerUtils.accelerating(),
                        ControllerUtils.braking(),
                        input.pressingLeft,
                        input.pressingRight,
                        ControllerUtils.drifting()
                );
            } else {
                vehicle.provideClientInput(
                        input.pressingForward,
                        input.pressingBack,
                        input.pressingLeft,
                        input.pressingRight,
                        input.jumping
                );
            }
        }
    }
}
