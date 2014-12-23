package org.usfirst.frc.team115.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class VBusMotorSystem extends Subsystem {
	protected ArrayList<SpeedController> motors;
	private double speed;
	
	public void stop() {
		for (SpeedController motor : motors) {
			motor.set(0);
		}
	}

	public void setSpeed(double speed) throws MotorSpeedException {
		this.speed = speed;
		if (Math.abs(speed) < 1) {
			for (SpeedController motor : motors) {
				motor.set(this.speed);
			}
		} else {
			throw new MotorSpeedException("Shooter speed cannot be "
					+ "greater than 1 or less than -1", speed);
		}
	}

	public double getSpeed() {
		return speed;
	}

}