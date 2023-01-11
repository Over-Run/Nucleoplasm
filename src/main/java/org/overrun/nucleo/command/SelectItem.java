package org.overrun.nucleo.command;

import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;

public class SelectItem extends Item {
    private BlockPos pos1;
    private BlockPos pos2;

    public SelectItem(Settings settings) {
        super(settings);
    }


    public BlockPos getPos1() {
        return pos1;
    }

    public void setPos1(BlockPos pos1) {
        this.pos1 = pos1;
    }

    public BlockPos getPos2() {
        return pos2;
    }

    public void setPos2(BlockPos pos2) {
        this.pos2 = pos2;
    }
}
