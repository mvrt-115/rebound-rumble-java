package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private SpeedController frontLeftMotor, frontRightMotor,
						backLeftMotor, backRightMotor;
	private RobotDrive drive;
	
	public DriveTrain() {
		super();
		backLeftMotor = new CANTalon(RobotMap.BACK_LEFT_DRIVE);
		backRightMotor = new CANTalon(RobotMap.BACK_RIGHT_DRIVE);
		frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE); 
		frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
		drive = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
	}
	
	public void drive(double left, double right) {
		drive.arcadeDrive(left, right);
	}
	
	public void drive(Joystick joystick) {
		drive.arcadeDrive(joystick);
	}
	
	public void reset() {
		//reset gyro, encoders, etc
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick());
	}

}
