package org.example;



public class Participant {
    double MDJunior;
    double MNDJunior;
    double MDTrainee;
    double MNDTrainee;

    double MDNoob;
    double MNDNoob;
    Participant () {
        MDJunior = 0;
        MNDJunior = 0;
        MDTrainee = 0;
        MNDTrainee = 0;
        MDNoob = 0;
        MNDNoob = 0;
    }

    public void changeMDJunior(double koef) {
        MDJunior = MDJunior + koef * (1 - MDJunior);

    }

    public void changeMNDJunior(double koef) {
        MNDJunior = MNDJunior + koef * (1 - MNDJunior);
    }
    public void changeMDTrainee(double koef) {
        MDTrainee = MDTrainee + koef * (1 - MDTrainee);

    }

    public void changeMNDTrainee(double koef) {
        MNDTrainee = MNDTrainee + koef * (1 - MNDTrainee);
    }
    public void changeMDNoob(double koef) {
        MDNoob = MDNoob + koef * (1 - MDNoob);

    }

    public void changeMNDNoob(double koef) {
        MNDNoob = MNDNoob + koef * (1 - MNDNoob);
    }

}
