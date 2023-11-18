package air.edu.ies6.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import air.edu.ies6.model.Docente;
import air.edu.ies6.service.DocenteService;


@Controller
public class DocenteController {
	@Autowired
	   Docente docente;
	   @Autowired
	   DocenteService docenteService;
	
	//private List<Alumno> docente = new ArrayList<>();
	
       
         @GetMapping("/FormularioDocente")
         public String mostrarFormularioDocente(Model model) {
           model.addAttribute("docente", new Docente());
           return "indexDocente";
         }

         
        
     
      @PostMapping("/guardarDocente")
      public String guardarDocente(Docente docente) {
     
     	   docenteService.guardarDocente(docente);
     return "redirect:/listadoDocente";
 }
      

    @GetMapping("/listadoDocente")
     public String mostrarListadoDocente(Model model) {
      //model.addAttribute("listaDocentes", DocenteUtil.getListaDocentes());
      model.addAttribute("listaDocentes", docenteService.buscarTodosDocentes());
     return "ListadoDocente";
 }
   
    

 @GetMapping ("/eliminarDocente/{dni}")
 public String eliminarDocente(@PathVariable String dni) throws Exception {
      docenteService.eliminarDocente(dni);
 	return "redirect:/listadoDocente";
 	
 	    }


       @GetMapping ("/modificarDocente/{dni}")
      public ModelAndView modificarDocente(@PathVariable String dni) throws Exception {
     	 
 	ModelAndView modificaDocente= new ModelAndView ("indexDocente");
 	
 	    modificaDocente.addObject("docente",docenteService.encontrarUnDocente(dni));
      	
      	return modificaDocente;
 	    }
       
       @PostMapping("/modificarDocente")
       public ModelAndView  modificarUnDocente(@ModelAttribute ("docente") Docente docente ) {
     	  
     	  docenteService.guardarDocente(docente);
     	  
     	  ModelAndView modelView= new ModelAndView("listadoDocente");
     	  
     	  modelView.addObject("listadoDocente",docenteService.buscarTodosDocentes());
     	  return modelView;
       }


      @GetMapping ({ "/indexDocente","/","/home"})
	public ModelAndView cargarDocente() {
		Docente docente= new Docente ();
	    docente.setFechaNacimiento(LocalDate.of(1990, 05,4));
		System.out.println("Edad:"+docente.getEdad());
		
		ModelAndView modelView=new ModelAndView ("indexDocente");
		modelView.addObject("docente",docente);
		return  modelView;
	
	}
      @GetMapping("/portalDocente")
      public String mostrarPortal(Model model) {
          return "portal";
      }
     
}

