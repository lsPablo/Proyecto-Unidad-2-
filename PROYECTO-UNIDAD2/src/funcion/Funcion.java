package funcion;

import peliculas.Pelicula;
import salas.Sala;

import java.time.LocalTime;

public class Funcion {
    String id;
    Pelicula pelicula;
    Sala sala;
    LocalTime horaProyeccion;


    public Funcion(String idFuncion, Pelicula pelicula, Sala sala, LocalTime horaProyeccion) {
        this.id = idFuncion;
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

    public String getId() {
        return id;
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
        String salaEnCartelera = sala.getId();
        String cartelera = String.format("ID FUNCION: %s, HORA DE FUNCION: %s, Pelicula%s, Sala: %s", id, horaProyeccion, peliculaEnCartelera,salaEnCartelera);
        return cartelera;
    }
}
