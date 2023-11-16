package com.genctechnologies.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public class MissionDaoImpl implements MissionDao {

	List<Mission> missions;
	
	private AvengerDao avengerDao;
	
	public MissionDaoImpl() {
		missions = new ArrayList<>();
		avengerDao = new AvengerDaoImpl();
	}

	@Override
	public List<Mission> getAllMissions() {
		// TODO Auto-generated method stub
		return missions;
	}

	@Override
	public Mission getMissionDetails(String missionId) {
		Optional<Mission> mission = this.missions.stream().
				filter(m -> m.getMissionId().equalsIgnoreCase(missionId)).
				findFirst();
		if(mission.isPresent()) {
			return mission.get();
		}
		return null;
	}

	@Override
	public boolean isMissionAlreadyExist(String missionId) {
		return this.missions.stream()
				.filter(m -> m.getMissionId().equalsIgnoreCase(missionId))
				.collect(Collectors.toList()).size() > 0 ? true : false;
	}

	@Override
	public void updateMission(Mission mission, String missionId) {
		if(this.missions.size() == 0) {
			System.out.println("No mission is created yet..");
			return;
		}
		List<Mission> updatedMissionList = missions.stream().
			map(m -> {
				if(m.getMissionId().equalsIgnoreCase(missionId)) {
					Mission updatedMission = mission;
					return updatedMission;
				}
				return m;
			}).collect(Collectors.toList());
		this.missions = updatedMissionList;
	}

	@Override
	public void assignAvengerToMission(Avenger avenger, String missionId) {
		Optional<Mission> mission = this.missions.stream()
			.filter(m -> m.getMissionId().equalsIgnoreCase(missionId))
			.findFirst();
		if(mission.isPresent()) {
			if(mission.get().getAssignedTo().size() == 2) {
				System.out.println("A mission can assigned to max 2 Avengers at a time.");
			}
			else {
				mission.get().assignAvengerToMission(avenger);
				avengerDao.addAvengers(avenger);
			}
		}
		else {
			System.out.println("Mission with the given ID does not exist");
		}
		
	}

	@Override
	public Mission createMission(Mission mission) {
		// TODO Auto-generated method != null stub
		missions.add(mission);
		return mission;
	}

}
