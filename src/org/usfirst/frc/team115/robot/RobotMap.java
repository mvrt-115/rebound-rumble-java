package org.usfirst.frc.team115.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * @author Ishan Mitra
 */
public class RobotMap {
	
	/* pneumatics
	public static final int FLAG_SOLENOID_1 = 0;
	public static final int FLAG_SOLENOID_2 = 1;
	 */

	// joystick
	public static final int JOYSTICK 			= 0;

	// joystick buttons
	public static final int SHOOT 				= 1;
	public static final int SHOOT_FAST 			= 3;
	public static final int SHOOT_SLOW 			= 4;
	public static final int TURN  				= 2;
	public static final int FLAG 				= 6;

	// motors
	public static final int SHOOTER_1 			= 3;
	public static final int SHOOTER_2 			= 2;
	public static final int ROLLER 				= 9;
	public static final int ELEVATOR 			= 4;
	public static final int FRONT_LEFT_DRIVE 	= 0;
	public static final int FRONT_RIGHT_DRIVE 	= 5;
	public static final int BACK_LEFT_DRIVE 	= 1;
	public static final int BACK_RIGHT_DRIVE 	= 6;
}

