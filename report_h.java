// Simcenter STAR-CCM+ macro: report_h.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.energy.*;

public class report_h extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation ss = getActiveSimulation();
    HtcFunction hfun = ((HtcFunction) ss.getFieldFunctionManager().getFunction("HeatTransferCoefficient"));
    Units uu_K = ((Units) ss.getUnitsManager().getObject("K"));
    Units uu_F = ((Units) ss.getUnitsManager().getObject("F"));

    Double[] Ts = {
       //351.9,
       //339.9,
       //322.0,
       //347.5,
       //322.0,
       //353.2,
       356.4
    };

    //Double[] Ts = {
    //   285.0,
    //   286.0,
    //   287.0,
    //   288.0,
    //   289.0,
    //   290.0,
    //};

    String[] bs = {
      //"#08_combustor_casing",
      //"4_INSULATION"        ,
      //"4_INSULATION 1"      ,
      //"4_INSULATION 2"      ,
      //"6_FLOW_LINER"        ,
      //"8_TFL"               ,
      "9_DS_BULKHEAD"
    };


//    for (double T_inf : Ts) {
    for (int i = 0; i < Ts.length; ++i){
      double T_inf = Ts[i];

      //hfun.getReferenceTemperature().setValueAndUnits(T_inf, uu_F);
      hfun.getReferenceTemperature().setValueAndUnits(T_inf, uu_K);

      AreaAverageReport rep = ((AreaAverageReport) ss.getReportManager().getReport("sa_h"));

      ss.println(i+" | " + String.format("%20s",bs[i]) + " | TINF | " + T_inf);
      //ss.println(i+" | " + String.format("%20s","TFL") + " | TINF | " + T_inf);
      rep.printReport();
    }
  }
}
