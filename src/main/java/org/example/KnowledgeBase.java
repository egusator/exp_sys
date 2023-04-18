package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.*;

public class KnowledgeBase {
    private Participant participant;
    private Map<String, CoeffsForTechnology> technology;
    private final Scanner in;
    {
        in = new Scanner(System.in);
        technology = new HashMap<String, CoeffsForTechnology>() {{
            put("1" , new CoeffsForTechnology(0.9, 0.9, 0.9, 0.2, 0.1, 0.1));
            put("2" , new CoeffsForTechnology(0.9, 0.7, 0.2, 0.1, 0.15, 0.5));
            put("3" , new CoeffsForTechnology(0.9, 0.5, 0.1, 0.1, 0.3, 0.8));
            put("4" , new CoeffsForTechnology(0.8, 0.8, 0.1, 0.2, 0.15, 0.7));
            put("5" , new CoeffsForTechnology(0.3, 0.5, 0.8, 0.8, 0.4, 0.3));
            put("6" , new CoeffsForTechnology(0.4, 0.65, 0.7, 0.7, 0.3, 0.5));
            put("7" , new CoeffsForTechnology(0.9, 0.6, 0.2, 0.1, 0.4, 0.7));
            put("8" , new CoeffsForTechnology(0.6, 0.9, 0.2, 0.4, 0.1, 0.7));
            put("9" , new CoeffsForTechnology(0.4, 0.6, 0.6, 0.6, 0.4, 0.3));
        }};
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
        participant.changeMNDJunior((1 - r) * k);
    }

    public void questionEducation() { //2
        System.out.println("Какое у вас образование?\n" +
                "Варианты ответов\n" +
                "1 - 9 классов\n" +
                "2 - 11 классов\n" +
                "3 - среднее спец образование\n" +
                "4 - высшее(бакалавр)\n" +
                "5 - высшее(маг)\n" +
                "6 - аспирант\n");
    }


    public void questionVUZ() { //3
        System.out.println("Где вы учились:");
    }

    public void questionEnglish() { //4
        System.out.println("Как хорошо вы знаете английский:\n" +
                "1 - свободно разговариваю и читаю\n" +
                "2 - технический\n" +
                "3 - нормик\n" +
                "4 - очень плохо\n" +
                "5 - только с переводчиком\n");
    }

    public void questionFaculty() { //5
        System.out.println("На каком факультете вы учились?:\n" +
                "1 - гуманитарное\n" +
                "2 - химическое/биолог\n" +
                "3 - экономическое\n" +
                "4 - инженерное\n" +
                "5 - профильное\n");
    }

    public void questionExperience() { //6
        System.out.println("Какой у вас опыт работы?:\n" +
                "1 - гуманитарное\n" +
                "2 - химическое/биолог\n" +
                "3 - экономическое\n" +
                "4 - инженерное\n" +
                "5 - профильное\n");
    }

    public void questionTenTechnologies() {//7
        System.out.println("\nВыделите 1-10 технологий, которые вы последние использовали в своих проектах\n" +
                "(Выпишите цифры): " +
                "\t1 - Java\n" +
                "\t2 - SpringBoot\n" +
                "\t3 - PostgreSQL\n" +
                "\t4 - MYSQL\n" +
                "\t5 - Python\n" +
                "\t6 - C#\n" +
                "\t7 - Hibernate\n" +
                "\t8 - Spring JDBC\n" +
                "\t9 - C++\n");
        String answer = in.nextLine();
        String[] answeredTechnologies = answer.split("\\s+");
        for(String s: answeredTechnologies) {
            CoeffsForTechnology coeffs = technology.get(s);
            participant.changeMDJunior(coeffs.getCoefMDJunior());
            participant.changeMDTrainee(coeffs.getCoefMDTrainee());
            participant.changeMDNoob(coeffs.getCoefMDNoob());
            participant.changeMNDJunior(coeffs.getCoefMNDJunior());
            participant.changeMNDTrainee(coeffs.getCoefMNDTrainee());
            participant.changeMNDNoob(coeffs.getCoefMNDNoob());
        }

    }

    public void questionJavaCore() { //7
        int numOfCurrAnswers = 0;
        int numOfAnswers = 10;
        System.out.println("1/“Для чего используется оператор NEW?”\n" +
                "\t1) Для создания новой переменной.\n" +
                "\t2) Для объявления нового класса.\n" +
                "\t3) Для создания экземпляра класса.\n" +
                "\t4) Это антагонист оператора OLD.\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;

        System.out.println("2/Что означает ключевое слово extends?\n" +
                "\t1)Что данный класс наследуется от другого\n" +
                "\t2)Что это дополнительный модуль класса, который расширяет его свойства.\n" +
                "\t3) Что два класса делают одно и то же.\n" +
                "\t4)Что данный класс реализует интерфейс\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;

        System.out.println("3/Что означает перегрузка метода в Java (overload).\n" +
                "   \t1) Изменение поведения метода класса относительно родительского.\n" +
                "\t2) Изменение поведения метода класса относительно дочернего.\n" +
                "\t3) Несколько методов с одинаковым названием, но разным набором параметров.\n" +
                "\t4) \n" +
                "Несколько разных классов с одинаковым методом.\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;

        System.out.println("4/Что означает переопределение метода в Java (override).\n" +
                "\t1) Изменение поведения метода класса относительно родительского.\n" +
                "\t2) Изменение поведения метода класса относительно дочернего.\n" +
                "\n" +
                "\t3) Несколько методов с одинаковым названием, но разным набором параметров.\n" +
                "\t4) Несколько разных классов с одинаковым методом.\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;

        System.out.println("5/Чем отличаются static-метод класса от обычного метода класса.\n" +
                "\t1) Поведение обычного метода класса можно изменить в классе-наследнике, а поведение static-метода нельзя.\n" +
                "\t2) Обычный метод класса можно переопределить, а static-метод нельзя.\n" +
                "\t3) Обычный метод класса работает от объекта класса, а static-метод от всего класса.\n" +
                "\t4) Static-метод класса можно вызывать только внутри класса, а обычный - в любой части кода.\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;


        System.out.println("6/Как вызвать static-метод внутри обычного?\n" +
                "\t1) Никак, static-метод можно вызвать только от объекта класса.\n" +
                "\t2) Можно, надо перед этим перегрузить обычный метод класса.\n" +
                "\t3) Можно, надо перед этим переопределить обычный метод класса.\n" +
                "\t4) Можно, ничего дополнительно делать не надо.\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;

        System.out.println("7/Выберите верные утверждения:\n" +
                "\t1) Абстрактный класс может не содержать ни одного абстрактного метода\n" +
                "\tЭтот ответ также является верным.\n" +
                "\tАбстрактный класс должен содержать хотя бы один абстрактный метод\n" +
                "\tАбстрактный метод может иметь тело, а может не иметь\n" +
                "\tМетоды в интерфейсе могут иметь тело, а могут не иметь\n");
        if (in.nextInt() == 3) numOfCurrAnswers++;


        double k = numOfCurrAnswers/numOfAnswers;
    }

}
