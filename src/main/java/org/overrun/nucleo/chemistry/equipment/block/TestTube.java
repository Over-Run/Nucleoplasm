package org.overrun.nucleo.chemistry.equipment.block;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;


public class TestTube extends Block {
    private final int voxel_x;
    private final int voxel_y;


    public TestTube(Settings settings, int voxel_x, int voxel_y) {
        super(settings);
        this.voxel_x = voxel_x;
        this.voxel_y = voxel_y;
    }
    public static void model() {
    }



    //using block bench
    public static VoxelShape createCuboidShaped(double x, double y, double z, double s_x, double s_y, double s_z) {
        return Block.createCuboidShape(x,y,z, s_x + x, s_y + y, s_z + z);
    }
}
