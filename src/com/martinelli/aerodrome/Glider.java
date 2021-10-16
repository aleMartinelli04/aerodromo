package com.martinelli.aerodrome;

public class Glider extends Plane {
    private final int efficiency;

    public Glider(String acronym, int efficiency) {
        super(acronym, "Aliante");
        this.efficiency = efficiency;
    }

    public int getEfficiency() {
        return this.efficiency;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Efficienza: " + getEfficiency());
    }
}
