package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class LeftPositionsCommand extends CommandGroup {

    public LeftPositionsCommand() {
    	addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.HIGH));
    	addSequential(new DriveFor(200));
    	addSequential(new TurnCommand(45));
    	addSequential(new ClawCommand(-1));
    }
}
