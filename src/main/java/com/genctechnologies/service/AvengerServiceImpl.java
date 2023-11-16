	package com.genctechnologies.service;

import java.util.List;

import com.genctechnologies.dao.AvengerDao;
import com.genctechnologies.dao.AvengerDaoImpl;
import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;

public class AvengerServiceImpl implements AvengerService {

	private AvengerDao avengerDao;
	
	public AvengerServiceImpl() {
		avengerDao = new AvengerDaoImpl();
	}

	public void assignMissionToAvenger(Mission mission, Avenger assignTo) {
		avengerDao.assignMissionToAvenger(mission, assignTo);

	}

	public int getMissionCountByAvenger(String name){
		return avengerDao.getMissionCountByAvenger(name);
	}

	@Override
	public boolean canAvengerTakeMission(String avengerId) {
		return avengerDao.getMissionCountByAvenger(avengerId) < 2 ? true : false ;
	}

	@Override
	public List<Avenger> getAvengers() {
		return avengerDao.getAvengers();
	}

}
