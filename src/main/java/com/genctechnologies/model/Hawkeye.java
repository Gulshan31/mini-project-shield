package com.genctechnologies.model;

public class Hawkeye extends Avenger {

	private Hawkeye() {
		name = "Hawkeye";
		avengerId = "Hawkeye";
	}

	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new Hawkeye();
		}
		return instance;
	}
	
}
