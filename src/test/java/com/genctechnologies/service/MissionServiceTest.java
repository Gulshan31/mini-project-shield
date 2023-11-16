package com.genctechnologies.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.genctechnologies.dao.MissionDao;
import com.genctechnologies.model.Mission;
import com.genctechnologies.service.MissionService;
import com.genctechnologies.service.MissionServiceImpl;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class MissionServiceTest extends TestCase  {
	
	private MissionService missionService;
	private MissionDao missionDao;

	@Test
	public void getMissions() {
		
		missionDao = mock(MissionDao.class);
		missionService = new MissionServiceImpl(missionDao);
		
		List<Mission> missionList = new ArrayList<>();
		Mission m1 = new Mission();
		m1.setMissionId("test1");
		m1.setName("test1");
		m1.setDescription("This is test 1 mission");
		
		Mission m2 = new Mission();
		m2.setMissionId("test2");
		m2.setName("test2");
		m2.setDescription("This is test 2 mission");
		
		missionList.add(m1);
		missionList.add(m2);
		
		Mockito.when(missionDao.getAllMissions()).thenReturn(missionList);
		List<Mission> missions = missionService.getMissions(); 
		assertEquals(2, missions.size());
		
	}
	
}
