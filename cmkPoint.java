// STAR-CCM+ macro: mkPoint.java
// Written by STAR-CCM+ 14.02.012
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class cmkPoint extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation sim = getActiveSimulation();
    Units uu = sim.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    LabCoordinateSystem lcs = sim.getCoordinateSystemManager().getLabCoordinateSystem();
    Region rr = sim.getRegionManager().getRegion("Body 1");


    Circle1 c1 = new Circle1(25);
    Circle1 c2 = new Circle1(50);
    System.out.println("circle area = " + c1.getArea());
    System.out.println("circle area = " + c2.getArea());


    double x1 = 0.9;
    double x2 = 0.2;

    double x = max(x1, x2);


    // make new point
    PointPart pointPart_0 = sim.getPartManager().createPointPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] { x, 0.0, 0.0}));


    pointPart_0.getPointCoordinate().setCoordinateSystem(lcs);
    pointPart_0.getPointCoordinate().setUnits0(uu);
    pointPart_0.getPointCoordinate().setUnits1(uu);
    pointPart_0.getPointCoordinate().setUnits2(uu);

    pointPart_0.getPointCoordinate().setDefinition("");
    pointPart_0.getInputParts().setQuery(null);


    pointPart_0.getInputParts().setObjects(rr);
    System.out.println("setting x = " + x);
  }

  // test Function in class
  public static double max(double num1, double num2) {
    double result;

    if (num1 > num2)
      result = num1;
    else
      result = num2;

    return result;
  }

}

// test class outside of macro class
class Circle1 {
  double radius;

  Circle1() {
    radius = 1.0;
  }

  Circle1(double newRadius) {
    radius = newRadius;
  }

  double getArea(){
    return radius * radius * Math.PI;
  }
}
