package org.example;

import java.util.Scanner;

import static java.lang.Math.*;

public class KnowledgeBase {
    private Participant participant;
    private final Scanner in;
    {
        in = new Scanner(System.in);
    }
    public KnowledgeBase(Participant participant) {
        this.participant = participant;
    }

    private double getRatingOfAge(double age) {
        return 1 / sqrt(2 * 3.14) * exp( - ((24 - age) * (24 - age)) / 2 );
    }

    public void questionHowOld() {
        System.out.println("Сколько вам лет?\n" +
                "Введите число: \n");
        int age = in.nextInt();
        double k = 0.1;// коэффициент от 0 до 1 в зависимости от того насколько важный вопрос
        double r = getRatingOfAge(age);
        participant.changeMND((1 - r) * k);
    }

    public void questionEducation() {
        System.out.println("Какое у вас образование?\n" +
                "Варианты ответов\n" +
                "1 - 9 классов\n" +
                "2 - 11 классов\n" +
                "3 - среднее спец образование\n" +
                "4 - высшее(бакалавр)\n" +
                "5 - высшее(маг)\n" +
                "6 - аспирант\n");
    }
}
