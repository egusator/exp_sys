package org.example;



public class Participant {
    double MD;
    double MND;
    Participant () {
        MD = 0;
        MND = 0;
    }

    public void changeMD(double koef) {
        MD = MD + koef *(1-MD);
    }

    public void changeMND(double koef) {
        MND = MND + koef * (1-MND);
    }

    public double getMD() {
        return MD;
    }

    public void setMD(double MD) {
        this.MD = MD;
    }
    public double getMND() {
        return MND;
    }

    public void setMND(double MND) {
        this.MND = MND;
    }
}
