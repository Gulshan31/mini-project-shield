package com.genctechnologies.model;

public class BlackWidow extends Avenger {

	private BlackWidow() {
		name = "Black Widow";
		avengerId = "Black Widow";
	}
	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new BlackWidow();
		}
		return instance;
	}
}
