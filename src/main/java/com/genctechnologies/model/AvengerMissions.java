package com.genctechnologies.model;

import java.util.ArrayList;
import java.util.List;

public class AvengerMissions {

	private final Avenger avenger;
	private final List<Mission> missions;
	
	public AvengerMissions(Avenger avenger) {
		this.avenger = avenger;
		this.missions = new ArrayList<>();
	}
	public void addMission(Mission mission) {
		this.missions.add(mission);
	}
	public Avenger getAvenger() {
		return avenger;
	}
	public List<Mission> getMissions(){
		return missions;
	}
}
