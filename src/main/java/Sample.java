
public class Sample {

    private Double temperature;
    private Double time;
    private Double dsc;
    private Double sensit;

    public Sample(Double temperature, Double time, Double dsc, Double sensit) {
        this.temperature = temperature;
        this.time = time;
        this.dsc = dsc;
        this.sensit = sensit;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature+273;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getDsc() {
        return dsc;
    }

    public void setDsc(Double dsc) {
        this.dsc = dsc;
    }

    public Double getSensit() {
        return sensit;
    }

    public void setSensit(Double sensit) {
        this.sensit = sensit;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "temperature=" + temperature +
                ", time=" + time +
                ", dsc=" + dsc +
                ", sensit=" + sensit +
                '}';
    }
}
