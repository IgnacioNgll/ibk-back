package com.formacionbdi.springboot.app.item.models;

public class Item {


	private double edadPromedio;
	private double desviacionEstandar;

	public Item() {
	}

	public Item(double edadPromedio, double desviacionEstandar) {
		this.edadPromedio = edadPromedio;
		this.desviacionEstandar = desviacionEstandar;
	}

	public Double getEdadPromedio() {
		return edadPromedio;
	}

	public void setEdadPromedio(double edadPromedio) {
		this.edadPromedio = edadPromedio;
	}

	public double getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

}
