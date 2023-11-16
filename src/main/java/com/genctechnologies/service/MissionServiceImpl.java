package com.genctechnologies.service;

import java.util.List;

import com.genctechnologies.dao.MissionDao;
import com.genctechnologies.dao.MissionDaoImpl;
import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public class MissionServiceImpl implements MissionService {

	private MissionDao missionDao = new MissionDaoImpl();

	public MissionServiceImpl() {}
	
	public MissionServiceImpl(MissionDao missionDao) {
		this.missionDao = missionDao;
	}


	@Override
	public boolean isMissionAlreadyExist(Mission mission) {
		// TODO Auto-generated method stub
		return missionDao.isMissionAlreadyExist(mission.getMissionId());
	}

	@Override
	public void assignAvengerToMission(Mission mission, Avenger assignedAvenger) {
		// TODO Auto-generated method stub
		missionDao.assignAvengerToMission(assignedAvenger, mission.getName());
	}

	@Override
	public Mission getMissionById(String missionId) {
		// TODO Auto-generated method stub
		return missionDao.getMissionDetails(missionId);
	}

	@Override
	public void updateMission(Mission mission, String missionId) {
		missionDao.updateMission(mission, missionId);
	}

	@Override
	public List<Mission> getMissions() {
		// TODO Auto-generated method stub
		return missionDao.getAllMissions();
	}


	@Override
	public Mission createMission(Mission mission) {
		// TODO Auto-generated method stub
		return missionDao.createMission(mission);
	}

}
