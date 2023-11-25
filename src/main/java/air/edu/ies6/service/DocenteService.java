package air.edu.ies6.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import air.edu.ies6.Repository.DocenteRepository;

import air.edu.ies6.model.Docente;

@Service 
public class DocenteService {
	
	@Autowired
	DocenteRepository docenteRepository;
	
       public void guardarDocente (Docente docente) {
    	   //motodo para guardar 
    	   docente.setEstado(true);
    	   docenteRepository.save(docente);
       }
       public void eliminarDocente(String dni)  throws Exception {
    	   //eliminar un objeto porr ssu identificador 
    	   Docente auxiliar= new Docente();
    	   auxiliar=encontrarUnDocente(dni);
    	   auxiliar.setEstado(false);
    	  docenteRepository.save(auxiliar);
       }
       
       public List<Docente> buscarTodosDocentes() {
    	   //algoritmo para buscar docente 
    	   //List<Docente>listadoDocente = new ArrayList<>();
    	   //return listadoDocente;
    	  return (List<Docente>) docenteRepository.findByEstado(true);
       }
       
       
       public void actualizarDocente(Docente docente) throws Exception {
       	
           // Comprueba si el docente existe
    	   Docente docenteEncontrado = docenteRepository.findById(docente.getDni()).orElse(null);
           if (docenteEncontrado != null) {
               // Actualiza el docente
               docenteRepository.save(docente);
               
           }
       }
       
       

	  public Docente encontrarUnDocente (String dni)throws Exception{
		  return docenteRepository.findById(dni).orElseThrow(()-> new Exception  ("Alumno no encontrado "));
	  }
	
}
