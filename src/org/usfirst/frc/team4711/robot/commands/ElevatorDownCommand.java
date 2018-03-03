package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;
 

public class ElevatorDownCommand extends Command {
	private ElevatorSubsystem _elevator;

    public ElevatorDownCommand() {
    	super("elevatorDownCommand");
    	
    	_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
