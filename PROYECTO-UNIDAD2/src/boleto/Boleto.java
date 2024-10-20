package boleto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Boleto {
    public String boletoId;
    public String tituloPelicula;
    public String sala;
    public String asiento;
    public LocalTime horaFuncion;
    public Double precioBoleto;


    public Boleto(String boletoId, String tituloPelicula, String sala, String asiento, LocalTime horaFuncion, Double precioBoleto) {
        this.boletoId = boletoId;
        this.tituloPelicula = tituloPelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.horaFuncion = horaFuncion;
        this.precioBoleto = precioBoleto;

    }


}
