package air.edu.ies6.util;

import java.time.LocalDate;
import java.time.Period;

public class CalculadoraUtil {
	public static int calculadoraEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}
