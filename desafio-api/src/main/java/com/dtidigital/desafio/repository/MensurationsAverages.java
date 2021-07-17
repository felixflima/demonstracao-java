package com.dtidigital.desafio.repository;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dtidigital.desafio.model.MensurationsAverage;

public interface MensurationsAverages extends JpaRepository<MensurationsAverage, LocalDate> {

}
