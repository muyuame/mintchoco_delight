package com.mintchoco.delight.client;

import com.mintchoco.delight.MintChocoDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

import java.util.function.Consumer;

/**
 * Client-only setup. Called from {@code FluidType#initializeClient}, which is only
 * ever invoked on the physical client, so the dedicated server never loads this class.
 */
public final class MintChocoClient {

    public static void registerMintSyrup(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return new ResourceLocation(MintChocoDelight.MODID, "block/mint_syrup_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return new ResourceLocation(MintChocoDelight.MODID, "block/mint_syrup_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFFB4E3C4;
            }
        });
    }

    public static void registerMintChocolate(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return new ResourceLocation(MintChocoDelight.MODID, "block/mint_chocolate_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return new ResourceLocation(MintChocoDelight.MODID, "block/mint_chocolate_flow");
            }

            @Override
            public int getTintColor() {
                return 0xFF93CDA6;
            }
        });
    }

    private MintChocoClient() {
    }
}
