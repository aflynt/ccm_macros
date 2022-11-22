package helpers;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.cadmodeler.*;

public class helper_cad {

  protected Simulation ss = null;
  protected CadModel cadModel_0 = null;

  public helper_cad(Simulation sim_arg, String cad_model_name){
    ss = sim_arg;
    cadModel_0 = ((CadModel) ss.get(SolidModelManager.class).getObject(cad_model_name));
  }

  public void name_cap_faces(){

    BodyManager bm = cadModel_0.getBodyManager();

    Collection<Body> bs = bm.getBodies();

    for (Body b : bs){
      name_junk_faces(b);
    }
  }
  public Boolean rename_face_at_pos(Vector3 pos, String face_name){

    return rename_face_at_centroid(pos.x, pos.y, pos.z, face_name);
  }

  public Boolean rename_face_at_centroid(double cx, double cy, double cz, String face_name) {

    Vector3 p_target = new Vector3(cx, cy, cz);

    Face f = find_face_at_centroid(p_target);
    if (f != null) {
        f.setNameAttribute(face_name);
        FaceManager fm = f.getManager();
        fm.hideFaces(new Vector<Face>(Arrays.asList(f)));
        return true;
    } else {
        return false;
    }
  }

  public void name_map_faces(Map<String, Vector3> map_nc){

    for(Map.Entry<String,Vector3> e : map_nc.entrySet()){
      String  name     = e.getKey();
      Vector3 centroid = e.getValue();
      double px = centroid.x;
      double py = centroid.y;

      Boolean found = rename_face_at_pos(centroid, name);
      ss.println(String.format("%20s : <%10.3f, %10.3f> : %b",name, px, py, found));
    }
  }

  private Face find_face_at_centroid(Vector3 p_target){

    BodyManager bm = cadModel_0.getBodyManager();

    Collection<Body> bs = bm.getBodies();

    for (Body b : bs){
      FaceManager fm = b.getFaceManager();
      Collection<Face> faces = fm.getFaces();

      //String bname = b.getPresentationName();

      for (Face f : faces){
        Vector3 p_centroid = new Vector3();
        Vector3 plane_normal = new Vector3();
        f.getFaceNormalAndCentroid(p_centroid, plane_normal);


        double ds = p_centroid.getL2Distance(p_target);
        //String sx = String.format("%10.3f",p_centroid.x);
        //String sy = String.format("%10.3f",p_centroid.y);
        //String rep_c = "<"+sx+","+sy+">";
        //String fname = f.getPresentationName();
        //ss.println("\tds:"+String.format("%10.3f", ds)+" for face: "+fname+" pc="+rep_c);
        if (Math.abs(ds) < 1.0e-3 ){
            return f;
        }
      }
    }
    Face bad_face = null;
    return bad_face;
  }

  private void name_junk_faces(Body b){

    String name  = "w";
    String s_sym  = "sym";
    String s_junk = "junk";

    FaceManager fm = b.getFaceManager();
    Collection<Face> faces = fm.getFaces();
    Vector<Face> faces_to_hide = new Vector();

    for (Face f : faces){

      Boolean hit = false;

      // retrieve face normals
      Vector3 centroid = new Vector3();
      Vector3 plane_normal = new Vector3();
      f.getFaceNormalAndCentroid(centroid, plane_normal);

      //Int nx = (Int) plane_normal.x;
      //Int ny = (Int) plane_normal.y;
      int nz = (int) plane_normal.z;

      if      ( nz == 1 ) { name = s_junk; hit = true; }
      else if ( nz ==-1 ) { name = s_sym;  hit = true; }
      
      if (hit){
        f.setNameAttribute(name);
        faces_to_hide.add(f);
      }
    }
    fm.hideFaces(faces_to_hide);
  }
    
}
