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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Ultrasonic environmentalUltrasonicFront;
    public static Ultrasonic environmentalUltrasonicRear;
    public static Spark cargoGate;
    public static Spark hatchExtender;
    public static Spark armHand;
    public static SpeedController driveTrainRightFront;
    public static SpeedController driveTrainRightRear;
    public static SpeedController driveTrainLeftFront;
    public static SpeedController driveTrainLeftRear;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        environmentalUltrasonicFront = new Ultrasonic(0, 1);
        LiveWindow.addSensor("Environmental", "Ultrasonic Front", environmentalUltrasonicFront);
        
        environmentalUltrasonicRear = new Ultrasonic(2, 3);
        LiveWindow.addSensor("Environmental", "Ultrasonic Rear", environmentalUltrasonicRear);
        
        cargoGate = new Spark(1);
        LiveWindow.addActuator("Cargo", "Gate", (Spark) cargoGate);
        cargoGate.setInverted(false);
        hatchExtender = new Spark(2);
        LiveWindow.addActuator("Hatch", "Extender", (Spark) hatchExtender);
        hatchExtender.setInverted(false);
        armHand = new Spark(3);
        LiveWindow.addActuator("Arm", "Hand", (Spark) armHand);
        armHand.setInverted(false);
        driveTrainRightFront = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "Right Front", (Talon) driveTrainRightFront);
        driveTrainRightFront.setInverted(true);
        driveTrainRightRear = new Talon(5);
        LiveWindow.addActuator("DriveTrain", "Right Rear", (Talon) driveTrainRightRear);
        driveTrainRightRear.setInverted(true);
        driveTrainLeftFront = new Talon(6);
        LiveWindow.addActuator("DriveTrain", "Left Front", (Talon) driveTrainLeftFront);
        driveTrainLeftFront.setInverted(false);
        driveTrainLeftRear = new Talon(7);
        LiveWindow.addActuator("DriveTrain", "Left Rear", (Talon) driveTrainLeftRear);
        driveTrainLeftRear.setInverted(false);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
