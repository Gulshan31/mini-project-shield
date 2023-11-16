package com.genctechnologies.shield;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.genctechnologies.constant.MissionStatus;
import com.genctechnologies.factory.AvengerFactory;
import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.Mission;
import com.genctechnologies.service.AvengerService;
import com.genctechnologies.service.AvengerServiceImpl;
import com.genctechnologies.service.MissionService;
import com.genctechnologies.service.MissionServiceImpl;

public class App 
{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static AvengerService avengerService = new AvengerServiceImpl();
	
	private static MissionService missionService = new MissionServiceImpl();
	
    public static void main( String[] args ) throws IOException
    {
    	ConsoleActivites();
    }
    
    private static void ConsoleActivites() throws IOException{
    	System.out.println("Welcome to Captain Fury. "
    			+ "Select an action\n1. Check the missions."
    			+ "\n2. Assign mission to Avengers."
    			+ "\n3. Check mission’s details."
    			+ "\n4. Check Avenger’s details."
    			+ "\n5. Update Mission’s status."
    			+ "\n6. List Avengers"
    			+ "\n7. Assign avenger to mission."
    			+ "\n8. Exit.");
		int action;
		try {
			action = Integer.parseInt(reader.readLine());
		
		switch(action) {
			
			///// Check the mission..
			case 1:
				List<Mission> missions = missionService.getMissions();
				if(missions.size() == 0) {
					System.out.println("No Mission has been assigned to an Avenger.\n");
					ConsoleActivites();	
				}
				else {
					missions.forEach(System.out::println);
				}
				break;
			
			//// Assign mission to Avengers.	
			case 2:
				System.out.println("Enter Avengers name by comma separated ");
				String avengers = reader.readLine();
				String [] avengersName = avengers.split(",");
				/// If blank or space is given as avenger name
				if(avengers.trim().length() == 0) {
					System.out.println("Input is not valid. Please try again.\n");
					ConsoleActivites();					
				}
				if(avengersName.length > 2) {
					System.out.println("A mission can be assigned to only two avengers at a time. Please try again.\n");
					ConsoleActivites();
				}
				else {
					try {
						if(avengerService.getMissionCountByAvenger(avengersName[0]) >= 2) {
							System.out.println("Sorry, "+ avengersName[0] +" has already been working on two missions. Please try again.\n");
							ConsoleActivites();
						}
						else if(avengerService.getMissionCountByAvenger(avengersName[1]) >= 2) {
							System.out.println("Sorry, "+ avengersName[1] +" has already been working on two missions. Please try again.\n");
							ConsoleActivites();	
						}
						/// Input is valid, proceed with assigning the mission.
						else {
							Avenger firstAvenger = AvengerFactory.getAvengerInstance(avengersName[0]);
							Avenger secondAvenger = AvengerFactory.getAvengerInstance(avengersName[1]);
							if(firstAvenger == null) {
								System.out.println("Sorry, No Avenger with this name "+ avengersName[0] +" found. Please with valid input.\n");
								ConsoleActivites();									
							}
							if(secondAvenger == null) {
								System.out.println("Sorry, No Avenger with this name "+ avengersName[1] +" found. Please with valid input.\n");
								ConsoleActivites();									
							}
							/// Valid avengers entered proceeding further.
				
							System.out.println("Enter Mission Name: ");
							String missionName = reader.readLine();
							while(missionName.trim().length() == 0) {
								System.out.println("Invalid Mission name, Please enter valid data: ");
								missionName = reader.readLine();
							}
							System.out.println("Enter Mission Details: ");
							String missionDetails = reader.readLine();
							while(missionDetails.trim().length() == 0) {
								System.out.println("Invalid Mission details, Please enter valid data: ");
								missionDetails = reader.readLine();
							}
							/// Mission data is valid, proceeding further.
							Mission mission = new Mission();
							mission.setDescription(missionDetails);
							mission.setName(missionName);
							mission.setMissionId(missionName);
							mission.setStatus(MissionStatus.CREATED);
							if(missionService.isMissionAlreadyExist(mission)) {
								System.out.println("The mission with this name already exist. Try updating the mission. ");
								ConsoleActivites();							
							}
							missionService.createMission(mission);
							missionService.assignAvengerToMission(mission, firstAvenger);
							missionService.assignAvengerToMission(mission, secondAvenger);
							ConsoleActivites();
						}
					}
					/// Input given is not as expected, seems there is only one avenger name given
					catch(ArrayIndexOutOfBoundsException ex) {
						System.out.println("A mission can be assigned to only two avengers at a time. Please try again.\n");
						ConsoleActivites();
					}
				}
				break;
			
			////// check missions's details.	
			case 3:
				List<Mission> missionList = missionService.getMissions();
				if(missionList.size() == 0) {
					System.out.println("No mission exists yet.");
				}
				else {
					missionList.forEach(System.out::println);
				}
				
				ConsoleActivites();
				break;
				
			///// check Avengers details.	
			case 4:
				List<Avenger> avengerList = avengerService.getAvengers();
				if(avengerList.size() == 0) {
					System.out.println("No Avengers exists yet.");
				}
				else {
					avengerList.forEach(System.out::println);
				}
				
				ConsoleActivites();				
				break;
				
			//// update mission's status.	
			case 5:
				System.out.println("Enter the mission name, which you want to update. You can update the status of the mission only");
				String missionId = reader.readLine();
				Mission mission = missionService.getMissionById(missionId);
				if(mission == null) {
					System.out.println("NO mission with "+ missionId + " exiss. Please enter a valid mission");
					ConsoleActivites();
				}
				System.out.println("Update the mission status. Enter the number as shown.\n");
				System.out.println("1. CREATED\n2. RUNNING\3. COMPLETED");
				int statusEnum = Integer.parseInt(reader.readLine());
				if(statusEnum > 3 || statusEnum < 1) {
					System.out.println("Please select a valid input");
					ConsoleActivites();
				}
				if(statusEnum == 1) {
					mission.setStatus(MissionStatus.CREATED);
				}
				else if(statusEnum == 2) {
					mission.setStatus(MissionStatus.RUNNING);
				}
				else if(statusEnum == 3) {
					mission.setStatus(MissionStatus.COMPLETED);
				}
				missionService.updateMission(mission, missionId);
				break;
				
			//// List Avengers.	
			case 6:
				List<Avenger> aList = avengerService.getAvengers();
				if(aList.size() == 0) {
					System.out.println("No Avengers exists yet.");
				}
				else {
					aList.forEach(System.out::println);
				}
				
				ConsoleActivites();				
				break;
			
			////// Assign avenger to mission.	
			case 7:
				System.out.println("Enter the avenger name.");
				String avengerId = reader.readLine();
				while(avengerId.trim().length() == 0) {
					System.out.println("Enter the valid avenger.");
					avengerId = reader.readLine();
				}
				System.out.println("Enter mission name");
				String missionName = reader.readLine();
				while(missionName.trim().length() == 0) {
					System.out.println("Enter the valid mission.");
					missionName = reader.readLine();
				}
				Avenger avenger = AvengerFactory.getAvengerInstance(avengerId);
				Mission currentMission = missionService.getMissionById(missionName);
				if(currentMission != null && missionService.isMissionAlreadyExist(currentMission)) {
					missionService.assignAvengerToMission(currentMission, avenger);	
				}
				else
					System.out.println("No mission with the given name exists.");
				ConsoleActivites();
				
				break;
				
			case 8:
				System.exit(0);
			default:
				break;
		}		
    }
    catch(NumberFormatException e) {
		System.out.println(e.getMessage());
		ConsoleActivites();
	}
}
}
