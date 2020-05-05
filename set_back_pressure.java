// STAR-CCM+ macro: set_back_pressure.java
// Written by STAR-CCM+ 15.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class set_back_pressure extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    String s_region   = "TS";
    String s_boundary = "outlet";
    double pressure   = -70000.0;

    setPressure( s_region, s_boundary, pressure);
  }

  void setPressure(String s_region, String s_boundary, double pressure){

    Simulation ss = getActiveSimulation();
    Region     rr = ss.getRegionManager().getRegion(s_region);
    Boundary   bb = rr.getBoundaryManager().getBoundary(s_boundary);
    StaticPressureProfile pp = bb.getValues().get(StaticPressureProfile.class);

    // set the outlet pressure
    pp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(pressure);
  }
}
