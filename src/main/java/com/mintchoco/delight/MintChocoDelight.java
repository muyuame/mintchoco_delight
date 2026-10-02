package com.mintchoco.delight;

import com.mintchoco.delight.client.ItemTooltips;
import com.mintchoco.delight.client.MintChocoClient;
import com.mintchoco.delight.event.ToothpasteTrigger;
import com.mintchoco.delight.registry.ModBlocks;
import com.mintchoco.delight.registry.ModCreativeTabs;
import com.mintchoco.delight.registry.ModFluids;
import com.mintchoco.delight.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(MintChocoDelight.MODID)
public class MintChocoDelight {
    public static final String MODID = "mintchoco_delight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MintChocoDelight(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFluids.FLUID_TYPES.register(modEventBus);
        ModFluids.FLUIDS.register(modEventBus);
        ModCreativeTabs.CREATIVE_TABS.register(modEventBus);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(MintChocoClient::registerFluidExtensions);
            NeoForge.EVENT_BUS.addListener(ItemTooltips::onItemTooltip);
        }
        NeoForge.EVENT_BUS.addListener(ToothpasteTrigger::onServerChat);
        LOGGER.info("Mint Choco Delight loading...");
    }
}
