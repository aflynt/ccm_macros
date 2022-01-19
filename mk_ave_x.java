// Simcenter STAR-CCM+ macro: mk_ave_x.java
// Written by Simcenter STAR-CCM+ 16.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;
import star.vis.*;

public class mk_ave_x extends StarMacro {

  public void execute() {
    execute0();
    // /shared/loki/THOR-AP-24HR/95792_FUJI/flyntga/linux21/wrc-fa-refined@04000_CP4MGP_drag_eval_20220119.sim
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    AreaAverageReport areaAverageReport_0 = 
      ((AreaAverageReport) simulation_0.getReportManager().getReport("Surface Average 1"));

    areaAverageReport_0.setPresentationName("ave_xf1");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Position"));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("wrtCarCL6m"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getFunctionInCoordinateSystem(cartesianCoordinateSystem_0).getComponentFunction(0));

    areaAverageReport_0.setFieldFunction(vectorComponentFieldFunction_0);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("ft"));

    areaAverageReport_0.setUnits(units_2);

    areaAverageReport_0.getParts().setQuery(null);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_1");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_2");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_3");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_4");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_5");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_6");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_7");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Subtract.front_8");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_1");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_2");

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_3");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_4");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_5");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_6");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Subtract.rear_7");

    areaAverageReport_0.getParts().setObjects(boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_2, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_3, boundary_16);

    areaAverageReport_0.printReport();

    ForceCoefficientReport forceCoefficientReport_19 = 
      ((ForceCoefficientReport) simulation_0.getReportManager().getReport("cx_b1"));

    forceCoefficientReport_19.getParts().setQuery(null);

    forceCoefficientReport_19.getParts().setObjects(boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_2, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_3, boundary_16);

    forceCoefficientReport_19.printReport();

    areaAverageReport_0.printReport();

    forceCoefficientReport_19.printReport();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("cp1");

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getObject("Scalar 1"));

    UserFieldFunction userFieldFunction_1 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Cp"));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(userFieldFunction_1);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValue(1.0);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setUnits(units_1);

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValue(-1.0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setUnits(units_1);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {6.128698053321965, -0.9476517659114165, 0.8062770406820973}), new DoubleVector(new double[] {6.128698053321965, -135.62303327182846, 0.8062770406820973}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 2.290933187654449, 1, 30.0);

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValue(10.0);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setUnits(units_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setUnits(units_2);

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setValue(-10.0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMinimumValue().setUnits(units_2);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setValue(10.0);

    scalarDisplayer_0.getScalarDisplayQuantity().getMaximumValue().setUnits(units_2);

    scalarDisplayer_0.setFillMode(ScalarFillMode.NODE_FILLED);

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CD Plot"));

    PlotUpdate plotUpdate_0 = 
      monitorPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      plotUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(1029);

    Cartesian2DAxisManager cartesian2DAxisManager_0 = 
      ((Cartesian2DAxisManager) monitorPlot_0.getAxisManager());

    cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.<AxisManager.AxisBounds>asList(new AxisManager.AxisBounds("Left Axis", -0.7458839581204537, true, 0.8722162382362635, true), new AxisManager.AxisBounds("Bottom Axis", 1.0, false, 4000.0, false))));

    simulation_0.saveState("/shared/loki/THOR-AP-24HR/95792_FUJI/flyntga/linux21/wrc-fa-refined@04000_CP4MGP_drag_eval_20220119.sim");
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("cp1");

    scene_0.close();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CD Plot"));

    monitorPlot_0.close();
  }
}
