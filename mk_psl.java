// STAR-CCM+ macro: mk_psl.java
// Written by STAR-CCM+ 14.02.012
//  make a bunch of points in x, y, z
//  make a bunch of streamlines
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class mk_psl extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation sim = getActiveSimulation();
    Region rr = sim.getRegionManager().getRegion("Subtract");
    PrimitiveFieldFunction pff = ((PrimitiveFieldFunction) sim.getFieldFunctionManager().getFunction("Velocity"));

    // reference part
    PointPart pp_ref = ((PointPart) sim.getPartManager().getObject("pref"));
    Units u_ft  = ((Units) sim.getUnitsManager().getObject("ft"));
    Units u_deg = ((Units) sim.getUnitsManager().getObject("deg"));
    Units u_m   = ((Units) sim.getUnitsManager().getObject("m"));


    int i, j, k;
    double x = -6.2;
    double y = 0.0;
    double z = 0.0;
    int NPOINTS = 8;

    // points for FUJI
    for ( i=0; i < NPOINTS ; ++i){

        switch(i) {  // specify y,z based on pt #
          case   0:  y = 2500.0/1000.0; z =  750.0/1000.0; break;
          case   1:  y = 2500.0/1000.0; z = 2250.0/1000.0; break;
          case   2:  y = 1875.0/1000.0; z = 3000.0/1000.0; break;
          case   3:  y =  625.0/1000.0; z = 3000.0/1000.0; break;
          case   4:  y = -625.0/1000.0; z = 3000.0/1000.0; break;
          case   5:  y =-1875.0/1000.0; z = 3000.0/1000.0; break;
          case   6:  y =-2500.0/1000.0; z = 2250.0/1000.0; break;
          case   7:  y =-2500.0/1000.0; z =  750.0/1000.0; break;
          default :  z =  0.0;
        }

        String sn = "p";
        String sy = String.format("%+05.0f", y*1000.0);
        String sz = String.format("%+05.0f", z*1000.0);
        String name = sn+"_y["+sy+"]_z["+sz+"]";

        System.out.println(name + " = " + y + "," + z);

        // make a new point
        PointPart pp = sim.getPartManager().createPointPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}));
        pp.copyProperties(pp_ref);
        pp.setPresentationName(name);

        pp.getPointCoordinate().setCoordinate(u_m, u_m, u_m, new DoubleVector(new double[] { x, y, z}));

        // make new streamline from new point
        StreamPart stream0 = sim.getPartManager().createStreamPart(new NeoObjectVector(new Object[] {rr}), new NeoObjectVector(new Object[] {pp}), pff, 1, 1, 0);
        stream0.setPresentationName("stream_"+name);
    }
  }
}
