package air.edu.ies6.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import air.edu.ies6.model.Docente;

@Repository
public interface DocenteRepository extends CrudRepository <Docente,String> {
	public List<Docente>findByEstado (Boolean estado);

}
	

