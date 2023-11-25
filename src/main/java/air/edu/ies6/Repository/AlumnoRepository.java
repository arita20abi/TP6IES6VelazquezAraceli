package air.edu.ies6.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import air.edu.ies6.model.Alumno;

 

     public interface AlumnoRepository extends CrudRepository <Alumno,String> {
        	public List<Alumno>findByEstado (Boolean estado);

        	
     }


	



    