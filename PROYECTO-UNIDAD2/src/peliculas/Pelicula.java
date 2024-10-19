package peliculas;

import funcion.Funcion;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Pelicula {
    public String id;
    public String titulo;
    public String gernero;
    public char clasificacion;
    public Duration duracion;
    public String sinopsis;
    public ArrayList<Funcion> listaFunciones = new ArrayList();

    Scanner sc = new Scanner(System.in);

    public Pelicula(String id, String titulo, String gernero, char clasificacion, Duration duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.gernero = gernero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }

    public String getId() {
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

    public Duration getDuracion() {
        return duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public ArrayList<Funcion> getListaFunciones() {
        return listaFunciones;
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

    public String generarIdFuncion(){
        int longitudFuncionesMasUno = this.listaFunciones.size() + 1;
        String idFuncion = String.format("F%d", longitudFuncionesMasUno);
        return idFuncion;
    }

    public String mostrarDatos() {
        long minutos = duracion.toMinutes();
        String duracionFormateada = String.format(" %s MINUTOS", minutos);
        String datos = String.format("ID: %s, NOMBRE: %s, GENERO: %s, CLASIFICACIÓN: %s, DURACIÓN: %s, SINOPSIS: %s", this.id, this.titulo, this.gernero, this.clasificacion, duracionFormateada, this.sinopsis);
        return datos;
    }

    public String mostrarTitulo() {
        String titulo = String.format("%s ", this.titulo);
        return titulo;
    }


}
