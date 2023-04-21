package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {


	private final int lowerAbsoluteLimit = 0;
	private final int higherAbsoluteLimit = 500;
	private final double relativeWarningRatio = 0.5;

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);

		//alarm
		if(speedLimit < this.lowerAbsoluteLimit || speedLimit > this.higherAbsoluteLimit){
			user.setAlarmState(true);
		}
		if((controller.getReferenceSpeed() - speedLimit) > relativeWarningRatio * controller.getReferenceSpeed() ){
			user.setAlarmState(true);
		}

	}



}
