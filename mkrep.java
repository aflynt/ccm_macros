// STAR-CCM+ macro: mkrep.java
// Written by STAR-CCM+ 14.02.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.vis.*;

public class mkrep extends StarMacro {

  public void execute() { execute0(); }

  private void execute0() {

    Simulation sim = getActiveSimulation();
    MaxReport mrref = ((MaxReport) sim.getReportManager().getReport("p_ref"));

    int i, j, k;
    double z = 0.0;
    double zref = 0.002 - 0.6096;

    // iterate over X
    for ( i=-14; i < 12 ; ++i)
    {
      double x = i*(1.0);

      // iterate over Y
      for ( j=-11; j < 12 ; ++j)
      {
        double y = j*(1.0);

        String sn = "dp_x[";
        String sx = String.format("%03.0f", x);
        String sy = String.format("%03.0f", y);
        String name = sn + sx + "]_y[" + sy + "]";

        System.out.println(name + " = " + x + "," + y);

        MaxReport mr = sim.getReportManager().createReport(MaxReport.class);

        mr.copyProperties(mrref);
        mr.setPresentationName(name);
        mr.getParts().setQuery(null);
        PointPart pp = ((PointPart) sim.getPartManager().getObject(name));
        mr.getParts().setObjects(pp);
      }
    }
  }
}

/*
    double r0 = 0.0;
    double rmax = 20.0;
    double dr = 1.0;
    double r = r0;
    double tmax = 315.0;
    double dt   =  45.0;
    double t = 0.0;
    int i, j;

    for ( i=0; i < 41 ; i++)
    {
      r = r0 + i*dr;

      for ( j=0; j < 1 ; j++)
      {
        t = (j+1)*dt;

        String sn = "p_r[";
        String sr = String.format("%03.0f", r);
        String st = String.format("%03.0f", t);
        String name = sn + sr + "]_t[" + st + "]";

        System.out.println(name + " = " + r + "," + t);

        */
