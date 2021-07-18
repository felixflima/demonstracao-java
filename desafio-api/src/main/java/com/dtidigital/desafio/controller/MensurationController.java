package com.dtidigital.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtidigital.desafio.model.Mensuration;
import com.dtidigital.desafio.model.MensurationsAverage;
import com.dtidigital.desafio.repository.Mensurations;
import com.dtidigital.desafio.repository.MensurationsAverages;

@RestController
@RequestMapping("/mensurations")
public class MensurationController {

	@Autowired
	private Mensurations mensurations;
	
	@Autowired
	private MensurationsAverages mensurationsAverages;

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

	//---[ Para implementar este método, criei uma view que agrupa as médias por dia, ]---*
	//---[ cuja data é obtida como string no formato dd-mm-yyyy ]---* 
	@GetMapping("/getAverageByDay/{mensurationDate}") 
	public ResponseEntity<MensurationsAverage> listar(@PathVariable String mensurationDate) {
		Optional<MensurationsAverage> mensurationsAverage = mensurationsAverages.findById(mensurationDate);

		if (mensurationsAverage.isPresent()) {
			return ResponseEntity.ok(mensurationsAverage.get());
		} 
		else {
			return ResponseEntity.notFound().build();
		}

        //---[ Comentada possibilidade com Query Nativa, jogando o result para um Dto ]---* 
		/*
		final String MY_QUERY = "SELECT " + 
	                              "mensuration_date, " +
				                  "mensuration_max_value as max_value_average, " + 
	                              "mensuration_min_value as min_value_average " + 
				                "FROM vw_mensuration_average " + 
	                            "WHERE mensuration_date = '%s'";

		EntityManagerFactory entityManagerFactory = Persistence
        		.createEntityManagerFactory("Mensurations-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String sqlWithParam = String.format(MY_QUERY, mensurationDate);
        Query query = entityManager.createNativeQuery(sqlWithParam, "mapeamento.MensurationAverageDto");
	
		List<MensurationAverageDto> mensurationAverageDto = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();
        */
        /*
		if (mensurationAverageDto.isEmpty()) {
			return ResponseEntity.notFound().build();
		} 
		else {
			return ResponseEntity.ok(mensurationAverageDto.get(0));
		}
		*/
	}
}
