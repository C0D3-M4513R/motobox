package com.ultreon.mods.motobox.vehicle.render.engine;

import com.ultreon.mods.motobox.Motobox;
import com.ultreon.mods.motobox.vehicle.render.BaseModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class IronEngineModel extends BaseModel {
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Motobox.id("vehicle/engine/iron"), "main");

    public IronEngineModel(EntityRendererFactory.Context ctx) {
        super(RenderLayer::getEntityCutout, ctx, MODEL_LAYER);
    }
}