package org.usfirst.frc.team115.reboundrumble.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		addSequential(new RaiseFlag(5));
		addSequential(new DriveStraight(4)); //drive using time rather than distance (goddamnit mech... I want encoders)
	}
}
