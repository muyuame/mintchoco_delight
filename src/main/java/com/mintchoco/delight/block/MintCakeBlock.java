package com.mintchoco.delight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * A cake that can optionally grant an effect for every bite.
 * Vanilla's {@link CakeBlock} hard-codes 2 / 0.1 and never applies effects, so the
 * eating logic is re-implemented here with per-block food values.
 */
public class MintCakeBlock extends CakeBlock {
    private final int nutrition;
    private final float saturation;
    @Nullable
    private final Supplier<MobEffectInstance> biteEffect;

    public MintCakeBlock(int nutrition, float saturation, @Nullable Supplier<MobEffectInstance> biteEffect, Properties properties) {
        super(properties);
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.biteEffect = biteEffect;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) {
            if (player.canEat(false)) {
                return InteractionResult.SUCCESS;
            }
            return player.getItemInHand(hand).isEmpty() ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
        return this.eatSlice(level, pos, state, player);
    }

    private InteractionResult eatSlice(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }
        player.awardStat(net.minecraft.stats.Stats.EAT_CAKE_SLICE);
        player.getFoodData().eat(this.nutrition, this.saturation);
        if (this.biteEffect != null) {
            player.addEffect(new MobEffectInstance(this.biteEffect.get()));
        }
        int bites = state.getValue(BITES);
        level.gameEvent(player, GameEvent.EAT, pos);
        if (bites < MAX_BITES) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return InteractionResult.SUCCESS;
    }
}