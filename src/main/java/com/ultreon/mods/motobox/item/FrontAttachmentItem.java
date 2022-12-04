package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.entity.VehicleEntity;
import com.ultreon.mods.motobox.vehicle.attachment.FrontAttachmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class FrontAttachmentItem extends VehicleComponentItem<FrontAttachmentType<?>> implements VehicleInteractable {
    public FrontAttachmentItem(Settings settings) {
        super(settings, "attachment", "attachment.front", FrontAttachmentType.REGISTRY);
    }

    @Override
    public ActionResult interactVehicle(ItemStack stack, PlayerEntity player, Hand hand, VehicleEntity vehicle) {
        if (vehicle.getFrontAttachment().type.isEmpty()) {
            if (player.world.isClient()) {
                return ActionResult.SUCCESS;
            }

            vehicle.setFrontAttachment(getComponent(stack));
            vehicle.playHitSound();
            if (!player.isCreative()) {
                stack.decrement(1);
            }
        }

        return ActionResult.PASS;
    }
}