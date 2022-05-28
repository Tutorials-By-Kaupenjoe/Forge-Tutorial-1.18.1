package net.kaupenjoe.tutorialmod.item.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedItemModel extends AnimatedGeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelLocation(AnimatedItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/animated_item.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AnimatedItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/animated_item_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AnimatedItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/animated_item.animation.json");
    }
}
