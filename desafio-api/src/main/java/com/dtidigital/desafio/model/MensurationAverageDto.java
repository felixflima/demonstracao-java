package com.dtidigital.desafio.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "mapeamento.MensurationAverageDto", classes = {
		@ConstructorResult(targetClass = MensurationAverageDto.class, columns = {
				@ColumnResult(name = "mensuration_date", type = String.class),
				@ColumnResult(name = "max_value_average", type = Float.class),
				@ColumnResult(name = "min_value_average", type = Float.class)
		})
})
public class MensurationAverageDto {

    private String mensurationDate;
    
	private Float MaxValueAverage;

	private Float MinValueAverage;


	public MensurationAverageDto() {
		super();
	}

	public MensurationAverageDto(String mensurationDate, Float maxValueAverage, Float minValueAverage) {
		super();
		this.mensurationDate = mensurationDate;
		MaxValueAverage = maxValueAverage;
		MinValueAverage = minValueAverage;
	}

	public MensurationsAverage transformaEmObjeto() {
		return new MensurationsAverage(mensurationDate, MaxValueAverage, MinValueAverage);
	}
	
	public String getMensurationDate() {
		return mensurationDate;
	}

	public void setMensurationDate(String mensurationDate) {
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
		MensurationAverageDto other = (MensurationAverageDto) obj;
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
