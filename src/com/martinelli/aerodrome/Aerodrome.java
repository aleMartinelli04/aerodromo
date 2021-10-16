package com.martinelli.aerodrome;

import java.util.ArrayList;
import java.util.List;

public class Aerodrome {
    private final List<Plane> planesList;

    public Aerodrome(boolean loadSamples) {
        this.planesList = new ArrayList<>();

        if (loadSamples) {
            this.planesList.add(new Aircraft("Rolladen-Schneider LS4", 900));
            this.planesList.add(new Aircraft("CVV 6 Canguro", 700));
            this.planesList.add(new Glider("Lockheed Martin F-22A Raptor", 1300));
            this.planesList.add(new Aircraft("Grob G 103 Twin Astir", 800));
            this.planesList.add(new Glider("Boeing 777-200LR", 1000));
        }
    }

    public boolean isEmpty() {
        return planesList.isEmpty();
    }

    public void insertPlane(Plane plane) {
        planesList.add(plane);
    }

    public void printPlanes() {
        if (isEmpty()) {
            System.out.println("Nessun aeroplano nella lista");
            return;
        }

        for (Plane plane : planesList) {
            plane.print();
            System.out.println();
        }
    }

    public void rapidPrint() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        for (int i = 0; i < planesList.size(); i++) {
            System.out.println((planesList.get(i).getName().equals("Aliante") ? "#" : "@") + i + ". " +
                    planesList.get(i).getAcronym());
        }
    }

    public void compare(int x1, int x2) throws IllegalStateException, IndexOutOfBoundsException, IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        if (x1 < 0 || x2 < 0 || x1 >= planesList.size() || x2 >= planesList.size()) {
            throw new IndexOutOfBoundsException();
        }

        Plane a = planesList.get(x1);
        Plane b = planesList.get(x2);

        if (!a.getName().equals(b.getName())) {
            throw new IllegalArgumentException();
        }

        if (a.getName().equals("Aliante")) {
            Glider ag = (Glider) a;
            Glider bg = (Glider) b;
            if (ag.getEfficiency() == bg.getEfficiency()) {
                System.out.println(ag.getAcronym() + " è uguale a " + bg.getAcronym());
            } else if (ag.getEfficiency() > bg.getEfficiency()) {
                System.out.println(ag.getAcronym() + " è più efficiente di " + bg.getAcronym());
            } else {
                System.out.println(ag.getAcronym() + " è meno efficiente di " + bg.getAcronym());
            }
        } else {
            Aircraft aa = (Aircraft) a;
            Aircraft ba = (Aircraft) b;
            if (aa.getPower() == ba.getPower()) {
                System.out.println(aa.getAcronym() + " è uguale a " + ba.getAcronym());
            } else if (aa.getPower() > ba.getPower()) {
                System.out.println(aa.getAcronym() + " è più potente di " + ba.getAcronym());
            } else {
                System.out.println(aa.getAcronym() + " è meno potente di " + ba.getAcronym());
            }
        }
    }
}
