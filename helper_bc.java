package helpers;

import java.util.*;
import java.io.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.energy.*;
import star.species.*;
import star.radiation.common.*;
import star.cadmodeler.*;
import star.meshing.*;

public class helper_bc {

  protected Simulation ss = null;

  public helper_bc(Simulation sim_arg){
    ss = sim_arg;
  }

  public void make_regions_from_parts(){

    Collection<GeometryPart> parts =  ss.get(SimulationPartManager.class).getParts();

    ss.getRegionManager().newRegionsFromParts( parts,"OneRegionPerPart",null,"OneBoundaryPerPartSurface",null,"OneFeatureCurve",null,RegionManager.CreateInterfaceMode.BOUNDARY,"OneEdgeBoundaryPerPart", null);

  }

  public void add_regions_to_mesh(){

    PartsMeshContinuum mesh = ((PartsMeshContinuum) ss.getContinuumManager().getContinuum("Parts Meshes"));

    Collection<Region> rs = ss.getRegionManager().getRegions();

    for (Region r : rs){
      r.setMeshContinuum(mesh);
    }

  }

  public void delete_interface_by_name(String iface_name){

    BoundaryInterface b1 = ((BoundaryInterface) ss.getInterfaceManager().getInterface(iface_name));

    b1.setResetOnRelativeMotion(false);
    b1.setCloseOnFixedSide(false);

    ss.getInterfaceManager().deleteInterfaces(b1);
  }

  public void check_physics(){
    //loop over PhysicsContinuum
    Collection<Object> ps = ss.getContinuumManager().getChildren();
    for (Object p : ps){
      Continuum c = (Continuum) p;
      
      String pname = c.getPresentationName();
      ss.println("* "+pname);
    }
  }

  private int get_region_number(String rname){

      // pre: name must start with a number
      // post: return number as int
      int n = 0;
      try {
        n = Integer.parseInt(rname.split("_")[0]);
      } catch (Exception e){ 
        ss.println("\t* region_number: "+rname+" : bad parse");
      }
      return n;
  }

  public void set_region_physics(String fname){

    Map<Integer,String> region_map = new HashMap<Integer, String>();

    try {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        StringBuilder content = new StringBuilder();
        String line;
        ArrayList<String> as = new ArrayList<String>();

        while ((line = br.readLine()) != null) {
          as.add(line);
        }

        for (String str : as){
          String[] str_list = str.strip().split("\\s+");
          int region_num  = Integer.parseInt(str_list[0].strip());
          String physics_name = str_list[1];
          //ss.println(String.format("%-20s",physics_name)+" w/ #: "+region_num);
          region_map.put(region_num, physics_name);
        }
        br.close();
    }
    catch (Exception e) {
        System.out.println("file not found!");
        ss.println("file not found");
    }

    Collection<Region> rs = ss.getRegionManager().getRegions();

    ArrayList<Region> ars = new ArrayList(rs);

    ars.sort( new Comparator<Region>(){

      @Override
      public int compare(Region left, Region right){
          String Lname = left.getPresentationName();
          String Rname = right.getPresentationName();
          //return Lname.compareTo(Rname);
          int nL = get_region_number(Lname);
          int nR = get_region_number(Rname);
          if (nL < nR){
            return -1;
          } else if ( nL == nR){
            return 0;
          } else {
            return 1;
          }
      }
    }
    );

    for (Region r : ars){

      String rname = r.getPresentationName();
      int n = get_region_number(rname);

      // lookup physics name in region_map
      String physics_name = region_map.get(n);

      // set region physics
      PhysicsContinuum pc = ((PhysicsContinuum) ss.getContinuumManager().getContinuum(physics_name));
      r.setPhysicsContinuum(pc);
      ss.println(String.format("Region %2d: %-20s %-20s", n, rname, physics_name));
    }
  }

  public ArrayList<Boundary> get_boundaries_by_number(int n){

    ArrayList<Boundary> blist = new ArrayList<Boundary>();

    // loop over regions
    Collection<Region> rs = ss.getRegionManager().getRegions();
    for (Region r : rs){

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      for (Boundary b: bs){
        int bnum = get_boundary_number(b.getPresentationName());
        if (n == bnum){
          blist.add(b);
        }
      }
    }

    return blist;
  }

  public int get_boundary_number(String bname){
    // input boundary name: #08_abcdef...
    // output returns: 8
    int n = 0;
    try {
       if (bname.contains("#")){
           String s = bname.split("_")[0].split("#")[1];
           n = Integer.parseInt(s);
       }
    } catch (Exception e){ 
      ss.println("\t* "+bname+": bad parse");
    }
    return n;
  }

  public void set_axis_boundary_type(){

    AxisBoundary bc_axis = ((AxisBoundary) ss.get(ConditionTypeManager.class).get(AxisBoundary.class));

    Collection<Region> rs = ss.getRegionManager().getRegions();

    // loop over regions
    for (Region r : rs){
      String rname = r.getPresentationName();

      Collection<Boundary> bs = r.getBoundaryManager().getBoundaries();

      // loop over boundaries
      for (Boundary b: bs){
        String bname = b.getPresentationName();
        if (bname.equals("centerline")) {
          b.setBoundaryType(bc_axis);
        } 
      }
    }
  }

  private void set_mdot(Boundary b,  double value, String units) {

    MassFlowRateProfile massFlowRateProfile_0 = b.getValues().get(MassFlowRateProfile.class);
    Units units_0 = ((Units) ss.getUnitsManager().getObject(units));
    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_0);
  }

  private void set_rad_temp(Boundary b,  double value, String units) {

    RadiationTemperatureProfile radiationTemperatureProfile_0 = b.getValues().get(RadiationTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    radiationTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);
  }

  private void set_tot_temp(Boundary b, double value, String units){

    TotalTemperatureProfile totalTemperatureProfile_0 = b.getValues().get(TotalTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    totalTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);
  }

  private void set_static_temp(Boundary b, double value, String units){
    StaticTemperatureProfile staticTemperatureProfile_0 = b.getValues().get(StaticTemperatureProfile.class);
    Units units_1 = ((Units) ss.getUnitsManager().getObject(units));
    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_1);

  }

  private void set_pressure(Boundary b, double value, String units){

    StaticPressureProfile staticPressureProfile_0 = b.getValues().get(StaticPressureProfile.class);
    Units units_2 = ((Units) ss.getUnitsManager().getObject(units));
    staticPressureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(value, units_2);
  }

  private void set_mdot_boundary(Boundary b, double mdot, String units_mdot, double temp, String units_temp){
    MassFlowBoundary bc_mdot = ((MassFlowBoundary) ss.get(ConditionTypeManager.class).get(MassFlowBoundary.class));
    b.setBoundaryType(bc_mdot);
    set_mdot(b, mdot, units_mdot);
    set_rad_temp(b, temp, units_temp);
    set_tot_temp(b, temp, units_temp);
  }

  private void set_pressure_boundary(Boundary b, double p, String units_p, double temp, String units_temp){
    PressureBoundary bc_pres = ((PressureBoundary) ss.get(ConditionTypeManager.class).get(PressureBoundary.class));
    b.setBoundaryType(bc_pres);
    set_pressure(b, p, units_p);
    set_rad_temp(b, temp, units_temp);
    set_static_temp(b, temp, units_temp);
  }

  private void set_temperature_boundary(Boundary b, double temp, String units) {

    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.TEMPERATURE);

    StaticTemperatureProfile stp = b.getValues().get(StaticTemperatureProfile.class);

    Units uu = ((Units) ss.getUnitsManager().getObject(units));

    stp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(temp, uu);
  }

  private void set_convective_boundary(Boundary b, double t_infinity, String units_temp, double h ) {
    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.CONVECTION);

    AmbientTemperatureProfile      atp = b.getValues().get(AmbientTemperatureProfile.class);
    HeatTransferCoefficientProfile htp = b.getValues().get(HeatTransferCoefficientProfile.class);

    Units uu_temp = ((Units) ss.getUnitsManager().getObject(units_temp));
    Units uu_h    = ((Units) ss.getUnitsManager().getObject("W/m^2-K"));  // hard coded units

    atp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(t_infinity, uu_temp);
    htp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(h, uu_h);
  }

  private void set_heat_flux_boundary(Boundary b, double val, String units){

    b.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.HEAT_FLUX);

    HeatFluxProfile hfp = b.getValues().get(HeatFluxProfile.class);

    Units uu = ((Units) ss.getUnitsManager().getObject(units));

    hfp.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(val, uu);

  }

  private void set_mole_fractions(Boundary b, DoubleVector dv){

    b.getConditions().get(SpeciesSpecificationOption.class).setSelected(SpeciesSpecificationOption.Type.MOLE_FRACTION);
    MoleFractionProfile mfp = b.getValues().get(MoleFractionProfile.class);

    mfp.getMethod(ConstantArrayProfileMethod.class).getQuantity().setArray(dv);

  }

  public void set_boundary_mole_fractions(int[] bc_nums, DoubleVector mole_fracs){

    // apply mole_fractions to boundary numbers in bc_nums

    ArrayList<Boundary> bs = new ArrayList<Boundary>();

    for (int bc_num : bc_nums){
      ArrayList<Boundary> bndry_list = get_boundaries_by_number(bc_num);
      bs.addAll(bndry_list);
    }

    for (Boundary b: bs){
        set_mole_fractions(b, mole_fracs);
    }
  }

  public void set_boundary_conditions(String fname){

    ArrayList<String> as = new ArrayList<String>();

    try {
        BufferedReader br = new BufferedReader(new FileReader(fname));
        String line;

        while ((line = br.readLine()) != null) {
          //ss.println("LINE: "+line);
          as.add(line);
        }
        br.close();
    }
    catch (Exception e) {
        System.out.println("bad parse of bc_file");
        ss.println("bad parse of bc_file");
    }

    try {

        for (String str : as){
          String[] str_list = str.strip().split("\\s+");
          String comment = "";
          String[] maybe_strlist = str.split("#");
          if (maybe_strlist.length > 1) {
            comment = maybe_strlist[1];
          }

          int bc_num  = Integer.parseInt(str_list[0].strip());
          String bc_type = str_list[1].strip();
          double p1_val  = Double.parseDouble(str_list[2].strip());
          String p1_units = str_list[3].strip();
          double p2_val  = Double.parseDouble(str_list[4].strip());
          String p2_units = str_list[5].strip();
          ss.print(String.format("# %2d: TYPE: %4s",bc_num, bc_type));
          ss.print(String.format(" values: %10.3f %5s %10.3f %5s", p1_val, p1_units, p2_val, p2_units));
          if (comment != ""){
            ss.println(" for bc: "+comment);
          } else {
            ss.print("\n");
          }

          ArrayList<Boundary> blist = get_boundaries_by_number(bc_num);
          for (Boundary b : blist){
            switch (bc_type) {
              case "mdot":        set_mdot_boundary(b, p1_val, p1_units, p2_val, p2_units); break;
              case "pres":    set_pressure_boundary(b, p1_val, p1_units, p2_val, p2_units); break;
              case "temp": set_temperature_boundary(b, p1_val, p1_units); break;
              case "conv":  set_convective_boundary(b, p1_val, p1_units, p2_val); break;
              case "flux":   set_heat_flux_boundary(b, p1_val, p1_units); break;
              default:
                break;
            }
          }
        }
    } catch (Exception e) {
        System.out.println("BC ERROR");
        ss.println("BC ERROR");
    }
  }
}


