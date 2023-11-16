package com.genctechnologies.model;

public class IronMan extends Avenger {
		
	private IronMan() {
		// TODO Auto-generated constructor stub
		name = "Ironman";
		avengerId = "Ironman";
		
	}
	public static Avenger getAvengerInstance() {
		if(instance == null) {
			return new IronMan();
		}
		return instance;
	}
}
