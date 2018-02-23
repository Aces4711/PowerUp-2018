//Package declaration
package org.usfirst.frc.team4711.robot;

import org.usfirst.frc.team4711.robot.commands.RunRainMaker;

//Import library/dependencies
import org.usfirst.frc.team4711.robot.commands.CommandWithController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

//Class declaration
public class Robot extends IterativeRobot {
	
	//Command Objects
	private Command autonomousCommand;
	private Command teleopCommand;
	public ADXRS450_Gyro gyro;
	
	public Robot() {
		//ahrs = new AHRS(SPI.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */
		gyro = new ADXRS450_Gyro();
	}
	
	public void robotInit() {
		autonomousCommand = new RunRainMaker();
		teleopCommand = new CommandWithController();
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
		
		gyro.reset();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
}