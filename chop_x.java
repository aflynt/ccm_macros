// Simcenter STAR-CCM+ macro: chop_x.java
// Written by Simcenter STAR-CCM+ 16.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class chop_x extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    

    Simulation ss = getActiveSimulation();
    Units uu = ss.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());
    UserFieldFunction ff = ((UserFieldFunction) ss.getFieldFunctionManager().getFunction("isXLess"));
    MeshManager mm = ss.getMeshManager();
    Region rr = ss.getRegionManager().getRegion("Region");
    Boundary bb_front = rr.getBoundaryManager().getBoundary("Subtract.front");
    Boundary bb_rear  = rr.getBoundaryManager().getBoundary("Subtract.rear");

    for(int i = -7; i < 10; ++i) {
        ff.setDefinition("$$Position(@CoordinateSystem(\"wrtCarCL6m\"))[0] > <"+ i +" ft > ? 1: 0");
        mm.splitBoundariesByFunction(ff, new NeoObjectVector(new Object[] {bb_front, bb_rear}));
    }
  }
}
