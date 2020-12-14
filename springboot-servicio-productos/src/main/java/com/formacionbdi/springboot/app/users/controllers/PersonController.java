package com.formacionbdi.springboot.app.users.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.users.models.entity.Person;
import com.formacionbdi.springboot.app.users.models.service.FirebaseInitialize;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class PersonController {

	@Autowired
	FirebaseInitialize db;

	@GetMapping("/listclientes")
	public List<Person> getAllEmployees() throws InterruptedException, ExecutionException {
		List<Person> empList = new ArrayList<Person>();
		CollectionReference employee = db.getFirebase().collection("users");
		ApiFuture<QuerySnapshot> querySnapshot = employee.get();
		double edadPromedio = 0.0;
		for (DocumentSnapshot calcularEdadProbable : querySnapshot.get().getDocuments()) {
			Person emp = calcularEdadProbable.toObject(Person.class);
			edadPromedio += emp.getAge();
		}
		edadPromedio = edadPromedio / querySnapshot.get().getDocuments().size();

		for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
			double edadFinal = 0.0;
			Person emp = doc.toObject(Person.class);
			edadFinal = edadPromedio - emp.getAge();
			emp.setPosibleMuerte(edadFinal + " "+"años probable a fallecer");
			empList.add(emp);
		}
		return empList;
	}

	@PostMapping("/creacliente")
	public String saveEmployee(@RequestBody Person person) {
		CollectionReference employeeCR = db.getFirebase().collection("users");
		employeeCR.document(String.valueOf(person.getName())).set(person);
		return person.getName();
	}

}
