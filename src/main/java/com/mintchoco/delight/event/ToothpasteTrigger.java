package com.mintchoco.delight.event;

import com.mintchoco.delight.registry.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ServerChatEvent;

/**
 * Rewards a player with a tube of toothpaste when they type the magic phrase in chat.
 */
public final class ToothpasteTrigger {
    private static final String PHRASE = "\u8584\u8377\u662f\u7259\u818f\u5473\u7684\u5783\u573e"; // 薄荷是牙膏味的垃圾

    public static void onServerChat(ServerChatEvent event) {
        if (!PHRASE.equals(event.getRawText().trim())) {
            return;
        }
        ServerPlayer player = event.getPlayer();
        ItemStack stack = new ItemStack(ModItems.TOOTHPASTE.get());
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        }
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.8F, 1.0F);
    }

    private ToothpasteTrigger() {
    }
}