package com.genctechnologies.model;

public class Hulk extends Avenger {

	private Hulk() {
		name = "Hulk";
		avengerId = "Hulk";
	}
	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new Hulk();
		}
		return instance;
	}
}
