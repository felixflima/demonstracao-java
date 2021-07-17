package com.dtidigital.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dtidigital.desafio.model.Mensuration;

public interface Mensurations extends JpaRepository<Mensuration, Long> {
  	

}
