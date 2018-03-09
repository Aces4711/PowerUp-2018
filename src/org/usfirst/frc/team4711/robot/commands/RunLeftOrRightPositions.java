package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.StartPositionSwitchSubsystem;
import org.usfirst.frc.team4711.robot.subsystems.StartPositionSwitchSubsystem.StartPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class RunLeftOrRightPositions extends ConditionalCommand {

	public RunLeftOrRightPositions(Command leftCommands, Command rightCommands) {
		super("runLeftOrRightPositions", leftCommands, rightCommands);
	}

	@Override
	protected boolean condition() {
		return StartPositionSwitchSubsystem.getInstance().getStartPosition() == StartPosition.LEFT;
	}

}
