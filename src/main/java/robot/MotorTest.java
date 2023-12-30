package robot;

import robot.Helpers.*;
import java.io.IOException;

import se.hirt.pi.adafruit.pwm.PWMDevice;
import se.hirt.pi.adafruit.pwm.PWMDevice.PWMChannel;

public class MotorTest {
	
	public static void main(String[] args) {
		try {
		MotorController.initializeVictorSP();
	} catch (IOException e) {
		System.out.println("Initialization failed!");
	}
		try {
		MotorController motor1 = new MotorController(0);
		for(i=1; i < 11; i++){
		motor1.setVictorSP(1);
		Thread.sleep(5000);
		motor1.setVictorSP(-1);
		Thread.sleep(5000);
	}

	} catch (IOException e) {
		System.out.println("MotorController could not be made!");
	} catch (InterruptedException a) {
		System.out.println("Not a valid time");
	}
	
	System.exit(0);
		
		
		
	}
}
