package org.usfirst.frc.team115.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * @author Lee Mracek
 */
public class RobotMap {
	// joystick
	public static final int JOYSTICK = 0;
	
	// joystick buttons
	public static final int SHOOT = 1;
	public static final int FLAG = 6;
	
	// motors
    public static final int SHOOTER_1 = 3;
    public static final int SHOOTER_2 = 4;
    public static final int ROLLER = 2;
    public static final int ELEVATOR = 1;
    public static final int FRONT_LEFT_DRIVE = 0;
    public static final int FRONT_RIGHT_DRIVE = 5;
    public static final int BACK_LEFT_DRIVE = 1;
    public static final int BACK_RIGHT_DRIVE = 6;
    
    public static final double DRIVE_POSITION_KP = 0;
    public static final double DRIVE_POSITION_KI = 0;
    public static final double DRIVE_POSITION_KD = 0;
    public static final double DRIVE_POSITION_KV = 0;
    public static final double DRIVE_POSITION_KA = 0;

    public static final double DRIVE_ON_TARGET_ERROR = 0;
    public static final double DRIVE_MAX_ACCEL = 0;
    public static final double DRIVE_MAX_VELOCITY = 0;
    
    public static final double DRIVE_STRAIGHT_KP = 0;
    public static final double DRIVE_STRAIGHT_KI = 0;
    public static final double DRIVE_STRAIGHT_KD = 0;
    
    public static final int DRIVE_ENCODER_RIGHT_DIOA = 0;
    public static final int DRIVE_ENCODER_RIGHT_DIOB = 1;
    
    public static final double TURN_KP = 0;
    public static final double TURN_KI = 0;
    public static final double TURN_KD = 0;
    public static final double TURN_KA = 0;
    public static final double TURN_KV = 0;
    public static final double TURN_ON_TARGET_ERROR = 0;
    public static final double TURN_MAX_ACCEL = 0;
    public static final double TURN_MAX_VELOCITY = 0;
}

