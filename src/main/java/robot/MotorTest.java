package robot;

import robot.Helpers.*;
import java.io.IOException;

import se.hirt.pi.adafruit.pwm.PWMDevice.*;

public class MotorTest {
	public static void main(String[] args) {
		try {
		MotorController.initializeVictorSP();
	} catch (IOException e) {
		System.out.println("Initialization failed!");
	}
		try {
		MotorController motor1 = new MotorController(0);
		motor1.setVictorSP(1);

		motor1.setVictorSP(-1);

	} catch (IOException e) {
		System.out.println("MotorController could not be made!");
	}
		
		
		System.exit(0);
		
		
	}
}
