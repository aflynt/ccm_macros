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
    MaxReport mrref = ((MaxReport) sim.getReportManager().getReport("p_r[000]_t[000]"));

    double r0 = 0.0;
    double rmax = 20.0;
    double dr = 1.0;
    double r = r0;
    double tmax = 315.0;
    double dt   =  45.0;
    double t = 0.0;
    int i, j;

    for ( i=0; i < 41 ; i++){
      r = r0 + i*dr;

      //for (j=0; t < tmax +1.0 ; j++){
      for ( j=0; j < 1 ; j++){

        t = (j+1)*dt;

        String sn = "p_r[";
        String sr = String.format("%03.0f", r);
        String st = String.format("%03.0f", t);
        String name = sn + sr + "]_t[" + st + "]";

        System.out.println(name + " = " + r + "," + t);

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
