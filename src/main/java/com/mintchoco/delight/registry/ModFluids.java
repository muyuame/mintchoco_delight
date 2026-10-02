package com.mintchoco.delight.registry;

import com.mintchoco.delight.MintChocoDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * The two Create-compatible fluids. No liquid block / bucket is registered on purpose:
 * the fluids only exist to be moved around by Create machinery.
 */
public final class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, MintChocoDelight.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, MintChocoDelight.MODID);

    public static final DeferredHolder<FluidType, FluidType> MINT_SYRUP_TYPE = FLUID_TYPES.register("mint_syrup",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("fluid_type.mintchoco_delight.mint_syrup")
                    .density(1200)
                    .viscosity(2000)));

    public static final DeferredHolder<FluidType, FluidType> MINT_CHOCOLATE_TYPE = FLUID_TYPES.register("mint_chocolate",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("fluid_type.mintchoco_delight.mint_chocolate")
                    .density(1400)
                    .viscosity(3000)));

    public static final DeferredHolder<Fluid, BaseFlowingFluid> MINT_SYRUP = FLUIDS.register("mint_syrup",
            () -> new BaseFlowingFluid.Source(mintSyrupProperties()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_MINT_SYRUP = FLUIDS.register("flowing_mint_syrup",
            () -> new BaseFlowingFluid.Flowing(mintSyrupProperties()));

    public static final DeferredHolder<Fluid, BaseFlowingFluid> MINT_CHOCOLATE = FLUIDS.register("mint_chocolate",
            () -> new BaseFlowingFluid.Source(mintChocolateProperties()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid> FLOWING_MINT_CHOCOLATE = FLUIDS.register("flowing_mint_chocolate",
            () -> new BaseFlowingFluid.Flowing(mintChocolateProperties()));

    private static BaseFlowingFluid.Properties mintSyrupProperties() {
        return new BaseFlowingFluid.Properties(MINT_SYRUP_TYPE, MINT_SYRUP, FLOWING_MINT_SYRUP)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2);
    }

    private static BaseFlowingFluid.Properties mintChocolateProperties() {
        return new BaseFlowingFluid.Properties(MINT_CHOCOLATE_TYPE, MINT_CHOCOLATE, FLOWING_MINT_CHOCOLATE)
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2);
    }

    private ModFluids() {
    }
}