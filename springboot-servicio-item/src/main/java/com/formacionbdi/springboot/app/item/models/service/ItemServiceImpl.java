package com.formacionbdi.springboot.app.item.models.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Person;

@Service
public class ItemServiceImpl implements ItemService {
	double edadPromedio = 0.0;
	double desviacionEstandar = 0.0;
	DatosCalcular datosCalcular = new DatosCalcular();

	@Override
	public List<Item> findAll() {

		Item lista = new Item();
		List<Item> listaItem = new ArrayList<>();
		int[] edad;
		int contador = 0;
		RestTemplate clienteRest = new RestTemplate();
		List<Person> persons = Arrays
				.asList(clienteRest.getForObject("http://localhost:8001/listclientes", Person[].class));

		edad = new int[persons.size()];
		for (Person person : persons) {
			edadPromedio += person.getAge();
			edad[contador] = person.getAge();
			contador++;
		}
		edadPromedio = edadPromedio / persons.size();
		desviacionEstandar = datosCalcular.stdev(edad);
		lista.setDesviacionEstandar(desviacionEstandar);
		lista.setEdadPromedio(edadPromedio);
		listaItem.add(lista);
		
		return listaItem;
//		return persons.stream().map(p -> new Item(edadPromedio, desviacionEstandar)).collect(Collectors.toList());
	}

}
