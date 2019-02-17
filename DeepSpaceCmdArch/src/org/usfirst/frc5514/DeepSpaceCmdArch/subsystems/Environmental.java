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

import org.usfirst.frc5514.DeepSpaceCmdArch.Robot;
import org.usfirst.frc5514.DeepSpaceCmdArch.RobotMap;
import org.usfirst.frc5514.DeepSpaceCmdArch.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// For I2C
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Ultrasonic;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Environmental extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Ultrasonic ultrasonicFront = RobotMap.environmentalUltrasonicFront;
    private final Ultrasonic ultrasonicRear = RobotMap.environmentalUltrasonicRear;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public PixyI2C linePixy;
	Port port = Port.kOnboard;
	String print;
	public PixyPacket[] packet1 = new PixyPacket[7];
	public PixyPacket[] packet2 = new PixyPacket[7];
	
	int gy,gz,ax,ay,az;
	
	
	public Environmental() {
		//DigitalModule module = DigitalModule.getInstance(2);
		
		// Use the PixyMon application to set the address of the Pixy2 camera
		// currently it's: 0x54
		linePixy = new PixyI2C("line", new I2C(port, 0x54), packet1, new PixyException(print), new PixyPacket());
	}
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
       	if (Robot.oi.getSafety()) {
    		System.out.println("Safety Button pressed, calling testLinePixy");
    		testLinePixy();
    	} 
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void testLinePixy() {
		
    	for (int i = 0; i < packet1.length; i++)
			packet1[i] = null;
		
		SmartDashboard.putString(" testLinePixy hello", "working");
		
		for (int i = 1; i < 8; i++) {
			
			try {
				packet1[i - 1] = linePixy.readPacket(i);
			} catch (PixyException e) {
				SmartDashboard.putString(" testLinePixy Error: " + i, "exception");
			}
			
			if (packet1[i - 1] == null) {
				SmartDashboard.putString(" testLinePixy Error: " + i, "True");
				continue;
			}
			
			SmartDashboard.putNumber(" testLinePixy X Value: " + i, packet1[i - 1].X);
			SmartDashboard.putNumber(" testLinePixy Y Value: " + i, packet1[i - 1].Y);
			SmartDashboard.putNumber(" testLinePixy Width Value: " + i, packet1[i - 1].Width);
			SmartDashboard.putNumber(" testLinePixy Height Value: " + i, packet1[i - 1].Height);
			SmartDashboard.putString(" testLinePixy Error: " + i, "False");
		}
	}
    
	// Get blocks that represent the vision tape on either side of the line. This
	// can return 0,1, or 2 blocks depending what is found in a frame.
	public PixyPacket[] getLinePosition() {
		
		PixyPacket[] blocks = linePixy.readBlocks();
		
		SmartDashboard.putBoolean("Line Blocks Array is null", blocks == null);
		
		if (blocks == null)
			return null;
		
		SmartDashboard.putString("Line Block 0", (blocks[0] == null) ? "null" : blocks[0].toString());
		SmartDashboard.putString("Line Block 1", (blocks[1] == null) ? "null" : blocks[1].toString());
		
		return blocks;
	}
    
	// Using blocks from pixy, create a target class that will do all the magic
	// math we need to determine angle and distance to line.
	public LineTarget getLineTarget() {
		
		PixyPacket[] packets = getLinePosition();
		
		if (packets == null || (packets[0] == null && packets[1] == null))
			return null;
		
		return new LineTarget(packets[0], packets[1]);
	}

	
	public LineTarget getLineTargetFiltered() {
		LineTarget t;
		
		for (int i = 0; i < 10; i++) {
			t = getLineTarget();
			
			if (t != null) {
				return t;
			}
		}
		return null;
	}
	
}

