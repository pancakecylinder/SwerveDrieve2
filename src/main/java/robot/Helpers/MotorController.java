
package robot.Helpers;

import java.io.IOException;
import java.lang.Math;

import se.hirt.pi.adafruit.pwm.PWMDevice;
import se.hirt.pi.adafruit.pwm.PWMDevice.PWMChannel;

public class MotorController extends PWMDevice {
	
	public static PWMDevice name;
	public static PWMChannel channel;
	
	//in Hz
	public static double frequency;
	//in seconds
	public static double period;
	//in milliseconds
	public static double msperiod;
	
	// 12 bit fidelity --> 0 to 4095
	public static final double bit12fidelity = 4095;
	
	
	//VICTOR SP Motor Controllers support input PWM from 10Hz and 345Hz (100ms - 2.9ms)  
	public static final double victorspfrequencymax = 344;
	public static final double victorspfrequencymin = 10;
	public static final double victorspmsperiodmax = 2.9;
	public static final double victorspmsperiodmin = 100;
	
	public static void initializeVictorSP() throws IOException {
		name = new PWMDevice();
		name.setPWMFreqency(victorspfrequencymax);
	}
	
	public static void setFrequency(double newfrequency) throws IOException	{
		name.setPWMFreqency(newfrequency);
		frequency = newfrequency;
		period = 1/frequency;
		msperiod = period * 1000;
	}

	public MotorController(int channelnumber) throws IllegalArgumentException,IOException {
				channel = name.getChannel(channelnumber);
		
		if (channelnumber < 0 || channelnumber > 16) {
			throw new IllegalArgumentException("Channel # has to be between 0 and 16");
		}
	}
	

/*2.004ms = full "forward"
 1.520ms = the "high end" of the deadband range
1.500ms = center of the deadband range (off)
1.480ms = the "low end" of the deadband range
0.997ms = full "reverse" 
scale of -1 to 1*/
	public void setVictorSP(double speed) throws IOException {
		
	// victorspmsperiodmax / factor  = ((speed/2) + 1.500)
	
	double victorspfactor = victorspmsperiodmax / ((speed/2) + 1.500);
	int pwmvalue = (int) Math.round((bit12fidelity / victorspfactor));
try {
    channel.setPWM(0, pwmvalue);
} catch (IOException e) {
	System.out.println("Sucks to suck!");
}
	}

	
}
	


