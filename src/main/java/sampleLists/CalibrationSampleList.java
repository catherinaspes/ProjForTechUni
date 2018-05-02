package sampleLists;

import java.util.ArrayList;
import java.util.List;

public class CalibrationSampleList implements SampleList {

    List<Sample> calibrationSampleList = new ArrayList<Sample>();

    public void addSample(Sample sample) {
        calibrationSampleList.add(sample);
    }

    public Sample getSample(int index) {
        return calibrationSampleList.get(index);
    }

    public int size() {
        return calibrationSampleList.size();
    }
    @Override
    public String toString() {

        return "sampleLists.SampleList{" +
                "sampleList=" + calibrationSampleList +
                '}';
    }
}



