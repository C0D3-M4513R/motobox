package com.ultreon.mods.motobox.item;

import com.ultreon.mods.motobox.vehicle.VehicleFrame;

public class VehicleFrameItem extends VehicleComponentItem<VehicleFrame> {
    public VehicleFrameItem(Settings settings) {
        super(settings, "frame", "frame", VehicleFrame.REGISTRY);
    }

    @Override
    protected boolean addToCreative(VehicleFrame component) {
        return super.addToCreative(component);
    }
}
