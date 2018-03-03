package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.commands.ClawCommand;
import org.usfirst.frc.team4711.robot.commands.ElevatorDownCommand;
import org.usfirst.frc.team4711.robot.commands.ElevatorUpCommand;
import org.usfirst.frc.team4711.robot.commands.RunElevatorCommand;
import org.usfirst.frc.team4711.robot.commands.RunWinchCommand;
import org.usfirst.frc.team4711.robot.config.KeyMap;
import org.usfirst.frc.team4711.robot.config.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ControllerSubsystem extends Subsystem {
	
	private Joystick joystick;
	private JoystickButton intakeButton;
	private JoystickButton ejectButton;
	private JoystickButton winchButton;
	private JoystickButton unwinchButton;
	private JoystickButton elevatorUpButton;

	private static ControllerSubsystem instance;
	
	private ControllerSubsystem(){
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
		
		intakeButton = new JoystickButton(joystick, KeyMap.INTAKE);
		intakeButton.toggleWhenPressed(new ClawCommand(1.0));
		
		ejectButton = new JoystickButton(joystick, KeyMap.EJECT);
		ejectButton.toggleWhenPressed(new ClawCommand(-1.0));
		
		winchButton = new JoystickButton(joystick, KeyMap.WINCH);
		winchButton.toggleWhenPressed(new RunWinchCommand(1.0));
		
		unwinchButton = new JoystickButton(joystick, KeyMap.UN_WINCH);
		unwinchButton.toggleWhenPressed(new RunWinchCommand(-1.0));
		
		elevatorUpButton = new JoystickButton(joystick, KeyMap.ELEVATOR_UP);
		elevatorUpButton.toggleWhenPressed(new ElevatorUpCommand(1));
		
		elevatorDownButton = new JoystickButton(joystick, KeyMap.ELEVATOR_DOWN);
		elevatorDownButton.toggleWhenPressed(new ElevatorDownCommand(1));
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