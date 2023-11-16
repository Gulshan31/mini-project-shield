package com.genctechnologies.model;

public class CaptainAmerica extends Avenger {

	private CaptainAmerica() {
		name = "Captain America";
		avengerId = "Captain America";
	}
	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new CaptainAmerica();
		}
		return instance;
	}
}
