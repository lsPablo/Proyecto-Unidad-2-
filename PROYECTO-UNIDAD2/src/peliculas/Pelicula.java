package peliculas;

import salas.Sala;

import java.sql.Time;

public class Pelicula {
    public int id;
    public String titulo;
    public String gernero;
    public char clasificacion;
    public Time duracion;
    public String sinopsis;
    public Sala sala;

    public Pelicula(int id, String titulo, String gernero, char clasificacion, Time duracion, String sinopsis, Sala sala) {
        this.id = id;
        this.titulo = titulo;
        this.gernero = gernero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGernero() {
        return gernero;
    }

    public char getClasificacion() {
        return clasificacion;
    }

    public Time getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public Sala getSala() {
        return sala;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGernero(String gernero) {
        this.gernero = gernero;
    }

    public void setClasificacion(char clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
