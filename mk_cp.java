// STAR-CCM+ macro: mk_cp.java
// Written by STAR-CCM+ 14.02.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class mk_cp extends StarMacro {

  public void execute() { execute0();}

  private void execute0() {

    Simulation sim = getActiveSimulation();

    // units
    Units um = ((Units) sim.getUnitsManager().getObject("m"));
    Units uf = ((Units) sim.getUnitsManager().getObject("ft"));

    // reference plane to copy general settings
    ConstrainedPlaneSection rcp = ((ConstrainedPlaneSection) sim.getPartManager().getObject("cp_u_x[+00]")); //reference cp

    double r0 = 0.0;
    double rmax = 20.0;
    double dr = 1.0;
    double r = r0;
    int xmin = -12;
    int xmax = 12;
    double dx   =  1.0;
    double x = 0.0;
    int i, j;


    // iterate over x
    for ( i=-14; i < 12; i++){

      x = (i)*dx;

      // generate a string name based on position
      String sn = "cp_u_x[";
      String sx = String.format("%03.0f", x);
      String name = sn + sx + "]";

      System.out.println(name + " = " + x);


      // make a new constrained plane
      ConstrainedPlaneSection ncp = (ConstrainedPlaneSection) sim.getPartManager().createConstrainedPlaneImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {}), um);
      ncp.copyProperties(rcp);
      ncp.setReevaluateStatus(true);

      // rename the plane
      ncp.setPresentationName(name);

      // set the x coordinate
      ncp.getOriginCoordinate().setCoordinate(uf, uf, uf, new DoubleVector(new double[] {x, 0.0, 0.0}));
    }
  }
}
