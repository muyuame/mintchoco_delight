package com.mintchoco.delight.registry;

import com.mintchoco.delight.MintChocoDelight;
import com.mintchoco.delight.ModFoods;
import com.mintchoco.delight.item.MintHotCocoaItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MintChocoDelight.MODID);

    private static Item.Properties food(FoodProperties properties) {
        return new Item.Properties().food(properties);
    }

    private static Item.Properties bottle() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    // --- Mint crop ---------------------------------------------------------
    public static final RegistryObject<Item> MINT_SEEDS = ITEMS.register("mint_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MINT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> MINT_LEAVES = ITEMS.register("mint_leaves",
            () -> new Item(food(ModFoods.MINT_LEAVES)));

    // --- Fluids in bottles -------------------------------------------------
    public static final RegistryObject<Item> MINT_SYRUP = ITEMS.register("mint_syrup",
            () -> new DrinkableItem(bottle()));
    public static final RegistryObject<Item> MINT_HOT_COCOA = ITEMS.register("mint_hot_cocoa",
            () -> new MintHotCocoaItem(bottle()));

    // --- Sweets ------------------------------------------------------------
    public static final RegistryObject<Item> MINT_CHOCOLATE_BAR = ITEMS.register("mint_chocolate_bar",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_BAR)));
    public static final RegistryObject<Item> MINT_COOKIE = ITEMS.register("mint_cookie",
            () -> new Item(food(ModFoods.MINT_COOKIE)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_COOKIE = ITEMS.register("mint_chocolate_cookie",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_COOKIE)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_ICE_CREAM = ITEMS.register("mint_chocolate_ice_cream",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_ICE_CREAM)));

    // --- Breads & doughs ---------------------------------------------------
    public static final RegistryObject<Item> MINT_BREAD = ITEMS.register("mint_bread",
            () -> new Item(food(ModFoods.MINT_BREAD)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_BREAD = ITEMS.register("mint_chocolate_bread",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_BREAD)));
    public static final RegistryObject<Item> MINT_DOUGH = ITEMS.register("mint_dough",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MINT_CHOCOLATE_DOUGH = ITEMS.register("mint_chocolate_dough",
            () -> new Item(new Item.Properties()));

    // --- Meals -------------------------------------------------------------
    public static final RegistryObject<Item> MINT_CHOCOLATE_PASTA = ITEMS.register("mint_chocolate_pasta",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_PASTA)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_FRIED_RICE = ITEMS.register("mint_chocolate_fried_rice",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_FRIED_RICE)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_DUMPLING = ITEMS.register("mint_chocolate_dumpling",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_DUMPLING)));

    // --- Slices ------------------------------------------------------------
    public static final RegistryObject<Item> MINT_CAKE_SLICE = ITEMS.register("mint_cake_slice",
            () -> new Item(food(ModFoods.MINT_CAKE_SLICE)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_CAKE_SLICE = ITEMS.register("mint_chocolate_cake_slice",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_CAKE_SLICE)));
    public static final RegistryObject<Item> MINT_CHOCOLATE_PIE_SLICE = ITEMS.register("mint_chocolate_pie_slice",
            () -> new Item(food(ModFoods.MINT_CHOCOLATE_PIE_SLICE)));

    // --- Novelty -----------------------------------------------------------
    public static final RegistryObject<Item> TOOTHPASTE = ITEMS.register("toothpaste",
            () -> new Item(food(ModFoods.TOOTHPASTE)));

    // --- Block items -------------------------------------------------------
    public static final RegistryObject<BlockItem> WILD_MINT = ITEMS.register("wild_mint",
            () -> new BlockItem(ModBlocks.WILD_MINT.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MINT_CAKE = ITEMS.register("mint_cake",
            () -> new BlockItem(ModBlocks.MINT_CAKE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MINT_CHOCOLATE_CAKE = ITEMS.register("mint_chocolate_cake",
            () -> new BlockItem(ModBlocks.MINT_CHOCOLATE_CAKE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MINT_CHOCOLATE_PIE = ITEMS.register("mint_chocolate_pie",
            () -> new BlockItem(ModBlocks.MINT_CHOCOLATE_PIE.get(), new Item.Properties()));

    private ModItems() {
    }
}
