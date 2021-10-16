package com.martinelli.aerodrome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aerodrome aerodrome = new Aerodrome(true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInserisci scelta: ");
            System.out.println(" 1. Inserisci aereo");
            System.out.println(" 2. Stampa aerei");
            System.out.println(" 3. Confronta due aerei");
            System.out.println(" 0. Esci");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Inserisci sigla: ");
                    String acronym = scanner.nextLine();

                    int type;

                    while (true) {
                        System.out.println("Inserisci tipo (1: aliante/2: aeromobile)");

                        if (!scanner.hasNextInt()) {
                            scanner.nextLine();
                            continue;
                        }

                        type = scanner.nextInt();

                        if (type != 1 && type != 2) {
                            continue;
                        }

                        break;
                    }

                    if (type == 1) {
                        Glider glider;
                        while (true) {
                            System.out.println("Inserisci efficienza:");

                            if (!scanner.hasNextInt()) {
                                scanner.nextLine();
                                continue;
                            }

                            glider = new Glider(acronym, scanner.nextInt());
                            aerodrome.insertPlane(glider);

                            break;
                        }
                    } else {
                        Aircraft aircraft;
                        while (true) {
                            System.out.println("Inserisci potenza:");

                            if (!scanner.hasNextInt()) {
                                scanner.nextLine();
                                continue;
                            }

                            aircraft = new Aircraft(acronym, scanner.nextInt());
                            aerodrome.insertPlane(aircraft);

                            break;
                        }
                    }

                    System.out.println("Aereo inserito con successo!");

                    break;

                case 2:
                    aerodrome.printPlanes();
                    break;

                case 3:
                    try {
                        aerodrome.rapidPrint();
                    } catch (IllegalStateException e) {
                        System.out.println("Nessun aeroplano nella lista");
                        break;
                    }

                    int[] x = new int[2];

                    for (int i = 0; i < x.length; i++) {
                        while (true) {
                            System.out.println("Inserisci numero " + (i == 0 ? "primo" : "secondo") + " aereo:");

                            if (!scanner.hasNextInt()) {
                                scanner.nextLine();
                                continue;
                            }

                            x[i] = scanner.nextInt();
                            break;
                        }
                    }

                    try {
                        aerodrome.compare(x[0], x[1]);
                    } catch (IllegalStateException e) {
                        System.out.println("Lista di aerei vuota");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Valori inseriti non validi");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Impossibile confrontare un Aliante e un Aeromobile");
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}
