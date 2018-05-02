import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import sampleLists.SampleList;

import java.io.File;
import java.io.IOException;

public class CreatePlot extends ApplicationFrame {

    String title;
    String plotTitle;
    String xlabel;
    String ylabel;
    String filePath;
    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlotTitle() {
        return plotTitle;
    }

    public void setPlotTitle(String plotTitle) {
        this.plotTitle = plotTitle;
    }

    public String getXlabel() {
        return xlabel;
    }

    public void setXlabel(String xlabel) {
        this.xlabel = xlabel;
    }

    public String getYlabel() {
        return ylabel;
    }

    public void setYlabel(String ylabel) {
        this.ylabel = ylabel;
    }

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
                getPlotTitle(), // Title
                getXlabel(), // x-axis Label
                getYlabel(), // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        try {
            ChartUtilities.saveChartAsJPEG(new File(getFilePath()+getFileName()+".jpg"), chart, 500, 300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }

    }
}
