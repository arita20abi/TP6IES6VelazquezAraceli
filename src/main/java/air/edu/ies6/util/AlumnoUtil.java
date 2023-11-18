package air.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import air.edu.ies6.model.Alumno;

public class AlumnoUtil {
private static List<Alumno> listaAlumnos = new ArrayList<>();
	

    public static List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public static void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    public static void eliminarAlumno(Alumno alumno) {
        listaAlumnos.remove(alumno);
    }
}
