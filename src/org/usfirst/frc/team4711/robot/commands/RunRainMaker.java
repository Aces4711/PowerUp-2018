package org.usfirst.frc.team4711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4711.robot.commands.RunCenterOrSidePositions;
import org.usfirst.frc.team4711.robot.commands.LeftPositionsCommand;
import org.usfirst.frc.team4711.robot.commands.RightPositionsCommands;

public class RunRainMaker extends CommandGroup {
    public RunRainMaker(char switchConfiguration) {
    	addSequential(new RunCenterOrSidePositions(new CenterPositionCommands(switchConfiguration), 
				new RunLeftOrRightPositions(new LeftPositionsCommand(switchConfiguration), 
											new RightPositionsCommands(switchConfiguration))));
    }
}