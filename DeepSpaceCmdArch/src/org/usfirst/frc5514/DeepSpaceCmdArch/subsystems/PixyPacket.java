// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5514.DeepSpaceCmdArch.subsystems;


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class PixyPacket {

	public int Signature;
	public int X;
	public int Y;
	public int Width;
	public int Height;

	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public PixyPacket (double speedLimit, double rotateLimit) {
		
		System.out.println("Constructors are working");
	
	}
	
	public PixyPacket() {
		
		System.out.println("Constructors are working");
		
	}
	
	public String toString() {
		return "" +
	" S:" + Signature +
	" X:" + X + 
	" Y:" + Y +
	" W:" + Width + 
	" H:" + Height;
	}
}

