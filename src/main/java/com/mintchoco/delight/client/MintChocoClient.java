package com.mintchoco.delight.client;

import com.mintchoco.delight.MintChocoDelight;
import com.mintchoco.delight.registry.ModFluids;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/**
 * Client-only setup. Registered from the mod constructor behind a dist check so the
 * dedicated server never touches client classes.
 */
public final class MintChocoClient {

    public static void registerFluidExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_syrup_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_syrup_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFFB4E3C4;
            }
        }, ModFluids.MINT_SYRUP_TYPE);

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_chocolate_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_chocolate_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFF93CDA6;
            }
        }, ModFluids.MINT_CHOCOLATE_TYPE);

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_milk_tea_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(MintChocoDelight.MODID, "block/mint_milk_tea_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFFD9F2DC;
            }
        }, ModFluids.MINT_MILK_TEA_TYPE);
    }

    private MintChocoClient() {
    }
}