package hu.bme.mit.train.door;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainDoor;

public class TrainDoorImpl implements TrainDoor {

	private TrainController controller;

	private boolean isDoorOpen = false;

	public TrainDoorImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getIsDoorOpen(){ return isDoorOpen; }

	@Override
	public void setIsDoorOpen(boolean newState){
		this.isDoorOpen = newState;
		controller.setIsDoorOpen(newState);
	}

}
