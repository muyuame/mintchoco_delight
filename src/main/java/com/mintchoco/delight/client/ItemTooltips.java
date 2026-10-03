package com.mintchoco.delight.client;

import com.mintchoco.delight.MintChocoDelight;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

/**
 * Adds a grey one-line description below the name of every item from this mod.
 * The text lives in the language files under {@code item.<modid>.<name>.desc},
 * so wording can be changed without touching code. Items that have no such key
 * simply show no extra line.
 */
public final class ItemTooltips {
    public static void onItemTooltip(ItemTooltipEvent event) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());
        if (!MintChocoDelight.MODID.equals(id.getNamespace())) {
            return;
        }
        String key = "item." + MintChocoDelight.MODID + "." + id.getPath() + ".desc";
        if (I18n.exists(key)) {
            event.getToolTip().add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
        }
    }

    private ItemTooltips() {
    }
}