package com.genctechnologies.factory;

import com.genctechnologies.model.Avenger;
import com.genctechnologies.model.BlackWidow;
import com.genctechnologies.model.CaptainAmerica;
import com.genctechnologies.model.Hawkeye;
import com.genctechnologies.model.Hulk;
import com.genctechnologies.model.IronMan;
import com.genctechnologies.model.Thor;

public class AvengerFactory {
	
	private AvengerFactory() {}
	
	public static Avenger getAvengerInstance(String instanceName) {
		if(instanceName.equalsIgnoreCase("ironman")) {
			return IronMan.getAvengerInstance();
		}
		else if(instanceName.equalsIgnoreCase("thor")) {
			return Thor.getAvengerInstance();
		}
		else if(instanceName.equalsIgnoreCase("hulk")) {
			return Hulk.getAvengerInstance();
		}
		else if(instanceName.equalsIgnoreCase("blackwidow")) {
			return BlackWidow.getAvengerInstance();
		}
		else if(instanceName.equalsIgnoreCase("hawkeye")) {
			return Hawkeye.getAvengerInstance();
		}
		else if(instanceName.equalsIgnoreCase("captainamerica")) {
			return CaptainAmerica.getAvengerInstance();
		}
		else {
			return null;
		}
	}
}
