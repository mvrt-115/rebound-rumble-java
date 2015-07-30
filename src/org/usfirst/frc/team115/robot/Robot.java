
package org.usfirst.frc.team115.robot;

import org.usfirst.frc.team115.robot.commands.Autonomous;
import org.usfirst.frc.team115.robot.commands.led.FadePulse;
import org.usfirst.frc.team115.robot.commands.led.FlashColor;
import org.usfirst.frc.team115.robot.commands.led.Rainbow;
import org.usfirst.frc.team115.robot.commands.led.SetColor;
import org.usfirst.frc.team115.robot.subsystems.DriveTrain;
import org.usfirst.frc.team115.robot.subsystems.Flag;
import org.usfirst.frc.team115.robot.subsystems.Loader;
import org.usfirst.frc.team115.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team115.robot.subsystems.LEDStrip;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Shooter shooter;
	public static Loader loader;
	public static DriveTrain drive;
	public static Flag flag;
	public static LEDStrip ledStripPrimary;

    Command autonomousCommand; // null because I don't want to deal with this yet
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// initializes each subsystem on the robot
    	shooter = new Shooter();
    	loader = new Loader();
    	drive = new DriveTrain();
    	oi = new OI();
		
    	ledStripPrimary = new LEDStrip(5803, "10.1.15.16");
    	
    	// initializes command for autonomous
		autonomousCommand = new Autonomous();
    }
	
    // runs periodically when the robot is  disabled
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	// Initialize and run the command at the start of autonomous
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This method is called once when teleop starts
     */
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//		new FadePulse(LEDStrip.PURPLE, LEDStrip.GOLD, (short) 5000).start();
//    	new FlashColor(LEDStrip.RED, (short)5000, (short)3000).start();;
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	new Rainbow((short) 3000).start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
//    	new FlashColor(LEDStrip.PURPLE, (short) 1000, (short) 500).start();
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
