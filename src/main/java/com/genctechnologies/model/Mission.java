package com.genctechnologies.model;

import java.util.ArrayList;
import java.util.List;

import com.genctechnologies.constant.MissionStatus;

public class Mission {

	private String missionId;
	
	private String name;
	
	private String description;
	
	private MissionStatus status;
	
	private List<Avenger> assignedTo;
	
	public Mission() {
		this.assignedTo = new ArrayList<Avenger>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MissionStatus getStatus() {
		return status;
	}

	public void setStatus(MissionStatus status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Avenger> getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(List<Avenger> assignedTo) {
		this.assignedTo = assignedTo;
	}

	/// We can assign avengers to the mission as well
	public void assignAvengerToMission(Avenger avenger){
		System.out.println(this.missionId + " is assigned to " + avenger.getName());
		avenger.setCurrentMissionCount(avenger.getCurrentMissionCount() + 1); 
		this.assignedTo.add(avenger);
	}

	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	@Override
	public String toString() {
		return "Mission [missionId=" + missionId + ", name=" + name + ", description=" + description + ", status="
				+ status + ", assignedTo=" + assignedTo + "]";
	}
	
	
}
