
package macro;

import star.common.*;
import java.util.*;
import star.base.neo.*;
import helpers.*;

public class jm extends StarMacro {

  @Override
  public void execute() {

    Simulation ss = getActiveSimulation();

    helper_bc hbc = new helper_bc(ss);
    //hbc.check_physics();
    hbc.make_regions_from_parts();
    hbc.add_regions_to_mesh();

    String iface_name = "2_ANNULAR_DUCT/9_DS_BULKHEAD 2";
    //String iface_name = "DELETE";
    hbc.delete_interface_by_name(iface_name);

    String pwd = "/shared/thor/home/flyntga/git/ccm_macros/";
    String fname_regions    = pwd+"regions.txt";
    String fname_boundaries = pwd+"boundaries.txt";

    hbc.set_region_physics(fname_regions);
    hbc.set_axis_boundary_type();
    hbc.set_boundary_conditions(fname_boundaries);

    int[] bc_nums = new int[] {4, 7};
    DoubleVector mole_fracs = new DoubleVector(new double[] {0.0089, 0.00151, 0.09734, 0.04819, 0.00893, 3.1E-4, 0.73761, 0.00312, 2.5E-4, 4.0E-5, 1.0E-5, 0.09379});
    hbc.set_boundary_mole_fractions(bc_nums, mole_fracs);


    //Map<String, Vector3> map_nc = new HashMap<String,Vector3>();
    ////               NAME                CENTROID x      y        z
    //map_nc.put("2_center_inlet"  , new Vector3(-7.0104,0.22225,0.0127));
    //map_nc.put("3_annular_inlet" , new Vector3(-7.0104,0.51991,0.0127));
    //map_nc.put("4_exhaust_inlet" , new Vector3( 3.0157,0.29655,0.0127));
    //map_nc.put("5_center_exit"   , new Vector3( 2.1232,0.26894,0.0127));
    //map_nc.put("6_annular_exit"  , new Vector3( 3.5655,0.91600,0.0127));
    //map_nc.put("7_exhaust_exit"  , new Vector3( 9.2456,0.45720,0.0127));

    //helper_cad hcad = new helper_cad(ss, "cm1");
    //hcad.name_cap_faces();
    //hcad.name_map_faces(map_nc);


  }
}

