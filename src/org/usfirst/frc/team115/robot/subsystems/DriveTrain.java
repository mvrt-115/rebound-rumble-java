package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private Talon[] motors = new Talon[4];
	private RobotDrive drive;
	private final int BACK_LEFT = 0;
	private final int BACK_RIGHT = 1;
	private final int FRONT_LEFT = 2;
	private final int FRONT_RIGHT = 3;

	/**
	 * Initializes each other motors based on ports set in RobotMap
	 */
	public DriveTrain() {
		super();
		motors[BACK_LEFT] = new Talon(RobotMap.BACK_LEFT_DRIVE);
		motors[BACK_RIGHT] = new Talon(RobotMap.BACK_RIGHT_DRIVE);
		motors[FRONT_LEFT] = new Talon(RobotMap.FRONT_LEFT_DRIVE); 
		motors[FRONT_RIGHT] = new Talon(RobotMap.FRONT_RIGHT_DRIVE);
		drive = new RobotDrive(motors[FRONT_LEFT], motors[BACK_LEFT], motors[FRONT_RIGHT], motors[BACK_RIGHT]);
	}

	/**
	 * Drives the robot
	 * @param left The speed of the left motors
	 * @param right The speed of the right motors
	 */
	public void drive(double left, double right) {
		drive.setLeftRightMotorOutputs(left, right);
	}

	/**
	 * Drives the robot
	 * @param joystick The joystick to drive based on
	 */
	public void drive(Joystick joystick, boolean b) {
		if(b)
			drive.arcadeDrive(joystick.getY(), joystick.getZ());
//		else
			//drive.arcadeDrive(joystick.getY()/2, 0);
	}

	/**
	 * Resets the gyro, encoders, etc
	 */
	public void reset() {
		// reset gyro, encoders, etc
	}

	/**
	 * Initializes the default command of the subsystem.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

}
