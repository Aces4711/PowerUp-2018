package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunElevatorCommand extends Command{
	private ElevatorSubsystem _elevator;
	
	private int _position;
	
	public RunElevatorCommand(int position) {
		super("Run Elevator Command");
		
		_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
		
		_position = position;
	}
	
	@Override
	protected void initialize() {
		_elevator.setMotorSpeed(_position);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
    protected void end() {
		_elevator.setMotorSpeed(0.0);
    }
	
	@Override
    protected void interrupted() {
        end();
    }

}
