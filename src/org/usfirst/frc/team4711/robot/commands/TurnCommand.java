package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {
	private double angle;
	private double setPoint;
	
	private DriveTrain DriveTrain;
	
	public TurnCommand(double angle) {
		super("TurnCommand");
		
		this.angle = angle;
		
		DriveTrain = DriveTrain.getInstance();
		requires(DriveTrain);
		
		setTimeout(10 * Math.abs(angle / 360));
	}
	
	@Override
	protected void initialize() {
		//DriveTrain.setRotateBy(angle);
		//used to start the PID Closed Loop
		//driveSubsystem.enable();
	}
	
	@Override
	protected void execute() {
		DriveTrain.turnOnAxis(angle > 0 ? 1.0 : -1.0);

	}
	
	@Override
	protected boolean isFinished() {
		return DriveTrain.gyro.getAngle() >= setPoint || isTimedOut();
		//Robot.gyro.getAngle() >= setPoint || isTimedOut();	
		//Math.abs(DriveTrain.getSetpoint() - DriveTrain.getPosition()) < .1 || isTimedOut();
	}

	@Override
    protected void end() {
        DriveTrain.stop();
    }
	
	@Override
    protected void interrupted() {
        end();
    }
}

