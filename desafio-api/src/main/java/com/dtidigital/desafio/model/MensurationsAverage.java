package com.dtidigital.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_mensuration_average")
public class MensurationsAverage {

	@Id
    @Column(name="mensuration_date")
    private LocalDate mensurationDate;
    
    @Column(name="max_value_average")
	private Float MaxValueAverage;

    @Column(name="min_value_average")
	private Float MinValueAverage;

	public LocalDate getMensurationDate() {
		return mensurationDate;
	}

	public void setMensurationDate(LocalDate mensurationDate) {
		this.mensurationDate = mensurationDate;
	}

	public Float getMaxValueAverage() {
		return MaxValueAverage;
	}

	public void setMaxValueAverage(Float maxValueAverage) {
		MaxValueAverage = maxValueAverage;
	}

	public Float getMinValueAverage() {
		return MinValueAverage;
	}

	public void setMinValueAverage(Float minValueAverage) {
		MinValueAverage = minValueAverage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MaxValueAverage == null) ? 0 : MaxValueAverage.hashCode());
		result = prime * result + ((MinValueAverage == null) ? 0 : MinValueAverage.hashCode());
		result = prime * result + ((mensurationDate == null) ? 0 : mensurationDate.hashCode());
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
		MensurationsAverage other = (MensurationsAverage) obj;
		if (MaxValueAverage == null) {
			if (other.MaxValueAverage != null)
				return false;
		} else if (!MaxValueAverage.equals(other.MaxValueAverage))
			return false;
		if (MinValueAverage == null) {
			if (other.MinValueAverage != null)
				return false;
		} else if (!MinValueAverage.equals(other.MinValueAverage))
			return false;
		if (mensurationDate == null) {
			if (other.mensurationDate != null)
				return false;
		} else if (!mensurationDate.equals(other.mensurationDate))
			return false;
		return true;
	}

}
