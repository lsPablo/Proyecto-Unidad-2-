package boleto;

public class Boleto {
    public String boletoId;
    public String tituloPelicula;
    public String sala;
    public String asiento;
    public String horaFuncion;


    public Boleto(String boletoId, String tituloPelicula, String sala, String asiento, String horaFuncion) {
        this.boletoId = boletoId;
        this.tituloPelicula = tituloPelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.horaFuncion = horaFuncion;

    }

}
