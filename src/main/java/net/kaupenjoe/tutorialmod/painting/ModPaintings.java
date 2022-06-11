package net.kaupenjoe.tutorialmod.painting;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TutorialMod.MOD_ID);


    public static final RegistryObject<PaintingVariant> MARATHON =
            PAINTING_MOTIVES.register("marathon", () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> FAMILY =
            PAINTING_MOTIVES.register("family", () -> new PaintingVariant(16, 32));


    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}
