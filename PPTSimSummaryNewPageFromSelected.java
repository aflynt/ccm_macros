// PPTSimSummaryNewPageFromSelected.java - v1.0 - Flavio Cimolin, 05/07/2019
// -------------------------------------------------------------------------
// Complementary macro for "PPTSimSummaryGeneration.java", to be used for quick
// page definition for the PPT pages.
// User just needs to select in the Simulation Tree nodes of type:
//   - Scene
//   - Plot
//   - Report
// The macro will simply create a new Summary containing the selection in the
// correct order.
// If it finds already existing entries satisfying the pattern, the macro will
// progressively create new pages with a proper enumeration.
//
package macro;

import org.openide.nodes.*;
import org.openide.windows.*;
import star.base.report.ui.*;
import star.common.*;
import star.common.ui.*;
import star.summary.*;
import star.vis.ui.*;

public class PPTSimSummaryNewPageFromSelected extends StarMacro {

    public static final String PagePattern = "PPT_Page";

    @Override
    public void execute() {

        Simulation sim = getActiveSimulation();

        //Get the selected nodes from the TopComponent
        Node nodes[];
        nodes = TopComponent.getRegistry().getActivatedNodes();

        // Exit if nothing is selected
        if (nodes.length == 0) {
            sim.println("No selected node in the tree. Please select Scenes, Plots or Reports.");
            return;
        }

        // Check if user selected at least one Scene, Plot or Report
        boolean check = false;
        for (Node node : nodes) {
            if ((node instanceof SceneNode) || (node instanceof StarPlotNode) || (node instanceof ReportNode)) {
                check = true;
                break;
            }
        }
        if (!check) {
            sim.println("Please select Scenes, Plots or Reports.");
            return;
        }

        // Check which is the last page in the current Summary
        int LastPageFound = 0;
        for (SimulationSummary ss : sim.get(SimulationSummaryManager.class).getObjects()) {
            if (ss.getPresentationName().startsWith(PagePattern)) {

                int PageFound = Integer.parseInt(ss.getPresentationName().substring(PagePattern.length()));

                if (PageFound > LastPageFound) {
                    LastPageFound = PageFound;
                }

            }
        }
        if (LastPageFound == 0) {
            sim.println("No PPT page found in current Summary.");
        } else {
            sim.println("Last PPT page found in current Summary: " + LastPageFound);
        }

        // Create new Summary
        SimulationSummary ss = sim.get(SimulationSummaryManager.class).createSimulationSummary();
        ss.setPresentationName(PagePattern + (LastPageFound + 1));

        sim.println("Created PPT page Summary: " + ss);

        // Sweep over selected nodes and add them to the Summary
        sim.println("Nodes added to Summary:");
        for (Node node : nodes) {

            if (node instanceof SceneNode) {
                sim.println("  Scene: " + node.getName());
                ss.getChildElementsManager().createObjectSummary(((SceneNode) node).getScene());
            }
            if (node instanceof StarPlotNode) {
                sim.println("  Plot: " + node.getName());
                ss.getChildElementsManager().createObjectSummary(((StarPlotNode) node).getPlot());
            }
            if (node instanceof ReportNode) {
                sim.println("  Report: " + node.getName());
                ss.getChildElementsManager().createObjectSummary(((ReportNode) node).getReport());
            }

        }
    }
}
