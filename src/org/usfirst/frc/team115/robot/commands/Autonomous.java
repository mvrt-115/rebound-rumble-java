package org.usfirst.frc.team115.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This class defines a CommandGroup with our autonomous commands.
 * @author Lee Mracek
 *
 */
public class Autonomous extends CommandGroup {
	public Autonomous() {
		addSequential(new DriveStraight(4)); // drive using time rather than distance (goddamnit mech... I want encoders)
	}
}
