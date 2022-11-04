// Simcenter STAR-CCM+ macro: do_it_all.java
// Written by Simcenter STAR-CCM+ 16.04.007
package macro;

import java.util.*;
import java.io.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.energy.*;

public class do_it_all extends StarMacro {

  public void execute() {
    exec_read_case_num();
    chg_speed();
    //chg_temperature();
    run();
    post_process();
  }

  String pwd = "DIR_NAME";
  int prob_num = 0;
  double airspeed = 0.3;
  double temperature = 100.0;
  String caseName = "run_"+String.format("%03d", prob_num);  // "ncT003"

  private void exec_read_case_num() {
    //Simulation sim = getActiveSimulation();

    // read case number into global variable "prob_num"
    try {
        //BufferedReader br = new BufferedReader(new FileReader("/home/flyntga/git/optuna/prob_num"));
        System.out.println("pwd: "+ pwd);
        String line;
        BufferedReader br = new BufferedReader(new FileReader(pwd+"optdata.txt"));

        line = br.readLine();
        prob_num = Integer.parseInt(line);

        line = br.readLine();
        airspeed = Double.parseDouble(line);
        //temperature = Double.parseDouble(line);

        caseName = "run_"+String.format("%03d", prob_num);
        //System.out.println("got problem number: " + prob_num);
        //System.out.println("case name is: " + caseName);
        br.close();
    }
    catch (Exception e) {
        System.out.println("file not found!");
        //sim.println("file not found!");
    }
  }

  private void post_process() {
    post(prob_num);
  }

  private void chg_speed() {

    set_airspeed(airspeed);

  }

  private void set_airspeed(double speed) {

    Simulation ss = getActiveSimulation();
    Region rr = ss.getRegionManager().getRegion("FURNACE");
    Boundary bb = rr.getBoundaryManager().getBoundary("inlet1");
    Units uu = ((Units) ss.getUnitsManager().getObject("m/s"));
    VelocityMagnitudeProfile vmp = bb.getValues().get(VelocityMagnitudeProfile.class);


    vmp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(speed);
    vmp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setUnits(uu);
  }

  private void run() {

    Simulation simulation_0 = 
      getActiveSimulation();

    simulation_0.getSimulationIterator().run();
  }

  private void post(int run_number) {

    String cwd = "/shared/loki/THOR-AP-24HR/700307_CNS_HRFS/flyntga/c019_cooldown/c19_2022/ss_tests/temp_sensitivity/post_ts/";

    String fname1 = "h_" + Integer.toString(run_number) + ".csv";
    String fname2 = "T_" + Integer.toString(run_number) + ".csv";
    String fname3 = "y_" + Integer.toString(run_number) + ".csv";

    Simulation simulation_0 = 
      getActiveSimulation();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("monitors_of_h"));

    monitorPlot_0.open();

    PlotUpdate plotUpdate_1 = 
      monitorPlot_0.getPlotUpdate();

    HardcopyProperties hardcopyProperties_1 = 
      plotUpdate_1.getHardcopyProperties();

    hardcopyProperties_1.setCurrentResolutionWidth(25);

    hardcopyProperties_1.setCurrentResolutionHeight(25);

    hardcopyProperties_1.setCurrentResolutionWidth(1273);

    hardcopyProperties_1.setCurrentResolutionHeight(496);

    Cartesian2DAxisManager cartesian2DAxisManager_1 = 
      ((Cartesian2DAxisManager) monitorPlot_0.getAxisManager());

    cartesian2DAxisManager_1.setAxesBounds(new Vector(Arrays.<AxisManager.AxisBounds>asList(new AxisManager.AxisBounds("Left Axis", 0.0, true, 10.0, true), new AxisManager.AxisBounds("Bottom Axis", 1.0, false, 4001.0, false))));

    monitorPlot_0.export(resolvePath(cwd + fname1), ",");

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("monitors_of_temp"));

    monitorPlot_1.open();

    PlotUpdate plotUpdate_2 = 
      monitorPlot_1.getPlotUpdate();

    HardcopyProperties hardcopyProperties_2 = 
      plotUpdate_2.getHardcopyProperties();

    hardcopyProperties_2.setCurrentResolutionWidth(25);

    hardcopyProperties_2.setCurrentResolutionHeight(25);

    hardcopyProperties_2.setCurrentResolutionWidth(1273);

    hardcopyProperties_2.setCurrentResolutionHeight(496);

    Cartesian2DAxisManager cartesian2DAxisManager_2 = 
      ((Cartesian2DAxisManager) monitorPlot_1.getAxisManager());

    cartesian2DAxisManager_2.setAxesBounds(new Vector(Arrays.<AxisManager.AxisBounds>asList(new AxisManager.AxisBounds("Left Axis", 19.999999999999943, false, 159.15308414191674, false), new AxisManager.AxisBounds("Bottom Axis", 1.0, false, 4001.0, false))));

    monitorPlot_1.export(resolvePath(cwd + fname2), ",");

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("monitors_of_yplus"));

    monitorPlot_2.open();

    PlotUpdate plotUpdate_3 = 
      monitorPlot_2.getPlotUpdate();

    HardcopyProperties hardcopyProperties_3 = 
      plotUpdate_3.getHardcopyProperties();

    hardcopyProperties_3.setCurrentResolutionWidth(25);

    hardcopyProperties_3.setCurrentResolutionHeight(25);

    hardcopyProperties_3.setCurrentResolutionWidth(1273);

    hardcopyProperties_3.setCurrentResolutionHeight(496);

    Cartesian2DAxisManager cartesian2DAxisManager_3 = 
      ((Cartesian2DAxisManager) monitorPlot_2.getAxisManager());

    cartesian2DAxisManager_3.setAxesBounds(new Vector(Arrays.<AxisManager.AxisBounds>asList(new AxisManager.AxisBounds("Left Axis", 3.189569084555049E-4, false, 3.358966733070086, false), new AxisManager.AxisBounds("Bottom Axis", 1.0, false, 4001.0, false))));

    monitorPlot_2.export(resolvePath(cwd + fname3), ",");
  }

  private void chg_temperature() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("FURNACE");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("OD1");

    StaticTemperatureProfile staticTemperatureProfile_0 = 
      boundary_1.getValues().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(temperature);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("C"));

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setUnits(units_1);

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("OD2");

    StaticTemperatureProfile staticTemperatureProfile_1 = 
      boundary_2.getValues().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(temperature);

    staticTemperatureProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setUnits(units_1);
  }
}
