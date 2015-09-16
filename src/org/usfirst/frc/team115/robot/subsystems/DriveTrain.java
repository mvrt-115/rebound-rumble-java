package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private CANTalon[] motors = new CANTalon[4];
	private RobotDrive drive;
	private final int BACK_LEFT = 0;
	private final int BACK_RIGHT = 1;
	private final int FRONT_LEFT = 2;
	private final int FRONT_RIGHT = 3;
	
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	
	private static final double ENCODER_DISTANCE_PER_PULSE = 1;
	
	/**
	 * Initializes each other motors based on ports set in RobotMap
	 */
	public DriveTrain() {
		super();
		motors[BACK_LEFT] = new CANTalon(RobotMap.BACK_LEFT_DRIVE);
		motors[BACK_RIGHT] = new CANTalon(RobotMap.BACK_RIGHT_DRIVE);
		motors[FRONT_LEFT] = new CANTalon(RobotMap.FRONT_LEFT_DRIVE); 
		motors[FRONT_RIGHT] = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
		
		leftEncoder = new Encoder(RobotMap.DRIVE_ENCODER_LEFT_DIOA, RobotMap.DRIVE_ENCODER_LEFT_DIOB);
		rightEncoder = new Encoder(RobotMap.DRIVE_ENCODER_RIGHT_DIOA, RobotMap.DRIVE_ENCODER_RIGHT_DIOB);
		leftEncoder.setDistancePerPulse(ENCODER_DISTANCE_PER_PULSE);
		rightEncoder.setDistancePerPulse(ENCODER_DISTANCE_PER_PULSE);
		
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
	public void drive(Joystick joystick) {
		drive.arcadeDrive(joystick);
	}
	
	public void control(double left, double right) {
		drive.setLeftRightMotorOutputs(left, right);
	}
	
	public void stop() {
		drive(0, 0);
	}
	
	/**
	 * Resets the gyro, encoders, etc
	 */
	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getVelocity() {
		return (leftEncoder.getRate() + rightEncoder.getRate() ) / 2;
	}
	
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	/**
	 * Initializes the default command of the subsystem.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}
	
	public double getCurrent() {
		double current = 0;
		for (CANTalon motor : motors)
			current += motor.getOutputCurrent();
		return current;
	}

}
