package com.genctechnologies.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public class AvengerDaoImpl implements AvengerDao {
	
	// Suppose this will be loaded from some persistence storage.
	static List<Avenger> avengers = new ArrayList<>();
	
	public AvengerDaoImpl() {
	}

	public void assignMissionToAvenger(Mission mission, Avenger assignTo) {
		
	}

	public int getMissionCountByAvenger(String name) {
		Optional<Avenger> avenger= avengers.stream().
					filter(a -> a.getAvengerId().equalsIgnoreCase(name)).findFirst();
		if(avenger.isPresent()) {
			return avenger.get().getCurrentMissionCount();
		}
		return -1;
	}

	@Override
	public List<Avenger> getAvengers() {
		return avengers;
	}

	@Override
	public void addAvengers(Avenger avenger) {
		avengers.add(avenger);
	}

}
