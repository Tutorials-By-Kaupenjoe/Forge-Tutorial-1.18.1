package net.kaupenjoe.tutorialmod.event;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.kaupenjoe.tutorialmod.entity.client.armor.CitrineArmorRenderer;
import net.kaupenjoe.tutorialmod.entity.custom.RaccoonEntity;
import net.kaupenjoe.tutorialmod.event.loot.CoalCokeFromCreeperAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.CucumberSeedsFromGrassAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.DowsingRodInIglooAdditionModifier;
import net.kaupenjoe.tutorialmod.item.custom.CitrineArmorItem;
import net.kaupenjoe.tutorialmod.particle.ModParticles;
import net.kaupenjoe.tutorialmod.particle.custom.CitrineParticles;
import net.kaupenjoe.tutorialmod.recipe.GemCuttingStationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(CitrineArmorItem.class, new CitrineArmorRenderer());
    }
}
