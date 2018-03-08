package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem.HEIGHTS;

import edu.wpi.first.wpilibj.command.Command;


public class ElevatorUpCommand extends Command {
	private ElevatorSubsystem _elevator;


    public ElevatorUpCommand() {
		super("elevatorUpCommand");
		_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
    }

    @Override
	protected void initialize() {
    	HEIGHTS height = _elevator.getCurrentPosition();
    	HEIGHTS nextHighestHeight = height.getNextHighestHeight();
    	_elevator.setCurrentPosition(nextHighestHeight);
    }

    @Override
	protected void execute() {
    }

    @Override
	protected boolean isFinished() {
    	// todo: Do we need something here?
        return true;
    }

    @Override
	protected void end() {
    }

    @Override
	protected void interrupted() {
    }
}
