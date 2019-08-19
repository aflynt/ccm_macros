// PPTSimSummaryGeneration.java - v1.0 - Flavio Cimolin, 05/07/2019
// ----------------------------------------------------------------
// Macro to generate a "Simulation Summary" in PPT format including Scenes,
// Plots and Report values in Tables.
// 
// The indication of how to structure the PPT is carried out via Simulation
// Summaries respecting a proper naming convention (e.g. their name have to
// be "PPT_Page1", "PPT_Page2",...). Each "page" contains a pointer to the
// Scene, Plot or Report elements to be included in that page.
// 
// The simplest way to create such page structure is to take advantage of the
// complementary macro "PPTSimSummaryNewPageFromSelected.java", just selecting the
// elements in the Simulation Tree and playing the macro to iteratively
// define each presentation page.
// 
// The macro supports three different layouts, with 1, 2 or 4 "elements"
// per slide. Each "element" can be either a Scene, a Plot or a collection of
// Reports, which are arranged in a tabulated format. If more than 4 elements
// are included in a Summary representing a page, the latest ones will be
// skipped.
// 
// The macro features a long list of exposed fields that can be customized
// for different stilying of the presentation.
// 
package macro;

import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.List;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;
import org.apache.poi.sl.draw.*;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import star.base.report.*;
import star.common.*;
import star.summary.*;
import star.vis.*;

public class PPTSimSummaryGeneration extends StarMacro {

    // PPT Page resolution
    private final int PageSizeX = 960;
    private final int PageSizeY = 540;

    // Options for title slide
    private final int TitleSlideMarginX = 30;
    private final int TitleSlideMarginY = 180;

    private final int TitleSlideSizeY = 100;

    private final String TitleSlideFontFamily = "Arial";
    private final double TitleSlideFontSize = 50.0;

    private final int SubtitleSlideSizeY = 50;
    private final int SubtitleSlideDistanceY = 20;
    private final double SubtitleSlideFontSize = 30.0;

    // Options for slides with Pictures
    private final int PictureResolutionX = 1280;
    private final int PictureResolutionY = 720;

    private final int PictureSlideMarginX = 20;
    private final int PictureSlideMarginY = 10;

    private final int PictureSlideTitleSizeY = 50;
    private final TextAlign PictureSlideTitleAlign = TextAlign.LEFT;

    private final int PictureBorderLineWidth = 1;
    private final Color PictureBorderLineColor = Color.GRAY;

    private final String PictureSlideTitleFontFamily = "Arial";
    private final double PictureSlideTitleFontSizeLayout1 = 30.0;
    private final double PictureSlideTitleFontSizeLayout2 = 20.0;
    private final double PictureSlideTitleFontSizeLayout4 = 20.0;

    // Options for slides with Tables
    private final int TableSlideMarginX = 20;
    private final int TableSlideMarginY = 20;

    private final int TableMinimumRowHeight = 5;
    private final int TableMaximumRowHeight = 80;

    private final double TableFirstColumnWidthRatio = 0.6;

    private final double TableLineWidth = 1.0;
    private final Color TableLineColor = Color.BLACK;

    private final TextAlign TableFirstColumnAlign = TextAlign.LEFT;
    private final TextAlign TableSecondColumnAlign = TextAlign.CENTER;

    private final String TableFontFamily = "Arial";
    private final double TableFontSizeLayout1 = 22.0;
    private final double TableFontSizeLayout2 = 14.0;
    private final double TableFontSizeLayout4 = 12.0;

    private final String formatPattern = "###.#####";

    private final Color TableTitleBackgroundColor = Color.LIGHT_GRAY;

    // Page Pattern String in Simulation Summaries
    public static final String PagePattern = "PPT_Page";

    // Other internal variables
    private Simulation sim;
    private HSLFSlideShow ppt;
    private List<Page> pages;

    private final String TemporaryImageFileName = System.getProperty("java.io.tmpdir") + File.separator + "tmp_image.png";

    @Override
    public void execute() {

        sim = getActiveSimulation();

        try {

            // Create a new empty slide show
            ppt = new HSLFSlideShow();

            // Setup page size
            ppt.setPageSize(new java.awt.Dimension(PageSizeX, PageSizeY));

            // Initialize List of Pages
            pages = new LinkedList<>();

            // Process Simulation Summary checking PagePattern
            for (SimulationSummary ss : sim.get(SimulationSummaryManager.class).getObjects()) {

                String Name = ss.getPresentationName();

                if (Name.startsWith(PagePattern)) {

                    String PageNumberString = Name.substring(PagePattern.length());

                    if (PageNumberString.matches("\\d+")) {
                        pages.add(new Page(Integer.parseInt(PageNumberString), ss));
                    }

                }

            }

            // Sort the Pages List
            Collections.sort(pages, (p1, p2) -> {
                return (p1.PageNumber - p2.PageNumber);
            });

            // Output list of Pages
            sim.println("PPT - Identified Pages and Elements in Summaries:");
            for (Page page : pages) {
                sim.println("Page: " + page.PageNumber);
                for (SummaryElement se : page.ss.getChildElements()) {
                    sim.println("  " + se);
                }
            }
            sim.println("");

            // Title Slide (use the Comment in Summaries if available,
            // otherwise the Simulation name)
            sim.println("PPT - Creating Title Slide\n");

            Slide TitleSlide = new Slide(1);

            String titletext;
            if (sim.get(CommentManager.class).getCommentFor(sim.get(SimulationSummaryManager.class)) != null) {
                titletext = sim.get(CommentManager.class).getCommentFor(sim.get(SimulationSummaryManager.class)).getText();
            } else {
                titletext = sim.getPresentationName();
            }
            
            TitleSlide.addTitleText(titletext);

            // Process Pages
            for (Page page : pages) {

                sim.println("PPT - Creating Page: " + page.PageNumber);
                sim.println("Number of Scene/Plot Elements found: " + page.ScenePlotCount);
                sim.println("Number of Report Set found: " + page.ReportSetCount);
                sim.println("Selected Layout Type: " + page.LayoutType);

                if (page.LayoutType == 0) {
                    sim.println("Skipping Page since there are no elements");
                    continue;
                }

                sim.println("Creating Slide with following Elements:");

                // Create Slide
                Slide slide = new Slide(page.LayoutType);

                // Process the Elements
                int elementid = 0;
                for (Object o : page.Element) {
                    if (o instanceof SceneSummary) {

                        Scene scene = ((SceneSummary) o).getScene();

                        if (elementid++ < page.LayoutType) {
                            sim.println("  Element " + elementid + ": " + scene.getPresentationName());
                        } else {
                            sim.println("  Element " + elementid + ": " + scene.getPresentationName() + " (SKIPPED)");
                        }

                        // Hardcopy image
                        scene.printAndWait(TemporaryImageFileName, 1, PictureResolutionX, PictureResolutionY);
                        HSLFPictureData pd = ppt.addPicture(new File(TemporaryImageFileName), PictureData.PictureType.JPEG);

                        // Use a comment for the title, in case it is present
                        String text;
                        if (sim.get(CommentManager.class).getCommentFor((SceneSummary) o) != null) {
                            text = sim.get(CommentManager.class).getCommentFor((SceneSummary) o).getText();
                        } else {
                            text = scene.getPresentationName();
                        }

                        slide.addPictureAndText(pd, text);

                    }

                    if (o instanceof PlotSummary) {

                        StarPlot plot = ((PlotSummary) o).getPlot();

                        if (elementid++ < page.LayoutType) {
                            sim.println("  Element " + elementid + ": " + plot.getPresentationName());
                        } else {
                            sim.println("  Element " + elementid + ": " + plot.getPresentationName() + " (SKIPPED)");
                        }

                        // Hardcopy image
                        plot.encode(TemporaryImageFileName, "png", PictureResolutionX, PictureResolutionY);
                        HSLFPictureData pd = ppt.addPicture(new File(TemporaryImageFileName), PictureData.PictureType.JPEG);

                        // Use a comment for the title, in case it is present
                        String text;
                        if (sim.get(CommentManager.class).getCommentFor((PlotSummary) o) != null) {
                            text = sim.get(CommentManager.class).getCommentFor((PlotSummary) o).getText();
                        } else {
                            text = plot.getPresentationName();
                        }

                        slide.addPictureAndText(pd, text);

                    }

                    if (o instanceof LinkedList) {

                        if (elementid++ < page.LayoutType) {
                            sim.println("  Element " + elementid + ": Table of Reports");
                        } else {
                            sim.println("  Element " + elementid + ": Table of Reports (SKIPPED)");
                        }

                        List reports = (LinkedList) o;

                        String[][] data = new String[reports.size() + 1][2];
                        data[0][0] = "Report";
                        data[0][1] = "Value";

                        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                        DecimalFormat formatter = (DecimalFormat) nf;
                        formatter.applyPattern(formatPattern);

                        int i = 1;
                        for (Object repobj : reports) {
                            Report report = ((ReportSummary) repobj).getReport();

                            sim.println("     " + report.getPresentationName());

                            // Use a comment for the text, in case it is present
                            String text;
                            if (sim.get(CommentManager.class).getCommentFor((ReportSummary) repobj) != null) {
                                text = sim.get(CommentManager.class).getCommentFor((ReportSummary) repobj).getText();
                            } else {
                                text = report.getPresentationName();
                            }

                            data[i][0] = text;
                            data[i][1] = formatter.format(report.getReportMonitorValue()) + " " + report.getUnits().toString();
                            i++;

                        }

                        slide.addTable(data);

                    }
                }

                sim.println("");

            }

            /* Basic Test to just create a number of slides with the various layouts
            // 
            Scene scene = sim.getSceneManager().getScene("Geometry Scene 1");

            // Open the Scene and save it to a temporary file
            scene.printAndWait(TemporaryImageFileName, 1, PictureResolutionX, PictureResolutionY);
            HSLFPictureData pd = ppt.addPicture(new File(TemporaryImageFileName), PictureData.PictureType.JPEG);

            // Title Slide
            {
                Slide slide = new Slide(1);
                slide.addTitleText(sim.getPresentationName());
                slide.addTitleText(sim.getPresentationName());
            }

            // Test 1 slide picture
            {
                Slide slide = new Slide(1);
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
            }

            // Test 2 slide picture
            {
                Slide slide = new Slide(2);
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
            }

            // Test 4 slide picture
            {
                Slide slide = new Slide(4);

                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addPictureAndText(pd, scene.getPresentationName());
            }

            String[][] data = {
                {"Resistance", "2"},
                {"Item File", "11,559"},
                {"Vendor File", "300"},
                {"Purchase History File", "10,000"},
                {"Total # of requisitions for the whole set of very long sentence that doesn't fin one line", "10,200,038"}
            };

            // Test 1 slide text
            {
                Slide slide = new Slide(1);

                slide.addTable(data);
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
            }

            // Test 2 slide text
            {
                Slide slide = new Slide(2);

                slide.addTable(data);
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
            }

            // Test 4 slide text
            {
                Slide slide = new Slide(4);

                slide.addTable(data);
                slide.addPictureAndText(pd, scene.getPresentationName());
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
                slide.addTable(data);
            }

            END OF TEST LINES */
            //
            // Save the output file
            FileOutputStream out;
            String FileName = sim.getPresentationName() + ".ppt";
            out = new FileOutputStream(resolvePath(FileName));
            ppt.write(out);
            out.close();
            sim.println("Generated PPT File: " + resolvePath(FileName));

        } catch (IOException ex) {
            sim.println(ex);
        }

    }

    class Page {

        int PageNumber;
        SimulationSummary ss;

        int ScenePlotCount;
        int ReportSetCount;
        int LayoutType;

        List Element;

        private Page(int PageNumber, SimulationSummary ss) {
            this.PageNumber = PageNumber;
            this.ss = ss;

            // Count Elements
            ScenePlotCount = 0;
            ReportSetCount = 0;
            boolean ReportSetFlag = false;
            for (SummaryElement se : ss.getChildElements()) {
                if ((se instanceof SceneSummary) || (se instanceof PlotSummary)) {
                    ScenePlotCount++;
                }
                if (ReportSetFlag == false) {
                    if (se instanceof ReportSummary) {
                        ReportSetFlag = true;
                        ReportSetCount++;
                        continue;
                    }
                }
                if (ReportSetFlag == true) {
                    if ((se instanceof SceneSummary) || (se instanceof PlotSummary)) {
                        ReportSetFlag = false;
                    }
                }
            }

            // Decide Layout
            int numelements = ScenePlotCount + ReportSetCount;

            if ((numelements == 1) || (numelements == 2)) {
                LayoutType = numelements;
            } else if (numelements > 2) {
                LayoutType = 4;
            } else {
                LayoutType = 0;
            }

            // Create Element List if there is something
            if (LayoutType != 0) {
                Element = new LinkedList();
            } else {
                return;
            }

            // Process the Summary to get Elements
            List<ReportSummary> reports = null;

            ReportSetFlag = false;
            for (SummaryElement se : ss.getChildElements()) {

                if ((se instanceof SceneSummary) || (se instanceof PlotSummary)) {
                    Element.add(se);
                    ReportSetFlag = false;
                }

                if (se instanceof ReportSummary) {

                    if (ReportSetFlag == false) {

                        reports = new LinkedList<>();
                        ReportSetFlag = true;

                        reports.add((ReportSummary) se);
                        Element.add(reports);

                    } else {

                        Element.remove(Element.size() - 1);

                        reports.add((ReportSummary) se);
                        Element.add(reports);

                    }

                }

            }

        }

    }

    class Slide {

        int LayoutType; // Number of items per page (1, 2, 4)
        int ElementCount;

        HSLFSlide slide;

        public Slide(int LayoutType) {

            slide = ppt.createSlide();

            this.LayoutType = LayoutType;
            this.ElementCount = 0;

        }

        private void addTitleText(String Text) {

            if (ElementCount == 0) {
                addTitleTextElement(Text, 0, 0, PageSizeX, PageSizeY);
            }
            if (ElementCount == 1) {
                addSubtitleTextElement(Text, 0, 0, PageSizeX, PageSizeY);
            }

            ElementCount++;

        }

        private void addPictureAndText(HSLFPictureData pd, String Text) {

            if (LayoutType == 1) {
                if (ElementCount == 0) {
                    addPictureAndTextElements(pd, Text, 0, 0, PageSizeX, PageSizeY);
                }
            }

            if (LayoutType == 2) {
                if (ElementCount == 0) {
                    addPictureAndTextElements(pd, Text, 0, 0, PageSizeX / 2, PageSizeY);
                }
                if (ElementCount == 1) {
                    addPictureAndTextElements(pd, Text, PageSizeX / 2, 0, PageSizeX / 2, PageSizeY);
                }
            }

            if (LayoutType == 4) {
                if (ElementCount == 0) {
                    addPictureAndTextElements(pd, Text, 0, 0, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 1) {
                    addPictureAndTextElements(pd, Text, PageSizeX / 2, 0, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 2) {
                    addPictureAndTextElements(pd, Text, 0, PageSizeY / 2, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 3) {
                    addPictureAndTextElements(pd, Text, PageSizeX / 2, PageSizeY / 2, PageSizeX / 2, PageSizeY / 2);
                }
            }

            ElementCount++;

        }

        private void addTable(String[][] data) {

            if (LayoutType == 1) {
                if (ElementCount == 0) {
                    addTableElements(data, 0, 0, PageSizeX, PageSizeY);
                }
            }

            if (LayoutType == 2) {
                if (ElementCount == 0) {
                    addTableElements(data, 0, 0, PageSizeX / 2, PageSizeY);
                }
                if (ElementCount == 1) {
                    addTableElements(data, PageSizeX / 2, 0, PageSizeX / 2, PageSizeY);
                }
            }

            if (LayoutType == 4) {
                if (ElementCount == 0) {
                    addTableElements(data, 0, 0, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 1) {
                    addTableElements(data, PageSizeX / 2, 0, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 2) {
                    addTableElements(data, 0, PageSizeY / 2, PageSizeX / 2, PageSizeY / 2);
                }
                if (ElementCount == 3) {
                    addTableElements(data, PageSizeX / 2, PageSizeY / 2, PageSizeX / 2, PageSizeY / 2);
                }
            }

            ElementCount++;

        }

        private void addTitleTextElement(String Text, int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            HSLFTextBox title = slide.createTextBox();
            title.setText(Text);
            title.setVerticalAlignment(VerticalAlignment.MIDDLE);
            title.setHorizontalCentered(false);
            title.setAnchor(getTitleTextAnchorInformation(InitialBorderX, InitialBorderY, AvailableSizeX, AvailableSizeY));
            HSLFTextRun rt = title.getTextParagraphs().get(0).getTextRuns().get(0);
            title.getTextParagraphs().get(0).setTextAlign(TextAlign.CENTER);
            rt.setFontFamily(TitleSlideFontFamily);
            rt.setFontSize(TitleSlideFontSize);

        }

        private void addSubtitleTextElement(String Text, int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            HSLFTextBox subtitle = slide.createTextBox();
            subtitle.setText(Text);
            subtitle.setVerticalAlignment(VerticalAlignment.MIDDLE);
            subtitle.setHorizontalCentered(false);
            subtitle.setAnchor(getSubtitleTextAnchorInformation(InitialBorderX, InitialBorderY, AvailableSizeX, AvailableSizeY));
            HSLFTextRun rt = subtitle.getTextParagraphs().get(0).getTextRuns().get(0);
            subtitle.getTextParagraphs().get(0).setTextAlign(TextAlign.CENTER);
            rt.setFontFamily(TitleSlideFontFamily);
            rt.setFontSize(SubtitleSlideFontSize);

        }

        private void addPictureAndTextElements(HSLFPictureData pd, String Text, int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            // Add the new picture to this slideshow
            HSLFPictureShape pictNew = new HSLFPictureShape(pd);
            slide.addShape(pictNew);
            pictNew.setAnchor(getPictureAnchorInformation(InitialBorderX, InitialBorderY, AvailableSizeX, AvailableSizeY));
            pictNew.setLineWidth(PictureBorderLineWidth);
            pictNew.setLineColor(PictureBorderLineColor);

            // Add the Scene name as title
            HSLFTextBox title = slide.createTextBox();
            title.setText(Text);
            title.setVerticalAlignment(VerticalAlignment.MIDDLE);
            title.setHorizontalCentered(false);
            title.setAnchor(getPictureTextAnchorInformation(InitialBorderX, InitialBorderY, AvailableSizeX, AvailableSizeY));
            HSLFTextRun rt = title.getTextParagraphs().get(0).getTextRuns().get(0);
            title.getTextParagraphs().get(0).setTextAlign(PictureSlideTitleAlign);
            rt.setFontFamily(PictureSlideTitleFontFamily);

            if (LayoutType == 1) {
                rt.setFontSize(PictureSlideTitleFontSizeLayout1);
            } else if (LayoutType == 2) {
                rt.setFontSize(PictureSlideTitleFontSizeLayout2);
            } else {
                rt.setFontSize(PictureSlideTitleFontSizeLayout4);
            }

        }

        private void addTableElements(String[][] data, int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            // Create the Table
            int NumRows = data.length;
            HSLFTable table = slide.createTable(NumRows, 2);
            DrawTableShape dts1 = new DrawTableShape(table);
            dts1.setAllBorders(TableLineWidth, TableLineColor);

            // Position the Table
            java.awt.Rectangle TableAnchorInformation = getTableAnchorInformation(InitialBorderX, InitialBorderY, AvailableSizeX, AvailableSizeY);
            table.moveTo(TableAnchorInformation.x, TableAnchorInformation.y);

            double ColumnWidth0 = TableFirstColumnWidthRatio * TableAnchorInformation.width;
            double ColumnWidth1 = (1 - TableFirstColumnWidthRatio) * TableAnchorInformation.width;
            table.setColumnWidth(0, ColumnWidth0);
            table.setColumnWidth(1, ColumnWidth1);

            double RowHeight = TableAnchorInformation.height / NumRows;

            // Discard rows in case RowHeight goes below the minimum threshold
            if (RowHeight < TableMinimumRowHeight) {

                RowHeight = TableMinimumRowHeight;
                NumRows = (int) Math.floor(((double) TableAnchorInformation.height) / RowHeight);

            }

            // Reduce RowHeight in case it goes above the maximum threshold
            if (RowHeight > TableMaximumRowHeight) {
                RowHeight = TableMaximumRowHeight;
            }

            // Set Row Height
            for (int i = 0; i < NumRows; i++) {
                table.setRowHeight(i, RowHeight);
            }

            // Set Table Text
            for (int i = 0; i < NumRows; i++) {
                for (int j = 0; j < 2; j++) {

                    HSLFTableCell cell = table.getCell(i, j);
                    cell.setText(data[i][j]);
                    cell.setVerticalAlignment(VerticalAlignment.MIDDLE);

                    HSLFTextRun rt = cell.getTextParagraphs().get(0).getTextRuns().get(0);
                    rt.setFontFamily(TableFontFamily);

                    if (LayoutType == 1) {
                        rt.setFontSize(TableFontSizeLayout1);
                    } else if (LayoutType == 2) {
                        rt.setFontSize(TableFontSizeLayout2);
                    } else {
                        rt.setFontSize(TableFontSizeLayout4);
                    }

                    if (i == 0) {
                        cell.getFill().setForegroundColor(TableTitleBackgroundColor);
                        rt.setBold(true);
                    } else {
                        rt.setBold(false);
                    }

                    if (j == 0) {
                        rt.getTextParagraph().setTextAlign(TableFirstColumnAlign);
                    } else {
                        rt.getTextParagraph().setTextAlign(TableSecondColumnAlign);
                    }

                    cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
                    cell.setHorizontalCentered(false);

                }
            }

        }

        private java.awt.Rectangle getTitleTextAnchorInformation(int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            return new java.awt.Rectangle(InitialBorderX + TitleSlideMarginX, InitialBorderY + TitleSlideMarginY, AvailableSizeX - 2 * TitleSlideMarginX, TitleSlideSizeY);

        }

        private java.awt.Rectangle getSubtitleTextAnchorInformation(int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            return new java.awt.Rectangle(InitialBorderX + TitleSlideMarginX, InitialBorderY + TitleSlideMarginY + TitleSlideSizeY + SubtitleSlideDistanceY, AvailableSizeX - 2 * TitleSlideMarginX, SubtitleSlideSizeY);

        }

        private java.awt.Rectangle getPictureAnchorInformation(int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            int ImagePlaceSizeX = AvailableSizeX - 2 * PictureSlideMarginX;
            int ImagePlaceSizeY = AvailableSizeY - 3 * PictureSlideMarginY - PictureSlideTitleSizeY;

            double RatioImage = ((double) PictureResolutionX) / ((double) PictureResolutionY);
            double RatioImagePlace = ((double) ImagePlaceSizeX) / ((double) ImagePlaceSizeY);

            int ImageBorderX = PictureSlideMarginX;
            int ImageBorderY = 2 * PictureSlideMarginY + PictureSlideTitleSizeY;
            int ImageSizeX = ImagePlaceSizeX;
            int ImageSizeY = ImagePlaceSizeY;

            if (Double.compare(RatioImage, RatioImagePlace) < 0) {

                ImageSizeX = (int) (ImageSizeY * RatioImage);
                ImageBorderX = (int) ((AvailableSizeX - ImageSizeX) / 2.0);

            } else if (Double.compare(RatioImage, RatioImagePlace) > 0) {

                ImageSizeY = (int) (ImageSizeX / RatioImage);
                ImageBorderY = 2 * PictureSlideMarginY + PictureSlideTitleSizeY + (int) ((AvailableSizeY - 2 * PictureSlideMarginY - PictureSlideTitleSizeY - ImageSizeY) / 2.0);

            }

            return new java.awt.Rectangle(InitialBorderX + ImageBorderX, InitialBorderY + ImageBorderY, ImageSizeX, ImageSizeY);

        }

        private java.awt.Rectangle getPictureTextAnchorInformation(int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            int ImagePlaceSizeX = AvailableSizeX - 2 * PictureSlideMarginX;
            int ImagePlaceSizeY = AvailableSizeY - 3 * PictureSlideMarginY - PictureSlideTitleSizeY;

            double RatioImage = ((double) PictureResolutionX) / ((double) PictureResolutionY);
            double RatioImagePlace = ((double) ImagePlaceSizeX) / ((double) ImagePlaceSizeY);

            int ImageBorderY = 2 * PictureSlideMarginY + PictureSlideTitleSizeY;
            int ImageSizeX = ImagePlaceSizeX;
            int ImageSizeY = ImagePlaceSizeY;

            if (Double.compare(RatioImage, RatioImagePlace) > 0) {

                ImageSizeY = (int) (ImageSizeX / RatioImage);
                ImageBorderY = 2 * PictureSlideMarginY + PictureSlideTitleSizeY + (int) ((AvailableSizeY - 2 * PictureSlideMarginY - PictureSlideTitleSizeY - ImageSizeY) / 2.0);

            }

            return new java.awt.Rectangle(InitialBorderX + PictureSlideMarginX, InitialBorderY + ImageBorderY - PictureSlideMarginY - PictureSlideTitleSizeY, AvailableSizeX - 2 * PictureSlideMarginX, PictureSlideTitleSizeY);

        }

        private java.awt.Rectangle getTableAnchorInformation(int InitialBorderX, int InitialBorderY, int AvailableSizeX, int AvailableSizeY) {

            return new java.awt.Rectangle(InitialBorderX + TableSlideMarginX, InitialBorderY + TableSlideMarginY, AvailableSizeX - 2 * TableSlideMarginX, AvailableSizeY - 2 * TableSlideMarginY);

        }

    }

}
