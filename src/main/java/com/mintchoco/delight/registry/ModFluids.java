package com.mintchoco.delight.registry;

import com.mintchoco.delight.MintChocoDelight;
import com.mintchoco.delight.client.MintChocoClient;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

/**
 * The two fluids. No liquid block / bucket is registered on purpose:
 * the fluids only exist so other machines can move them around.
 */
public final class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MintChocoDelight.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MintChocoDelight.MODID);

    public static final RegistryObject<FluidType> MINT_SYRUP_TYPE = FLUID_TYPES.register("mint_syrup",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("fluid_type.mintchoco_delight.mint_syrup")
                    .density(1200)
                    .viscosity(2000)) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    MintChocoClient.registerMintSyrup(consumer);
                }
            });

    public static final RegistryObject<FluidType> MINT_CHOCOLATE_TYPE = FLUID_TYPES.register("mint_chocolate",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("fluid_type.mintchoco_delight.mint_chocolate")
                    .density(1400)
                    .viscosity(3000)) {
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    MintChocoClient.registerMintChocolate(consumer);
                }
            });

    public static final RegistryObject<ForgeFlowingFluid> MINT_SYRUP = FLUIDS.register("mint_syrup",
            () -> new ForgeFlowingFluid.Source(mintSyrupProperties()));
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_MINT_SYRUP = FLUIDS.register("flowing_mint_syrup",
            () -> new ForgeFlowingFluid.Flowing(mintSyrupProperties()));

    public static final RegistryObject<ForgeFlowingFluid> MINT_CHOCOLATE = FLUIDS.register("mint_chocolate",
            () -> new ForgeFlowingFluid.Source(mintChocolateProperties()));
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_MINT_CHOCOLATE = FLUIDS.register("flowing_mint_chocolate",
            () -> new ForgeFlowingFluid.Flowing(mintChocolateProperties()));

    private static ForgeFlowingFluid.Properties mintSyrupProperties() {
        return new ForgeFlowingFluid.Properties(MINT_SYRUP_TYPE, MINT_SYRUP, FLOWING_MINT_SYRUP)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2);
    }

    private static ForgeFlowingFluid.Properties mintChocolateProperties() {
        return new ForgeFlowingFluid.Properties(MINT_CHOCOLATE_TYPE, MINT_CHOCOLATE, FLOWING_MINT_CHOCOLATE)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2);
    }

    private ModFluids() {
    }
}
