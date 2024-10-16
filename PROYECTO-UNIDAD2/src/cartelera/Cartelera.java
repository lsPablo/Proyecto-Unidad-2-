package cartelera;

import peliculas.Pelicula;
import salas.Sala;

import java.time.LocalTime;

public class Cartelera {
    Pelicula pelicula;
    Sala sala;
    LocalTime horaProyeccion;

    public Cartelera(Pelicula pelicula, Sala sala, LocalTime horaProyeccion) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horaProyeccion = horaProyeccion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalTime getHoraProyeccion() {
        return horaProyeccion;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setHoraProyeccion(LocalTime horaProyeccion) {
        this.horaProyeccion = horaProyeccion;
    }

    public String mostrarCartelera() {
        String peliculaEnCartelera = pelicula.mostrarDatos();
        String salaEnCarteñera = sala.getId();
        String cartelera = String.format("HORA DE FUNCION: %s, Pelicula%s, Sala: %s", horaProyeccion, peliculaEnCartelera,salaEnCarteñera);
        return cartelera;
    }
}
