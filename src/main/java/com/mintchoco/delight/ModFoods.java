package com.mintchoco.delight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

/**
 * Food values for every edible item added by this mod.
 * Values mirror the closest Farmer's Delight / vanilla / Create counterpart,
 * plus the minty speed boost the concept calls for.
 */
public final class ModFoods {
    /** Speed I for the given amount of ticks. */
    private static FoodProperties.Builder speed(int ticks) {
        return new FoodProperties.Builder()
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, ticks, 0), 1.0F);
    }

    // Mint leaves: mirrors Farmer's Delight's cabbage leaf (1 / 0.4, fast bite), plus 5s Speed I.
    public static final FoodProperties MINT_LEAVES = speed(100)
            .nutrition(1).saturationMod(0.4F).fast().build();

    // Create's chocolate bar is 6 nutrition / 0.3 saturation - keep that, add speed.
    public static final FoodProperties MINT_CHOCOLATE_BAR = speed(300)
            .nutrition(6).saturationMod(0.3F).build();

    // Cookies: vanilla values (2 / 0.1) with the fast bite, plus speed.
    public static final FoodProperties MINT_COOKIE = speed(300)
            .nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties MINT_CHOCOLATE_COOKIE = speed(300)
            .nutrition(2).saturationMod(0.1F).fast().build();

    // Breads: plain bread values.
    public static final FoodProperties MINT_BREAD = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties MINT_CHOCOLATE_BREAD = new FoodProperties.Builder()
            .nutrition(5).saturationMod(0.6F).build();

    public static final FoodProperties MINT_CHOCOLATE_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.3F).build();

    // Pasta: 14 nutrition / 21 saturation (modifier 0.75), 5 min Comfort + 5 min Speed.
    public static final FoodProperties MINT_CHOCOLATE_PASTA = new FoodProperties.Builder()
            .nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0), 1.0F)
            .build();

    // Fried rice: Farmer's Delight values (12 / 0.8 + 3 min Nourishment) with an extra 5 min Speed.
    public static final FoodProperties MINT_CHOCOLATE_FRIED_RICE = new FoodProperties.Builder()
            .nutrition(12).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0), 1.0F)
            .build();

    // Dumplings: Farmer's Delight values.
    public static final FoodProperties MINT_CHOCOLATE_DUMPLING = new FoodProperties.Builder()
            .nutrition(10).saturationMod(0.7F).build();

    // Slices use exactly Farmer's Delight's cake / pie slice effects.
    public static final FoodProperties MINT_CAKE_SLICE = speed(400)
            .nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties MINT_CHOCOLATE_CAKE_SLICE = speed(400)
            .nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties MINT_CHOCOLATE_PIE_SLICE = speed(600)
            .nutrition(3).saturationMod(0.3F).fast().build();

    // Toothpaste: technically edible, but you really should not. 5 seconds of Nausea.
    public static final FoodProperties TOOTHPASTE = new FoodProperties.Builder()
            .nutrition(0).saturationMod(0.0F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0F)
            .build();

    private ModFoods() {
    }
}