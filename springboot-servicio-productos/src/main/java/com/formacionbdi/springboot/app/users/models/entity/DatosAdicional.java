package com.formacionbdi.springboot.app.users.models.entity;

import org.springframework.stereotype.Component;

@Component
public class DatosAdicional {

	private Double edadPromedio;
	private Double desviacionEstandar;

	public Double getEdadPromedio() {
		return edadPromedio;
	}

	public void setEdadPromedio(Double edadPromedio) {
		this.edadPromedio = edadPromedio;
	}

	public Double getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(Double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

}
