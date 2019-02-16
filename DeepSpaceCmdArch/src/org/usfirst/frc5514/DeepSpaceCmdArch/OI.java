// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5514.DeepSpaceCmdArch;

import org.usfirst.frc5514.DeepSpaceCmdArch.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc5514.DeepSpaceCmdArch.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickButton1;
    public XboxController mecstick = new XboxController(0);
    public JoystickButton launchPadBtn1;
    public Joystick launchpad;

    private double leftDeadzone;
    
    private double leftXAxis;
    private double leftXValue;
    
    private double leftYAxis;
    private double leftYValue;
    
    private double rightDeadzone;
    
    private double rightXAxis;
    private double rightXValue;
    
    boolean LPSafety;
	boolean LPCargoGate;
	boolean LPArmDown;
	boolean LPArmUp;
	boolean LPHandExt;
	boolean LPHandRtc;
	boolean LPHandOpen;
	boolean LPHandClose;
	double LPDial;
	
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        launchpad = new Joystick(0);
		
        leftDeadzone = .1;
		rightDeadzone = .2;
        
		/* Not needed here, must pull values in functions below
		LPSafety = launchpad.getRawButton(4);
		LPCargoGate = launchpad.getRawButton(5);
		LPArmDown = launchpad.getRawButton(6);
		LPArmUp = launchpad.getRawButton(7);
		LPHandExt = launchpad.getRawButton(8);
		LPHandRtc = launchpad.getRawButton(9);
		LPHandOpen = launchpad.getRawButton(10);
		LPHandClose = launchpad.getRawButton(11);
		LPDial = launchpad.getRawAxis(6);
		*/
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public XboxController getXboxJoystick() {
        return mecstick;
    }
    

    public Joystick getLaunchPad() {
        return launchpad;
    }

    public double getX() {
    	
		leftXAxis = mecstick.getX(GenericHID.Hand.kLeft)*-1.0;
		
		if (Math.abs(leftXAxis) < leftDeadzone) {
			
			leftXValue = 0;
			
		} else if (leftXAxis < 0) {
			
			leftXValue = leftXAxis + leftDeadzone;
			
		} else if (leftXAxis > 0) {
			
			leftXValue = leftXAxis - leftDeadzone;
			
		} else {
			
			leftXValue = 0;
			
		}
		
		return leftXValue;
		
    }
    
    public double getY() {
    	
    	leftYAxis = mecstick.getY(GenericHID.Hand.kLeft)*-1.0;
		
		if (Math.abs(leftYAxis) < leftDeadzone) {
			
			leftYValue = 0;
			
		} else if (leftYAxis < 0) {
			
			leftYValue = leftYAxis + leftDeadzone;
			
		} else if (leftXAxis > 0) {
			
			leftYValue = leftYAxis - leftDeadzone;
			
		} else {
			
			leftYValue = 0;
			
		}
		
		return leftYValue;
		
    }
    
    public double getRotate() {
    	
    	rightXAxis = mecstick.getY(GenericHID.Hand.kLeft)*-1.0;
		
		if (Math.abs(rightXAxis) < rightDeadzone) {
			
			rightXValue = 0;
			
		} else if (rightXAxis < 0) {
			
			rightXValue = rightXAxis + rightDeadzone;
			
		} else if (leftXAxis > 0) {
			
			rightXValue = rightXAxis - rightDeadzone;
			
		} else {
			
			rightXValue = 0;
			
		}
		
		return rightXValue;

    }
   
    public boolean getSafety() {
    	return launchpad.getRawButton(4);	
    }
    public boolean getCargoGate() {
    	return launchpad.getRawButton(5);	
    }
    
    public boolean getArmDown() {
    	return launchpad.getRawButton(6);
    }

    public boolean getArmUp() {
    	return launchpad.getRawButton(7);
    }

    public boolean getHandExt() {
    	return launchpad.getRawButton(8);
    }    
    
    public boolean getHandRtc() {
    	return launchpad.getRawButton(9);
    }
    
    public boolean getHandOpen() {
    	return launchpad.getRawButton(10);
    }
    
    public boolean getHandClose() {
    	return launchpad.getRawButton(11);
    }
    
    public double getSpeed() {
    	// This produces values of 0.44 -> 0.5
    	LPDial = (1 - ((launchpad.getRawAxis(6) + 1.0) / 2.0));
    	
    	// test purposes only - values are 0 -> 0.11811
    	//LPDial = launchpad.getRawAxis(6);
    	
    	return LPDial;
    	
    }
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

