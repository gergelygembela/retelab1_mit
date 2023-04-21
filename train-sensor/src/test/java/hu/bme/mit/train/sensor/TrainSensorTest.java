package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainController;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl sensor;
    TrainUser mockTrainUser;
    TrainController mockTrainController;

    @Before
    public void before() {
        mockTrainUser = mock(TrainUser.class);

        mockTrainController = mock(TrainController.class);
        when(mockTrainController.getReferenceSpeed()).thenReturn(150);

        sensor = new TrainSensorImpl(mockTrainController, mockTrainUser);


    }
    /**Verifies that a negative speed limit triggers the alarm
    *due to the implementation and the test environment, the
    *alarm is expected to be triggered TWICE. Once by the
    *negative speed, and once more by the speed difference being
    *too high.
    */
    @Test
    public void TestNegativeSpeedTriggersAlarm() {
        sensor.overrideSpeedLimit(-1);
        verify(mockTrainUser, times(2)).setAlarmState(true);
    }    
    
    //verifies that a speed limit higher than 500 triggers the alarm.    
    @Test
    public void TestExcessiveSpeedTriggersAlarm() {
        sensor.overrideSpeedLimit(501);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    //Verifies that a legal speed limit does not trigger the alarm
    @Test
    public void TestZeroSpeedTriggersNoAlarm() {
        sensor.overrideSpeedLimit(130);
        verify(mockTrainUser, times(0)).setAlarmState(true);
    }


    /**Verifies that a speed limit can trigger the alarm
     * based on the dynamic rule.
    */
    @Test
    public void TestSpeedDifferenceTriggersAlarm() {
        sensor.overrideSpeedLimit(50);        
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }


    @Test
    public void testSpeedLimitSaved(){
        sensor.overrideSpeedLimit(42);
        Assert.assertEquals(42, sensor.getSpeedLimit());
    }

}



