package com.mintchoco.delight;

import com.mintchoco.delight.client.ItemTooltips;
import com.mintchoco.delight.event.ToothpasteTrigger;
import com.mintchoco.delight.registry.ModBlocks;
import com.mintchoco.delight.registry.ModCreativeTabs;
import com.mintchoco.delight.registry.ModFluids;
import com.mintchoco.delight.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MintChocoDelight.MODID)
public class MintChocoDelight {
    public static final String MODID = "mintchoco_delight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MintChocoDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFluids.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.addListener(ItemTooltips::onItemTooltip);
        }
        MinecraftForge.EVENT_BUS.addListener(ToothpasteTrigger::onServerChat);
        LOGGER.info("Mint Choco Delight loading...");
    }
}
