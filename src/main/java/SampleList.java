import java.util.ArrayList;
import java.util.List;

public class SampleList {

    List<Sample> sampleList = new ArrayList<Sample>();

    void addSample(Sample sample){
        sampleList.add(sample);
    }

    Sample getSample(int index){
        return sampleList.get(index);
    }

    @Override
    public String toString() {

        return "SampleList{" +
                "sampleList=" + sampleList +
                '}';
    }
}
