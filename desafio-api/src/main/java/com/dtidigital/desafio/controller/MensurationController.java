package com.dtidigital.desafio.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dtidigital.desafio.model.Mensuration;
import com.dtidigital.desafio.model.MensurationsAverage;
import com.dtidigital.desafio.repository.Mensurations;
import com.dtidigital.desafio.service.MensurationService;

@Controller
@RequestMapping("/mensurations")
public class MensurationController {

	@Autowired
	private Mensurations mensurations;
	
	@Autowired
	private MensurationService mensurationService;
	
	@GetMapping
    public String exibeFormulario(Model model){
        model.addAttribute(new Mensuration());
        return "mensurations";
    }

	
	@PostMapping
    public ModelAndView adicionaMedicao(@Valid Mensuration mensuration,
         Errors errors) {
      if (errors.hasErrors()) {
          ModelAndView model = new ModelAndView("mensurations");
          return model;
       }
       ModelAndView model = new ModelAndView("redirect:/mensurations");
       model.addObject(new Mensuration());
   	   mensurationService.salvar(mensuration);
       return model;
    }
	
	
	@GetMapping("/getDataById/{mensurationId}") 
	public ResponseEntity<Mensuration> listar(@PathVariable Long mensurationId) {
		Optional<Mensuration> mensuration = mensurations.findById(mensurationId);
		
		if (mensuration.isPresent()) {
			return ResponseEntity.ok(mensuration.get());
		} 
		else {
			return ResponseEntity.notFound().build();
		}
	}

    
	@GetMapping("/getAverageByDay/{mensurationDate}") 
	public ResponseEntity<MensurationsAverage> listar(@PathVariable String parametro1) {
		final String MY_QUERY = "SELECT " + 
	                              "* " +
				                "FROM vw_mensuration_average " + 
	                            "WHERE mensuration_date = cast(?1 as date) ";

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date mensurationDate = formato.parse(parametro1);
		
		EntityManagerFactory entityManagerFactory = Persistence
        		.createEntityManagerFactory("vw_mensuration_average");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery(MY_QUERY, MensurationsAverage.class);
		query.setParameter(0, mensurationDate, TemporalType.DATE);
		
		List<MensurationsAverage> mensurationAverage = query.getResultList();
        
		if (mensurationAverage.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		else {
			return ResponseEntity.ok(mensurationAverage.get(0));
		}
	}
	
}
