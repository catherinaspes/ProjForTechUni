
public class SaphireCp{

    public SaphireCp(double temp) {
        cpOdJprzezmgK(temp);
    }

    public double cpODjPRZEZmolRAZYk(double temp){
            LowTempSaphireCp lt = new LowTempSaphireCp();
            HighTempSaphireCp ht = new HighTempSaphireCp();
            double result;
            if(temp<900){

                result = lt.la1 + lt.la2*temp+(lt.la3/Math.pow(temp, 2))+
                        lt.la4*Math.pow(temp, 3)
                        +lt.la5*Math.pow(temp,4)+lt.la6*Math.pow(temp, 5)
                        +lt.la7*Math.pow(temp, 6)+lt.la8*Math.pow(temp,7);


            } else {
                result= ht.ha1 + ht.ha2*temp + (ht.ha3 / Math.pow(temp, 2))+
                        ht.ha4 * Math.pow(temp, 3)
                        + ht.ha5 * Math.pow(temp, 4) + ht.ha6 * Math.pow(temp, 5)
                        + ht.ha7 * Math.pow(temp, 6) + ht.ha8 * Math.pow(temp, 7);
            }
            return result;

        }

        public double cpOdJprzezmgK(double temp){
            double result = cpODjPRZEZmolRAZYk(temp)/(1000*101.9613);
            return result;
        }


}
