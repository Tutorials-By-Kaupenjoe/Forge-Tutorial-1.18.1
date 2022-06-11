package net.kaupenjoe.tutorialmod.entity.client.armor;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.custom.CitrineArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitrineArmorModel extends AnimatedGeoModel<CitrineArmorItem> {
	
	@Override
	public ResourceLocation getModelResource(CitrineArmorItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/citrine_armor.geo.json");
    }

	@Override
	public ResourceLocation getTextureResource(CitrineArmorItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/models/armor/citrine_armor_texture.png");
    }

	@Override
	public ResourceLocation getAnimationResource(CitrineArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/armor_animation.json");
    }
}
