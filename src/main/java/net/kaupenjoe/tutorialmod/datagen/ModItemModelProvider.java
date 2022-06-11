package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CITRINE);

        handheldItem(ModItems.CITRINE_AXE);
        handheldItem(ModItems.CITRINE_SHOVEL);
        handheldItem(ModItems.CITRINE_PICKAXE);
        handheldItem(ModItems.CITRINE_SWORD);
        handheldItem(ModItems.CITRINE_HOE);

        simpleItem(ModItems.COAL_COKE);
        simpleItem(ModItems.CUCUMBER);
        simpleItem(ModItems.CUCUMBER_SEEDS);
        simpleItem(ModItems.HONEY_BUCKET);
        simpleItem(ModItems.MAGIC_DUST);

        simpleItem(ModItems.CITRINE_HELMET);
        simpleItem(ModItems.CITRINE_CHESTPLATE);
        simpleItem(ModItems.CITRINE_LEGGING);
        simpleItem(ModItems.CITRINE_BOOTS);

        simpleItem(ModItems.DATA_TABLET);
        simpleItem(ModItems.DOWSING_ROD);
        simpleItem(ModItems.EBONY_SIGN);
        simpleItem(ModItems.GEM_CUTTER_TOOL);
        simpleItem(ModItems.RAW_CITRINE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
