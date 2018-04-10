package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TurnCommandGyro extends Command {

	
	private DriveTrain _driveTrain;
	private double _angle;
	private double _dir;
	
	public TurnCommandGyro(double angle) {
		super("TurnCommandGyro");
		
		_angle = Math.abs(angle);
		_dir = angle > 0 ? 1.0 : -1.0;
		
		_driveTrain = DriveTrain.getInstance();
		requires(_driveTrain);
		 
		
		setTimeout(5);
		//5	* Math.abs(angle / 360)
	}
	
	@Override
	protected void initialize() {
		//_driveTrain.gyro.reset();
		execute();
	}
	
	@Override
	protected void execute() {
		_driveTrain.turnOnAxis(_dir);
		//System.out.println(_driveTrain.gyro.getAngle());
	}
	
	@Override
	protected boolean isFinished() {
		return true;
		//return (_dir > 0 ? 
		//		_driveTrain.gyro.getAngle() >= _angle :
		//		_driveTrain.gyro.getAngle() <= 360 - _angle) || isTimedOut();
		//Robot.gyro.getAngle() >= setPoint || isTimedOut();	
		//Math.abs(DriveTrain.getSetpoint() - DriveTrain.getPosition()) < .1 || isTimedOut();
	}

	@Override
    protected void end() {
        _driveTrain.stop();
    }
	
	@Override
    protected void interrupted() {
        end();
    }
}

