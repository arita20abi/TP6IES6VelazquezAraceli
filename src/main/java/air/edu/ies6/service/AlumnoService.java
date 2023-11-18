package air.edu.ies6.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import air.edu.ies6.Repository.AlumnoRepository;
import air.edu.ies6.model.Alumno;


@Service 
public class AlumnoService {
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
       public void guardarAlumno (Alumno alumno) {
    	   //motodo para guardar 
    	   alumno.setEstado(true);
    	   alumnoRepository.save(alumno);
       }
       public void eliminarAlumno(String dni)  throws Exception {
    	   //eliminar un objeto porr ssu identificador 
    	   Alumno auxiliar= new Alumno();
    	   auxiliar=encontrarUnAlumno(dni);
    	   auxiliar.setEstado(false);
    	   alumnoRepository.save(auxiliar);
       }
       
       
       public List<Alumno> buscarTodosAlumnos() {
    	   //algoritmo para buscar alumnos 
    	   //List<Alumno>listado = new ArrayList<>();
    	   //return listado;
    	  return (List<Alumno>) alumnoRepository.findByEstado(true);
       }
       public void modificaUnAlumno (Alumno alumno) {
    	   
       }

	  public Alumno encontrarUnAlumno (String dni)throws Exception{
		  return alumnoRepository.findById(dni).orElseThrow(()-> new Exception  ("Alumno no encontrado "));
	  }
	
}