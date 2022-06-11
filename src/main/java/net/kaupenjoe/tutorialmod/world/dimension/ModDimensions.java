package net.kaupenjoe.tutorialmod.world.dimension;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> KJDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(TutorialMod.MOD_ID, "kjdim"));
    public static final ResourceKey<DimensionType> KJDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, KJDIM_KEY.location());

    public static void register() {
        System.out.println("Registering ModDimensions for " + TutorialMod.MOD_ID);
    }
}
