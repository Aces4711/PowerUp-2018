package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.StartPositionSwitchSubsystem;
import org.usfirst.frc.team4711.robot.subsystems.StartPositionSwitchSubsystem.StartPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class RunCenterOrSidePositions extends ConditionalCommand {

	public RunCenterOrSidePositions(Command centerCommands, Command sideCommands) {
		super("runCenterOrSidePositions", centerCommands, sideCommands);
	}

	@Override
	protected boolean condition() {
		return StartPositionSwitchSubsystem.getInstance().getStartPosition() == StartPosition.CENTER;
	}

}