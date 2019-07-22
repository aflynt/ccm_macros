// STAR-CCM+ macro: mod_cad.java
// Written by STAR-CCM+ 14.02.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.cadmodeler.*;

public class mod_cad extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation sim = getActiveSimulation();
    Units uu1 = sim.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    Units uu2 = sim.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    // get my global variables ga = global angle
    ScalarGlobalParameter ga1 = ((ScalarGlobalParameter) sim.get(GlobalParameterManager.class).getObject("ga1"));

    // set it to angle
    ga1.getQuantity().setValue(-35.0);





    // start working with cad modeler
    CadModel cm = ((CadModel) sim.get(SolidModelManager.class).getObject("3D-CAD Model 1"));

    // edit cad model
    sim.get(SolidModelManager.class).editCadModel(cm);



    // get sketch 1
    Sketch sk = ((Sketch) cm.getFeature("Sketch 1"));
    cm.getFeatureManager().rollBack(sk);
    cm.getFeatureManager().startSketchEdit(sk);

    // get spline
    SplineSketchPrimitive spline = ((SplineSketchPrimitive) sk.getSketchPrimitive("Spline 1"));


    // edit the spline tangency
    //                  (spline, pt_idx, tan_angle, { tan_mag_bck, tan_mag_fwd } )
    sk.editSplineTangent(spline, 1, -55, new DoubleVector(new double[] {1.0, 1.0}));
    sk.editSplineTangent(spline, 2, -20, new DoubleVector(new double[] {1.5, 1.5}));
    sk.editSplineTangent(spline, 3,  25,  new DoubleVector(new double[] {2.0, 2.0}));


    sk.markFeatureForEdit();
    cm.getFeatureManager().stopSketchEdit(sk, false);
    cm.getFeatureManager().markDependentNotUptodate(sk);
    cm.getFeatureManager().rollForwardToEnd();
    cm.update();
    sim.get(SolidModelManager.class).endEditCadModel(cm);
  }

}
