package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunElevatorCommand extends Command {
	private ElevatorSubsystem _elevator;
	
	private double _dir;
	private double _position;
	
	public RunElevatorCommand(ElevatorSubsystem.HEIGHTS position) {
		super("Run Elevator Command");
		
		_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
		
		_position = position.getHeight();
		setTimeout(5);
	}
	
	@Override
	protected void initialize() {
		_dir = _elevator.getPosition() < _position? -1.0 : 1.0;
		execute();
	}
	
    protected void execute() {
    	_elevator.setMotorSpeed(_dir);
    }
    
	@Override
	protected boolean isFinished() {
		//System.out.println("_position : " + _position + "_position Inches : " + Utils.convertPositionToInches(_position, RobotMap.ELEVATOR_WHEEL_DIAMETER) + ", _dir : " + _dir + ", _elevator.getPosition() : " + _elevator.getPosition());
		return ((_dir > 0.0) ? _elevator.getPosition() <=  _position:
							  _elevator.getPosition() >=  _position) ||
				isTimedOut();
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
