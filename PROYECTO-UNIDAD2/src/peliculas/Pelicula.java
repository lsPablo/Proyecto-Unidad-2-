package peliculas;

import java.sql.Time;
import java.time.Duration;

public class Pelicula {
    public String id;
    public String titulo;
    public String gernero;
    public char clasificacion;
    public Duration duracion;
    public String sinopsis;

    public Pelicula(String id, String titulo, String gernero, char clasificacion, Duration duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.gernero = gernero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
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

    public Duration getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setId(String id) {
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

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }



}
