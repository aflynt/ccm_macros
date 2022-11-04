// Simcenter STAR-CCM+ macro: get_sim_report.java
// Written by Simcenter STAR-CCM+ 16.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class get_sim_report extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    new star.common.SimulationFingerprintXmlReporter().report(getActiveSimulation(), resolvePath("/shared/loki/ARCHIVE_10TB_2/95957_Navy_TF/uvas/pencil/timing/done_pencil/sim_rep_0.xml"));
  }
}
