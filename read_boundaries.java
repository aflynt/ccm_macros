// Simcenter STAR-CCM+ macro: read_boundaries.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.energy.*;
import star.species.*;
import star.radiation.common.*;

public class read_boundaries extends StarMacro {

  private Simulation ss;

  // physics continuum
  String pc_gin = "g__gas_inlet";
  String pc_gan = "g__gas_annulus";
  String pc_gex = "g__gas_exhaust";
  String pc_kao = "s__kaowool";
  String pc_inc = "s__inconel_625";
  String pc_cst = "s__carbon_steel";
  String pc_ysz = "s__ysz";

  // map of region# to physics name
  Map<Integer,String> region_map = new HashMap<Integer, String>(){{
    put(0  , pc_gin);
    put(1  , pc_gin);
    put(2  , pc_gan);
    put(3  , pc_gex);
    put(4  , pc_kao);
    put(5  , pc_inc);
    put(6  , pc_cst);
    put(7  , pc_inc);
    put(8  , pc_cst);
    put(9  , pc_cst);
    put(10 , pc_cst);
    put(11 , pc_inc);
    put(12 , pc_inc);
    put(13 , pc_ysz);
    put(14 , pc_gex);
  }};


  // map of boundary# to boundary type
  // special case for: mdot, pres
  Map<Integer,String> bc_map = new HashMap<Integer, String>(){{
    put(2, "mdot");
    put(3, "mdot");
    put(4, "mdot");
    put(5, "pres");
    put(6, "pres");
    put(7, "pres");
  }};

  private void check_physics(){
    //loop over PhysicsContinuum
    Collection<Object> ps = ss.getContinuumManager().getChildren();
    for (Object p : ps){
      Continuum c = (Continuum) p;
      
      String pname = c.getPresentationName();
      //if(pname.equals(pc_ysz)){
      //  ss.println("ysz physics found !!!!!!");
      //}
      ss.println("* "+pname);
    }
  }

  int get_region_number(String rname){

      // pre: name must start with a number
      // post: return number as int
      int n = 0;
      try {
        n = Integer.parseInt(rname.split("_")[0]);
      } catch (Exception e){ 
        ss.println("\t* region_number: "+rname+" : bad parse");
      }
      return n
  }

  private void set_region_physics(){

    Collection<Region> rs = ss.getRegionManager().getRegions();

    for (Region r : rs){

      int n = get_region_number(r.getPresentationName());

      // lookup physics name in region_map
      String physics_name = region_map.get(n);

      // set region physics
      PhysicsContinuum pc = ((PhysicsContinuum) ss.getContinuumManager().getContinuum(physics_name));
      r.setPhysicsContinuum(pc);
    }
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

  private void set_boundary_type(){

    // boundary types
    MassFlowBoundary bc_mdot = ((MassFlowBoundary) ss.get(ConditionTypeManager.class).get(MassFlowBoundary.class));
    PressureBoundary bc_pres = ((PressureBoundary) ss.get(ConditionTypeManager.class).get(PressureBoundary.class));
    AxisBoundary     bc_axis = ((AxisBoundary)     ss.get(ConditionTypeManager.class).get(AxisBoundary.class));

    Collection<Region> rs = ss.getRegionManager().getRegions();

    // loop over regions
    for (Region r : rs){
      String rname = r.getPresentationName();
      ss.println("== "+rname);

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      // loop over boundaries
      for (Boundary b: bs){
        String bname = b.getPresentationName();
        if (bname.equals("centerline")) {

          b.setBoundaryType(bc_axis);

        } else if (bname.contains("#")) {
          try {
             int n = get_boundary_number(bname);
             if (bc_map.containsKey(n)){

                String bc_name = bc_map.get(n);
                ss.println("\t_ "+ bname+" in for # "+ n + " = "+ bc_name);

                switch (bc_name) {
                  case "mdot": b.setBoundaryType(bc_mdot); break;
                  case "pres": b.setBoundaryType(bc_pres); break;
                  default    : break;
                }
             }
          } catch (Exception e){ 
            ss.println("\t* "+bname+": bad parse");
          }
        }
      }
    }
  }

  private void set_mdot(Boundary b,  double value, String units) {

    MassFlowRateProfile massFlowRateProfile_0 = b.getValues().get(MassFlowRateProfile.class);
    Units units_0 = ((Units) ss.getUnitsManager().getObject(units));
    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_0);
  }

  private void set_rad_temp(Boundary b,  double value, String units) {

    RadiationTemperatureProfile radiationTemperatureProfile_0 = b.getValues().get(RadiationTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    radiationTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);
  }

  private void set_tot_temp(Boundary b, double value, String units){

    TotalTemperatureProfile totalTemperatureProfile_0 = b.getValues().get(TotalTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    totalTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);
  }

  private void set_static_temp(Boundary b, double value, String units){
    StaticTemperatureProfile staticTemperatureProfile_0 = b.getValues().get(StaticTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);

  }

  private void set_pressure(Boundary b, double value, String units){

    StaticPressureProfile staticPressureProfile_0 = b.getValues().get(StaticPressureProfile.class);
    Units units_2 = ((Units) ss.getUnitsManager().getObject(units));
    staticPressureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_2);
  }

  private void set_mdot_boundary(Boundary b, double mdot, String units_mdot, double temp, String units_temp){
    set_mdot(b, mdot, units_mdot);
    set_rad_temp(b, temp, units_temp);
    set_tot_temp(b, temp, units_temp);
  }

  private void set_pressure_boundary(Boundary b, double p, String units_p, double temp, String units_temp){
    set_pressure(b, p, units_p);
    set_rad_temp(b, temp, units_temp);
    set_static_temp(b, temp, units_temp);
  }

  private void set_temperature_boundary(Boundary b, double temp, String units) {

    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.TEMPERATURE);

    StaticTemperatureProfile stp = b.getValues().get(StaticTemperatureProfile.class);

    Units uu = ((Units) ss.getUnitsManager().getObject(units));

    stp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(temp, uu);
  }

  private void set_convective_boundary(Boundary b, double t_infinity, double h, String units_temp) {
    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.CONVECTION);

    AmbientTemperatureProfile      atp = b.getValues().get(AmbientTemperatureProfile.class);
    HeatTransferCoefficientProfile htp = b.getValues().get(HeatTransferCoefficientProfile.class);

    Units uu_temp = ((Units) ss.getUnitsManager().getObject(units_temp));
    Units uu_h    = ((Units) ss.getUnitsManager().getObject("W/m^2-K"));  // hard coded units

    atp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(t_infinity, uu_temp);
    htp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(h, uu_h);
  }

  private void set_heat_flux_boundary(Boundary b, double val, String units){

    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.HEAT_FLUX);

    HeatFluxProfile hfp = b.getValues().get(HeatFluxProfile.class);

    Units uu = ((Units) ss.getUnitsManager().getObject(units));

    hfp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(val, uu);

  }

  private void set_mole_fractions(Boundary b, DoubleVector dv){

    b.getConditions().get(SpeciesSpecificationOption.class).setSelected(SpeciesSpecificationOption.Type.MOLE_FRACTION);
    MoleFractionProfile mfp = b.getValues().get(MoleFractionProfile.class);

    mfp.getMethod(ConstantArrayProfileMethod.class).getQuantity().setArray(dv);

  }

  private void set_boundary_conditions(){

    double T_inlet      = 1450.0;  // F
    double T_annulus    =  120.0;  // F
    double T_exhaust    = 3800.0;  // F
    double T_backflow   = 1520.3;  // F
    double T_infinity   =  110.0;  // F
    double h_room       =    1.0;  // W/m^2-K
    double mdot_inlet   =  120.0 / (2.0 * 3.14159); // lbm/s
    double mdot_annulus =    3.0 / (2.0 * 3.14159); // lbm/s

    double p_atm = 101325.0/6894.76;   //psi
    double p_center  = 1000.0 - p_atm; //psi
    double p_annulus = 1050.0 - p_atm; //psi
    double p_exhaust =  950.0 - p_atm; //psi

    double q_flux = -631000.0; // W/m^2

    DoubleVector mole_fracs = new DoubleVector(new double[] {0.0089, 0.00151, 0.09734, 0.04819, 0.00893, 3.1E-4, 0.73761, 0.00312, 2.5E-4, 4.0E-5, 1.0E-5, 0.09379});

    // loop over boundary numbers
    for (int n = 2; n <11; ++n){

      ArrayList<Boundary> blist = get_boundaries_by_number(n);

      for (Boundary b : blist){
        String bname = b.getPresentationName();
        switch (n) {
          case 2: set_mdot_boundary(b, mdot_inlet  , "lb/s", T_inlet  , "F"); break;
          case 3: set_mdot_boundary(b, mdot_annulus, "lb/s", T_annulus, "F"); break;
          case 4: set_mdot_boundary(b, mdot_inlet  , "lb/s", T_exhaust, "F");
                  set_mole_fractions(b, mole_fracs); break;
          case 5: set_pressure_boundary(b, p_center , "psi", T_inlet   , "F"); break;
          case 6: set_pressure_boundary(b, p_annulus, "psi", T_annulus , "F"); break;
          case 7: set_pressure_boundary(b, p_exhaust, "psi", T_backflow, "F"); 
                  set_mole_fractions(b, mole_fracs); break;
          case 8: set_temperature_boundary(b, T_inlet, "F"); break;
          case 9:  set_convective_boundary(b, T_infinity, h_room, "F"); break;
          case 10:  set_heat_flux_boundary(b, q_flux, "W/m^2"); break;
          default: break;
        }
      }
    }
  }

  public void execute() {
    execute0();
  }

  private void execute0() {

    ss = getActiveSimulation();

    //set_region_physics();
    //set_boundary_type();
    set_boundary_conditions();
  }
}
