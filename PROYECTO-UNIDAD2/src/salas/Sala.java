package salas;

import peliculas.Pelicula;

import java.util.ArrayList;

public class Sala {
    public String id;
    private static String[][] distribucion = new String [12][10];

    static {
        llenarDistribucion();
    }

    public Sala(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void llenarDistribucion() {
        for (int i = 0; i < 10; i++) {
            char letra = 'L'; // Inicia con la letra 'L'
            for (int j = 0; j < 12; j++) {
                if (letra == 'L' || letra == 'K') {
                    distribucion[j][i] = letra + "V" + (i + 1);
                } else if (letra == 'J' || letra == 'I') {
                    distribucion[j][i] = letra + "P" + (i + 1);
                } else {
                    distribucion[j][i] = letra + " " + (i + 1);
                }
                letra--; // Decrementa la letra después de su uso
            }
        }
    }

    public void mostrarDistribucion() {
        for (int i = 0; i < 12; i++) { // Corrige el rango a 11
            for (int j = 0; j < 10; j++) { // Corrige el rango a 9
                System.out.print(distribucion[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("                --------PANTALLA--------  ");
    }

    public Double reservarAsiento(String asiento) {
        Double precioAsiento = 0.0, totalAsiento = 0.0;
        for (int i = 0; i < distribucion.length; i++) {
            for (int j = 0; j < distribucion[i].length; j++) {
                if (distribucion[i][j].equals(asiento)) {
                    if (distribucion[i][j].toLowerCase().charAt(0) == 'V') {
                        if (!distribucion[i][j].equals("X")) {
                            precioAsiento = 400.00;
                            distribucion[i][j] = "X";
                        } else {
                            System.out.println("Asiento ya reservado.");
                        }
                    } else if (distribucion[i][j].toLowerCase().charAt(0) == 'P') {
                        if (!distribucion[i][j].equals("X")) {
                            precioAsiento = 200.00;
                            distribucion[i][j] = "X";
                        } else {
                            System.out.println("Asiento ya reservado.");
                        }
                    }else{
                        if (!distribucion[i][j].equals("X")) {
                            precioAsiento = 75.00;
                            distribucion[i][j] = "X";
                        } else {
                            System.out.println("Asiento ya reservado.");
                        }
                    }
                }
                totalAsiento = precioAsiento + totalAsiento;
            }
            return totalAsiento;
        }
        System.out.println("Asiento no encontrado.");
        return null;
    }



}

