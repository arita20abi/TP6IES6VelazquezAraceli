package air.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;


import air.edu.ies6.model.Docente;

public class DocenteUtil {
private static List<Docente> listaDocentes = new ArrayList<>();
	

    public static List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public static void agregarDocente(Docente docente) {
        listaDocentes.add(docente);
    }

    public static void eliminarDocente(Docente docente) {
        listaDocentes.remove(docente);
    }
}
