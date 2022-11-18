// Simcenter STAR-CCM+ macro: set_wagner.java
// Written by Simcenter STAR-CCM+ 17.04.007
package macro;

import java.util.*;

import star.common.*;
import star.material.*;
import star.flow.*;
import star.energy.*;
import star.lagrangian.*;

public class set_wagner extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("g__gas_exhaust"));

    LagrangianMultiphaseModel lagrangianMultiphaseModel_0 = 
      physicsContinuum_0.getModelManager().getModel(LagrangianMultiphaseModel.class);

    LagrangianPhase lagrangianPhase_0 = 
      ((LagrangianPhase) lagrangianMultiphaseModel_0.getPhaseManager().getPhase("droplets"));

    SingleComponentDropletModel singleComponentDropletModel_0 = 
      lagrangianPhase_0.getModelManager().getModel(SingleComponentDropletModel.class);

    SingleComponentDropletMaterial singleComponentDropletMaterial_0 = 
      ((SingleComponentDropletMaterial) singleComponentDropletModel_0.getMaterial());

    singleComponentDropletMaterial_0.getMaterialProperties().getMaterialProperty(SaturationPressureProperty.class).setMethod(WagnerSaturationPressureMethod.class);
  }
}
