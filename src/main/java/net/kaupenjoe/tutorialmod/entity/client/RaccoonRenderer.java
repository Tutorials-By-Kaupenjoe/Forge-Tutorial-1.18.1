package net.kaupenjoe.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.RaccoonEntity;
import net.kaupenjoe.tutorialmod.entity.variant.RaccoonVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public static final Map<RaccoonVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), (p_114874_) -> {
                p_114874_.put(RaccoonVariant.DEFAULT,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                p_114874_.put(RaccoonVariant.DARK,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoondark.png"));
                p_114874_.put(RaccoonVariant.RED,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/redraccoon.png"));
            });

    public RaccoonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaccoonModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(RaccoonEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }

        stack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0f, 90f, 0f)));

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
