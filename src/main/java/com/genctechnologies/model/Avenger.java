package com.genctechnologies.model;

public abstract class Avenger {

	static Avenger instance = null;
	
	public String avengerId;
	
	public String name;
		
	private int currentMissionCount;
	
	private int missionsCompleted;
	
	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentMissionCount() {
		return currentMissionCount;
	}

	public void setCurrentMissionCount(int currentMissionCount) {
		this.currentMissionCount = currentMissionCount;
	}

	public String getName() {
		return name;
	}

	public String getAvengerId() {
		return avengerId;
	}

	public void setAvengerId(String avengerId) {
		this.avengerId = avengerId;
	}

	public int getMissionCompleted() {
		return missionsCompleted;
	}

	public void setMissionsCompleted(int missionsCompleted) {
		this.missionsCompleted = missionsCompleted;
	}

	@Override
	public String toString() {
		return "Avenger [avengerId=" + avengerId + ", name=" + name 
				+ ", currentMissionCount=" + currentMissionCount + ", missionsCompleted=" + missionsCompleted + "]";
	}
}
