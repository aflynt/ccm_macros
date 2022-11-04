// Simcenter STAR-CCM+ macro: set_reports.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class set_reports extends StarMacro {

  private Simulation ss;
  private Region  rr_1_center_duct;
  private Region  rr_2_annular_duct;
  private Region  rr_3_exhaust_duct;
  private Region  rr_9_ds_bulkhead;
  private Boundary b_rr1_i;
  private Boundary b_rr2_i;
  private Boundary b_rr3_i;
  private Boundary b_rr1_o;
  private Boundary b_rr2_o;
  private Boundary b_rr3_o;
  private InterfaceBoundary b_iface;

  public void execute() {
    init();
    execute0();
  }

  private void init(){
    ss = getActiveSimulation();
    rr_1_center_duct  = ss.getRegionManager().getRegion("1_CENTER_DUCT");
    rr_2_annular_duct = ss.getRegionManager().getRegion("2_ANNULAR_DUCT");
    rr_3_exhaust_duct = ss.getRegionManager().getRegion("3_EXHAUST_DUCT");
    rr_9_ds_bulkhead  = ss.getRegionManager().getRegion("9_DS_BULKHEAD");
    b_rr1_i  = rr_1_center_duct.getBoundaryManager().getBoundary("#02_inlet");
    b_rr2_i  = rr_2_annular_duct.getBoundaryManager().getBoundary("#03_inlet");
    b_rr3_i  = rr_3_exhaust_duct.getBoundaryManager().getBoundary("#04_inlet");
    b_rr1_o  = rr_1_center_duct.getBoundaryManager().getBoundary("#05_outlet");
    b_rr2_o  = rr_2_annular_duct.getBoundaryManager().getBoundary("#06_outlet");
    b_rr3_o  = rr_3_exhaust_duct.getBoundaryManager().getBoundary("#07_outlet");
    b_iface  = ((InterfaceBoundary) rr_9_ds_bulkhead.getBoundaryManager().getBoundary("i0 [11_DUCT_EXHAUST/9_DS_BULKHEAD]"));
  }

  private void set_rep_mdot(String repname, Collection<NamedObject> objects){

    MassFlowReport mfr = ((MassFlowReport) ss.getReportManager().getReport(repname));
    mfr.getParts().setQuery(null);

    mfr.getParts().setObjects(objects);
  }

  private void set_rep_ave(String repname, Collection<NamedObject> objects){
    AreaAverageReport areaAverageReport_0 = ((AreaAverageReport) ss.getReportManager().getReport(repname));
    areaAverageReport_0.getParts().setQuery(null);

    areaAverageReport_0.getParts().setObjects(objects);
  }

  private void execute0() {

    set_rep_mdot("bal_mdot_annulus", Arrays.asList(b_rr2_i, b_rr2_o));
    set_rep_mdot("bal_mdot_exhaust", Arrays.asList(b_rr3_i, b_rr3_o));
    set_rep_mdot("bal_mdot_inlet"  , Arrays.asList(b_rr1_i, b_rr1_o));
    set_rep_mdot("mdot_gas_inlet", Arrays.asList(b_rr1_i));
    set_rep_mdot("mdot_gas_outlet",Arrays.asList(b_rr1_o));

    set_rep_ave("i_p",         Arrays.asList( b_rr1_i));
    set_rep_ave("i_rho",       Arrays.asList( b_rr1_i));
    set_rep_ave("i_T",         Arrays.asList( b_rr1_i));
    set_rep_ave("i_u",         Arrays.asList( b_rr1_i));
    set_rep_ave("i_u_annulus", Arrays.asList( b_rr1_i));
    set_rep_ave("i_u_inlet",   Arrays.asList( b_rr1_i));

    set_rep_ave("mf_ar",        Arrays.asList( b_rr3_o));
    set_rep_ave("mf_CO",        Arrays.asList( b_rr3_o));
    set_rep_ave("mf_CO2",       Arrays.asList( b_rr3_o));
    set_rep_ave("mf_H2O",       Arrays.asList( b_rr3_o));
    set_rep_ave("mf_N2",        Arrays.asList( b_rr3_o));
    set_rep_ave("mf_NO",        Arrays.asList( b_rr3_o));
    set_rep_ave("mf_O",         Arrays.asList( b_rr3_o));
    set_rep_ave("mf_O2",        Arrays.asList( b_rr3_o));
    set_rep_ave("mf_OH",        Arrays.asList( b_rr3_o));

    set_rep_ave("o_p",          Arrays.asList( b_rr3_o));
    set_rep_ave("o_rho",        Arrays.asList( b_rr3_o));
    set_rep_ave("o_T",          Arrays.asList( b_rr3_o));
    set_rep_ave("o_u",          Arrays.asList( b_rr3_o));
    set_rep_ave("sa_exit_temp", Arrays.asList( b_rr3_o));

    set_rep_ave("T_AN_OUT"    , Arrays.asList( b_rr2_o));
    set_rep_ave("T_gas_inlet" , Arrays.asList( b_rr3_i));
    set_rep_ave("T_gas_outlet", Arrays.asList( b_rr3_o));

    set_rep_ave("T_shell", Arrays.asList( b_iface ));
  }
}
