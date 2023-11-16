package com.genctechnologies.dao;

import java.util.List;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public interface MissionDao {
	
	List<Mission> getAllMissions();
	
	Mission createMission(Mission mission);
	
	Mission getMissionDetails(String missionId);
	
	boolean isMissionAlreadyExist(String missionId);
	
	void updateMission(Mission mission , final String missionId);
	
	void assignAvengerToMission(Avenger avenger, String missionId);
}
