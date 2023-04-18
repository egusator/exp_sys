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
        System.out.println(p.getKUJunior());
        System.out.println(p.getKUTrainee());
        System.out.println(p.getKUNoob());

    }
}