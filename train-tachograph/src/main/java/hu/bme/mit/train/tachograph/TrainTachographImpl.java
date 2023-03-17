package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainDoor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainTachograph;

public class TrainTachographImpl implements TrainTachograph {

	TrainController controller;
	TrainUser user;

	com.google.common.collect.Table<java.util.Date, Integer, Integer> historyTable 
  		= com.google.common.collect.HashBasedTable.create();

	public TrainTachographImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public void logData(){
		historyTable.put(new java.util.Date(), user.getJoystickPosition(), controller.getReferenceSpeed() );
	}
	
	@Override
	public com.google.common.collect.Table<java.util.Date, Integer, Integer> getHistory(){
		return historyTable;
	}
}
