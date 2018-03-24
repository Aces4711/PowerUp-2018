package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class RightPositionsCommands extends CommandGroup {

    public RightPositionsCommands(char switchConfiguration) {
    	
    	// if close switch is on the right (like we are)
    	if (switchConfiguration == 'R') {
    		addSequential(new DriveFor(128));
			addSequential(new TurnCommand(-90)); // because -90 would be too easy!
			//addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			//addSequential(new ClawCommand(-0.5));
    	}
    	else if (switchConfiguration == 'L') {
    		addSequential(new DriveFor(200));
    	}
    	else {
    		//Bad robot! How!??
    		System.out.println("Encountered unexpected values in plate configuration.");
    	}
    }
}