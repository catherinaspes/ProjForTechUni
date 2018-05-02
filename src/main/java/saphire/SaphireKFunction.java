package saphire;

public class SaphireKFunction {

    double cp;
    double beta;
    double term1;
    double term2;

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getTerm1() {
        return term1;
    }

    public void setTerm1(double term1) {
        this.term1 = term1;
    }

    public double getTerm2() {
        return term2;
    }

    public void setTerm2(double term2) {
        this.term2 = term2;
    }

    public SaphireKFunction(double temp) {
        computeSaphireKFunction(temp);

    }

    double computeSaphireKFunction(double temp){

        SaphireCp sf = new SaphireCp();
       // ConstValues cv = new ConstValues();

        cp = sf.cpOdJprzezmgK(temp);

        double result = (cp*beta*84.8)/(term1-term2);
        return result;

    }


}
