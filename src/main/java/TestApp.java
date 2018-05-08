
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestApp {

   /* public static void main(String[] args) throws IOException {


        ZerolineSampleList zerolineSampleList = new ZerolineSampleList();
        MeasurementSampleList measurementSampleList = new MeasurementSampleList();
        CalibrationSampleList calibrationSampleList = new CalibrationSampleList();


        String zerolineFilePath = "C:\\Users\\Kasia\\Desktop\\Zeroline_ZLGd-6-1400_01_R1.txt";
        String measurementFilePath = "C:\\Users\\Kasia\\Desktop\\Measurement_ZLGd-6-1400_01_R1.txt";
        String calibrationFilePath = "C:\\Users\\Kasia\\Desktop\\Calibration_ZLGd-6-1400_01_R1.txt";


        BufferedReader zerolineFileReader = null;

        try {
            zerolineFileReader = new BufferedReader(new FileReader(zerolineFilePath));

        } finally {
            if (zerolineFileReader != null) {
                zerolineFileReader.close();
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
                measuementFileReader.close();
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
                calibrationFileReader.close();
            }
        }

        String cline = null;
        try {
            while ((cline = measuementFileReader.readLine()) != null) {
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
                for(int i = 0; i<calibrationSampleList.size(); i++) {

                    kf.process(calibrationSampleList.getSample(i).getTemperature(),
                            calibrationSampleList.getSample(i), zerolineSampleList.getSample(i));

                    dff.processedSamples.add(ps);
                    System.out.println(dff.processedSamples.get(i).getTemp() + " " + dff.processedSamples.get(i).getKodT());
                }


               CreatePlot cp = new CreatePlot("Tytuł"); */









}
