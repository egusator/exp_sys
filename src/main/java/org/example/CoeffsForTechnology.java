package org.example;

public class CoeffsForTechnology {
    private double coefMDJunior;
    private double coefMNDJunior;
    private double coefMDTrainee;
    private double coefMNDTrainee;
    private double coefMDNoob;
    private double coefMNDNoob;

    public double getCoefMDJunior() {
        return coefMDJunior;
    }

    public void setCoefMDJunior(double coefMDJunior) {
        this.coefMDJunior = coefMDJunior;
    }

    public double getCoefMNDJunior() {
        return coefMNDJunior;
    }

    public void setCoefMNDJunior(double coefMNDJunior) {
        this.coefMNDJunior = coefMNDJunior;
    }

    public double getCoefMDTrainee() {
        return coefMDTrainee;
    }

    public void setCoefMDTrainee(double coefMDTrainee) {
        this.coefMDTrainee = coefMDTrainee;
    }

    public double getCoefMNDTrainee() {
        return coefMNDTrainee;
    }

    public void setCoefMNDTrainee(double coefMNDTrainee) {
        this.coefMNDTrainee = coefMNDTrainee;
    }

    public double getCoefMDNoob() {
        return coefMDNoob;
    }

    public void setCoefMDNoob(double coefMDNoob) {
        this.coefMDNoob = coefMDNoob;
    }

    public double getCoefMNDNoob() {
        return coefMNDNoob;
    }

    public void setCoefMNDNoob(double coefMNDNoob) {
        this.coefMNDNoob = coefMNDNoob;
    }

    public CoeffsForTechnology(double coefMDJunior, double coefMDTrainee, double coefMDNoob, double coefMNDJunior,  double coefMNDTrainee, double coefMNDNoob) {
        this.coefMDJunior = coefMDJunior;
        this.coefMNDJunior = coefMNDJunior;
        this.coefMDTrainee = coefMDTrainee;
        this.coefMNDTrainee = coefMNDTrainee;
        this.coefMDNoob = coefMDNoob;
        this.coefMNDNoob = coefMNDNoob;
    }
}
