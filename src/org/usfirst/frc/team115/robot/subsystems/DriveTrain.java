package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private CANTalon frontLeftMotor, frontRightMotor,
						backLeftMotor, backRightMotor;
	private RobotDrive drive;
	
	/**
	 * Initializes each other motors based on ports set in RobotMap
	 */
	public DriveTrain() {
		super();
		backLeftMotor = new CANTalon(RobotMap.BACK_LEFT_DRIVE);
		backRightMotor = new CANTalon(RobotMap.BACK_RIGHT_DRIVE);
		frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE); 
		frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
		drive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
	}
	
	/**
	 * Drives the robot
	 * @param left The speed of the left motors
	 * @param right The speed of the right motors
	 */
	public void drive(double left, double right) {
		drive.arcadeDrive(left, right);
	}
	/**
	 * Drives the robot
	 * @param joystick The joystick to drive based on
	 */
	public void drive(Joystick joystick) {
		drive.arcadeDrive(joystick);
	}
	
	/**
	 * Resets the gyro, encoders, etc
	 */
	public void reset() {
		//reset gyro, encoders, etc
	}
	
	/**
	 * Initializes the default command of the subsystem.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

}
