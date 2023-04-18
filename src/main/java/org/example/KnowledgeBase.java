package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.*;

public class KnowledgeBase {
    private Participant participant;
    private Map<String, CoeffsForTechnology> technology;
    private Map<String, Integer> ratingVUZ;
    private final Scanner in;

    {
        in = new Scanner(System.in);
        technology = new HashMap<String, CoeffsForTechnology>() {{
            put("1", new CoeffsForTechnology(0.15, 0.3, 0, 0, 0, 0.1));
            put("2", new CoeffsForTechnology(0.3, 0.2, 0, 0, 0, 0.4));
            put("3", new CoeffsForTechnology(0.2, 0.2, 0.1, 0, 0.1, 0.3));
            put("4", new CoeffsForTechnology(0.2, 0.2, 0.1, 0, 0.1, 0.3));
            put("5", new CoeffsForTechnology(0.15, 0.3, 0.2, 0.1, 0, 0.2));
            put("6", new CoeffsForTechnology(0.15, 0.3, 0.1, 0.1, 0, 0.25));
            put("7", new CoeffsForTechnology(0.3, 0.1, 0, 0, 0.1, 0.45));
            put("8", new CoeffsForTechnology(0.25, 0.15, 0, 0, 0.05, 0.4));
            put("9", new CoeffsForTechnology(0.15, 0.3, 0.2, 0.1, 0, 0.2));
        }};

        ratingVUZ = new HashMap<String, Integer>() {{
            put("ТГУ", 1);
            put("ТПУ", 1);
            put("МГУ", 2);
            put("МФТИ", 2);
            put("НГУ", 3);
            put("ТУСУР", 3);
        }};
    }

    public KnowledgeBase(Participant participant) {
        this.participant = participant;
    }

    public void questionHowOld() {
        System.out.println("Сколько вам лет?\n" +
                "Введите число: \n");
        int age = in.nextInt();
        if (age >= 18 && age <= 20) {
            participant.changeMDTrainee(0.2);
            participant.changeMDNoob(0.1);
            participant.changeMNDJunior(0.1);
        } else {
            participant.changeMDJunior(0.2);
            participant.changeMNDNoob(0.2);
            participant.changeMNDTrainee(0.15);
        }
    }

    public void questionEducation() { //2
        System.out.println("\nКакое у вас образование?\n" +
                "Варианты ответов\n" +
                "\t1 - 9 классов\n" +
                "\t2 - 11 классов\n" +
                "\t3 - среднее спец образование\n" +
                "\t4 - высшее(бакалавр)\n" +
                "\t5 - высшее(маг)\n" +
                "\t6 - аспирант\n");
        int answer = in.nextInt();
        switch (answer) {
            case 1:
                participant.changeMDNoob(0.3);
                participant.changeMNDJunior(0.3);
                participant.changeMNDTrainee(0.2);
                break;
            case 2:
                participant.changeMDNoob(0.25);
                participant.changeMDTrainee(0.1);
                participant.changeMNDJunior(0.25);
                break;
            case 3:
                participant.changeMDTrainee(0.2);
                participant.changeMDJunior(0.1);
                participant.changeMNDNoob(0.15);
                break;
            case 4:
                participant.changeMDJunior(0.2);
                participant.changeMNDTrainee(0.1);
                participant.changeMNDNoob(0.3);
                break;
            case 5:
            case 6:
                participant.changeMDJunior(0.4);
                participant.changeMNDTrainee(0.3);
                participant.changeMNDNoob(0.5);
                break;
        }
    }


    public void questionVUZ() { //3
        System.out.println("\nГде вы учились:\n");
        in.nextLine();
        String answer = in.nextLine();
        if (ratingVUZ.containsKey(answer)) {
            int r = ratingVUZ.get(answer);
            if (r <= 2) {
                participant.changeMDJunior(0.4);
                participant.changeMNDNoob(0.3);
                participant.changeMNDTrainee(0.2);
            } else if (r == 3) {
                participant.changeMDJunior(0.15);
                participant.changeMDTrainee(0.2);
                participant.changeMNDNoob(0.25);
            } else {
                participant.changeMNDJunior(0.1);
                participant.changeMDNoob(0.2);
            }
        }
    }

    public void questionEnglish() { //4
        System.out.println("\nКак хорошо вы знаете английский?:\n" +
                "\t1 - свободно разговариваю и читаю\n" +
                "\t2 - средний уровень\n" +
                "\t3 - технический\n" +
                "\t4 - только с переводчиком\n");
        int answer = in.nextInt();
        switch (answer) {
            case 1:
                participant.changeMDJunior(0.2);
                participant.changeMDTrainee(0.2);
                break;
            case 2:
                participant.changeMDJunior(0.1);
                participant.changeMDTrainee(0.1);
                break;
            case 3:
                participant.changeMDJunior(0.25);
                participant.changeMNDNoob(0.25);
                break;
            case 4:
                participant.changeMDNoob(0.4);
                break;
        }
    }

    public void questionFaculty() { //5
        System.out.println("\nКакое у вас образование?:\n" +
                "\t1 - гуманитарное\n" +
                "\t2 - химическое/биолог\n" +
                "\t3 - экономическое\n" +
                "\t4 - инженерное\n" +
                "\t5 - профильное\n");
        int answer = in.nextInt();
        switch (answer) {
            case 1:
                participant.changeMDNoob(0.3);
                participant.changeMNDJunior(0.2);
                participant.changeMNDTrainee(0.1);
                break;
            case 2:
                participant.changeMDTrainee(0.1);
                participant.changeMDNoob(0.15);
                participant.changeMNDJunior(0.15);
                break;
            case 3:
                participant.changeMNDNoob(0.1);
                participant.changeMDTrainee(0.1);
                participant.changeMDJunior(0.05);
                break;
            case 4:
                participant.changeMDJunior(0.1);
                participant.changeMDTrainee(0.2);
                participant.changeMNDNoob(0.2);
                break;
            case 5:
                participant.changeMDJunior(0.2);
                participant.changeMDTrainee(0.2);
                participant.changeMNDNoob(0.3);
                break;
        }
    }

    public void questionExperience() { //6
        System.out.println("\nКакой у вас опыт работы?:\n" +
                "1 - 0\n" +
                "2 - меньше года\n" +
                "3 - больше года\n");
        int answer = in.nextInt();
        switch (answer) {
            case 1:
                participant.changeMDTrainee(0.2);
                participant.changeMDNoob(0.2);
                participant.changeMNDJunior(0.1);
                break;
            case 2:
                participant.changeMDJunior(0.4);
                participant.changeMNDTrainee(0.2);
                participant.changeMNDNoob(0.5);
                break;
            case 3:
                participant.changeMDJunior(0.7);
                participant.changeMNDTrainee(0.5);
                participant.changeMNDNoob(0.8);
                break;
        }
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
        in.nextLine();
        String answer = in.nextLine();
        String[] answeredTechnologies = answer.split("\\s+");
        for (String s : answeredTechnologies) {
            CoeffsForTechnology coeffs = technology.get(s);
            participant.changeMDJunior(coeffs.getCoefMDJunior());
            participant.changeMDTrainee(coeffs.getCoefMDTrainee());
            participant.changeMDNoob(coeffs.getCoefMDNoob());
            participant.changeMNDJunior(coeffs.getCoefMNDJunior());
            participant.changeMNDTrainee(coeffs.getCoefMNDTrainee());
            participant.changeMNDNoob(coeffs.getCoefMNDNoob());
        }
        if (answeredTechnologies.length < 3) {
            participant.changeMDNoob(0.6);
            participant.changeMNDJunior(0.4);
            participant.changeMNDTrainee(0.2);
        }
    }

    public void questionJavaCore() { //7
        int points = 0;
        System.out.println("1/“Для чего используется оператор NEW?”\n" +
                "\t1) Для создания новой переменной.\n" +
                "\t2) Для объявления нового класса.\n" +
                "\t3) Для создания экземпляра класса.\n" +
                "\t4) Это антагонист оператора OLD.\n");
        if (in.nextInt() == 3) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 1;
        } else {
            participant.changeMDNoob(0.5);
            participant.changeMNDJunior(0.4);
        }

        System.out.println("2/Что означает ключевое слово extends?\n" +
                "\t1)Что данный класс наследуется от другого\n" +
                "\t2)Что это дополнительный модуль класса, который расширяет его свойства.\n" +
                "\t3)Что два класса делают одно и то же.\n" +
                "\t4)Что данный класс реализует интерфейс\n");
        if (in.nextInt() == 1) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 1;
        } else {
            participant.changeMNDTrainee(0.3);
            participant.changeMDNoob(0.5);
            participant.changeMNDJunior(0.4);
        }


        System.out.println("3/Что означает перегрузка метода в Java (overload).\n" +
                "\t1) Изменение поведения метода класса относительно родительского.\n" +
                "\t2) Изменение поведения метода класса относительно дочернего.\n" +
                "\t3) Несколько методов с одинаковым названием, но разным набором параметров.\n" +
                "\t4) Несколько разных классов с одинаковым методом.\n");
        if (in.nextInt() == 3) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 1;

        } else {
            participant.changeMNDTrainee(0.3);
            participant.changeMDNoob(0.5);
            participant.changeMNDJunior(0.4);
        }


        System.out.println("4/Что означает переопределение метода в Java (override).\n" +
                "\t1) Изменение поведения метода класса относительно родительского.\n" +
                "\t2) Изменение поведения метода класса относительно дочернего.\n" +
                "\t3) Несколько методов с одинаковым названием, но разным набором параметров.\n" +
                "\t4) Несколько разных классов с одинаковым методом.\n");
        if (in.nextInt() == 1) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 1;
        } else {
            participant.changeMDNoob(0.3);
            participant.changeMNDTrainee(0.3);
            participant.changeMNDJunior(0.4);
        }


        System.out.println("5/Чем отличаются static-метод класса от обычного метода класса.\n" +
                "\t1) Поведение обычного метода класса можно изменить в классе-наследнике, а поведение static-метода нельзя.\n" +
                "\t2) Обычный метод класса можно переопределить, а static-метод нельзя.\n" +
                "\t3) Обычный метод класса работает от объекта класса, а static-метод от всего класса.\n" +
                "\t4) Static-метод класса можно вызывать только внутри класса, а обычный - в любой части кода.\n");
        if (in.nextInt() == 3) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 2;
        } else {
            participant.changeMDNoob(0.3);
            participant.changeMNDJunior(0.4);
        }

        System.out.println("6/Как вызвать static-метод внутри обычного?\n" +
                "\t1) Никак, static-метод можно вызвать только от объекта класса.\n" +
                "\t2) Можно, надо перед этим перегрузить обычный метод класса.\n" +
                "\t3) Можно, надо перед этим переопределить обычный метод класса.\n" +
                "\t4) Можно, ничего дополнительно делать не надо.\n");
        if (in.nextInt() == 4) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 2;
        } else {
            participant.changeMDNoob(0.3);
            participant.changeMNDJunior(0.4);
        }

        System.out.println("7/选择正确的陈述 Выберите правильность утверждения:\n" +
                "\t1) Абстрактный класс может не содержать ни одного абстрактного метода\n" +
                "\t2) Абстрактный класс должен содержать хотя бы один абстрактный метод\n" +
                "\t3) Абстрактный метод может иметь тело, а может не иметь\n");
        if (in.nextInt() == 1) {
            participant.changeMDJunior(0.4);
            participant.changeMDTrainee(0.2);
            participant.changeMNDNoob(0.3);
            points += 2;
        } else {
            participant.changeMDNoob(0.3);
            participant.changeMNDJunior(0.4);
        }


        if (points >= 10) {
            participant.changeMDJunior(1);
            participant.changeMNDTrainee(0.3);
            participant.changeMNDNoob(0.7);
        } else if (points >= 7) {
            participant.changeMDTrainee(1);
            participant.changeMNDJunior(0.3);
            participant.changeMDNoob(0.2);
        } else {
            participant.changeMDNoob(0.8);
            participant.changeMNDJunior(0.9);
            participant.changeMNDTrainee(0.5);
        }
    }
}
