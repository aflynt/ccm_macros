// Simcenter STAR-CCM+ macro: get_emissivities.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.radiation.common.*;

public class get_emissivities extends StarMacro {
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

//sr1 , e_inconel |c0|
sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_INLET]"
sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_SPOOL]"
sr1 , e_inconel , "Default [1_CENTER_DUCT/5_DUCT_CONTRACTION]"
sr2 , e_inconel , "w_m_1 [2_ANNULAR_DUCT/5_DUCT_INLET]"
sr2 , e_inconel , "w_m_2 [2_ANNULAR_DUCT/5_DUCT_SPOOL 2]"
sr2 , e_inconel , "w_m_3 [2_ANNULAR_DUCT/5_DUCT_SPOOL]"
sr2 , e_inconel , "w_m_4 [2_ANNULAR_DUCT/5_DUCT_CONTRACTION 2]"
sr2 , e_inconel , "w_m_5 [2_ANNULAR_DUCT/5_DUCT_CONTRACTION]"
sr2 , e_inconel , "FL [2_ANNULAR_DUCT/7_REAR_ADAPTER]"
sr2 , e_inconel , "FU [2_ANNULAR_DUCT/7_REAR_ADAPTER 2]"
sr2 , e_kaowool , "w_ins_contraction [2_ANNULAR_DUCT/4_INSULATION]"
sr2 , e_kaowool , "w_ins_spool [2_ANNULAR_DUCT/4_INSULATION 2]"
sr2 , e_kaowool , "w_ins_us [2_ANNULAR_DUCT/4_INSULATION 3]"
sr3 , e_inconel , "RL [3_EXHAUST_DUCT/7_REAR_ADAPTER]"
sr3 , e_inconel , "RU [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"
sr3 , e_ysz     , "w_SHD_ID [13_SHIELD_COATING/3_EXHAUST_DUCT]"
sr3 , e_inconel , "w_SHD_DS [13_SHIELD_COATING/3_EXHAUST_DUCT 2]"
sr3 , e_inconel , "w_SHD_DS [12_SHIELD_METAL/3_EXHAUST_DUCT]"
sr3 , e_inconel , "w_SHD_OD [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"
sr4 , e_inconel , "RU [14_SPRAY/7_REAR_ADAPTER]"

      trip_list.add(new Trip<String, Double, String>("1_CENTER_DUCT" , 0.71, "Default [1_CENTER_DUCT/5_DUCT_SPOOL]"          ));
      trip_list.add(new Trip<String, Double, String>("1_CENTER_DUCT" , 0.71, "Default [1_CENTER_DUCT/5_DUCT_INLET]"          ));
      trip_list.add(new Trip<String, Double, String>("1_CENTER_DUCT" , 0.71, "Default [1_CENTER_DUCT/5_DUCT_CONTRACTION]"    ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.71, "Default [2_ANNULAR_DUCT/5_DUCT_SPOOL]"         ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.71, "Default [2_ANNULAR_DUCT/5_DUCT_INLET]"         ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.60, "Default [2_ANNULAR_DUCT/4_INSULATION]"         ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.60, "Default [2_ANNULAR_DUCT/4_INSULATION 1]"       ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.60, "Default [2_ANNULAR_DUCT/4_INSULATION 2]"       ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT", 0.71, "Default [2_ANNULAR_DUCT/5_DUCT_CONTRACTION]"   ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "r5 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER]"            ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "f3 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER 2]"          ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "f2 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER 3]"          ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "f1 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER 4]"          ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "r6 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER 5]"          ));
      trip_list.add(new Trip<String, Double, String>("2_ANNULAR_DUCT 2", 0.71, "f4 [2_ANNULAR_DUCT 2/7_REAR_ADAPTER 6]"          ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e7 [3_EXHAUST_DUCT/7_REAR_ADAPTER]"            ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e1 [3_EXHAUST_DUCT/7_REAR_ADAPTER 2]"          ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e8 [3_EXHAUST_DUCT/7_REAR_ADAPTER 3]"          ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e2 [3_EXHAUST_DUCT/7_REAR_ADAPTER 4]"          ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e9 [3_EXHAUST_DUCT/7_REAR_ADAPTER 5]"          ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "e1 [12_SHIELD_METAL/3_EXHAUST_DUCT]"           ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "od_1 [12_SHIELD_METAL/3_EXHAUST_DUCT 2]"       ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.60, "e1 [13_SHIELD_COATING/3_EXHAUST_DUCT]"         ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.60, "id_face [13_SHIELD_COATING/3_EXHAUST_DUCT 2]"  ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "w1 [11_DUCT_EXHAUST/3_EXHAUST_DUCT]"           ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "w2 [11_DUCT_EXHAUST/3_EXHAUST_DUCT 2]"         ));
      trip_list.add(new Trip<String, Double, String>("3_EXHAUST_DUCT", 0.71, "w0 [11_DUCT_EXHAUST/3_EXHAUST_DUCT 3]"         ));
      trip_list.add(new Trip<String, Double, String>("14_SPRAY"      , 0.71, "e6 [14_SPRAY/7_REAR_ADAPTER]"                  ));


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

    check_emissivities(true);
    //check_props(); // checks boundary type
    set_emissivities();
  }
}
