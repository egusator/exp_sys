package org.example;


public class Main {
    public static void main(String[] args) {
        Participant p = new Participant();
        KnowledgeBase e = new KnowledgeBase(p);
        e.questionHowOld();
        e.questionEducation();
        e.questionVUZ();
        e.questionEnglish();
        e.questionFaculty();
        e.questionExperience();
        e.questionTenTechnologies();
        e.questionJavaCore();

        if (p.getKUJunior() > p.getKUNoob() && p.getKUJunior() > p.getKUTrainee()) {
            System.out.println("Поздравляем! Вы нам подходите. ");
        } else if (p.getKUTrainee() > p.getKUNoob() && p.getKUTrainee() > p.getKUJunior()) {
            System.out.println("Прямо сейчас мы не можем предоставить вам работу на позиции Junior, но мы готовы предложить вам стажировку");
        } else {
            System.out.println("Спасибо за прохождение собеседования. Мы вам обязательно перезвоним!");
        }
        /*
        System.out.println(p.getKUJunior());
        System.out.println(p.getKUTrainee());
        System.out.println(p.getKUNoob());
        */
    }
}