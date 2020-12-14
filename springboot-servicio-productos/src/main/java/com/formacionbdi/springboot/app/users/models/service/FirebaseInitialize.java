package com.formacionbdi.springboot.app.users.models.service;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitialize {

	@PostConstruct
	public void initialize() throws IOException {

		try {
			FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://reto-ibk-8692e-default-rtdb.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}

}
