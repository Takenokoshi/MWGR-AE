package com.takenokoshi.mwgrae;

import appeng.api.config.Actionable;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.KeyCounter;
import appeng.api.storage.cells.CellState;
import appeng.api.storage.cells.StorageCell;
import net.minecraft.network.chat.Component;

public class WaterGeneratorCellInv implements StorageCell {

    public static final long VIEW_COUNTER = 1L << 42;

    protected final String name;
    protected final AEFluidKey fluidKey;

    public WaterGeneratorCellInv(String name, AEFluidKey fluidKey) {
        this.name = name;
        this.fluidKey = fluidKey;
    }

    @Override
    public Component getDescription() {
        return Component.translatable("description.mwgr_ae." + name);
    }

    @Override
    public double getIdleDrain() {
        return 0.1d;
    }

    @Override
    public CellState getStatus() {
        return CellState.TYPES_FULL;
    }

    @Override
    public void persist() {
    }

    @Override
    public long insert(AEKey what, long amount, Actionable mode, IActionSource source) {
        return what.equals(fluidKey) ? amount : 0;
    }

    @Override
    public long extract(AEKey what, long amount, Actionable mode, IActionSource source) {
        return what.equals(fluidKey) ? amount : 0;
    }

    @Override
    public void getAvailableStacks(KeyCounter out) {
        out.add(fluidKey, VIEW_COUNTER);
    }

}
