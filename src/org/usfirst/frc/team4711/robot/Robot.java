//Package declaration
package org.usfirst.frc.team4711.robot;

import org.usfirst.frc.team4711.robot.commands.RunRainMaker;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4711.robot.subsystems.RobotEyeSubsystem;
//Import library/dependencies
import org.usfirst.frc.team4711.robot.commands.CommandWithController;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

//Class declaration
public class Robot extends IterativeRobot {
	
	//Command Objects
	private Command autonomousCommand;
	private Command teleopCommand;

	
	public Robot() {
		//ahrs = new AHRS(SPI.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */
	}
	
	public void robotInit() {
		teleopCommand = new CommandWithController();
		
		System.out.println(DriverStation.getInstance().getGameSpecificMessage());
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
		String plateConfiguration = null;
		
		while (plateConfiguration == null) {
			System.out.println("autonomousInit entered loop...");
			String tryPlateConfiguration = DriverStation.getInstance().getGameSpecificMessage();
			if (tryPlateConfiguration.length() > 0)
				plateConfiguration = tryPlateConfiguration; 
		}
		System.out.println("autonomousInit exited loop. plateConfiguration: " + plateConfiguration);
		
		char switchConfiguration = plateConfiguration.charAt(0);
		
		autonomousCommand = new RunRainMaker(switchConfiguration);
		DriveTrain.getInstance().gyro.reset();
		
		if(teleopCommand != null)
			teleopCommand.cancel();
		
		if(autonomousCommand != null) 
			autonomousCommand.start();
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
}