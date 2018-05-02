package sampleLists;

import java.util.ArrayList;
import java.util.List;

public interface SampleList {



    List<Sample> sampleList = new ArrayList<Sample>();

    void addSample(Sample sample);

    Sample getSample(int index);

    public int size();

    @Override
    public String toString();
}
