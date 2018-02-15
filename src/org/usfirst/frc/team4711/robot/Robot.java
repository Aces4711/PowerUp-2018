package org.usfirst.frc.team4711.robot;

import org.usfirst.frc.team4711.robot.commands.DriveWithController;
//import org.usfirst.frc.team4711.robot.commands.DropNShoot;
//import org.usfirst.frc.team4711.robot.commands.RunTest;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	private Command autonomousCommand;
	private Command teleopCommand;
	
	public void robotInit() {
		//autonomousCommand = new DropNShoot();
		teleopCommand = new DriveWithController();
		//teleopCommand = new RunTest(RunTest.State.FREE, 0.0);
	}
	
	public void teleopInit() {
		if(autonomousCommand != null) 
			autonomousCommand.cancel();
		
		if(teleopCommand != null)
			teleopCommand.start();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		if(teleopCommand != null)
			teleopCommand.cancel();
		
		if(autonomousCommand != null) 
			autonomousCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
}