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

  private void set_bc_velo(Boundary b, double speed, String units){

    InletBoundary inlet_bc_type = ((InletBoundary) ss.get(ConditionTypeManager.class).get(InletBoundary.class));
    b.setBoundaryType(inlet_bc_type);

    Units uu = ((Units) ss.getUnitsManager().getObject(units));
    VelocityMagnitudeProfile vprofile = b.getValues().get(VelocityMagnitudeProfile.class);
    vprofile.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(speed, uu);
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
    Units uu_kph = ((Units) ss.getUnitsManager().getObject("kph"));

    PressureBoundary bc_type_pres = ((PressureBoundary) ss.get(ConditionTypeManager.class).get(PressureBoundary.class));

    b5.setBoundaryType(bc_type_pres);

    b6.getConditions().get(WallShearStressOption.class).setSelected(WallShearStressOption.Type.SLIP);
    b7.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.VECTOR);
    WallRelativeVelocityProfile vwall = b7.getValues().get(WallRelativeVelocityProfile.class);
    vwall.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(140.0, 0.0, 0.0, uu_kph);


    StaticPressureProfile pprofile = boundary_5.getValues().get(StaticPressureProfile.class);
    Units uu_Pa = ((Units) ss.getUnitsManager().getObject("Pa"));
    pprofile.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(1.0, uu_Pa);
  }
}
