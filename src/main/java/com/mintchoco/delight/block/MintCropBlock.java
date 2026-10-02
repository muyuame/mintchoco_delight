package com.mintchoco.delight.block;

import com.mintchoco.delight.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Mint, grown exactly like wheat (8 stages, no farmland bonus different from vanilla crops).
 */
public class MintCropBlock extends CropBlock {
    public MintCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.MINT_SEEDS.get();
    }
}