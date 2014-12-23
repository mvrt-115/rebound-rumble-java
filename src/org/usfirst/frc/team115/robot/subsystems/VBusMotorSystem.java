package org.usfirst.frc.team115.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class VBusMotorSystem extends Subsystem {
	protected ArrayList<CANTalon> motors = new ArrayList<CANTalon>();
	private double speed;
	
	public void stop() {
		for (CANTalon motor : motors) {
			motor.set(0);
		}
	}

	public void setSpeed(double speed) throws MotorSpeedException {
		this.speed = speed;
		if (Math.abs(speed) <= 1) {
			for (CANTalon motor : motors) {
				motor.set(-this.speed);
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