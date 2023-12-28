
package Helpers;

import java.io.IOException;

import se.hirt.pi.adafruit.pwm.PWMDevice;
import se.hirt.pi.adafruit.pwm.PWMDevice.PWMChannel;

public class MotorController extends PWMDevice {
	
PWMDevice name = new PWMDevice();

	public MotorController(int channelnumber) throws IOException{
		PWMChannel channel = name.getChannel(channelnumber);
	}
	
	public void set(double frequency) throws IOException{
		name.setPWMFreqency(frequency);
	}
	

}
