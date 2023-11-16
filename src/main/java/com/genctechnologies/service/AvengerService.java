package com.genctechnologies.service;

import java.util.List;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public interface AvengerService {
	
	/**
	 * check the status of all the avengers 
	 * (if they are available to take any mission or already on a mission)
	 * **/
	List<Avenger>getAvengers();
	
	/**
	 * assign any mission to avengers.
	 * **/
	void assignMissionToAvenger(Mission mission, Avenger assignTo);
	
	/**
	 * current mission count for given avenger
	 * */
	int getMissionCountByAvenger(String name);
	
	/**
	 * can avenger take a mission.
	 * */
	boolean canAvengerTakeMission(String avengerId);
	
}
