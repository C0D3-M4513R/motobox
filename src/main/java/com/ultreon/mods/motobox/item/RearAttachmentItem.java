package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.RearAttachmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class RearAttachmentItem extends VehicleComponentItem<RearAttachmentType<?>> implements VehicleInteractable {
    public RearAttachmentItem(Settings settings) {
        super(settings, "attachment", "attachment.rear", RearAttachmentType.REGISTRY);
    }

    @Override
    public ActionResult interactVehicle(ItemStack stack, PlayerEntity player, Hand hand, VehicleEntity vehicle) {
        if (vehicle.getRearAttachment().type.isEmpty()) {
            if (player.world.isClient()) {
                return ActionResult.SUCCESS;
            }

            vehicle.setRearAttachment(getComponent(stack));
            vehicle.playHitSound();
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }

        return ActionResult.PASS;
    }
}
