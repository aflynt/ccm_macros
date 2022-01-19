// Simcenter STAR-CCM+ macro: mk_forceReport.java
// Written by Simcenter STAR-CCM+ 16.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class mk_forceReport extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation ss = getActiveSimulation();
    Region rr = ss.getRegionManager().getRegion("Region");
    ForceCoefficientReport fcref = ((ForceCoefficientReport) ss.getReportManager().getReport("Cx"));


    Boundary f_1 = rr.getBoundaryManager().getBoundary("Subtract.front_1");
    Boundary f_2 = rr.getBoundaryManager().getBoundary("Subtract.front_2");
    Boundary f_3 = rr.getBoundaryManager().getBoundary("Subtract.front_3");
    Boundary f_4 = rr.getBoundaryManager().getBoundary("Subtract.front_4");
    Boundary f_5 = rr.getBoundaryManager().getBoundary("Subtract.front_5");
    Boundary f_6 = rr.getBoundaryManager().getBoundary("Subtract.front_6");
    Boundary f_7 = rr.getBoundaryManager().getBoundary("Subtract.front_7");
    Boundary b_1 = rr.getBoundaryManager().getBoundary("Subtract.front_8");
    Boundary b_2 = rr.getBoundaryManager().getBoundary("Subtract.rear_1");
    Boundary b_3 = rr.getBoundaryManager().getBoundary("Subtract.rear_2");
    Boundary b_4 = rr.getBoundaryManager().getBoundary("Subtract.rear_3");
    Boundary b_5 = rr.getBoundaryManager().getBoundary("Subtract.rear_4");
    Boundary b_6 = rr.getBoundaryManager().getBoundary("Subtract.rear_5");
    Boundary b_7 = rr.getBoundaryManager().getBoundary("Subtract.rear_6");
    Boundary b_8 = rr.getBoundaryManager().getBoundary("Subtract.rear_7");

    mk_ff( ss, rr, fcref,  "cx_f1",  f_1 );
    mk_ff( ss, rr, fcref,  "cx_f2",  f_2 );
    mk_ff( ss, rr, fcref,  "cx_f3",  f_3 );
    mk_ff( ss, rr, fcref,  "cx_f4",  f_4 );
    mk_ff( ss, rr, fcref,  "cx_f5",  f_5 );
    mk_ff( ss, rr, fcref,  "cx_f6",  f_6 );
    mk_ff( ss, rr, fcref,  "cx_f7",  f_7 );
    mk_ff( ss, rr, fcref,  "cx_b1",  b_1 );
    mk_ff( ss, rr, fcref,  "cx_b2",  b_2 );
    mk_ff( ss, rr, fcref,  "cx_b3",  b_3 );
    mk_ff( ss, rr, fcref,  "cx_b4",  b_4 );
    mk_ff( ss, rr, fcref,  "cx_b5",  b_5 );
    mk_ff( ss, rr, fcref,  "cx_b6",  b_6 );
    mk_ff( ss, rr, fcref,  "cx_b7",  b_7 );
    mk_ff( ss, rr, fcref,  "cx_b8",  b_8 );


  }

  private void mk_ff( Simulation ss, Region rr, ForceCoefficientReport fcref,  String ff_name, Boundary b){


    ForceCoefficientReport fcnew = ss.getReportManager().createReport(ForceCoefficientReport.class);

    fcnew.copyProperties(fcref);

    fcnew.setPresentationName(ff_name);

    fcnew.getParts().setQuery(null);

    fcnew.getParts().setObjects(b);
  }
}
