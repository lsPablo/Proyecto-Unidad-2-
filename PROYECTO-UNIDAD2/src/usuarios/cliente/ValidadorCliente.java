package usuarios.cliente;

import java.time.YearMonth;

public class ValidadorCliente {

    public boolean validarFechaCorrecta(YearMonth fechaDeseada){
        YearMonth fechaActual = YearMonth.now();

        if(fechaDeseada.isBefore(fechaActual)) return false;
        return true;
    }
}
