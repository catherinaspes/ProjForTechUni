public class KFunction {

    DaneTestoweWpisaneNaSztywno cv = new DaneTestoweWpisaneNaSztywno();
    DataFromFiles dff = new DataFromFiles();

 Double cpodT;
 Double beta;

 Double fiIsoStS;
 Double fiIsoEndS;
 Double tend;
 Double tst;
 Double fiZero;
 Double fiIsoStZero;
 Double fiIsoEndZero;
 Double t;



    public  KFunction() {

    }


    public Double getCpodT(double temp) {
       SaphireCp saphireCp = new SaphireCp(temp);
       double result = saphireCp.cpOdJprzezmgK(temp);
        return result;
    }

    public Double getBeta() {
        return cv.getBeta();
    }

    public Double getFiIsoStS() {
        return cv.getIsoStS();
    }

    public Double getFiIsoEndS() {
        return cv.getIsoStEndS();
    }

    public Double getTend() {
        return  cv.getTend();
    }

    public Double getTst() {
        return cv.getTst();
    }

    public Double getFiZero() {
        return fiZero;
    }

    public Double getFiIsoStZero() {
        return cv.getIsoStZero();
    }

    public Double getFiIsoEndZero() {
        return cv.getIsoEndZero();
    }

    public Double getT() {
        return t;
    }

    Double term1(Sample sample){
        Double termOne =
        sample.getDsc() - (getFiIsoStS()+((getFiIsoEndS()-getFiIsoStS())/(getTend() - getTst()))*(sample.getTime()-getTst()));
        return termOne;
    }

    Double term2(Sample sample){
        Double termTwo = sample.getDsc() - (getFiIsoStZero()+((getFiIsoEndZero()-getFiIsoStZero())/(getTend() - getTst()))*(sample.getTime()-getTst()));
        return termTwo;
    }

    ProcessedSample process(Double temp, Sample sampleCal, Sample sampleZero){

        ProcessedSample result = new ProcessedSample();

        result.temp = temp;
        result.tempCal = sampleCal.getTemperature();
        result.tempZero = sampleZero.getTemperature();
        result.term1 = term1(sampleCal);
        result.term2 = term2(sampleZero);
        result.kodT=  getCpodT(temp)*getBeta()/result.term1-result.term2;
        return result;
    }


}
