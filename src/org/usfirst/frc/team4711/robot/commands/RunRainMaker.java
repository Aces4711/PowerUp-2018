package org.usfirst.frc.team4711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunRainMaker extends CommandGroup {

    public RunRainMaker() {
    	System.out.println("Run Rain Maker!");
    	addSequential(new DriveFor(36.0));
    	addSequential(new DriveFor(-36.0));
    }
}