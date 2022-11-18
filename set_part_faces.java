// Simcenter STAR-CCM+ macro: set_part_faces.java
// Written by Simcenter STAR-CCM+ 17.06.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.cadmodeler.*;

public class set_part_faces extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation ss = getActiveSimulation();

    CadModel cm = ((CadModel) ss.get(SolidModelManager.class).getObject("3D-CAD Model 2"));

    star.cadmodeler.Body cadmodelerBody_0 = 
      ((star.cadmodeler.Body) cm.getBody("1_CENTER_DUCT"));

    Face face_0 = 
      ((Face) cadmodelerBody_0.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_1 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_INLET"));

    Face face_1 = 
      ((Face) cadmodelerBody_1.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_2 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION 3"));

    Face face_2 = 
      ((Face) cadmodelerBody_2.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_3 = 
      ((star.cadmodeler.Body) cm.getBody("2_ANNULAR_DUCT"));

    Face face_3 = 
      ((Face) cadmodelerBody_3.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_4 = 
      ((star.cadmodeler.Body) cm.getBody("6_FLOW_LINER"));

    Face face_4 = 
      ((Face) cadmodelerBody_4.getFace("junk"));

    cadmodelerBody_0.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_0, face_1, face_2, face_3, face_4}));

    ImportCadFileFeature importCadFileFeature_0 = 
      ((ImportCadFileFeature) cm.getFeature("ImportCad 1"));

    star.cadmodeler.Body cadmodelerBody_5 = 
      ((star.cadmodeler.Body) cm.getBody("8_TFL"));

    Face face_5 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_5,new DoubleVector(new double[] {1.0639604387500001, 0.9289687541999995, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_6 = 
      ((star.cadmodeler.Body) cm.getBody("15_DEFLECTOR"));

    Face face_6 = 
      ((Face) cadmodelerBody_6.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_7 = 
      ((star.cadmodeler.Body) cm.getBody("15_DEFLECTOR 2"));

    Face face_7 = 
      ((Face) cadmodelerBody_7.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_8 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_SPOOL"));

    Face face_8 = 
      ((Face) cadmodelerBody_8.getFace("junk"));

    star.cadmodeler.Body cadmodelerBody_9 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION 2"));

    Face face_9 = 
      ((Face) cadmodelerBody_9.getFace("junk"));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_5, face_6, face_7, face_8, face_9}), "junk", false);

    cadmodelerBody_5.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_5, face_6, face_7, face_8, face_9}));

    star.cadmodeler.Body cadmodelerBody_10 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_CONTRACTION"));

    Face face_10 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_10,new DoubleVector(new double[] {0.974677340075, 0.4661624916, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_11 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION"));

    Face face_11 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_11,new DoubleVector(new double[] {1.1189856855998825, 0.4753137198570805, 0.0254})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_10, face_11}), "junk", false);

    cadmodelerBody_10.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_10, face_11}));

    star.cadmodeler.Body cadmodelerBody_12 = 
      ((star.cadmodeler.Body) cm.getBody("3_EXHAUST_DUCT"));

    Face face_12 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {6.1570241096, 0.5244751512000005, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_13 = 
      ((star.cadmodeler.Body) cm.getBody("13_SHIELD_COATING"));

    Face face_13 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_13,new DoubleVector(new double[] {3.7329671847999997, 0.334807468687, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_14 = 
      ((star.cadmodeler.Body) cm.getBody("12_SHIELD_METAL"));

    Face face_14 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_14,new DoubleVector(new double[] {3.734028631354756, 0.3359365471371595, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_15 = 
      ((star.cadmodeler.Body) cm.getBody("7_REAR_ADAPTER"));

    Face face_15 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.094118042104605, 0.35743657005049995, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_16 = 
      ((star.cadmodeler.Body) cm.getBody("14_SPRAY"));

    Face face_16 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {3.7839481343999997, 0.42909218855, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_17 = 
      ((star.cadmodeler.Body) cm.getBody("11_DUCT_EXHAUST"));

    Face face_17 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {3.8174750167999996, 1.0053593938999998, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_18 = 
      ((star.cadmodeler.Body) cm.getBody("9_DS_BULKHEAD"));

    Face face_18 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.7009249831999997, 0.8852624915999999, 0.0254})));

    star.cadmodeler.Body cadmodelerBody_19 = 
      ((star.cadmodeler.Body) cm.getBody("10_LOCK"));

    Face face_19 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_19,new DoubleVector(new double[] {2.7290125252, 1.0481124579999999, 0.0254})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_12, face_13, face_14, face_15, face_16, face_17, face_18, face_19}), "junk", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_12, face_13, face_14, face_15, face_16, face_17, face_18, face_19}));

    Face face_20 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {-7.0104, 0.18954680149999958, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_20}), "#02_center_inlet", false);

    cadmodelerBody_0.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_20}));

    Face face_21 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {-7.0104, 0.5179206986624998, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_21}), "#03_annular_inlet", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_21}));

    Face face_22 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_1,new DoubleVector(new double[] {-7.0104, 0.4492386700375, 0.014568754199999999})));

    Face face_23 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_2,new DoubleVector(new double[] {-7.0104, 0.4772749916, 0.014568754199999999})));

    Face face_24 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_4,new DoubleVector(new double[] {-7.0104, 0.5462675200104, 0.014568754199999999})));

    cadmodelerBody_1.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_22, face_23, face_24}));

    Face face_25 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {-0.3256351988125917, 0.5099227812915789, 0.0})));

    Face face_26 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_4,new DoubleVector(new double[] {-0.06920158244999994, 0.8269874748000001, 0.0})));

    Face face_27 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_2,new DoubleVector(new double[] {-3.002171500725, 0.48475000839999993, 0.0})));

    Face face_28 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_1,new DoubleVector(new double[] {-4.0209761592, 0.4508738299625004, 0.0})));

    Face face_29 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {-0.18664703841506522, 0.30875006419280804, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_25, face_26, face_27, face_28, face_29}), "sym", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_25, face_26, face_27, face_28, face_29}));

    Face face_30 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_4,new DoubleVector(new double[] {-4.162974842689705, 0.5635751999999995, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_30}), "#09_od_walls", false);

    cadmodelerBody_4.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_30}));

    Face face_31 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {-2.9894238408, -1.3276679355911247E-15, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_31}), "centerline", false);

    cadmodelerBody_0.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_31}));

    Face face_32 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {0.04390598407021826, 0.12615726887089163, 0.014568754199999999})));

    Face face_33 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {1.021933870022, 0.20319999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_32, face_33}), "c0", false);

    cadmodelerBody_0.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_32, face_33}));

    Face face_34 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_8,new DoubleVector(new double[] {0.9524523400749999, 0.47363750839999985, 0.0})));

    Face face_35 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_9,new DoubleVector(new double[] {0.55034233975, 0.48475000839999993, 0.0})));

    Face face_36 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_10,new DoubleVector(new double[] {0.977947659925, 0.47363750839999996, 0.0})));

    Face face_37 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_11,new DoubleVector(new double[] {1.1189856855998825, 0.4753137198570805, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_34, face_35, face_36, face_37}), "sym", false);

    cadmodelerBody_8.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_34, face_35, face_36, face_37}));

    Face face_38 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_5,new DoubleVector(new double[] {1.5077895612499999, 0.9252312457999998, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_38}), "sym", false);

    cadmodelerBody_5.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_38}));

    Face face_39 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_19,new DoubleVector(new double[] {2.7290125252, 1.0481124579999999, 0.0})));

    Face face_40 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.0338125251999997, 0.9739718519, 0.0})));

    Face face_41 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.0935597942590403, 0.36462192994949993, 0.0})));

    Face face_42 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {3.8174750167999996, 1.0053593938999998, 0.0})));

    Face face_43 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {6.949375890399999, 0.389924848800001, 0.0})));

    Face face_44 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {3.7839481344, 0.42909218855, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_39, face_40, face_41, face_42, face_43, face_44}), "sym", false);

    cadmodelerBody_19.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_39, face_40, face_41, face_42, face_43, face_44}));

    Face face_45 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_14,new DoubleVector(new double[] {3.734028631354756, 0.3359365471371595, 0.0})));

    Face face_46 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_13,new DoubleVector(new double[] {3.7329671847999997, 0.334807468687, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_45, face_46}), "sym", false);

    cadmodelerBody_14.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_45, face_46}));

    Face face_47 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_6,new DoubleVector(new double[] {-0.19400544042491627, 0.5426402776450276, 0.0})));

    Face face_48 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_7,new DoubleVector(new double[] {-0.2777218855, 0.5149430471374999, 0.0})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_47, face_48}), "sym", false);

    cadmodelerBody_6.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_47, face_48}));

    Imprint imprint_0 = 
      cm.getFeatureManager().createImprint();

    imprint_0.setAutoPreview(true);

    cm.allowMakingPartDirty(false);

    imprint_0.setBodies(new NeoObjectVector(new Object[] {cadmodelerBody_0, cadmodelerBody_3, cadmodelerBody_12, cadmodelerBody_11, cadmodelerBody_9, cadmodelerBody_2, cadmodelerBody_10, cadmodelerBody_1, cadmodelerBody_8, cadmodelerBody_4, cadmodelerBody_15, cadmodelerBody_5, cadmodelerBody_18, cadmodelerBody_19, cadmodelerBody_17, cadmodelerBody_14, cadmodelerBody_13, cadmodelerBody_16, cadmodelerBody_6, cadmodelerBody_7}));

    imprint_0.setBodyGroups(new NeoObjectVector(new Object[] {}));

    imprint_0.setCadFilters(new NeoObjectVector(new Object[] {}));

    imprint_0.setSecondGroupBodies(new NeoObjectVector(new Object[] {}));

    imprint_0.setSecondGroupBodyGroups(new NeoObjectVector(new Object[] {}));

    imprint_0.setSecondGroupCadFilters(new NeoObjectVector(new Object[] {}));

    imprint_0.setImprintOntoToolBodies(true);

    imprint_0.setImprintOption(0);

    Units units_0 = 
      ((Units) ss.getUnitsManager().getObject("m"));

    imprint_0.getTolerance().setValueAndUnits(1.0E-5, units_0);

    imprint_0.setTwoGroupImprint(false);

    imprint_0.setIsBodyGroupCreation(false);

    cm.getFeatureManager().markDependentNotUptodate(imprint_0);

    cm.allowMakingPartDirty(true);

    imprint_0.markFeatureForEdit();

    cm.getFeatureManager().execute(imprint_0);

    Face face_49 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_0,new DoubleVector(new double[] {2.123186, 0.259251697015, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_49}), "#05_center_exit", false);

    cadmodelerBody_0.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_49}));

    Face face_50 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.0157419999999995, 0.3021512626, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_50}), "#04_exhaust_inlet", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_50}));

    Face face_51 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {9.2456, 0.524475151200001, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_51}), "#07_exhaust_exit", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_51}));

    Face face_52 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {9.2456, 0.9289687542, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_52}), "w_end_ds", false);

    cadmodelerBody_17.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_52}));

    Face face_53 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {6.621514080034001, 1.6129616697502413E-15, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_53}), "centerline", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_53}));

    Face face_54 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_4,new DoubleVector(new double[] {-0.24244619884724533, 0.6541254659397047, 0.014568754200000008})));

    Face face_55 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_4,new DoubleVector(new double[] {-0.12065, 0.8133100742368452, 0.014568754199999999})));

    Face face_56 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_5,new DoubleVector(new double[] {-0.1639749832, 0.8635999999999999, 0.014568754199999999})));

    Face face_57 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_5,new DoubleVector(new double[] {-0.22225, 0.8960937374, 0.014568754199999999})));

    Face face_58 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_5,new DoubleVector(new double[] {0.99897296395, 0.9398, 0.014568754199999999})));

    Face face_59 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_19,new DoubleVector(new double[] {2.6416, 1.0481124579999999, 0.014568754199999999})));

    Face face_60 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_19,new DoubleVector(new double[] {2.9015498992, 1.1938, 0.014568754199999999})));

    Face face_61 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_19,new DoubleVector(new double[] {3.2512, 1.085487542, 0.014568754199999999})));

    Face face_62 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.4244999328, 0.9397999999999999, 0.014568754199999999})));

    Face face_63 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.6576, 0.9885406060999999, 0.014568754199999999})));

    Face face_64 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.7009249831999997, 1.0541, 0.014568754199999999})));

    Face face_65 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {3.8025249831999997, 1.0541, 0.014568754199999999})));

    Face face_66 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {3.8608, 1.0053593938999998, 0.014568754199999997})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_54, face_55, face_56, face_57, face_58, face_59, face_60, face_61, face_62, face_63, face_64, face_65, face_66}), "#09_od_walls", false);

    cadmodelerBody_4.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_54, face_55, face_56, face_57, face_58, face_59, face_60, face_61, face_62, face_63, face_64, face_65, face_66}));

    Face face_67 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_17,new DoubleVector(new double[] {6.1570241096, 0.9397999999999992, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_67}), "#10_exhaust_duct_od", false);

    cadmodelerBody_17.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_67}));

    Face face_68 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.5651587241768, 0.9159875, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_68}), "#06_annular_exit", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_68}));

    Face face_69 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_18,new DoubleVector(new double[] {3.5651587241768, 0.9159875, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_69}), "exit_face", false);

    cadmodelerBody_18.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_69}));

    Face face_70 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {4.209541999999999, 0.3359365471375, 0.014568754199999999})));

    Face face_71 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {4.209542, 0.334863531313, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_70, face_71}), "w_SHD_DS", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_70, face_71}));

    Face face_72 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_14,new DoubleVector(new double[] {4.209541999999999, 0.3359365471375, 0.014568754199999999})));

    Face face_73 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_13,new DoubleVector(new double[] {4.209542, 0.334863531313, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_72, face_73}), "w_SHD_ds", false);

    cadmodelerBody_14.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_72, face_73}));

    Face face_74 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.5706928573046053, 0.3366134999999999, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_74}), "w_SHD_OD", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_74}));

    Face face_75 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_14,new DoubleVector(new double[] {3.5706928573046053, 0.3366134999999999, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_75}), "w_SHD_OD", false);

    cadmodelerBody_14.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_75}));

    Face face_76 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.7329671847999997, 0.334645, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_76}), "w_SHD_ID", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_76}));

    Face face_77 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_13,new DoubleVector(new double[] {3.7329671847999997, 0.334645, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_77}), "w_SHD_ID", false);

    cadmodelerBody_13.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_77}));

    Face face_78 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.079194340075, 0.385445, 0.014568754199999999})));

    Face face_79 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.069717, 0.3626813215625, 0.014568754199999999})));

    Face face_80 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {2.539560034662, 0.3457575, 0.014568754199999999})));

    Face face_81 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {2.145411, 0.3685211784374998, 0.014568754199999999})));

    Face face_82 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {2.132663340075, 0.385445, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_78, face_79, face_80, face_81, face_82}), "#08_combustor_casing", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_78, face_79, face_80, face_81, face_82}));

    Face face_83 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.101419340075, 0.385445, 0.014568754199999999})));

    Face face_84 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.1141669999999997, 0.37403857419030684, 0.014568754199999999})));

    Face face_85 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.169839603412, 0.3875828923713866, 0.014568754200000008})));

    Face face_86 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.244723, 0.4476788862998531, 0.014568754199999999})));

    Face face_87 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.254200340075, 0.47625, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_83, face_84, face_85, face_86, face_87}), "FL", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_83, face_84, face_85, face_86, face_87}));

    Face face_88 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.254200340075, 0.47625, 0.014568754199999999})));

    Face face_89 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.244723, 0.4476788862998531, 0.014568754199999999})));

    Face face_90 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.169839603412, 0.3875828923713866, 0.014568754200000008})));

    Face face_91 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.101419340075, 0.38544500000000004, 0.014568754199999999})));

    Face face_92 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.1141669999999997, 0.37403857419030684, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_88, face_89, face_90, face_91, face_92}), "FL", false);

    cadmodelerBody_15.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_88, face_89, face_90, face_91, face_92}));

    Face face_93 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.266948, 0.5123377677674467, 0.014568754199999999})));

    Face face_94 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.455195052004, 0.6839753514928119, 0.014568754199999999})));

    Face face_95 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {3.7083999999999997, 0.8555408651413654, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_93, face_94, face_95}), "FU", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_93, face_94, face_95}));

    Face face_96 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.7083999999999997, 0.8555408651413654, 0.014568754199999999})));

    Face face_97 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.455195052004, 0.6839753514928119, 0.014568754199999999})));

    Face face_98 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.266948, 0.5123377677674467, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_96, face_97, face_98}), "FU", false);

    cadmodelerBody_15.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_96, face_97, face_98}));

    Face face_99 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.1939385106970395, 0.38756771781450183, 0.014568754199999999})));

    Face face_100 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.2960855084, 0.42545, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_99, face_100}), "RL", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_99, face_100}));

    Face face_101 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.2960855084, 0.42545, 0.014568754199999999})));

    Face face_102 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.1939385106970395, 0.38756771781450183, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_101, face_102}), "RL", false);

    cadmodelerBody_15.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_101, face_102}));

    Face face_103 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.3177480000000004, 0.4900750168, 0.014568754199999999})));

    Face face_104 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {3.317748, 0.42815781145, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_103, face_104}), "RU", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_103, face_104}));

    Face face_105 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.3177480000000004, 0.4900750168, 0.014568754199999999})));

    Face face_106 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.317748, 0.42909218855, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_105, face_106}), "RU", false);

    cadmodelerBody_15.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_105, face_106}));

    Face face_107 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.570952947996, 0.6989738914830002, 0.014568754199999999})));

    Face face_108 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.7592, 0.8458909131169999, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_107, face_108}), "RU", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_107, face_108}));

    Face face_109 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.7592, 0.8458909131169999, 0.014568754199999999})));

    Face face_110 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_15,new DoubleVector(new double[] {3.570952947996, 0.6989738914830002, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_109, face_110}), "RU", false);

    cadmodelerBody_15.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_109, face_110}));

    Face face_111 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.7839481344, 0.42545, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_111}), "s_id", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_111}));

    Face face_112 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {3.7839481344, 0.42545000000000005, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_112}), "s_id", false);

    cadmodelerBody_16.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_112}));

    Face face_113 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {4.130548, 0.42909218855, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_113}), "s_end", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_113}));

    Face face_114 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {4.130548, 0.42909218855, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_114}), "s_end", false);

    cadmodelerBody_16.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_114}));

    Face face_115 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_12,new DoubleVector(new double[] {3.6643478656, 0.43179999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_115}), "s_od", false);

    cadmodelerBody_12.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_115}));
  }

  private void execute1() {

    Simulation ss = 
      getActiveSimulation();

    CadModel cm = 
      ((CadModel) ss.get(SolidModelManager.class).getObject("3D-CAD Model 2"));

    ImportCadFileFeature importCadFileFeature_0 = 
      ((ImportCadFileFeature) cm.getFeature("ImportCad 1"));

    star.cadmodeler.Body cadmodelerBody_16 = 
      ((star.cadmodeler.Body) cm.getBody("14_SPRAY"));

    Face face_116 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_16,new DoubleVector(new double[] {3.6643478656, 0.43179999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_116}), "s_od", false);

    cadmodelerBody_16.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_116}));

    star.cadmodeler.Body cadmodelerBody_3 = 
      ((star.cadmodeler.Body) cm.getBody("2_ANNULAR_DUCT"));

    Face face_117 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {-4.030453499275, 0.5064124999999996, 0.014568754199999997})));

    Face face_118 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {-0.02222499999999992, 0.5016738299624999, 0.014568754199999997})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_117, face_118}), "w_ins_us", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_117, face_118}));

    star.cadmodeler.Body cadmodelerBody_2 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION 3"));

    Face face_119 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_2,new DoubleVector(new double[] {-4.030453499275, 0.5064124999999995, 0.014568754199999999})));

    Face face_120 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_2,new DoubleVector(new double[] {-0.02222499999999992, 0.5016738299625, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_119, face_120}), "w_ins_us", false);

    cadmodelerBody_2.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_119, face_120}));

    Imprint imprint_0 = 
      ((Imprint) cm.getFeature("Imprint 1"));

    Face face_121 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {-0.012747659925000043, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_121}), "w_m_1", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_121}));

    star.cadmodeler.Body cadmodelerBody_1 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_INLET"));

    Face face_122 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_1,new DoubleVector(new double[] {-0.012747659924999948, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_122}), "w_m_1", false);

    cadmodelerBody_1.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_122}));

    Face face_123 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.009477340075000007, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_123}), "w_m_2", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_123}));

    star.cadmodeler.Body cadmodelerBody_8 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_SPOOL"));

    Face face_124 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_8,new DoubleVector(new double[] {0.009477340074999997, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_124}), "w_m_2", false);

    cadmodelerBody_8.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_124}));

    Face face_125 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.952452340075, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_125}), "w_m_3", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_125}));

    Face face_126 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_8,new DoubleVector(new double[] {0.9524523400749999, 0.49529999999999996, 0.014568754199999997})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_126}), "w_m_3", false);

    cadmodelerBody_8.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_126}));

    Face face_127 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.974677340075, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_127}), "w_m_4", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_127}));

    star.cadmodeler.Body cadmodelerBody_10 = 
      ((star.cadmodeler.Body) cm.getBody("5_DUCT_CONTRACTION"));

    Face face_128 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_10,new DoubleVector(new double[] {0.974677340075, 0.49529999999999996, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_128}), "w_m_4", false);

    cadmodelerBody_10.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_128}));

    Face face_129 = 
      ((Face) imprint_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {2.110438340075, 0.385445, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_129}), "w_m_5", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_129}));

    Face face_130 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_10,new DoubleVector(new double[] {2.110438340075, 0.385445, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_130}), "w_m_5", false);

    cadmodelerBody_10.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_130}));

    Face face_131 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.022224999999999977, 0.5000386700375, 0.014568754199999999})));

    Face face_132 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.4148576602499999, 0.5064124999999999, 0.014568754199999999})));

    Face face_133 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.942975, 0.5016738299625, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_131, face_132, face_133}), "w_ins_spool", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_131, face_132, face_133}));

    star.cadmodeler.Body cadmodelerBody_9 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION 2"));

    Face face_134 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_9,new DoubleVector(new double[] {0.942975, 0.5016738299625, 0.014568754199999999})));

    Face face_135 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_9,new DoubleVector(new double[] {0.4148576602499999, 0.5064124999999999, 0.014568754199999999})));

    Face face_136 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_9,new DoubleVector(new double[] {0.022224999999999977, 0.5000386700374999, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_134, face_135, face_136}), "w_ins_spool", false);

    cadmodelerBody_9.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_134, face_135, face_136}));

    Face face_137 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {0.987425, 0.4992581169491579, 0.014568754199999999})));

    Face face_138 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {1.4622668158719998, 0.4595350916585253, 0.014568754200000008})));

    Face face_139 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_3,new DoubleVector(new double[] {2.100961, 0.39318760559328136, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_137, face_138, face_139}), "w_ins_contraction", false);

    cadmodelerBody_3.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_137, face_138, face_139}));

    star.cadmodeler.Body cadmodelerBody_11 = 
      ((star.cadmodeler.Body) cm.getBody("4_INSULATION"));

    Face face_140 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_11,new DoubleVector(new double[] {1.4622668158719998, 0.4595350916585253, 0.014568754200000008})));

    Face face_141 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_11,new DoubleVector(new double[] {2.100961, 0.39318760559328153, 0.014568754199999999})));

    Face face_142 = 
      ((Face) importCadFileFeature_0.getFaceByLocation(cadmodelerBody_11,new DoubleVector(new double[] {0.987425, 0.4992581169491579, 0.014568754199999999})));

    cm.setFaceNameAttributes(new NeoObjectVector(new Object[] {face_140, face_141, face_142}), "w_ins_contraction", false);

    cadmodelerBody_11.getFaceManager().hideFaces(new NeoObjectVector(new Object[] {face_140, face_141, face_142}));
  }
}
