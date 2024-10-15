package salas;

import peliculas.Pelicula;

import java.util.ArrayList;

public class Sala {
    public int id;
    private int capacidad = 120;
    public String[][] distribucion;
    public String tipoAsiento;

    public Sala(int id, int capacidad, String[][] distribucion, String tipoAsiento) {
        this.id = id;
        this.capacidad = capacidad;
        this.distribucion = distribucion;
        this.tipoAsiento = tipoAsiento;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public String[][] getDistribucion() {
        return this.distribucion;
    }

    public String getTipoAsiento() {
        return this.tipoAsiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setDistribucion(String[][] distribucion) {
        this.distribucion = distribucion;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    private void llenarDistribucion() {
        distribucion = new String[12][10];
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

}
