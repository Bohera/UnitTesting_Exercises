package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlarmTest {
    @Test
    public void test_Alarm_WithLowPressure() {
        Sensor sensorWithLowPressure = Mockito.mock(Sensor.class);
        when(sensorWithLowPressure.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensorWithLowPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_WithHighPressure() {
        Sensor sensorWithHighPressure = Mockito.mock(Sensor.class);
        when(sensorWithHighPressure.popNextPressurePsiValue()).thenReturn(100.0);
        Alarm alarm = new Alarm(sensorWithHighPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_WithNormalPressure() {
        Sensor sensorWithNormalPressure = Mockito.mock(Sensor.class);
        when(sensorWithNormalPressure.popNextPressurePsiValue()).thenReturn(19.0);
        Alarm alarm = new Alarm(sensorWithNormalPressure);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}