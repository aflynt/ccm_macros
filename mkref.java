// STAR-CCM+ macro: mkref.java
// Written by STAR-CCM+ 14.02.012
//  make a bunch of points in r, theta, z
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class mkref extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    // reference part
    PointPart pp_ref = ((PointPart) simulation_0.getPartManager().getObject("p_r[+10]_t[000]"));
    Units u_ft  = ((Units) simulation_0.getUnitsManager().getObject("ft"));
    Units u_deg = ((Units) simulation_0.getUnitsManager().getObject("deg"));
    Units u_mm  = ((Units) simulation_0.getUnitsManager().getObject("mm"));

    double r0 = 0.0;
    double rmax = 20.0;
    double dr = 1.0;
    double r = r0;
    double tmax = 315.0;
    double dt   =  45.0;
    double t = 0.0;
    double z = 5.0
    int i, j;

    // Assumes cylindrical coordinates
    //// iterate over radius
    //for (i=0; r <= rmax ; i++){
    for ( i=0; i < 41 ; i++){
      r = r0 + i*dr;

      // iterate over theta
      //for (j=0; t < tmax +1.0 ; j++){
      for ( j=0; j < 1 ; j++){

        t = (j+1)*dt;

        String sn = "p_r[";
        String sr = String.format("%03.0f", r);
        String st = String.format("%03.0f", t);
        String name = sn + sr + "]_t[" + st + "]";

        System.out.println(name + " = " + r + "," + t);

        // make a new point
        PointPart pp     = simulation_0.getPartManager().createPointPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 0.0}));
        pp.copyProperties(pp_ref);
        pp.setPresentationName(name);
        pp.getPointCoordinate().setCoordinate(u_ft, u_deg, u_mm, new DoubleVector(new double[] { r, t, z}));
      }
    }
  }
}
