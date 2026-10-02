package com.mintchoco.delight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.HotCocoaItem;

/**
 * Farmer's Delight hot cocoa (clears one milk-curable effect) plus Speed I for 15 seconds.
 */
public class MintHotCocoaItem extends HotCocoaItem {
    private static final int SPEED_TICKS = 300;

    public MintHotCocoaItem(Properties properties) {
        super(properties);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        super.affectConsumer(stack, level, consumer);
        if (!level.isClientSide) {
            consumer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SPEED_TICKS, 0));
        }
    }
}