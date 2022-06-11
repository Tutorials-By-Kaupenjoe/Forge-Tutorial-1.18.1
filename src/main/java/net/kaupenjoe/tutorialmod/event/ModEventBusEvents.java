package net.kaupenjoe.tutorialmod.event;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.kaupenjoe.tutorialmod.entity.custom.RaccoonEntity;
import net.kaupenjoe.tutorialmod.event.loot.CoalCokeFromCreeperAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.CucumberSeedsFromGrassAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.DowsingRodInIglooAdditionModifier;
import net.kaupenjoe.tutorialmod.recipe.GemCuttingStationRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(TutorialMod.MOD_ID,"cucumber_seeds_from_grass"),
                    new CucumberSeedsFromGrassAdditionModifier.Serializer());
            helper.register(new ResourceLocation(TutorialMod.MOD_ID,"dowsing_rod_in_igloo"),
                    new DowsingRodInIglooAdditionModifier.Serializer());
            helper.register(new ResourceLocation(TutorialMod.MOD_ID,"coal_coke_from_creeper"),
                    new CoalCokeFromCreeperAdditionModifier.Serializer());
        });

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(TutorialMod.MOD_ID, GemCuttingStationRecipe.Type.ID),
                    GemCuttingStationRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
    }
}
