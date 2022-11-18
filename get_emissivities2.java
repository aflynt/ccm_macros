// Simcenter STAR-CCM+ macro: get_emissivities.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.radiation.common.*;

public class get_emissivities2 extends StarMacro {
  Simulation ss;
  Units uu;

  public class Trip<T, U, V> {
    private final T first;
    private final U second;
    private final V third;

    public Trip(T first, U second, V third) {
      this.first  = first;
      this.second = second;
      this.third  = third;
    }

    public T get_1() { return first;}
    public U get_2() { return second;}
    public V get_3() { return third;}

  }


  private void set_emissivities(){

      ArrayList<Trip<String, Double, String>> trip_list = new ArrayList<Trip<String, Double, String>>();

      double e_inconel = 0.71;
      double e_kaowool = 0.60;
      double e_ysz     = 0.61;
      String sr1 = "1_CENTER_DUCT";
      String sr2 = "2_ANNULAR_DUCT";
      String sr3 = "3_EXHAUST_DUCT";
      String sr4 = "14_SPRAY";

      trip_list.add(new Trip<String, Double, String>(sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_INLET]"  ));
      trip_list.add(new Trip<String, Double, String>(sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_SPOOL]"  ));
      trip_list.add(new Trip<String, Double, String>(sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_CONTRACTION]"  ));

      trip_list.add(new Trip<String, Double, String>(sr2 , e_inconel , "Default [2_ANNULAR_DUCT/5_DUCT_INLET]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_inconel , "Default [2_ANNULAR_DUCT/5_DUCT_SPOOL]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_inconel , "Default [2_ANNULAR_DUCT/5_DUCT_CONTRACTION]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_inconel , "FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_inconel , "FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_kaowool , "Default [2_ANNULAR_DUCT/4_INSULATION_CONTRACTION]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_kaowool , "Default [2_ANNULAR_DUCT/4_INSULATION_SPOOL]"));
      trip_list.add(new Trip<String, Double, String>(sr2 , e_kaowool , "Default [2_ANNULAR_DUCT/4_INSULATION_INLET]"));

      trip_list.add(new Trip<String, Double, String>(sr3 , e_inconel , "RU [3_EXHAUST_DUCT/7_REAR_ADAPTER]"));
      trip_list.add(new Trip<String, Double, String>(sr3 , e_inconel , "RL [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"));
      trip_list.add(new Trip<String, Double, String>(sr3 , e_ysz     , "SHD_ID [13_SHIELD_COATING/3_EXHAUST_DUCT]"));
      trip_list.add(new Trip<String, Double, String>(sr3 , e_ysz     , "SHD_END [13_SHIELD_COATING/3_EXHAUST_DUCT 2]"));
      trip_list.add(new Trip<String, Double, String>(sr3 , e_inconel , "SHD_END [12_SHIELD_METAL/3_EXHAUST_DUCT]"));
      trip_list.add(new Trip<String, Double, String>(sr3 , e_inconel , "SHD_OD [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"));

      trip_list.add(new Trip<String, Double, String>(sr4 , e_inconel , "RU [14_SPRAY/7_REAR_ADAPTER]"  ));

      for (var t : trip_list) {

        String rname = t.get_1();
        double val   = t.get_2();
        String bname = t.get_3();

        try {
          Region   r = ss.getRegionManager().getRegion(rname);
          Boundary b = r.getBoundaryManager().getBoundary(bname);

          EmissivityProfile ep = b.getValues().get(EmissivityProfile.class);

          ep.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(val, uu);

          ss.println("SETTING EMISSIVITY:" + String.format("%6.3f R,B=", val) + String.format("%20s",rname) + " , " + String.format("%20s",bname));
        } catch (Exception e) {
          ss.println("bad parse for region, bndry:" + rname + " " + bname);
        }

      }

  }

  private void check_emissivities(boolean showall){

    String em_str = "";
    Double d = 0.0;
    Collection<Region> rs = ss.getRegionManager().getRegions();
    for (Region r : rs){
      String rname = r.getPresentationName();

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      for (Boundary b: bs){
        String bname = b.getPresentationName();

        try {

          EmissivityProfile ep = b.getValues().get(EmissivityProfile.class);
          em_str = ep.getMethod(ConstantScalarProfileMethod.class).getQuantity().getDefinition();
          d = Double.parseDouble(em_str.strip());

          if (showall){
              ss.println(String.format("%-20s | %12.3f |%s|", rname, d, bname));
          } else {
              if ( !(Math.abs(d - 0.8)  <  1.0e-4) ) {
                  ss.println(String.format("%-20s | %12.3f |%s|", rname, d, bname));
              }
          }
        } catch (Exception e) {
        }
      }
    }
  }

  private void check_props(){

    String em_str = "";
    Double d = 0.0;

    Collection<Region> rs = ss.getRegionManager().getRegions();
    for (Region r : rs){
      String rname = r.getPresentationName();

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      for (Boundary b: bs){
        String bname = b.getPresentationName();

        try {

          BoundaryType bt = b.getBoundaryType();

          String bt_str = bt.toString();

          
          ss.println(String.format("%-20s | %-40s | %s", rname, bname, bt_str));

        } catch (Exception e) {
        }
      }
    }
  }

  public void execute() {
    execute0();
  }

  private void execute0() {

    ss = getActiveSimulation();
    uu = ((Units) ss.getUnitsManager().getObject(""));

    //check_props(); // checks boundary type

    //check_emissivities(true);
    set_emissivities();
  }
}
