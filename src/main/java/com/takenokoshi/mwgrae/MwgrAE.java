package com.takenokoshi.mwgrae;

import com.github.misosouptgit.mwgr.MekanismWaterGeneratorRebuild;

import appeng.api.storage.StorageCells;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(MwgrAE.MODID)
public class MwgrAE {
    public static final String MODID = "mwgr_ae";

    public MwgrAE(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                MekanismWaterGeneratorRebuild.WATER_GENERATOR_ITEM.asItem(),
                Fluids.WATER,
                "water_generator"));
        StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                MekanismWaterGeneratorRebuild.LAVA_GENERATOR_ITEM.asItem(),
                Fluids.LAVA,
                "lava_generator"));
        if (ModList.get().isLoaded("mekanism")) {
            StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                    MekanismWaterGeneratorRebuild.HEAVY_WATER_GENERATOR_ITEM.asItem(),
                    BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath("mekanism", "heavy_water")),
                    "heavywater_generator"));
        }
    }
}
