import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.io.File;
import java.io.IOException;

public class CreatePlot extends ApplicationFrame {

    String title;


    public CreatePlot(final String title) {
        super(title);

    }

    public String getTitle(){
        return this.title;
    }

     void drawPlot(SampleList sampleList){
        XYSeries series = new XYSeries("wykres");
        for (int i = 0; i<sampleList.size(); i++){
            series.add(sampleList.getSample(i).getTime(),sampleList.getSample(i).getTemperature() );
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Wykres", // Title
                "x-czyli czas", // x-axis Label
                "y-czyli temperatura", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        try {
            ChartUtilities.saveChartAsJPEG(new File("D:\\chart.jpg"), chart, 500, 300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }

    }
}
