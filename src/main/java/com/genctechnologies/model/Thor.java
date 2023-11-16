package com.genctechnologies.model;

public class Thor extends Avenger {

	private Thor() {
		name = "Thor";
		avengerId = "Thor";
	}
	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new Thor();
		}
		return instance;
	}

}
