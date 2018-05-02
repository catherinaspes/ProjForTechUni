public class KFunction {

 Double cpodT;
 Double beta;
 Double fiS;
 Double fiIsoStS;
 Double fiIsoEndS;
 Double tend;
 Double tst;
 Double fiZero;
 Double fiIsoStZero;
 Double fiIsoEndZero;
 Double t;

    public  KFunction(Double temp) {
        kFunctionComput(temp);
    }

    Double term1(){
        Double termOne =
        fiS - (fiIsoStS+((fiIsoEndS-fiIsoStS)/(tend - tst))*(t-tst));
        return termOne;
    }

    Double term2(){
        Double termTwo =
                fiZero - (fiIsoStZero+((fiIsoEndZero-fiIsoStZero)/(tend - tst))*(t-tst));
        return termTwo;
    }

    Double kFunctionComput(Double temp){

        double result = cpodT*beta/(term1()-term2());
        return result;

    }
}
