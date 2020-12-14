package com.formacionbdi.springboot.app.item.models.service;

public class DatosCalcular {
	
	public static double stdev(int[] list) {
		double sum = 0.0;
		double mean = 0.0;
		double num = 0.0;
		double numi = 0.0;

		for (int i : list) {
			sum += i;
		}
		mean = sum / list.length;

		for (int i : list) {
			numi = Math.pow(((double) i - mean), 2);
			num += numi;
		}

		return Math.sqrt(num / list.length);
	}

}
