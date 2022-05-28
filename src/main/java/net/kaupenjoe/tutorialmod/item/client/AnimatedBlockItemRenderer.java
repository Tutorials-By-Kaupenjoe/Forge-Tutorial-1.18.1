package net.kaupenjoe.tutorialmod.item.client;

import net.kaupenjoe.tutorialmod.item.custom.AnimatedBlockItem;
import net.kaupenjoe.tutorialmod.item.custom.AnimatedItem;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class AnimatedBlockItemRenderer extends GeoItemRenderer<AnimatedBlockItem> {
    public AnimatedBlockItemRenderer() {
        super(new AnimatedBlockItemModel());
    }
}
