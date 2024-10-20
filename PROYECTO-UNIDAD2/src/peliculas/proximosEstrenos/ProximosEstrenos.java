package peliculas;

import java.time.Duration;
import java.time.LocalDateTime;

public class proximosEstrenos extends Pelicula {
    public LocalDateTime fechaEstrenos;

    public proximosEstrenos(String id, String titulo, String gernero, char clasificacion, Duration duracion, String sinopsis, LocalDateTime fechaEstrenos) {
        super(id, titulo, gernero, clasificacion, duracion, sinopsis);
        this.fechaEstrenos = fechaEstrenos;
    }

    public String mostrarEstrenosProximos(){
        long minutos = duracion.toMinutes();
        String duracionFormateada = String.format(" %s MINUTOS", minutos);
        String datos = String.format("ID: %s, NOMBRE: %s, GENERO: %s, CLASIFICACIÓN: %s, DURACIÓN: %s, SINOPSIS: %s, FECHA DE ESTRENO: %s", this.id, this.titulo, this.gernero, this.clasificacion, duracionFormateada, this.sinopsis, this.fechaEstrenos);
        return datos;
    }
}
