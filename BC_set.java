// Simcenter STAR-CCM+ macro: BC_set.java
// Written by Simcenter STAR-CCM+ 17.06.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class BC_set extends StarMacro {

  Simulation ss;
  Region rr;

  public void execute() {
    execute0();
  }

  private void set_bc_velocity(Boundary b, double speed, String units){

    Units uu = ((Units) ss.getUnitsManager().getObject(units));
    InletBoundary inlet_bc_type = ((InletBoundary) ss.get(ConditionTypeManager.class).get(InletBoundary.class));
    b.setBoundaryType(inlet_bc_type);
    VelocityMagnitudeProfile vprofile = b.getValues().get(VelocityMagnitudeProfile.class);
    vprofile.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(speed, uu);
  }

  private void set_bc_pressure(Boundary b, double pressure, String units){

    Units uu = ((Units) ss.getUnitsManager().getObject(units));
    PressureBoundary bc_type_pres = ((PressureBoundary) ss.get(ConditionTypeManager.class).get(PressureBoundary.class));
    b.setBoundaryType(bc_type_pres);
    StaticPressureProfile pprofile = b.getValues().get(StaticPressureProfile.class);
    pprofile.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(1.0, uu);
  }

  private void set_bc_slip(Boundary b){
    b.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);
  }

  private void set_bc_road(Boundary b, double vx, String units){

    Units uu = ((Units) ss.getUnitsManager().getObject(units));
    b.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.VECTOR);
    WallRelativeVelocityProfile vprofile = b.getValues().get(WallRelativeVelocityProfile.class);
    vprofile.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(vx, 0.0, 0.0, uu);
  }

  private void execute0() {

    ss = getActiveSimulation();
    rr = ss.getRegionManager().getRegion("a_ts");

    Boundary b1 = rr.getBoundaryManager().getBoundary("#01_inlet");
    Boundary b2 = rr.getBoundaryManager().getBoundary("#02_out_suck_coarse");
    Boundary b3 = rr.getBoundaryManager().getBoundary("#03_out_suck_fine");
    Boundary b4 = rr.getBoundaryManager().getBoundary("#04_out_pblrs");
    Boundary b5 = rr.getBoundaryManager().getBoundary("#05_outlet");
    Boundary b6 = rr.getBoundaryManager().getBoundary("#06_slip_wall");
    Boundary b7 = rr.getBoundaryManager().getBoundary("#07_rolling_road");

    double v1 =   6.53;
    double v2 =  -0.27;
    double v3 =  -0.34;
    double v4 = -20.35;
    double v7 = 140.00;
    double p5 =   0.00;

    set_bc_velocity(b1, v1, "m/s");
    set_bc_velocity(b2, v2, "m/s");
    set_bc_velocity(b3, v3, "m/s");
    set_bc_velocity(b4, v4, "m/s");

    set_bc_pressure(b5, p5, "Pa");

    set_bc_slip(b6);

    set_bc_road(b7, v7, "kph");
  }
}
