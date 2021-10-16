package com.martinelli.aerodrome;

public class Aircraft extends Plane {
    private final int power;

    public Aircraft(String acronym, int power) {
        super(acronym, "Aeromobile");
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Potenza: " + getPower());
    }
}
