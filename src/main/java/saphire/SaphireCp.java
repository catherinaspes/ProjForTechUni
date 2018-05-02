package saphire;

import static saphire.HighTempSaphireCp.*;
import static saphire.LowTempSaphireCp.*;

public class SaphireCp{


        public double cpODjPRZEZmolRAZYk(double temp){
            double result;
            if(temp<900){

                result = la1 + la2*temp+(la3/Math.pow(temp, 2))+
                        la4*Math.pow(temp, 3)
                        +la5*Math.pow(temp,4)+la6*Math.pow(temp, 5)
                        +la7*Math.pow(temp, 6)+la8*Math.pow(temp,7);


            } else {
                result= ha1 + ha2*temp + (ha3 / Math.pow(temp, 2))+
                        ha4 * Math.pow(temp, 3)
                        + ha5 * Math.pow(temp, 4) + ha6 * Math.pow(temp, 5)
                        + ha7 * Math.pow(temp, 6) + ha8 * Math.pow(temp, 7);
            }
            return result;

        }

        public double cpOdJprzezmgK(double temp){
            double result = cpODjPRZEZmolRAZYk(temp)/(1000*101.9613);
            return result;
        }













}
