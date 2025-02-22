package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainDoor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainTachograph;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.door.TrainDoorImpl;
import hu.bme.mit.train.tachograph.TrainTachographImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainDoor door = new TrainDoorImpl(controller);
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TrainTachograph tachograph = new TrainTachographImpl(controller, user);


	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public TrainDoor getDoor(){
		return door;
	}

	public TrainTachograph getTachograph(){
		return tachograph;
	}

}
