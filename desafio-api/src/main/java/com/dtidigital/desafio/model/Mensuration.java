package com.dtidigital.desafio.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensuration implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name="mensuration_date",nullable=false)
    private LocalDate mensurationDate;
    
    @Column(name="mensuration_max_value",nullable=false)
	private Float mensurationMaxValue;

    @Column(name="mensuration_min_value",nullable=false)
	private Float mensurationMinValue;

    @Column(name="mensuration_place",nullable=false, length = 60)
	private String mensurationPlace;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getMensurationDate() {
		return mensurationDate;
	}

	public void setMensurationDate(LocalDate mensurationDate) {
		this.mensurationDate = mensurationDate;
	}

	public Float getMensurationMaxValue() {
		return mensurationMaxValue;
	}

	public void setMensurationMaxValue(Float mensurationMaxValue) {
		this.mensurationMaxValue = mensurationMaxValue;
	}

	public Float getMensurationMinValue() {
		return mensurationMinValue;
	}

	public void setMensurationMinValue(Float mensurationMinValue) {
		this.mensurationMinValue = mensurationMinValue;
	}

	public String getMensurationPlace() {
		return mensurationPlace;
	}

	public void setMensurationPlace(String mensurationPlace) {
		this.mensurationPlace = mensurationPlace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mensurationDate == null) ? 0 : mensurationDate.hashCode());
		result = prime * result + ((mensurationMaxValue == null) ? 0 : mensurationMaxValue.hashCode());
		result = prime * result + ((mensurationMinValue == null) ? 0 : mensurationMinValue.hashCode());
		result = prime * result + ((mensurationPlace == null) ? 0 : mensurationPlace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensuration other = (Mensuration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mensurationDate == null) {
			if (other.mensurationDate != null)
				return false;
		} else if (!mensurationDate.equals(other.mensurationDate))
			return false;
		if (mensurationMaxValue == null) {
			if (other.mensurationMaxValue != null)
				return false;
		} else if (!mensurationMaxValue.equals(other.mensurationMaxValue))
			return false;
		if (mensurationMinValue == null) {
			if (other.mensurationMinValue != null)
				return false;
		} else if (!mensurationMinValue.equals(other.mensurationMinValue))
			return false;
		if (mensurationPlace == null) {
			if (other.mensurationPlace != null)
				return false;
		} else if (!mensurationPlace.equals(other.mensurationPlace))
			return false;
		return true;
	}


}
