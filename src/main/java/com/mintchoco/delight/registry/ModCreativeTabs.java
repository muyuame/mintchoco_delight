package com.mintchoco.delight.registry;

import com.mintchoco.delight.MintChocoDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MintChocoDelight.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = CREATIVE_TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mintchoco_delight"))
                    .icon(() -> new ItemStack(ModItems.MINT_CHOCOLATE_BAR.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MINT_SEEDS.get());
                        output.accept(ModItems.MINT_LEAVES.get());
                        output.accept(ModItems.WILD_MINT.get());
                        output.accept(ModItems.MINT_SYRUP.get());
                        output.accept(ModItems.MINT_HOT_COCOA.get());
                        output.accept(ModItems.MINT_CHOCOLATE_BAR.get());
                        output.accept(ModItems.MINT_COOKIE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_COOKIE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_ICE_CREAM.get());
                        output.accept(ModItems.MINT_BREAD.get());
                        output.accept(ModItems.MINT_CHOCOLATE_BREAD.get());
                        output.accept(ModItems.MINT_DOUGH.get());
                        output.accept(ModItems.MINT_CHOCOLATE_DOUGH.get());
                        output.accept(ModItems.MINT_CHOCOLATE_PASTA.get());
                        output.accept(ModItems.MINT_CHOCOLATE_FRIED_RICE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_DUMPLING.get());
                        output.accept(ModItems.MINT_CAKE.get());
                        output.accept(ModItems.MINT_CAKE_SLICE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_CAKE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_CAKE_SLICE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_PIE.get());
                        output.accept(ModItems.MINT_CHOCOLATE_PIE_SLICE.get());
                        output.accept(ModItems.TOOTHPASTE.get());
                    })
                    .build());

    private ModCreativeTabs() {
    }
}