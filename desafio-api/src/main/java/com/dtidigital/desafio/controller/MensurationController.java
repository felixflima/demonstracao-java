package com.dtidigital.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtidigital.desafio.model.Mensuration;
import com.dtidigital.desafio.model.MensurationAverageDto;
import com.dtidigital.desafio.repository.Mensurations;

@RestController
@RequestMapping("/mensurations")
public class MensurationController {

	@Autowired
	private Mensurations mensurations;
	

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
	public ResponseEntity<MensurationAverageDto> listar(@PathVariable String mensurationDate) {
		final String MY_QUERY = "SELECT " + 
	                              "mensuration_date, " +
				                  "max_value_average, " + 
	                              "min_value_average " + 
				                "FROM vw_mensuration_average " + 
	                            "WHERE mensuration_date = %s";

		EntityManagerFactory entityManagerFactory = Persistence
        		.createEntityManagerFactory("vw_mensuration_average");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sqlWithParam = String.format(MY_QUERY, mensurationDate);
        Query query = entityManager.createNativeQuery(sqlWithParam, "mapeamento.MensurationAverageDto");
        
		List<MensurationAverageDto> mensurationAverageDto = query.getResultList();
        
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Data encontrada - " + mensurationAverageDto.get(0).getMensurationDate()); 

		if (mensurationAverageDto.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		else {
			//MensurationsAverage mensurationAverageResponse = mensurationAverageDto.get(0).transformaEmObjeto();
			
			return ResponseEntity.ok(mensurationAverageDto.get(0));
		}
		
	}
}
