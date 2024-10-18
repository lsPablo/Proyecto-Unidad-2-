package cine;

import peliculas.Pelicula;

import java.util.Scanner;

public class ValidadorCine {
    public Cine cine = new Cine();
    Scanner sc = new Scanner(System.in);

    public Pelicula validadorPeliculaId() {
        System.out.println("Ingresa el titulo de la Pelicula");
        String tituloPelicula = sc.nextLine();
        boolean peliculaEncontrada = false;

        for (Pelicula pelicula : this.cine.listaPeliculas) {
            if (pelicula.getId().equals(tituloPelicula)) {
                peliculaEncontrada = true;
                return pelicula;
            }
        }

        if (!peliculaEncontrada) {
            System.out.println("La pelicula ingresada no existe");
        }
    }
}
