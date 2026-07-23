package com.takenokoshi.mwgrae;

import com.github.misosoupTgit.mwgr.MWGRMod;

import appeng.api.storage.StorageCells;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(MwgrAE.MODID)
public class MwgrAE {
    public static final String MODID = "mwgr_ae";

    public MwgrAE() {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetUp);
    }

    private void commonSetUp(final FMLCommonSetupEvent event) {
        StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(MWGRMod.MOD_ID, "water_generator")),
                Fluids.WATER,
                "water_generator"));
        StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                ForgeRegistries.ITEMS.getValue(new ResourceLocation(MWGRMod.MOD_ID, "lava_generator")),
                Fluids.LAVA,
                "lava_generator"));
        if (ModList.get().isLoaded("mekanism")) {
            StorageCells.addCellHandler(new WaterGeneratorCellHandler(
                    ForgeRegistries.ITEMS.getValue(new ResourceLocation(MWGRMod.MOD_ID, "heavywater_generator")),
                    ForgeRegistries.FLUIDS.getHolder(new ResourceLocation("mekanism", "heavy_water")).get().get(),
                    "heavywater_generator"));
        }
    }
}
