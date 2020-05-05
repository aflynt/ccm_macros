// STAR-CCM+ macro: postPP.java
// Written by STAR-CCM+ 15.02.007
package macro;

import java.util.*;

import java.nio.file.*;
import java.io.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class postPP extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation sim = getActiveSimulation();

    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    System.out.println("Current relative path is: " + s);
    String     pwd = s+"/";

    // export all the PLOTS
    for (StarPlot plot : sim.getPlotManager().getObjects()) {

       // get plot name
       String name = plot.getPresentationName() +".csv";
       plot.export(resolvePath(pwd+name), ",");
    }

    // save all the scenes
    for (Scene scene : sim.getSceneManager().getScenes()) {

      scene.open(true);
      String name = scene.getPresentationName() +".png";
      scene.printAndWait(resolvePath(pwd+name), 1, 1394, 501, true, false);
    }
  }
}
