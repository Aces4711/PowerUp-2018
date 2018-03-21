package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

//WIP
public class CenterPositionCommands extends CommandGroup {
	public CenterPositionCommands(char switchConfiguration) {
		/*
		String plateConfiguration = DriverStation.getInstance().getGameSpecificMessage();
		char switchConfiguration = plateConfiguration.charAt(0);
		
		if (switchConfiguration == 'L') {
			addSequential(new DriveFor(60));
			addSequential(new TurnCommand(225));
			addSequential(new DriveFor(100));
			addSequential(new TurnCommand(45));
			addSequential(new ClawCommand(-0.5));
		}
		else if (switchConfiguration == 'R') {
			addSequential(new DriveFor(60));
			addSequential(new TurnCommand(45));
			addSequential(new DriveFor(100));
			addSequential(new TurnCommand(225));
			addSequential(new ClawCommand(-0.5));
		}
		else {
			System.out.println("Encountered unexpected values in plate configuration.");
		}
		*/
		addSequential(new DriveFor(80));
	}
}