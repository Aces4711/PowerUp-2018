package org.usfirst.frc.team4711.robot;


public class Utils {
	public static double convertInchesToPosition(double inches, double diameter) {
		double circumference = Math.PI * diameter;
		double position = (inches / circumference) * 4.0 * 1024.0;
		
		return position;
	}
	
	public static double convertPositionToInches(double position, double diameter) {
		double circumference = Math.PI * diameter;
		double inches = (position / (4.0 * 1024.0)) * circumference;
		
		return inches;
	}

}
