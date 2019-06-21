// STAR-CCM+ macro: mk_moment_reports.java
// Written by STAR-CCM+ 14.02.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class mk_moment_reports extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation ss = getActiveSimulation();
    Region rr = ss.getRegionManager().getRegion("LTS");

    MomentReport mr_ref = ((MomentReport) ss.getReportManager().getReport("Mxx-REF"));

    Units uu = ((Units) ss.getUnitsManager().getObject("lbf-ft"));
    LabCoordinateSystem labcs = ss.getCoordinateSystemManager().getLabCoordinateSystem();
    CartesianCoordinateSystem cc = ((CartesianCoordinateSystem) labcs.getLocalCoordinateSystemManager().getObject("wrtDeck"));

    String s0 = "box_lower";
    String s1 = "box_upper";
    String s2 = "deck-lower";
    String s3 = "deck-upper";
    String s4 = "frame";
    String s5 = "hatch";
    String s6 = "pipe";
    String s7 = "tube";
    String dir = "X";
    String b  = "boundary";

    Boundary b0 = rr.getBoundaryManager().getBoundary(s0);
    Boundary b1 = rr.getBoundaryManager().getBoundary(s1);
    Boundary b2 = rr.getBoundaryManager().getBoundary(s2);
    Boundary b3 = rr.getBoundaryManager().getBoundary(s3);
    Boundary b4 = rr.getBoundaryManager().getBoundary(s4);
    Boundary b5 = rr.getBoundaryManager().getBoundary(s5);
    Boundary b6 = rr.getBoundaryManager().getBoundary(s6);
    Boundary b7 = rr.getBoundaryManager().getBoundary(s7);

    int i,j;
    for( i = 0; i < 9; i++) // loop boundaries
    {
      for( j = 0; j < 3; j++) // loop xyz
      {
        MomentReport mr_new = ss.getReportManager().createReport(MomentReport.class);
        mr_new.copyProperties(mr_ref);
        mr_new.setUnits(uu);
        mr_new.setCoordinateSystem(cc);

        switch(j)
        {
          case 0:
            dir = "xx";
            mr_new.getDirection().setComponents(1.0, 0.0, 0.0);
            break;

          case 1:
            dir = "yy";
            mr_new.getDirection().setComponents(0.0, 1.0, 0.0);
            break;

          case 2:
            dir = "zz";
            mr_new.getDirection().setComponents(0.0, 0.0, 1.0);
            break;
        }

        mr_new.getParts().setQuery(null);

        switch(i)
        {
          case 0: mr_new.getParts().setObjects(b0); b = s0; break;
          case 1: mr_new.getParts().setObjects(b1); b = s1; break;
          case 2: mr_new.getParts().setObjects(b2); b = s2; break;
          case 3: mr_new.getParts().setObjects(b3); b = s3; break;
          case 4: mr_new.getParts().setObjects(b4); b = s4; break;
          case 5: mr_new.getParts().setObjects(b5); b = s5; break;
          case 6: mr_new.getParts().setObjects(b6); b = s6; break;
          case 7: mr_new.getParts().setObjects(b7); b = s7; break;
          case 8: mr_new.getParts().setObjects(b0,
                      b1,
                      b2,
                      b3,
                      b4,
                      b5,
                      b6,
                      b7); b = "all"; break;
        }

        String name = "M"+dir+"_"+b;
        mr_new.setPresentationName(name);
      }
    }
  }
}
