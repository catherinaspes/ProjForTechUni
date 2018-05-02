package sampleLists;

import java.util.ArrayList;
import java.util.List;

public class MeasurementSampleList implements SampleList{

    List<Sample> measaurementSampleList = new ArrayList<Sample>();

    public void addSample(Sample sample) {
        measaurementSampleList.add(sample);
    }

    public Sample getSample(int index) {
        return measaurementSampleList.get(index);
    }

    public int size() {
        return measaurementSampleList.size();
    }
    @Override
    public String toString() {

        return "sampleLists.SampleList{" +
                "sampleList=" + measaurementSampleList +
                '}';
    }
}
