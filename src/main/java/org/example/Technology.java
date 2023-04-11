package org.example;

public class Technology {
    private int number;
    private String name;
    private double rating;

    public Technology(int number, String name, double rating) {
        this.number = number;
        this.name = name;
        this.rating = rating;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
