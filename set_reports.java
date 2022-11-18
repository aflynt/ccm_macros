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

  public void execute() {
    init();
    execute0();
  }

  private void init(){
    ss = getActiveSimulation();
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

  private int get_boundary_number(String bname){
    // input boundary name: #08_abcdef...
    // output returns: 8
    int n = 0;
    try {
       if (bname.contains("#")){
           String s = bname.split("_")[0].split("#")[1];
           n = Integer.parseInt(s);
       }
    } catch (Exception e){ 
      ss.println("\t* "+bname+": bad parse");
    }
    return n;
  }

  private ArrayList<Boundary> get_boundaries_by_number(int n){

    ArrayList<Boundary> blist = new ArrayList<Boundary>();

    // loop over regions
    Collection<Region> rs = ss.getRegionManager().getRegions();
    for (Region r : rs){

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      for (Boundary b: bs){
        int bnum = get_boundary_number(b.getPresentationName());
        if (n == bnum){
          blist.add(b);
        }
      }
    }

    return blist;
  }
  private Boundary get_boundary_by_number(int n){
    ArrayList<Boundary> blist = get_boundaries_by_number(n);
    if (blist.isEmpty()){
      Boundary b = null;
      return b;
    } else {
      return blist.get(0);
    }
  }

  private Boundary get_boundary_by_name(String bname){

    Collection<Region> rs = ss.getRegionManager().getRegions();
    for (Region r : rs){
      String rname = r.getPresentationName();

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();
      for (Boundary b: bs){

        String iname = b.getPresentationName();
        //ss.println("r,n ="+String.format("%20s",rname)+" "+iname);
        if (iname.equals(bname)){
          //ss.println("found!");
          return b;
        }
      }
    }
    ss.println("NULL_");

    Boundary the_b = null;
    return the_b;
  }


  private void execute0() {

    try {

      Boundary b_c_i  = get_boundary_by_number(2); // center_inlet
      Boundary b_a_i  = get_boundary_by_number(3); // annular inlet
      Boundary b_e_i  = get_boundary_by_number(4); // exhaust inlet
      Boundary b_c_e  = get_boundary_by_number(5); // c exit
      Boundary b_a_e  = get_boundary_by_number(6); // a exit
      Boundary b_e_e  = get_boundary_by_number(7); // e exit
      Boundary b_iface  = get_boundary_by_name("Default [11_DUCT_EXHAUST/9_DS_BULKHEAD]");

      if (b_c_i == null) ss.println("b_c_i is null"); 
      if (b_a_i == null) ss.println("b_a_i is null"); 
      if (b_e_i == null) ss.println("b_e_i is null");
      if (b_c_e == null) ss.println("b_c_e is null");
      if (b_a_e == null) ss.println("b_a_e is null");
      if (b_e_e == null) ss.println("b_e_e is null");
      if (b_iface == null) ss.println("b_iface is null");


      set_rep_mdot("bal_mdot_annulus", Arrays.asList(b_a_i, b_a_e));
      set_rep_mdot("bal_mdot_exhaust", Arrays.asList(b_e_i, b_e_e));
      set_rep_mdot("bal_mdot_inlet"  , Arrays.asList(b_c_i, b_c_e));
      set_rep_mdot("mdot_gas_inlet", Arrays.asList(b_c_i));
      set_rep_mdot("mdot_gas_outlet",Arrays.asList(b_c_e));

      set_rep_ave("i_p_ex",         Arrays.asList( b_e_i));
      set_rep_ave("i_p_an",         Arrays.asList( b_a_i));

      set_rep_ave("i_p",         Arrays.asList( b_c_i));
      set_rep_ave("i_rho",       Arrays.asList( b_c_i));
      set_rep_ave("i_T",         Arrays.asList( b_c_i));
      set_rep_ave("i_u",         Arrays.asList( b_c_i));
      set_rep_ave("i_u_annulus", Arrays.asList( b_c_i));
      set_rep_ave("i_u_inlet",   Arrays.asList( b_c_i));

      set_rep_ave("mf_ar",        Arrays.asList( b_e_e));
      set_rep_ave("mf_CO",        Arrays.asList( b_e_e));
      set_rep_ave("mf_CO2",       Arrays.asList( b_e_e));
      set_rep_ave("mf_H2O",       Arrays.asList( b_e_e));
      set_rep_ave("mf_N2",        Arrays.asList( b_e_e));
      set_rep_ave("mf_NO",        Arrays.asList( b_e_e));
      set_rep_ave("mf_O",         Arrays.asList( b_e_e));
      set_rep_ave("mf_O2",        Arrays.asList( b_e_e));
      set_rep_ave("mf_OH",        Arrays.asList( b_e_e));

      set_rep_ave("o_p",          Arrays.asList( b_e_e));
      set_rep_ave("o_rho",        Arrays.asList( b_e_e));
      set_rep_ave("o_T",          Arrays.asList( b_e_e));
      set_rep_ave("o_u",          Arrays.asList( b_e_e));
      set_rep_ave("sa_exit_temp", Arrays.asList( b_e_e));

      set_rep_ave("T_AN_OUT"    , Arrays.asList( b_a_e));
      set_rep_ave("T_gas_inlet" , Arrays.asList( b_e_i));
      set_rep_ave("T_gas_outlet", Arrays.asList( b_e_e));

      set_rep_ave("T_shell", Arrays.asList( b_iface ));
      } catch (Exception e){
        String msg = e.getMessage();
        ss.println("thrown: "+ msg);
      }
  }
}
