package com.wmaxlees.gregcolonies.apiimp.initializer;

import static com.minecolonies.core.colony.buildings.modules.BuildingModules.*;
import static com.wmaxlees.gregcolonies.core.colony.buildings.modules.BuildingModules.*;

import com.minecolonies.api.colony.buildings.registry.BuildingEntry;
import com.minecolonies.core.colony.buildings.views.EmptyView;
import com.wmaxlees.gregcolonies.api.blocks.ModBlocks;
import com.wmaxlees.gregcolonies.api.colony.buildings.ModBuildings;
import com.wmaxlees.gregcolonies.api.util.constant.Constants;
import com.wmaxlees.gregcolonies.core.colony.buildings.workerbuildings.BuildingFluidWarehouse;
import com.wmaxlees.gregcolonies.core.colony.buildings.workerbuildings.BuildingMachinist;
import com.wmaxlees.gregcolonies.core.colony.buildings.workerbuildings.BuildingToolPartSmith;
import com.wmaxlees.gregcolonies.core.colony.buildings.workerbuildings.BuildingToolmaker;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;

public final class GregColoniesModBuildingsInitializer {
  public static final DeferredRegister<BuildingEntry> DEFERRED_REGISTER =
      DeferredRegister.create(
          new ResourceLocation(Constants.MINECOLONIES_MOD_ID, "buildings"), Constants.MOD_ID);

  static {
    ModBuildings.toolmaker =
        DEFERRED_REGISTER.register(
            ModBuildings.TOOLMAKER_ID,
            () ->
                new BuildingEntry.Builder()
                    .setBuildingBlock(ModBlocks.blockHutToolmaker)
                    .setBuildingProducer(BuildingToolmaker::new)
                    .setBuildingViewProducer(() -> EmptyView::new)
                    .setRegistryName(
                        new ResourceLocation(Constants.MOD_ID, ModBuildings.TOOLMAKER_ID))
                    .addBuildingModuleProducer(TOOLMAKER_WORK)
                    .addBuildingModuleProducer(TOOLMAKER_CRAFT)
                    .createBuildingEntry());

    ModBuildings.toolpartsmith =
        DEFERRED_REGISTER.register(
            ModBuildings.TOOL_PART_SMITH_ID,
            () ->
                new BuildingEntry.Builder()
                    .setBuildingBlock(ModBlocks.blockHutToolPartSmith)
                    .setBuildingProducer(BuildingToolPartSmith::new)
                    .setBuildingViewProducer(() -> EmptyView::new)
                    .setRegistryName(
                        new ResourceLocation(Constants.MOD_ID, ModBuildings.TOOL_PART_SMITH_ID))
                    .addBuildingModuleProducer(TOOLPARTSMITH_WORK)
                    .addBuildingModuleProducer(TOOLPARTSMITH_CRAFT)
                    .createBuildingEntry());

    ModBuildings.machinist =
        DEFERRED_REGISTER.register(
            ModBuildings.MACHINIST_ID,
            () ->
                new BuildingEntry.Builder()
                    .setBuildingBlock(ModBlocks.blockHutMachinist)
                    .setBuildingProducer(BuildingMachinist::new)
                    .setBuildingViewProducer(() -> BuildingMachinist.View::new)
                    .setRegistryName(
                        new ResourceLocation(Constants.MOD_ID, ModBuildings.MACHINIST_ID))
                    .addBuildingModuleProducer(MACHINIST_WORK)
                    .addBuildingModuleProducer(MACHINIST_CRAFT)
                    .addBuildingModuleProducer(MACHINIST_INPUT_TOOL)
                    .addBuildingModuleProducer(MACHINIST_OUTPUT_TOOL)
                    .createBuildingEntry());

    ModBuildings.fluidWarehouse =
        DEFERRED_REGISTER.register(
            ModBuildings.FLUID_WAREHOUSE_ID,
            () ->
                new BuildingEntry.Builder()
                    .setBuildingBlock(ModBlocks.blockHutFluidWarehouse)
                    .setBuildingProducer(BuildingFluidWarehouse::new)
                    .setBuildingViewProducer(() -> BuildingMachinist.View::new)
                    .setRegistryName(
                        new ResourceLocation(Constants.MOD_ID, ModBuildings.FLUID_WAREHOUSE_ID))
                    .addBuildingModuleProducer(FLUID_WAREHOUSE_WORK)
                    .addBuildingModuleProducer(FLUID_LIST_COURIER_TANKS)
                    .addBuildingModuleProducer(INVENTORY_USER)
                    .addBuildingModuleProducer(TANK_SELECTOR_TOOL)
                    .createBuildingEntry());
  }
}
