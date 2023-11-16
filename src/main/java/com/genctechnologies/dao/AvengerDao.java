package com.genctechnologies.dao;

import java.util.List;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public interface AvengerDao {
	
	List<Avenger>getAvengers();
		
	void assignMissionToAvenger(Mission mission, Avenger assignTo);
	
	int getMissionCountByAvenger(String name);
	
	void addAvengers(Avenger avenger);
}
