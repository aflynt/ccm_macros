// Simcenter STAR-CCM+ macro: restore_derived_parts.java
// Written by Simcenter STAR-CCM+ 17.06.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class restore_derived_parts extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    LinePart linePart_0 = 
      ((LinePart) simulation_0.getPartManager().getObject("Line Probe"));

    linePart_0.getInputParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("1_CENTER_DUCT");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("#02_CENTER_INLET");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("#05_CENTER_EXIT");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("c0");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("centerline");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_INLET]"));

    InterfaceBoundary interfaceBoundary_2 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_SPOOL]"));

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("2_ANNULAR_DUCT");

    Boundary boundary_5 = 
      region_1.getBoundaryManager().getBoundary("#03_ANNULAR_INLET");

    Boundary boundary_6 = 
      region_1.getBoundaryManager().getBoundary("#06_ANNULAR_EXIT");

    Boundary boundary_7 = 
      region_1.getBoundaryManager().getBoundary("#08_COMBUSTOR_CASING");

    Boundary boundary_8 = 
      region_1.getBoundaryManager().getBoundary("baffle");

    InterfaceBoundary interfaceBoundary_3 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("baffle [15_DEFLECTOR/2_ANNULAR_DUCT]"));

    Boundary boundary_9 = 
      region_1.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_4 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_5 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_INLET]"));

    InterfaceBoundary interfaceBoundary_6 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_SPOOL]"));

    InterfaceBoundary interfaceBoundary_7 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_8 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_INLET]"));

    InterfaceBoundary interfaceBoundary_9 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_SPOOL]"));

    InterfaceBoundary interfaceBoundary_10 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/6_FLOW_LINER]"));

    InterfaceBoundary interfaceBoundary_11 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/8_TFL]"));

    InterfaceBoundary interfaceBoundary_12 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/9_DS_BULKHEAD]"));

    Boundary boundary_10 = 
      region_1.getBoundaryManager().getBoundary("FL");

    InterfaceBoundary interfaceBoundary_13 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"));

    Boundary boundary_11 = 
      region_1.getBoundaryManager().getBoundary("FU");

    InterfaceBoundary interfaceBoundary_14 = 
      ((InterfaceBoundary) region_1.getBoundaryManager().getBoundary("FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"));

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("3_EXHAUST_DUCT");

    Boundary boundary_12 = 
      region_2.getBoundaryManager().getBoundary("#04_EXHAUST_INLET");

    Boundary boundary_13 = 
      region_2.getBoundaryManager().getBoundary("#07_EXHAUST_EXIT");

    Boundary boundary_14 = 
      region_2.getBoundaryManager().getBoundary("centerline");

    Boundary boundary_15 = 
      region_2.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_15 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("Default [11_DUCT_EXHAUST/3_EXHAUST_DUCT]"));

    Boundary boundary_16 = 
      region_2.getBoundaryManager().getBoundary("RL");

    InterfaceBoundary interfaceBoundary_16 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("RL [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"));

    Boundary boundary_17 = 
      region_2.getBoundaryManager().getBoundary("RU");

    InterfaceBoundary interfaceBoundary_17 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("RU [3_EXHAUST_DUCT/7_REAR_ADAPTER]"));

    Boundary boundary_18 = 
      region_2.getBoundaryManager().getBoundary("SHD_END");

    InterfaceBoundary interfaceBoundary_18 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_END [12_SHIELD_METAL/3_EXHAUST_DUCT]"));

    InterfaceBoundary interfaceBoundary_19 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_END [13_SHIELD_COATING/3_EXHAUST_DUCT 2]"));

    Boundary boundary_19 = 
      region_2.getBoundaryManager().getBoundary("SHD_ID");

    InterfaceBoundary interfaceBoundary_20 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_ID [13_SHIELD_COATING/3_EXHAUST_DUCT]"));

    Boundary boundary_20 = 
      region_2.getBoundaryManager().getBoundary("SHD_OD");

    InterfaceBoundary interfaceBoundary_21 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SHD_OD [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"));

    Boundary boundary_21 = 
      region_2.getBoundaryManager().getBoundary("SPRAY_END");

    InterfaceBoundary interfaceBoundary_22 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SPRAY_END [14_SPRAY/3_EXHAUST_DUCT 3]"));

    Boundary boundary_22 = 
      region_2.getBoundaryManager().getBoundary("SPRAY_ID");

    InterfaceBoundary interfaceBoundary_23 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SPRAY_ID [14_SPRAY/3_EXHAUST_DUCT]"));

    Boundary boundary_23 = 
      region_2.getBoundaryManager().getBoundary("SPRAY_OD");

    InterfaceBoundary interfaceBoundary_24 = 
      ((InterfaceBoundary) region_2.getBoundaryManager().getBoundary("SPRAY_OD [14_SPRAY/3_EXHAUST_DUCT 2]"));

    Boundary boundary_24 = 
      region_2.getBoundaryManager().getBoundary("w_1");

    Boundary boundary_25 = 
      region_2.getBoundaryManager().getBoundary("w_2");

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("4_INSULATION_CONTRACTION");

    Boundary boundary_26 = 
      region_3.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_25 = 
      ((InterfaceBoundary) region_3.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_26 = 
      ((InterfaceBoundary) region_3.getBoundaryManager().getBoundary("Default [4_INSULATION_CONTRACTION/5_DUCT_CONTRACTION]"));

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("4_INSULATION_INLET");

    Boundary boundary_27 = 
      region_4.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_27 = 
      ((InterfaceBoundary) region_4.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_INLET]"));

    InterfaceBoundary interfaceBoundary_28 = 
      ((InterfaceBoundary) region_4.getBoundaryManager().getBoundary("Default [4_INSULATION_INLET/5_DUCT_INLET]"));

    Boundary boundary_28 = 
      region_4.getBoundaryManager().getBoundary("W_END_US");

    Region region_5 = 
      simulation_0.getRegionManager().getRegion("4_INSULATION_SPOOL");

    Boundary boundary_29 = 
      region_5.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_29 = 
      ((InterfaceBoundary) region_5.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/4_INSULATION_SPOOL]"));

    InterfaceBoundary interfaceBoundary_30 = 
      ((InterfaceBoundary) region_5.getBoundaryManager().getBoundary("Default [4_INSULATION_SPOOL/5_DUCT_SPOOL]"));

    Region region_6 = 
      simulation_0.getRegionManager().getRegion("5_DUCT_CONTRACTION");

    Boundary boundary_30 = 
      region_6.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_31 = 
      ((InterfaceBoundary) region_6.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_32 = 
      ((InterfaceBoundary) region_6.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_33 = 
      ((InterfaceBoundary) region_6.getBoundaryManager().getBoundary("Default [4_INSULATION_CONTRACTION/5_DUCT_CONTRACTION]"));

    InterfaceBoundary interfaceBoundary_34 = 
      ((InterfaceBoundary) region_6.getBoundaryManager().getBoundary("Default [5_DUCT_CONTRACTION/5_DUCT_SPOOL]"));

    Region region_7 = 
      simulation_0.getRegionManager().getRegion("5_DUCT_INLET");

    Boundary boundary_31 = 
      region_7.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_35 = 
      ((InterfaceBoundary) region_7.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_INLET]"));

    InterfaceBoundary interfaceBoundary_36 = 
      ((InterfaceBoundary) region_7.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_INLET]"));

    InterfaceBoundary interfaceBoundary_37 = 
      ((InterfaceBoundary) region_7.getBoundaryManager().getBoundary("Default [4_INSULATION_INLET/5_DUCT_INLET]"));

    InterfaceBoundary interfaceBoundary_38 = 
      ((InterfaceBoundary) region_7.getBoundaryManager().getBoundary("Default [5_DUCT_INLET/5_DUCT_SPOOL]"));

    Boundary boundary_32 = 
      region_7.getBoundaryManager().getBoundary("W_END_US");

    Region region_8 = 
      simulation_0.getRegionManager().getRegion("5_DUCT_SPOOL");

    Boundary boundary_33 = 
      region_8.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_39 = 
      ((InterfaceBoundary) region_8.getBoundaryManager().getBoundary("Default [1_CENTER_DUCT/5_DUCT_SPOOL]"));

    InterfaceBoundary interfaceBoundary_40 = 
      ((InterfaceBoundary) region_8.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/5_DUCT_SPOOL]"));

    InterfaceBoundary interfaceBoundary_41 = 
      ((InterfaceBoundary) region_8.getBoundaryManager().getBoundary("Default [4_INSULATION_SPOOL/5_DUCT_SPOOL]"));

    InterfaceBoundary interfaceBoundary_42 = 
      ((InterfaceBoundary) region_8.getBoundaryManager().getBoundary("Default [5_DUCT_CONTRACTION/5_DUCT_SPOOL]"));

    InterfaceBoundary interfaceBoundary_43 = 
      ((InterfaceBoundary) region_8.getBoundaryManager().getBoundary("Default [5_DUCT_INLET/5_DUCT_SPOOL]"));

    Region region_9 = 
      simulation_0.getRegionManager().getRegion("6_FLOW_LINER");

    Boundary boundary_34 = 
      region_9.getBoundaryManager().getBoundary("#09_OD_WALLS");

    Boundary boundary_35 = 
      region_9.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_44 = 
      ((InterfaceBoundary) region_9.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/6_FLOW_LINER]"));

    InterfaceBoundary interfaceBoundary_45 = 
      ((InterfaceBoundary) region_9.getBoundaryManager().getBoundary("Default [6_FLOW_LINER/8_TFL]"));

    Boundary boundary_36 = 
      region_9.getBoundaryManager().getBoundary("W_END_US");

    Region region_10 = 
      simulation_0.getRegionManager().getRegion("7_REAR_ADAPTER");

    Boundary boundary_37 = 
      region_10.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_46 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("Default [7_REAR_ADAPTER/9_DS_BULKHEAD]"));

    Boundary boundary_38 = 
      region_10.getBoundaryManager().getBoundary("FL");

    InterfaceBoundary interfaceBoundary_47 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"));

    Boundary boundary_39 = 
      region_10.getBoundaryManager().getBoundary("FU");

    InterfaceBoundary interfaceBoundary_48 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"));

    Boundary boundary_40 = 
      region_10.getBoundaryManager().getBoundary("RL");

    InterfaceBoundary interfaceBoundary_49 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("RL [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"));

    Boundary boundary_41 = 
      region_10.getBoundaryManager().getBoundary("RU");

    InterfaceBoundary interfaceBoundary_50 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("RU [3_EXHAUST_DUCT/7_REAR_ADAPTER]"));

    InterfaceBoundary interfaceBoundary_51 = 
      ((InterfaceBoundary) region_10.getBoundaryManager().getBoundary("RU [14_SPRAY/7_REAR_ADAPTER]"));

    Region region_11 = 
      simulation_0.getRegionManager().getRegion("8_TFL");

    Boundary boundary_42 = 
      region_11.getBoundaryManager().getBoundary("#09_OD_WALLS");

    Boundary boundary_43 = 
      region_11.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_52 = 
      ((InterfaceBoundary) region_11.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/8_TFL]"));

    InterfaceBoundary interfaceBoundary_53 = 
      ((InterfaceBoundary) region_11.getBoundaryManager().getBoundary("Default [6_FLOW_LINER/8_TFL]"));

    InterfaceBoundary interfaceBoundary_54 = 
      ((InterfaceBoundary) region_11.getBoundaryManager().getBoundary("Default [8_TFL/9_DS_BULKHEAD]"));

    InterfaceBoundary interfaceBoundary_55 = 
      ((InterfaceBoundary) region_11.getBoundaryManager().getBoundary("Default [10_LOCK/8_TFL]"));

    Region region_12 = 
      simulation_0.getRegionManager().getRegion("9_DS_BULKHEAD");

    Boundary boundary_44 = 
      region_12.getBoundaryManager().getBoundary("#09_OD_WALLS");

    Boundary boundary_45 = 
      region_12.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_56 = 
      ((InterfaceBoundary) region_12.getBoundaryManager().getBoundary("Default [2_ANNULAR_DUCT/9_DS_BULKHEAD]"));

    InterfaceBoundary interfaceBoundary_57 = 
      ((InterfaceBoundary) region_12.getBoundaryManager().getBoundary("Default [7_REAR_ADAPTER/9_DS_BULKHEAD]"));

    InterfaceBoundary interfaceBoundary_58 = 
      ((InterfaceBoundary) region_12.getBoundaryManager().getBoundary("Default [8_TFL/9_DS_BULKHEAD]"));

    InterfaceBoundary interfaceBoundary_59 = 
      ((InterfaceBoundary) region_12.getBoundaryManager().getBoundary("Default [10_LOCK/9_DS_BULKHEAD]"));

    InterfaceBoundary interfaceBoundary_60 = 
      ((InterfaceBoundary) region_12.getBoundaryManager().getBoundary("Default [11_DUCT_EXHAUST/9_DS_BULKHEAD]"));

    Boundary boundary_46 = 
      region_12.getBoundaryManager().getBoundary("eface");

    Region region_13 = 
      simulation_0.getRegionManager().getRegion("10_LOCK");

    Boundary boundary_47 = 
      region_13.getBoundaryManager().getBoundary("#09_OD_WALLS");

    Boundary boundary_48 = 
      region_13.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_61 = 
      ((InterfaceBoundary) region_13.getBoundaryManager().getBoundary("Default [10_LOCK/8_TFL]"));

    InterfaceBoundary interfaceBoundary_62 = 
      ((InterfaceBoundary) region_13.getBoundaryManager().getBoundary("Default [10_LOCK/9_DS_BULKHEAD]"));

    Region region_14 = 
      simulation_0.getRegionManager().getRegion("11_DUCT_EXHAUST");

    Boundary boundary_49 = 
      region_14.getBoundaryManager().getBoundary("#09_OD_WALLS");

    Boundary boundary_50 = 
      region_14.getBoundaryManager().getBoundary("#10_exhaust_duct_od");

    Boundary boundary_51 = 
      region_14.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_63 = 
      ((InterfaceBoundary) region_14.getBoundaryManager().getBoundary("Default [11_DUCT_EXHAUST/3_EXHAUST_DUCT]"));

    InterfaceBoundary interfaceBoundary_64 = 
      ((InterfaceBoundary) region_14.getBoundaryManager().getBoundary("Default [11_DUCT_EXHAUST/9_DS_BULKHEAD]"));

    Boundary boundary_52 = 
      region_14.getBoundaryManager().getBoundary("w_end_ds");

    Region region_15 = 
      simulation_0.getRegionManager().getRegion("12_SHIELD_METAL");

    Boundary boundary_53 = 
      region_15.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_65 = 
      ((InterfaceBoundary) region_15.getBoundaryManager().getBoundary("Default [12_SHIELD_METAL/13_SHIELD_COATING]"));

    Boundary boundary_54 = 
      region_15.getBoundaryManager().getBoundary("SHD_END");

    InterfaceBoundary interfaceBoundary_66 = 
      ((InterfaceBoundary) region_15.getBoundaryManager().getBoundary("SHD_END [12_SHIELD_METAL/3_EXHAUST_DUCT]"));

    Boundary boundary_55 = 
      region_15.getBoundaryManager().getBoundary("SHD_OD");

    InterfaceBoundary interfaceBoundary_67 = 
      ((InterfaceBoundary) region_15.getBoundaryManager().getBoundary("SHD_OD [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"));

    Region region_16 = 
      simulation_0.getRegionManager().getRegion("13_SHIELD_COATING");

    Boundary boundary_56 = 
      region_16.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_68 = 
      ((InterfaceBoundary) region_16.getBoundaryManager().getBoundary("Default [12_SHIELD_METAL/13_SHIELD_COATING]"));

    Boundary boundary_57 = 
      region_16.getBoundaryManager().getBoundary("SHD_END");

    InterfaceBoundary interfaceBoundary_69 = 
      ((InterfaceBoundary) region_16.getBoundaryManager().getBoundary("SHD_END [13_SHIELD_COATING/3_EXHAUST_DUCT 2]"));

    Boundary boundary_58 = 
      region_16.getBoundaryManager().getBoundary("SHD_ID");

    InterfaceBoundary interfaceBoundary_70 = 
      ((InterfaceBoundary) region_16.getBoundaryManager().getBoundary("SHD_ID [13_SHIELD_COATING/3_EXHAUST_DUCT]"));

    Region region_17 = 
      simulation_0.getRegionManager().getRegion("14_SPRAY");

    Boundary boundary_59 = 
      region_17.getBoundaryManager().getBoundary("RU");

    InterfaceBoundary interfaceBoundary_71 = 
      ((InterfaceBoundary) region_17.getBoundaryManager().getBoundary("RU [14_SPRAY/7_REAR_ADAPTER]"));

    Boundary boundary_60 = 
      region_17.getBoundaryManager().getBoundary("SPRAY_END");

    InterfaceBoundary interfaceBoundary_72 = 
      ((InterfaceBoundary) region_17.getBoundaryManager().getBoundary("SPRAY_END [14_SPRAY/3_EXHAUST_DUCT 3]"));

    Boundary boundary_61 = 
      region_17.getBoundaryManager().getBoundary("SPRAY_ID");

    InterfaceBoundary interfaceBoundary_73 = 
      ((InterfaceBoundary) region_17.getBoundaryManager().getBoundary("SPRAY_ID [14_SPRAY/3_EXHAUST_DUCT]"));

    Boundary boundary_62 = 
      region_17.getBoundaryManager().getBoundary("SPRAY_OD");

    InterfaceBoundary interfaceBoundary_74 = 
      ((InterfaceBoundary) region_17.getBoundaryManager().getBoundary("SPRAY_OD [14_SPRAY/3_EXHAUST_DUCT 2]"));

    Region region_18 = 
      simulation_0.getRegionManager().getRegion("15_DEFLECTOR");

    Boundary boundary_63 = 
      region_18.getBoundaryManager().getBoundary("Default");

    InterfaceBoundary interfaceBoundary_75 = 
      ((InterfaceBoundary) region_18.getBoundaryManager().getBoundary("Default [15_DEFLECTOR/2_ANNULAR_DUCT]"));

    linePart_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    LinePart linePart_1 = 
      ((LinePart) simulation_0.getPartManager().getObject("Line Probe 2"));

    linePart_1.getInputParts().setQuery(null);

    linePart_1.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    LinePart linePart_2 = 
      ((LinePart) simulation_0.getPartManager().getObject("Line Probe 3"));

    linePart_2.getInputParts().setQuery(null);

    linePart_2.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_0 = 
      ((PointPart) simulation_0.getPartManager().getObject("pmon_0"));

    pointPart_0.getInputParts().setQuery(null);

    pointPart_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_1 = 
      ((PointPart) simulation_0.getPartManager().getObject("pmon_1"));

    pointPart_1.getInputParts().setQuery(null);

    pointPart_1.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_2 = 
      ((PointPart) simulation_0.getPartManager().getObject("pmon_2"));

    pointPart_2.getInputParts().setQuery(null);

    pointPart_2.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_3 = 
      ((PointPart) simulation_0.getPartManager().getObject("Point"));

    pointPart_3.getInputParts().setQuery(null);

    pointPart_3.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_4 = 
      ((PointPart) simulation_0.getPartManager().getObject("Point 2"));

    pointPart_4.getInputParts().setQuery(null);

    pointPart_4.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_5 = 
      ((PointPart) simulation_0.getPartManager().getObject("Point 3"));

    pointPart_5.getInputParts().setQuery(null);

    pointPart_5.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_6 = 
      ((PointPart) simulation_0.getPartManager().getObject("Point 4"));

    pointPart_6.getInputParts().setQuery(null);

    pointPart_6.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("ps_rpassage"));

    planeSection_0.getInputParts().setQuery(null);

    planeSection_0.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_7 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_0"));

    pointPart_7.getInputParts().setQuery(null);

    pointPart_7.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_8 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_1"));

    pointPart_8.getInputParts().setQuery(null);

    pointPart_8.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_9 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_2"));

    pointPart_9.getInputParts().setQuery(null);

    pointPart_9.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_10 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_3"));

    pointPart_10.getInputParts().setQuery(null);

    pointPart_10.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_11 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_4"));

    pointPart_11.getInputParts().setQuery(null);

    pointPart_11.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    PointPart pointPart_12 = 
      ((PointPart) simulation_0.getPartManager().getObject("xm2_5"));

    pointPart_12.getInputParts().setQuery(null);

    pointPart_12.getInputParts().setObjects(region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, interfaceBoundary_0, interfaceBoundary_1, interfaceBoundary_2, region_1, boundary_5, boundary_6, boundary_7, boundary_8, interfaceBoundary_3, boundary_9, interfaceBoundary_4, interfaceBoundary_5, interfaceBoundary_6, interfaceBoundary_7, interfaceBoundary_8, interfaceBoundary_9, interfaceBoundary_10, interfaceBoundary_11, interfaceBoundary_12, boundary_10, interfaceBoundary_13, boundary_11, interfaceBoundary_14, region_2, boundary_12, boundary_13, boundary_14, boundary_15, interfaceBoundary_15, boundary_16, interfaceBoundary_16, boundary_17, interfaceBoundary_17, boundary_18, interfaceBoundary_18, interfaceBoundary_19, boundary_19, interfaceBoundary_20, boundary_20, interfaceBoundary_21, boundary_21, interfaceBoundary_22, boundary_22, interfaceBoundary_23, boundary_23, interfaceBoundary_24, boundary_24, boundary_25, region_3, boundary_26, interfaceBoundary_25, interfaceBoundary_26, region_4, boundary_27, interfaceBoundary_27, interfaceBoundary_28, boundary_28, region_5, boundary_29, interfaceBoundary_29, interfaceBoundary_30, region_6, boundary_30, interfaceBoundary_31, interfaceBoundary_32, interfaceBoundary_33, interfaceBoundary_34, region_7, boundary_31, interfaceBoundary_35, interfaceBoundary_36, interfaceBoundary_37, interfaceBoundary_38, boundary_32, region_8, boundary_33, interfaceBoundary_39, interfaceBoundary_40, interfaceBoundary_41, interfaceBoundary_42, interfaceBoundary_43, region_9, boundary_34, boundary_35, interfaceBoundary_44, interfaceBoundary_45, boundary_36, region_10, boundary_37, interfaceBoundary_46, boundary_38, interfaceBoundary_47, boundary_39, interfaceBoundary_48, boundary_40, interfaceBoundary_49, boundary_41, interfaceBoundary_50, interfaceBoundary_51, region_11, boundary_42, boundary_43, interfaceBoundary_52, interfaceBoundary_53, interfaceBoundary_54, interfaceBoundary_55, region_12, boundary_44, boundary_45, interfaceBoundary_56, interfaceBoundary_57, interfaceBoundary_58, interfaceBoundary_59, interfaceBoundary_60, boundary_46, region_13, boundary_47, boundary_48, interfaceBoundary_61, interfaceBoundary_62, region_14, boundary_49, boundary_50, boundary_51, interfaceBoundary_63, interfaceBoundary_64, boundary_52, region_15, boundary_53, interfaceBoundary_65, boundary_54, interfaceBoundary_66, boundary_55, interfaceBoundary_67, region_16, boundary_56, interfaceBoundary_68, boundary_57, interfaceBoundary_69, boundary_58, interfaceBoundary_70, region_17, boundary_59, interfaceBoundary_71, boundary_60, interfaceBoundary_72, boundary_61, interfaceBoundary_73, boundary_62, interfaceBoundary_74, region_18, boundary_63, interfaceBoundary_75);

    StreamPart streamPart_0 = 
      ((StreamPart) simulation_0.getPartManager().getObject("SL_TFL"));

    streamPart_0.getInputParts().setQuery(null);

    streamPart_0.getInputParts().setObjects(region_1);

    SourceSeed sourceSeed_0 = 
      streamPart_0.getSourceSeed();

    sourceSeed_0.getSeedParts().setQuery(null);

    sourceSeed_0.getSeedParts().setObjects(boundary_5);
  }
}
