package funcion;

import peliculas.Pelicula;
import salas.Sala;

import java.time.LocalTime;

public class Funcion {
    String id;
    Sala sala;
    LocalTime horaProyeccion;


    public Funcion(String idFuncion, Sala sala, LocalTime horaProyeccion) {
        this.id = idFuncion;
        this.sala = sala;
        this.horaProyeccion = horaProyeccion;
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

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setHoraProyeccion(LocalTime horaProyeccion) {
        this.horaProyeccion = horaProyeccion;
    }

    public String mostrarCartelera() {
        String salaEnCartelera = sala.getId();
        String cartelera = String.format("ID FUNCION: %s, HORA DE FUNCION: %s, Sala: %s", id, horaProyeccion,salaEnCartelera);
        return cartelera;
    }
}
