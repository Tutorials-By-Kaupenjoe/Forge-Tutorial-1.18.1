package net.kaupenjoe.tutorialmod.villager;

import java.util.Set;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
	public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES,
			TutorialMod.MOD_ID);

	public static final RegistryObject<PoiType> KAUPEN_PORTAL = POI.register("kaupen_portal",
			() -> new PoiType(Set.copyOf(ModBlocks.KAUPEN_PORTAL.get().getStateDefinition().getPossibleStates()), 1,
					1));

	public static void register(IEventBus eventBus) {
		POI.register(eventBus);
	}
}