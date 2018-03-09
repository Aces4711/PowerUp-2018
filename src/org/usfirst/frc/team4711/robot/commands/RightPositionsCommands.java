package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightPositionsCommands extends CommandGroup {

    public RightPositionsCommands() {
    	addSequential(new DriveFor(128));
    	addSequential(new TurnCommand(-90));
    	addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
    	addSequential(new DriveFor(12));
    	addSequential(new ClawCommand(-1));
    }
}
