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

import air.edu.ies6.model.Alumno;
import air.edu.ies6.service.AlumnoService;


@Controller
public class AlumnoController {
	
	   @Autowired
	   Alumno alumno;
	   @Autowired
	   AlumnoService alumnoService;
	
	//private List<Alumno> alumnos = new ArrayList<>();
	
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
         model.addAttribute("alumno", new Alumno());
        return "index";
    }


    @PostMapping("/guardar")
    public String guardarAlumno(Alumno alumno) {
        //salumno.setEdad(CalculadoraEdad.calculadoraEdad(alumno.getFechaNacimiento()));
          //AlumnoUtil.getListaAlumnos().add(alumno);
    	alumnoService.guardarAlumno(alumno);
        return "redirect:/listado";
    }

   
    @GetMapping("/listado")
    public String mostrarListadoAlumno(Model model) {
      model.addAttribute("listaAlumnos", alumnoService.buscarTodosAlumnos());
      return "listadoAlumno";
    }
    
    
    
    @GetMapping ("/eliminarAlumno/{dni}")
     public String eliminarAlumno(@PathVariable String dni) throws Exception {
    	alumnoService.eliminarAlumno(dni);
    	return "redirect:/listado";
    	
    	    }

          @GetMapping ("/modificarAlumno/{dni}")
         public ModelAndView modificarAlumno(@PathVariable String dni) throws Exception {
        	  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        	  
    	ModelAndView modificaAlumno= new ModelAndView ("index");
    	
    	modificaAlumno.addObject("alumno",alumnoService.encontrarUnAlumno(dni));
    	System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    	return modificaAlumno;
    	    }
          
          @PostMapping("/modificarAlumno")
          public ModelAndView  modificarUnAlumno(@ModelAttribute ("alumno") Alumno alumno ) {
        	  
        	  alumnoService.guardarAlumno(alumno);
        	  
        	  ModelAndView modelView= new ModelAndView("listado");
        	  
        	  modelView.addObject("listado",alumnoService.buscarTodosAlumnos());
        	  return modelView;
          }


         @GetMapping ({ "/index","/","/home"})
	public ModelAndView cargarAlumno() {
		Alumno alumno= new Alumno ();
	    alumno.setFechaNacimiento(LocalDate.of(1990, 05,4));
		System.out.println("Edad:"+alumno.getEdad());
		
		ModelAndView modelView=new ModelAndView ("index");
		modelView.addObject("alumno",alumno);
		return  modelView;
	
	}
         
         @GetMapping("/portal")
         public String mostrarPortal(Model model) {
             return "portal";
         }
}
