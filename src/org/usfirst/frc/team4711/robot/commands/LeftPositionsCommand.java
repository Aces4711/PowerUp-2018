package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto code when we're in left position
 * @author Team 4711
 *
 */
public class LeftPositionsCommand extends CommandGroup {

    public LeftPositionsCommand(char switchConfiguration) {
		
		
		// if close switch is on the left (like we are)
		if (switchConfiguration == 'L') {
			addSequential(new DriveFor(128));
			addSequential(new TurnCommand(45)); // 45 is actually 90
			//addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			//addSequential(new ClawCommand(-0.5));
		}
		else if (switchConfiguration == 'R') {
			addSequential(new DriveFor(200));		}
		else {
			// should never get here. 
			System.out.println("Encountered unexpected values in plate configuration.");
		}
    }
}
