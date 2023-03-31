package org.overrun.nucleoplasm_api.common.fluids;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.common.Nucleoplasm_api;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

import java.util.Objects;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideFluidRegistry<T extends BaseFlowableFluid> extends NuclideBase {

    public NuclideFluidRegistry(NuclideBase base) {
        super(base.getModid());
    }

    public NuclideFluidRegistry() {
        super();
    }
    public NuclideFluidRegistry(String modid) {super(modid);}
    public IFluid add(String name, T still, T flowing, FabricBlockSettings blockSettings, FabricItemSettings settings) {
        T stillFluid = Registry.register(Registries.FLUID, new Identifier(getModid(), name), still);
        T flowingFluid = Registry.register(Registries.FLUID, new Identifier(getModid(), "flowing_" + name), flowing);
        FluidBlock fluidBlock = Registry.register(Registries.BLOCK, new Identifier(getModid(), name + "_block"), new FluidBlock(stillFluid ,blockSettings));
        BucketItem item = Registry.register(Registries.ITEM, new Identifier(getModid(), name + "_bucket"), new BucketItem(stillFluid, settings.maxCount(1)));
        return new IFluid(stillFluid, flowingFluid, fluidBlock, item);
    }

    public class IFluid {
        private final T still, flowing;
        private final FluidBlock block;
        private final BucketItem item;
        public IFluid(T still, T flowing, FluidBlock block, BucketItem item) {
            this.block = block;
            this.still = still;
            this.flowing = flowing;
            this.item = item;
        }

        public T getFlowing() {
            return flowing;
        }

        public T getStill() {
            return still;
        }

        public FluidBlock getBlock() {
            return block;
        }

        public BucketItem getItem() {
            return item;
        }
    }
}
