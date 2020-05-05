// STAR-CCM+ macro: get_area.java
// Written by STAR-CCM+ 15.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

//import java.io.File;
//import java.io.IOException;
import java.io.*;

public class get_area extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    String pwd = "/raid/linux4/flyntga/96045_AMES_CTS/cts/WT_FULL/wide_hsd/wide_parent/wide_parent_post/";
    String fname = "area.csv";

    Simulation ss = getActiveSimulation();
    ConstrainedPlaneSection cp = ((ConstrainedPlaneSection) ss.getPartManager().getObject("area_plane"));
    Units uu = ((Units) ss.getUnitsManager().getObject("in"));
    XyzInternalTable table = ((XyzInternalTable) ss.getTableManager().getTable("area_table"));

    for(int xpos = 1; xpos <= 264; ++xpos)
    {
      // move the plane
      cp.getOriginCoordinate().setCoordinate(uu, uu, uu, new DoubleVector(new double[] {(double) xpos, 0.0, 0.0}));

      // export table data
      table.extract();
      table.export(pwd+fname, ",");

      // rw_data
      rw_data(pwd, fname);
    }
  }

  void rw_data(String pwd, String fname)
  {
    try {
        // read in data 
        BufferedReader br = new BufferedReader(new FileReader(pwd+fname));
        String header = br.readLine();
        String data   = br.readLine();

        // write data
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt", true));
        out.write(data);
        out.write('\n');
        out.close();

        br.close();
    }
    catch (Exception e) {
        System.out.println("file not found!");
        //sim.println("file not found!");
    }
  }
}
