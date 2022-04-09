package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntityTypes;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.custom.*;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(16)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_SWORD = ITEMS.register("citrine_sword",
            () -> new LevitationSwordItem(ModTiers.CITRINE, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_PICKAXE = ITEMS.register("citrine_pickaxe",
            () -> new PickaxeItem(ModTiers.CITRINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_SHOVEL = ITEMS.register("citrine_shovel",
            () -> new ShovelItem(ModTiers.CITRINE, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_AXE = ITEMS.register("citrine_axe",
            () -> new AxeItem(ModTiers.CITRINE, 4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_HOE = ITEMS.register("citrine_hoe",
            () -> new HoeItem(ModTiers.CITRINE, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_HELMET = ITEMS.register("citrine_helmet",
            () -> new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_CHESTPLATE = ITEMS.register("citrine_chestplate",
            () -> new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_LEGGING = ITEMS.register("citrine_leggings",
            () -> new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_BOOTS = ITEMS.register("citrine_boots",
            () -> new CitrineArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(500)));

    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> CITRINE_STAFF = ITEMS.register("citrine_staff",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GEM_CUTTER_TOOL = ITEMS.register("gem_cutter_tool",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(32)));

    public static final RegistryObject<Item> EBONY_SIGN = ITEMS.register("ebony_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(16),
                    ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()));

    public static final RegistryObject<Item> HONEY_BUCKET = ITEMS.register("honey_bucket",
            () -> new BucketItem(ModFluids.HONEY_FLUID,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> RACCOON_SPAWN_EGG = ITEMS.register("raccoon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.RACCOON,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
