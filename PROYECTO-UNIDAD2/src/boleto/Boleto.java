package boleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class Boleto {
    public String id;
    public String tituloPelicula;
    public String sala;
    public String asiento;
    public LocalTime horaFuncion;
    public Double precioBoleto;


    public Boleto(String id, String tituloPelicula, String sala, String asiento, LocalTime horaFuncion, Double precioBoleto) {
        this.id = id;
        this.tituloPelicula = tituloPelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.horaFuncion = horaFuncion;
        this.precioBoleto = precioBoleto;

    }

    public String getId() {
        return id;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public String getSala() {
        return sala;
    }

    public String getAsiento() {
        return asiento;
    }

    public LocalTime getHoraFuncion() {
        return horaFuncion;
    }

    public Double getPrecioBoleto() {
        return precioBoleto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public void setHoraFuncion(LocalTime horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public void setPrecioBoleto(Double precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public String generarIdBoleto(){
        Random random = new Random();
        int AnioActual = LocalDate.now().getYear();
        int MesActual = LocalDate.now().getMonthValue();
        int DiaActual = LocalDate.now().getDayOfMonth();
        int numeroAleatorio =random.nextInt(1000000);
        return String.format("%d%d%d%d",AnioActual,numeroAleatorio,MesActual,DiaActual);
    }

    public String mostrarBoleto(){
        return String.format("ID: %s, PELICULA: %s, SALA: %s, ASIENTO: %s, HORA DE FUNCION: %s, PRECIO BOLETO: %.2f", this.id, this.tituloPelicula, this.sala, this.asiento, this.horaFuncion, this.precioBoleto);
    }

}
