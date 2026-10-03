package com.mintchoco.delight.registry;

import com.mintchoco.delight.MintChocoDelight;
import com.mintchoco.delight.block.MintCakeBlock;
import com.mintchoco.delight.block.MintCropBlock;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MintChocoDelight.MODID);

    public static final RegistryObject<MintCropBlock> MINT_CROP = BLOCKS.register("mint_crop",
            () -> new MintCropBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<WildCropBlock> WILD_MINT = BLOCKS.register("wild_mint",
            () -> new WildCropBlock(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<MintCakeBlock> MINT_CAKE = BLOCKS.register("mint_cake",
            () -> new MintCakeBlock(2, 0.1F, null, cakeProperties()));

    public static final RegistryObject<MintCakeBlock> MINT_CHOCOLATE_CAKE = BLOCKS.register("mint_chocolate_cake",
            () -> new MintCakeBlock(3, 1.0F / 3.0F,
                    () -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0), cakeProperties()));

    public static final RegistryObject<PieBlock> MINT_CHOCOLATE_PIE = BLOCKS.register("mint_chocolate_pie",
            () -> new PieBlock(cakeProperties(), () -> ModItems.MINT_CHOCOLATE_PIE_SLICE.get()));

    private static BlockBehaviour.Properties cakeProperties() {
        return BlockBehaviour.Properties.of()
                .forceSolidOn()
                .strength(0.5F)
                .sound(SoundType.WOOL)
                .pushReaction(PushReaction.DESTROY);
    }

    private ModBlocks() {
    }
}
