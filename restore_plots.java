// Simcenter STAR-CCM+ macro: restore_plots.java
// Written by Simcenter STAR-CCM+ 17.06.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class restore_plots extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("02_axial_temps_TFL"));

    xYPlot_0.getParts().setQuery(null);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("2_ANNULAR_DUCT");

    Boundary boundary_6 = 
      region_1.getBoundaryManager().getBoundary("#06_ANNULAR_EXIT");

    InterfaceBoundary interfaceBoundary_11 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/8_TFL]"));

    InterfaceBoundary interfaceBoundary_12 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/9_DS_BULKHEAD]"));

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("ps_rpassage"));

    xYPlot_0.getParts().setObjects(boundary_6, interfaceBoundary_11, interfaceBoundary_12, planeSection_0);

    XYPlot xYPlot_1 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("03_axial_temps_shield"));

    xYPlot_1.openInteractive();

    PlotUpdate plotUpdate_0 = 
      xYPlot_1.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(25);

    hardcopyProperties_0.setCurrentResolutionHeight(25);

    hardcopyProperties_0.setCurrentResolutionWidth(1389);

    hardcopyProperties_0.setCurrentResolutionHeight(517);

    xYPlot_1.getParts().setQuery(null);

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("3_EXHAUST_DUCT");

    InterfaceBoundary interfaceBoundary_20 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_ID [13_SHIELD_COATING/3_EXHAUST_DUCT]"));

    InterfaceBoundary interfaceBoundary_21 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_OD [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"));

    Region region_10 = 
      simulation_0.getRegionManager().getRegion("7_REAR_ADAPTER");

    InterfaceBoundary interfaceBoundary_47 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"));

    InterfaceBoundary interfaceBoundary_48 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"));

    InterfaceBoundary interfaceBoundary_49 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("RL [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"));

    InterfaceBoundary interfaceBoundary_50 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("RU [3_EXHAUST_DUCT/7_REAR_ADAPTER]"));

    xYPlot_1.getParts().setObjects(interfaceBoundary_20, interfaceBoundary_21, interfaceBoundary_47, interfaceBoundary_48, interfaceBoundary_49, interfaceBoundary_50, planeSection_0);

    XYPlot xYPlot_2 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("00_wall_flux_cond"));

    xYPlot_2.openInteractive();

    PlotUpdate plotUpdate_1 = 
      xYPlot_2.getPlotUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      plotUpdate_1.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(25);

    hardcopyProperties_1.setCurrentResolutionHeight(25);

    hardcopyProperties_1.setCurrentResolutionWidth(1389);

    hardcopyProperties_1.setCurrentResolutionHeight(517);

    xYPlot_2.getParts().setQuery(null);

    InterfaceBoundary interfaceBoundary_4 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_5 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_INLET]"));

    InterfaceBoundary interfaceBoundary_6 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_SPOOL]"));

    InterfaceBoundary interfaceBoundary_10 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/6_FLOW_LINER]"));

    InterfaceBoundary interfaceBoundary_13 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"));

    InterfaceBoundary interfaceBoundary_14 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"));

    xYPlot_2.getParts().setObjects(interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, interfaceBoundary_13, interfaceBoundary_14);

    XYPlot xYPlot_3 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("00_wall_flux_rad"));

    xYPlot_3.openInteractive();

    PlotUpdate plotUpdate_2 = 
      xYPlot_3.getPlotUpdate();

    HardcopyProperties hardcopyProperties_2 = 
      plotUpdate_2.getHardcopyProperties();

    hardcopyProperties_2.setCurrentResolutionWidth(25);

    hardcopyProperties_2.setCurrentResolutionHeight(25);

    hardcopyProperties_2.setCurrentResolutionWidth(1389);

    hardcopyProperties_2.setCurrentResolutionHeight(517);

    xYPlot_3.getParts().setQuery(null);

    xYPlot_3.getParts().setObjects(interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, interfaceBoundary_13, interfaceBoundary_14);

    XYPlot xYPlot_4 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("00_wall_flux_total"));

    xYPlot_4.openInteractive();

    PlotUpdate plotUpdate_3 = 
      xYPlot_4.getPlotUpdate();

    HardcopyProperties hardcopyProperties_3 = 
      plotUpdate_3.getHardcopyProperties();

    hardcopyProperties_3.setCurrentResolutionWidth(25);

    hardcopyProperties_3.setCurrentResolutionHeight(25);

    hardcopyProperties_3.setCurrentResolutionWidth(1389);

    hardcopyProperties_3.setCurrentResolutionHeight(517);

    xYPlot_4.getParts().setQuery(null);

    xYPlot_4.getParts().setObjects(interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, interfaceBoundary_13, interfaceBoundary_14);
  }
}
