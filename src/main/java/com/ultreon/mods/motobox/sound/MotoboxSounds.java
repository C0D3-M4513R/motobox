package com.ultreon.mods.motobox.sound;

import com.ultreon.mods.motobox.Motobox;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;

public class MotoboxSounds {
    public static final SoundEvent COLLISION = register("entity.vehicle.collision");
    public static final SoundEvent LANDING = register("entity.vehicle.landing");
    public static final SoundEvent SKID = register("entity.vehicle.skid");

    public static final SoundEvent STONE_ENGINE = register("entity.vehicle.stone_engine");
    public static final SoundEvent MOTORBIKE_ENGINE = register("entity.vehicle.motorbike_engine");
    public static final SoundEvent TRUCK_ENGINE = register("entity.vehicle.truck_engine");

    private static SoundEvent register(String path) {
        var id = Motobox.id(path);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void init() {
    }
}
