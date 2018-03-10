package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterPositionCommands extends CommandGroup {
	public CenterPositionCommands() {
		addSequential(new DriveFor(90));
		addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
		addSequential(new ClawCommand(-0.5));
	}
}