/**
 * ScenesAndPlotsToPPT.java - Flavio Cimolin, 07/10/2016
 * -----------------------------------------------------
 *
 * Basic example of macro that creates a PPT presentation with all the Scenes
 * and Plots of the current Simulation. By acting on the basic parameters on the
 * first lines of the macro class definition, it is possible to customize the
 * PPT file name, the choice on whether to include all Scenes and Plots or only
 * those containing a particular filter String, and a number of heights and
 * widths for the presentation page and images.
 *
 * The macro takes advantage of the functionalities of the APACHE-POI 3.15
 * libraries: https://poi.apache.org/
 *
 * In order for the macro to work, the jar files of the libraries must be
 * properly referenced in the STAR-CCM+ User Classpath field.
 */
package macro;

import java.io.*;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;
import star.common.*;
import star.vis.*;

public class ScenesAndPlotsToPPT extends StarMacro {

    // PPT filename
    private final String PPTFileName = "slideshow.ppt";

    // Inclusion filters
    private final boolean IncludeAllImages = true;
    private final String InclusionFilter = "PPT";

    // Choice of PPT insertion of Scenes and/or Plots
    private final boolean ExportScenes = true;
    private final boolean ExportPlots = true;

    // Image Resolution for hardcopy
    private final int ImageResolutionX = 1200;
    private final int ImageResolutionY = 600;
    private final double MagnificationFactor = 1.0;

    // Page, Title and Image Sizes of PPT file
    private final int PageSizeX = 720;
    private final int PageSizeY = 540;
    private final int MarginX = 20;
    private final int MarginY = 10;
    private final int TitleSizeY = 70;

    // Other internal variables
    private final String TemporaryImageFileName = System.getProperty("java.io.tmpdir") + File.separator + "tmp_image.png";

    private Simulation sim;

    private int ImageBorderX;
    private int ImageBorderY;
    private int ImageSizeX;
    private int ImageSizeY;

    @Override

    public void execute() {

        sim = getActiveSimulation();

        try {

            // Create a new empty slide show
            HSLFSlideShow ppt = new HSLFSlideShow();

            // Setup page size
            ppt.setPageSize(new java.awt.Dimension(PageSizeX, PageSizeY));

            // Create title slide with Simulation name
            HSLFSlide TitleSlide = ppt.createSlide();
            HSLFTextBox TitleSlideTitle = TitleSlide.addTitle();
            TitleSlideTitle.setText(sim.getPresentationName());
            TitleSlideTitle.setAnchor(new java.awt.Rectangle(MarginX, PageSizeY / 2, PageSizeX - 2 * MarginX, TitleSizeY));

            // Image size place calculations
            computeCorrectImageSizeAndPosition();

            // Loop over all STAR-CCM+ Scenes
            if (ExportScenes) {
                for (Scene scene : sim.getSceneManager().getScenes()) {

                    // Check inclusion filter String
                    if ((IncludeAllImages) || (scene.getPresentationName().contains(InclusionFilter))) {

                        // Open the Scene and save it to a temporary file
                        scene.open(true);
                        scene.printAndWait(TemporaryImageFileName, 1, (int) (MagnificationFactor * ImageResolutionX), (int) (MagnificationFactor * ImageResolutionY));

                        // Add a slide
                        HSLFSlide slide = ppt.createSlide();

                        // Add the new picture to this slideshow
                        HSLFPictureData pd = ppt.addPicture(new File(TemporaryImageFileName), PictureData.PictureType.JPEG);
                        HSLFPictureShape pictNew = new HSLFPictureShape(pd);
                        pictNew.setAnchor(new java.awt.Rectangle(ImageBorderX, ImageBorderY, ImageSizeX, ImageSizeY));
                        slide.addShape(pictNew);

                        // Add the Scene name as title
                        HSLFTextBox title = slide.addTitle();
                        title.setText(scene.getPresentationName());
                        title.setAnchor(new java.awt.Rectangle(MarginX, MarginY, PageSizeX - 2 * MarginX, TitleSizeY));

                    }
                }
            }

            // Loop over all STAR-CCM+ Plots
            if (ExportPlots) {
                for (StarPlot plot : sim.getPlotManager().getObjects()) {

                    // Check inclusion filter String
                    if ((IncludeAllImages) || (plot.getPresentationName().contains(InclusionFilter))) {

                        // Save the Plot to a temporary file
                        plot.encode(TemporaryImageFileName, "jpg", (int) (MagnificationFactor * ImageResolutionX), (int) (MagnificationFactor * ImageResolutionY));

                        // Add a slide
                        HSLFSlide slide = ppt.createSlide();

                        // Add the new picture to this slideshow
                        HSLFPictureData pd = ppt.addPicture(new File(TemporaryImageFileName), PictureData.PictureType.JPEG);
                        HSLFPictureShape pictNew = new HSLFPictureShape(pd);
                        pictNew.setAnchor(new java.awt.Rectangle(ImageBorderX, ImageBorderY, ImageSizeX, ImageSizeY));
                        slide.addShape(pictNew);

                        // Add the Scene name as title
                        HSLFTextBox title = slide.addTitle();
                        title.setText(plot.getPresentationName());
                        title.setAnchor(new java.awt.Rectangle(MarginX, MarginY, PageSizeX - 2 * MarginX, TitleSizeY));

                    }
                }
            }

            // Save the output file
            FileOutputStream out;
            out = new FileOutputStream(resolvePath(PPTFileName));
            ppt.write(out);
            out.close();
            sim.println("Generated PPT File: " + resolvePath(PPTFileName));

        } catch (IOException ex) {
            sim.println(ex);
        }
    }

    private void computeCorrectImageSizeAndPosition() {

        int ImagePlaceSizeX = PageSizeX - 2 * MarginX;
        int ImagePlaceSizeY = PageSizeY - 3 * MarginY - TitleSizeY;

        double RatioImage = ((double) ImageResolutionX) / ((double) ImageResolutionY);
        double RatioImagePlace = ((double) ImagePlaceSizeX) / ((double) ImagePlaceSizeY);

        ImageBorderX = MarginX;
        ImageBorderY = 2 * MarginY + TitleSizeY;
        ImageSizeX = ImagePlaceSizeX;
        ImageSizeY = ImagePlaceSizeY;

        sim.println("Ratio of the Scene images: " + RatioImage);
        sim.println("Ratio of the PPT place for images: " + RatioImagePlace);
        sim.println("Nominal values for image position: " + ImageBorderX + " " + ImageBorderY + " " + ImageSizeX + " " + ImageSizeY);

        if (Double.compare(RatioImage, RatioImagePlace) < 0) {

            sim.println("Adapting image place in PPT to fit Y size");

            ImageSizeX = (int) (ImageSizeY * RatioImage);
            ImageBorderX = (int) ((PageSizeX - ImageSizeX) / 2.0);

        } else if (Double.compare(RatioImage, RatioImagePlace) > 0) {

            sim.println("Adapting image place in PPT to fit X size");

            ImageSizeY = (int) (ImageSizeX / RatioImage);
            ImageBorderY = 2 * MarginY + TitleSizeY + (int) ((PageSizeY - 2 * MarginY - TitleSizeY - ImageSizeY) / 2.0);

        }

        sim.println("Modified values for image position: " + ImageBorderX + " " + ImageBorderY + " " + ImageSizeX + " " + ImageSizeY);

    }

}
