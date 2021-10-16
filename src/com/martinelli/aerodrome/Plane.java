package com.martinelli.aerodrome;

public abstract class Plane {
    private final String acronym;
    private final String name;

    public Plane(String acronym, String name) {
        this.acronym = acronym;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void print() {
        System.out.println("Tipo: " + getName());
        System.out.println("Sigla: " + getAcronym());
    }
}
