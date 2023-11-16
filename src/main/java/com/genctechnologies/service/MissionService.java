package com.genctechnologies.service;

import java.util.List;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public interface MissionService {
	/**
	 * check if mission already exist
	 * */
	boolean isMissionAlreadyExist(Mission mission);
	
	
	/**
	 * assign an individual avenger to any mission.
	 * */
	void assignAvengerToMission(Mission mission, Avenger assignedAvenger);
	
	/**
	 * check the details of any mission.
	 * */
	Mission getMissionById(String missionId);
	
	/**
	 * update the status of the mission.
	 * */
	void updateMission(Mission mission, String missionId);
	
	/**
	 * check the status of all the missions.
	 * */
	List<Mission>getMissions();
	
	Mission createMission(Mission mission);
}
