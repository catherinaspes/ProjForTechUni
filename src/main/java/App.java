import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class App extends JFrame{


  //  public static void main(String... d) {
  //     new GetData();

   // }


    public static void main(String[] args) throws IOException {


        ZerolineSampleList zerolineSampleList = new ZerolineSampleList();
        MeasurementSampleList measurementSampleList = new MeasurementSampleList();
        CalibrationSampleList calibrationSampleList = new CalibrationSampleList();


        String zerolineFilePath = "C:\\Users\\Kasia\\Desktop\\Zeroline.txt";
        String measurementFilePath = "C:\\Users\\Kasia\\Desktop\\Measurement.txt";
        String calibrationFilePath = "C:\\Users\\Kasia\\Desktop\\Calibration.txt";


        BufferedReader zerolineFileReader = null;

        try {
            zerolineFileReader = new BufferedReader(new FileReader(zerolineFilePath));

        }
        catch (IOException e) {
            System.out.println("Blad z plikiem");
            e.printStackTrace();
        }finally {
            if (zerolineFileReader != null) {
             //   zerolineFileReader.close();
            }
        }

        String zline = null;
        try {
            while ((zline = zerolineFileReader.readLine()) != null) {
                String divider[] = zline.split(";");
                Double firstParam = Double.parseDouble(divider[0]);
                Double secondParam = Double.parseDouble(divider[1]);
                Double thirdParam = Double.parseDouble(divider[2]);
                Double fourthParam = Double.parseDouble(divider[3]);
                Sample sample = new Sample(firstParam,secondParam,thirdParam,fourthParam);
                zerolineSampleList.addSample(sample);
            }
        } catch (IOException e) {
            System.out.println("Blad z wczytywaniem linii");
            e.printStackTrace();
        }

        System.out.println("Plik zeroline załadowany pomyślnie");

        BufferedReader measuementFileReader = null;

        try {
            measuementFileReader = new BufferedReader(new FileReader(measurementFilePath));

        } finally {
            if (measuementFileReader != null) {
              //  measuementFileReader.close();
            }
        }

        String mline = null;
        try {
            while ((mline = measuementFileReader.readLine()) != null) {
                String divider[] = mline.split(";");
                Double firstParam = Double.parseDouble(divider[0]);
                Double secondParam = Double.parseDouble(divider[1]);
                Double thirdParam = Double.parseDouble(divider[2]);
                Double fourthParam = Double.parseDouble(divider[3]);
                Sample sample = new Sample(firstParam,secondParam,thirdParam,fourthParam);
                measurementSampleList.addSample(sample);
            }
        } catch (IOException e) {
            System.out.println("Blad z wczytywaniem linii");
            e.printStackTrace();
        }

        System.out.println("Plik measurement załadowany pomyślnie");

        BufferedReader calibrationFileReader = null;

        try {
            calibrationFileReader = new BufferedReader(new FileReader(calibrationFilePath));

        } finally {
            if (calibrationFileReader != null) {
              //  calibrationFileReader.close();
            }
        }

        String cline = null;
        try {
            while ((cline = calibrationFileReader.readLine()) != null) {
                String divider[] = cline.split(";");
                Double firstParam = Double.parseDouble(divider[0]);
                Double secondParam = Double.parseDouble(divider[1]);
                Double thirdParam = Double.parseDouble(divider[2]);
                Double fourthParam = Double.parseDouble(divider[3]);
                Sample sample = new Sample(firstParam,secondParam,thirdParam,fourthParam);
                calibrationSampleList.addSample(sample);
            }
        } catch (IOException e) {
            System.out.println("Blad z wczytywaniem linii");
            e.printStackTrace();
        }

        System.out.println("Plik calibration załadowany pomyślnie");
        DataFromFiles dff = new DataFromFiles();
        dff.setCalibrationSampleList(calibrationSampleList);
        dff.setMeasurementSampleList(measurementSampleList);
        dff.setZerolineSampleList(zerolineSampleList);

        ProcessedSample ps = new ProcessedSample();
        KFunction kf = new KFunction();
        for(int i = 0; i<dff.getCalibrationSampleList().size()-1; i++) {

           ps = kf.process(dff.getCalibrationSampleList().getSample(i).getTemperature(),
                    dff.getCalibrationSampleList().getSample(i), dff.getZerolineSampleList().getSample(i));


            dff.processedSamples.add(ps);
            System.out.println(dff.processedSamples.get(i).getTemp() + " " + dff.processedSamples.get(i).getKodT());
        }
        System.out.println("Lista uzupelniona");


         CreatePlot cp = new CreatePlot("Temperatura od K(t)");
         cp.setFileName("WykresKodT");
         cp.setFilePath("D:\\");
         cp.setPlotTitle("wykres k od t wzgledem temperatury");
         cp.setXlabel("temp");
         cp.setYlabel("k od t");
        cp.drawPlot(dff);






    }
}


