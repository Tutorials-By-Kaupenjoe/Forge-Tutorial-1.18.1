package net.kaupenjoe.tutorialmod.loot_modifiers;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.event.loot.CoalCokeFromCreeperAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.CucumberSeedsFromGrassAdditionModifier;
import net.kaupenjoe.tutorialmod.event.loot.DowsingRodInIglooAdditionModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
	private static final DeferredRegister<GlobalLootModifierSerializer<?>> SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, TutorialMod.MOD_ID);
	
	public static final RegistryObject<GlobalLootModifierSerializer<?>> CUCUMBER_SEEDS = SERIALIZERS.register("cucumber_seeds_from_grass", () -> new CucumberSeedsFromGrassAdditionModifier.Serializer());
	public static final RegistryObject<GlobalLootModifierSerializer<?>> DOWSING_ROD = SERIALIZERS.register("dowsing_rod_in_igloo", () -> new DowsingRodInIglooAdditionModifier.Serializer());
	public static final RegistryObject<GlobalLootModifierSerializer<?>> COAL_COKE = SERIALIZERS.register("coal_coke_from_creeper", () -> new CoalCokeFromCreeperAdditionModifier.Serializer());
	
	public static void register(IEventBus eventBus) {
		SERIALIZERS.register(eventBus);
	}
}
