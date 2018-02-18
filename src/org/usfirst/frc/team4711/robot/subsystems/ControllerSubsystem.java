package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.commands.IntakeCommand;
import org.usfirst.frc.team4711.robot.commands.EjectCommand;
import org.usfirst.frc.team4711.robot.config.KeyMap;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ControllerSubsystem extends Subsystem {
	private Joystick joystick;
	private JoystickButton intakeButton;
	private JoystickButton ejectButton;

	private static ControllerSubsystem instance;
	
	private ControllerSubsystem(){
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		intakeButton = new JoystickButton(joystick, KeyMap.INTAKE);
		intakeButton.whenPressed(new IntakeCommand(0.75));
		
		ejectButton = new JoystickButton(joystick, KeyMap.EJECT);
		ejectButton.whenPressed(new EjectCommand(-0.75));
		
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static ControllerSubsystem getInstance(){
		if(instance == null)
			instance = new ControllerSubsystem();
		
		return instance;
	}
	
	public Joystick getController(){
		return joystick;
	}

}
