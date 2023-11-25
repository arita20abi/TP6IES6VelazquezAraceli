package air.edu.ies6.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import air.edu.ies6.model.Docente;


public interface DocenteRepository extends CrudRepository <Docente,String> {
	public List<Docente>findByEstado (Boolean estado);

}
	

