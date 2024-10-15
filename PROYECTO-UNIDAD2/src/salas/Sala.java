package salas;

import peliculas.Pelicula;

import java.util.ArrayList;

public class Sala {
    public int id;
    private int capacidad = 120;
    public Pelicula pelicula; //PENDIENTE POR VER SIS SI VA AQUI
    public String[][] distribucion;
    public String tipoAsiento;

    public Sala(int id, int capacidad, Pelicula pelicula, String[][] distribucion, String tipoAsiento) {
        this.id = id;
        this.capacidad = capacidad;
        this.pelicula = pelicula;
        this.distribucion = distribucion;
        this.tipoAsiento = tipoAsiento;
    }

    public int getId() {
        return this.id;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public Pelicula getPelicula() {
        return this.pelicula;
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

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setDistribucion(String[][] distribucion) {
        this.distribucion = distribucion;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    private void llenarDistribucion() {
        distribucion = new String[11][9];
        for (int i = 0; i < 11; i++) {
            char letra = 'L'; // Inicia con la letra 'L' en cada fila
            for (int j = 0; j < 13; j++) {
                if (letra == 'L' || letra == 'K'){
                    distribucion[j][i] = letra +"V"+ Integer.toString(i+1);
                    letra--; // Incrementa la letra para la siguiente fila
                }else if(letra == 'J' || letra == 'I'){
                    distribucion[j][i] = letra + "P" + Integer.toString(i+1);
                    letra--; // Incrementa la letra para la siguiente fila
                }else{
                    distribucion[j][i] = letra + " " + Integer.toString(i+1);
                    letra--; // Incrementa la letra para la siguiente fila
                }
            }
        }
    }

    public void mostrarDistribucion() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(distribucion[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("                --------PANTALLA--------  ");
    }

}

