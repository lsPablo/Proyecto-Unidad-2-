package cine;

import peliculas.Pelicula;

import java.util.Scanner;

public class ValidadorCine {
    public Cine cine = new Cine();
    Scanner sc = new Scanner(System.in);

    public void validadorPeliculaId() {
        System.out.println("Ingresa el ID de la Pelicula");
        String idPelicula = sc.nextLine();
        boolean peliculaEncontrada = false;

        for (Pelicula pelicula : this.cine.listaPeliculas) {
            if (pelicula.getId().equals(idPelicula)) {
                peliculaEncontrada = true;
                break;
            }
        }

        if (!peliculaEncontrada) {
            System.out.println("El ID de la pelicula no existe");
        }
    }
}
