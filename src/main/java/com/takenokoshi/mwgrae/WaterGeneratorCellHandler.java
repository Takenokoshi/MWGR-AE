package com.takenokoshi.mwgrae;

import appeng.api.stacks.AEFluidKey;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

public class WaterGeneratorCellHandler implements ICellHandler {

    private final Item item;
    private final Fluid fluid;
    private final String name;

    public WaterGeneratorCellHandler(Item item, Fluid fluid, String name) {
        this.item = item;
        this.fluid = fluid;
        this.name = name;
    }

    @Override
    public StorageCell getCellInventory(ItemStack arg0, ISaveProvider arg1) {
        return isCell(arg0) ? new WaterGeneratorCellInv(name, AEFluidKey.of(fluid)) : null;
    }

    @Override
    public boolean isCell(ItemStack arg0) {
        return arg0.getItem().equals(item);
    }

}
