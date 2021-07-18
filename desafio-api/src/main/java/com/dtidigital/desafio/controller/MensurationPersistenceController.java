package com.dtidigital.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dtidigital.desafio.model.Mensuration;
import com.dtidigital.desafio.service.MensurationService;

@Controller
@RequestMapping("/mensurations")
public class MensurationPersistenceController {

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
	
}
