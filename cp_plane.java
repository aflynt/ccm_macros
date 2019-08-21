// STAR-CCM+ macro: cp_plane.java
// Written by STAR-CCM+ 14.02.012
/** Make many planes that touch a given streamline
 */
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.vis.*;

public class cp_plane extends StarMacro {

  public void execute() {
    make_me_some_planes();
  }

  private void make_me_some_planes() {
    int i, j, k;
    double x = 0.0;
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

        //System.out.println(name + " = " + y + "," + z);

        //String pn = "pyy";
        //String sn = "stream_p_y[+1875]_z[+3000]";
        String strm_n = "stream_"+name;
        String pn = "cp_"+strm_n;
        //double xpos = 15.0;
        //double xpos =  1127;
        //double xpos =  2175;
        //double xpos =  3223;
        //double xpos =  4271;
        //double xpos =  5319;
        //double xpos =  6367;
        //double xpos =  7415;
        //double xpos =  8463;
        //double xpos =  9511;
        //double xpos = 10559;
        //double xpos = 11607;
        //double xpos = 12655;
        //double xpos = 13703;
        double xpos = 14751;
        String sx = String.format("%+05.0f", xpos);

        // call my beautiful function
        mk_planes(pn+"_"+sx, strm_n, xpos/1000.0);
    }
  }

  void mk_planes(String plane_name, String stream_name, double xpos)
  {
    // need pxx as reference plane section
    Simulation sim = getActiveSimulation();
    Units u_m = ((Units) sim.getUnitsManager().getObject("m"));
    PlaneSection ps_cp = ((PlaneSection) sim.getPartManager().getObject("pxx"));
    MaxReport mrref = ((MaxReport) sim.getReportManager().getReport("p_ref"));
    NeoObjectVector nov = new NeoObjectVector(new Object[] {});
    DoubleVector dv001 = new DoubleVector(new double[] {0.0, 0.0, 1.0});
    DoubleVector dv000 = new DoubleVector(new double[] {0.0, 0.0, 0.0});
    DoubleVector dv0   = new DoubleVector(new double[] {0.0});

    PlaneSection ps_new = (PlaneSection) sim.getPartManager().createImplicitPart(nov, dv001, dv000, 0, 1, dv0);

    // copy props from ref ps
    ps_new.copyProperties(ps_cp);

    // change position
    ps_new.getOriginCoordinate().setCoordinate(u_m, u_m, u_m, new DoubleVector(new double[] {xpos, 0.0, 5.0}));
    ps_new.getInputParts().setQuery(null);

    // set streamline to intersect
    StreamPart stream = ((StreamPart) sim.getPartManager().getObject(stream_name));
    ps_new.getInputParts().setObjects(stream);

    // set the name
    ps_new.setPresentationName(plane_name);

    // make a report for each plane while we're at it
    MaxReport mr = sim.getReportManager().createReport(MaxReport.class);
    mr.copyProperties(mrref);
    mr.setPresentationName(plane_name);
    mr.getParts().setQuery(null);
    mr.getParts().setObjects(ps_new);
    //System.out.println(plane_name);
  }
}
