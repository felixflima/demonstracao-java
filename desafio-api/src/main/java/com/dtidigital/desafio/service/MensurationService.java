package com.dtidigital.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtidigital.desafio.model.Mensuration;
import com.dtidigital.desafio.repository.Mensurations;

@Service
public class MensurationService {
  @Autowired
  private Mensurations mensurationRepository;
  
  public Mensuration salvar(Mensuration mensuration) {
	  return mensurationRepository.save(mensuration);
  }
  

}
