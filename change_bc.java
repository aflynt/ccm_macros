// Simcenter STAR-CCM+ macro: change_bc.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.energy.*;
import star.species.*;
import star.radiation.common.*;

public class change_bc extends StarMacro {

  private Simulation ss;

  private Boundary b_02b;
  private Boundary b_05b;
  private Boundary b_03b;
  private Boundary b_06b;
  private Boundary b_04b;
  private Boundary b_07b;
  private Boundary b_08b;
  private Boundary b_091;
  private Boundary b_092;
  private Boundary b_093;
  private Boundary b_094;
  private Boundary b_097;
  private Boundary b_098;
  private Boundary b_095;
  private Boundary b_096;
  private Boundary b_099;
  private Boundary b_010;

  private Region rr_11;
  private Region rr_10;
  private Region rr_9;
  private Region rr_8;
  private Region rr_6;
  private Region rr_3;
  private Region rr_2;
  private Region rr_1;

  public void execute() {
    execute0();
  }

  private void allocate_boundaries(){

    rr_1  = ss.getRegionManager().getRegion("1_CENTER_DUCT");
    rr_2  = ss.getRegionManager().getRegion("2_ANNULAR_DUCT");
    rr_3  = ss.getRegionManager().getRegion("3_EXHAUST_DUCT");
    rr_6  = ss.getRegionManager().getRegion("6_FLOW_LINER");
    rr_8  = ss.getRegionManager().getRegion("8_TFL");
    rr_9  = ss.getRegionManager().getRegion("9_DS_BULKHEAD");
    rr_10 = ss.getRegionManager().getRegion("10_LOCK");
    rr_11 = ss.getRegionManager().getRegion("11_DUCT_EXHAUST");

    b_02b = rr_1.getBoundaryManager().getBoundary("#02_inlet");
    b_03b = rr_2.getBoundaryManager().getBoundary("#03_inlet");
    b_04b = rr_3.getBoundaryManager().getBoundary("#04_inlet");
    b_05b = rr_1.getBoundaryManager().getBoundary("#05_outlet");
    b_06b = rr_2.getBoundaryManager().getBoundary("#06_outlet");
    b_07b = rr_3.getBoundaryManager().getBoundary("#07_outlet");
    b_08b = rr_2.getBoundaryManager().getBoundary("#08_combustor_casing");
    b_091 = rr_6.getBoundaryManager().getBoundary("#09_od_wall_1");
    b_092 = rr_6.getBoundaryManager().getBoundary("#09_od_wall_2");
    b_093 = rr_6.getBoundaryManager().getBoundary("#09_od_wall_3");
    b_094 = rr_8.getBoundaryManager().getBoundary("#09_od_wall_4");
    b_095 = rr_10.getBoundaryManager().getBoundary("#09_od_wall_5");
    b_096 = rr_10.getBoundaryManager().getBoundary("#09_od_wall_6");
    b_097 = rr_9.getBoundaryManager().getBoundary("#09_od_wall_7");
    b_098 = rr_9.getBoundaryManager().getBoundary("#09_od_wall_8");
    b_099 = rr_11.getBoundaryManager().getBoundary("#09_od_wall_9");
    b_010 = rr_11.getBoundaryManager().getBoundary("#10_ex_od");
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

    MoleFractionProfile mfp = b.getValues().get(MoleFractionProfile.class);

    mfp.getMethod(ConstantArrayProfileMethod.class).getQuantity().setArray(dv);

  }

  private void execute0() {

    ss = getActiveSimulation();
    allocate_boundaries();

    double T_inlet      = 1450.0;
    double T_annulus    =  120.0;
    double T_exhaust    = 3800.0;
    double T_backflow   = 1520.3;
    double T_infinity   =  110.0;
    double h_room       =    1.0;
    double mdot_inlet   =  120.0 / (2.0 * 3.14159);
    double mdot_annulus =    3.0 / (2.0 * 3.14159);

    double p_atm = 101325.0/6894.76;   //psi
    double p_center  = 1000.0 - p_atm;
    double p_annulus = 1050.0 - p_atm;
    double p_exhaust =  950.0 - p_atm;

    double q_flux = -631000.0; // W/m^2

    DoubleVector mole_fracs = new DoubleVector(new double[] {0.0089, 0.00151, 0.09734, 0.04819, 0.00893, 3.1E-4, 0.73761, 0.00312, 2.5E-4, 4.0E-5, 1.0E-5, 0.09379});

    set_mdot_boundary(b_02b, mdot_inlet  , "lb/s", T_inlet  , "F");
    set_mdot_boundary(b_03b, mdot_annulus, "lb/s", T_annulus, "F");
    set_mdot_boundary(b_04b, mdot_inlet  , "lb/s", T_exhaust, "F");

    set_pressure_boundary(b_05b, p_center , "psi", T_inlet   , "F");
    set_pressure_boundary(b_06b, p_annulus, "psi", T_annulus , "F");
    set_pressure_boundary(b_07b, p_exhaust, "psi", T_backflow, "F");

    set_mole_fractions(b_04b, mole_fracs);
    set_mole_fractions(b_07b, mole_fracs);

    set_temperature_boundary(b_08b, T_inlet, "F");

    set_convective_boundary(b_091, T_infinity, h_room, "F");
    set_convective_boundary(b_092, T_infinity, h_room, "F");
    set_convective_boundary(b_093, T_infinity, h_room, "F");
    set_convective_boundary(b_094, T_infinity, h_room, "F");
    set_convective_boundary(b_095, T_infinity, h_room, "F");
    set_convective_boundary(b_096, T_infinity, h_room, "F");
    set_convective_boundary(b_097, T_infinity, h_room, "F");
    set_convective_boundary(b_098, T_infinity, h_room, "F");
    set_convective_boundary(b_099, T_infinity, h_room, "F");

    set_heat_flux_boundary(b_010, q_flux, "W/m^2");

  }
}
