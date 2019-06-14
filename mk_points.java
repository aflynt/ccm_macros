// STAR-CCM+ macro: mk_points.java
// Written by STAR-CCM+ 14.02.012
//  make a bunch of points in x, y, z
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class mk_points extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    // reference part
    PointPart pp_ref = ((PointPart) simulation_0.getPartManager().getObject("point-ref"));
    Units u_ft  = ((Units) simulation_0.getUnitsManager().getObject("ft"));
    Units u_deg = ((Units) simulation_0.getUnitsManager().getObject("deg"));
    Units u_m   = ((Units) simulation_0.getUnitsManager().getObject("m"));


    int i, j, k;
    double z = 0.0
    double zref = 0.002 - 0.6096;

    // Assumes cylindrical coordinates
    //// iterate over X
    for ( i=-14; i < 12 ; ++i){
      double x = i*(1.0);

      // iterate over Y
      for ( j=-11; j < 12 ; ++j){
        double y = j*(1.0);

        String sn = "p_x[";
        String sx = String.format("%03.0f", x);
        String sy = String.format("%03.0f", y);
        String name = sn + sx + "]_y[" + sy + "]";

        System.out.println(name + " = " + x + "," + y);

        // make a new point
        PointPart pp     = simulation_0.getPartManager().createPointPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}));
        pp.copyProperties(pp_ref);
        pp.setPresentationName(name);


        switch(j) {  // specify z based on y
          case -11:  z = -1.36834   + zref; break;
          case -10:  z = -1.05048   + zref; break;
          case  -9:  z = -0.73262   + zref; break;
          case  -8:  z = -0.414762  + zref; break;
          case  -7:  z = -0.0969046 + zref; break;
          case  -6:  z =  0.220668  + zref; break;
          case  -5:  z =  0.452312  + zref; break;
          case  -4:  z =  0.572373  + zref; break;
          case  -3:  z =  0.609165  + zref; break;
          case  -2:  z =  0.6096    + zref; break;
          case  -1:  z =  0.6096    + zref; break;
          case   0:  z =  0.6096    + zref; break;
          case  11:  z = -1.36834   + zref; break;
          case  10:  z = -1.05048   + zref; break;
          case   9:  z = -0.73262   + zref; break;
          case   8:  z = -0.414762  + zref; break;
          case   7:  z = -0.0969046 + zref; break;
          case   6:  z =  0.220668  + zref; break;
          case   5:  z =  0.452312  + zref; break;
          case   4:  z =  0.572373  + zref; break;
          case   3:  z =  0.609165  + zref; break;
          case   2:  z =  0.6096    + zref; break;
          case   1:  z =  0.6096    + zref; break;
          default :  z =  0.0;
        }

        pp.getPointCoordinate().setCoordinate(u_ft, u_ft, u_m, new DoubleVector(new double[] { x, y, z}));
      }
    }
  }
}
