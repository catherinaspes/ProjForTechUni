package sampleLists;

import java.util.ArrayList;
import java.util.List;

public class ZerolineSampleList implements SampleList{
    List<Sample> zerolineSamplelist = new ArrayList<Sample>();

    public void addSample(Sample sample) {
        zerolineSamplelist.add(sample);
    }

    public Sample getSample(int index) {
        return zerolineSamplelist.get(index);
    }

    public int size() {
        return zerolineSamplelist.size();
    }
    @Override
    public String toString() {

        return "sampleLists.SampleList{" +
                "sampleList=" + zerolineSamplelist +
                '}';
    }
}
