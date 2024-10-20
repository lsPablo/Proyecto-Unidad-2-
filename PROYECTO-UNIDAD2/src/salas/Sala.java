package salas;

import funcion.Funcion;
import peliculas.Pelicula;

import java.util.ArrayList;

public class Sala {
    public String id;
    private static String[][] distribucion = new String [12][10];
    public ArrayList<Funcion> listaFunciones;

    static {
        llenarDistribucion();
    }

    public Sala(String id) {
        this.id = id;
        this.listaFunciones = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Funcion> getListaFunciones() {
        return listaFunciones;
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
        Double precioAsiento = 0.00, totalAsiento = 0.00;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                if (distribucion[i][j].equals(asiento)) {
                    if (distribucion[i][j].equals("LV" + (j+1))  || distribucion[i][j].equals("kV" + (j+1)) ) {
                        if (!distribucion[i][j].equals("X")) {
                            precioAsiento = 400.00;
                            distribucion[i][j] = "X";
                        } else {
                            System.out.println("Asiento ya reservado.");
                        }
                    } else if (distribucion[i][j].equals("JP" + (j+1))  || distribucion[i][j].equals("IP" + (j+1))) {
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
                    totalAsiento = precioAsiento + totalAsiento;
                    return totalAsiento;
                }
            }
        }
        System.out.println("Asiento no encontrado.");
        return null;
    }




}

