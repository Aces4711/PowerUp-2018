package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem.HEIGHTS;

import edu.wpi.first.wpilibj.command.Command;


public class ElevatorDownCommand extends Command {
	private ElevatorSubsystem _elevator;

    public ElevatorDownCommand() {
    	super("elevatorDownCommand");

    	_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
    }

    @Override
	protected void initialize() {
    	HEIGHTS height = _elevator.getCurrentPosition();
    	HEIGHTS lowHeight = height.getNextLowestHeight();
    	_elevator.setCurrentPosition(lowHeight);
    }

    @Override
	protected void execute() {

    }

    @Override
	protected boolean isFinished() {
        return true;
    }

    @Override
	protected void end() {

    }

    @Override
	protected void interrupted() {

    }
}
