package frc.robot.extra.settings;

public class RobotSettings {
    // --- Robot Drive Train Settings --- //
    public static double driveTrainSpeed = 0.6;
    public static double driveTrainDriveSpeed = 1.0;
    public static double driveTrainTurnSpeed = 1.0;

    public static double driveTrainRightSpeed = 1.0;
    public static double driveTrainLeftSpeed = 1.0;

    public static boolean driveTrainIsDriveNormalized = false;
    
    // --- Robot Elevator Settings --- //
    public static double elevatorSpeed = 0.6;
    public static double elevatorSpeedAscending = 1.0;
    public static double elevatorSpeedDescending = 1.0;

    public static boolean elevatorLimitAscending = true;
    public static boolean elevatorLimitDescending = true;

    // --- Robot Arm Settings --- //
    public static double armSpeed = 0.7;
    public static double armSpeedUpRotation = 1.0;
    public static double armSpeedDownRotation = 0.5;

    // --- Robot Claw Settings --- //
    public static double clawSpeed = 0.6f;
    public static double clawSpeedOpen = 1.0f;
    public static double clawSpeedClose = 1.0f;

    public static boolean clawConstantClampForce = false;
    
    // --- Robot Port Settings --- //
    public static int portDriveTrainMotorRight1 = 5;
    public static int portDriveTrainMotorRight2 = 4;
    public static int portDriveTrainMotorLeft1 = 3;
    public static int portDriveTrainMotorLeft2 = 2;

    public static int portElevatorMotor = 9;
    public static int dportElevatorSwitchTop = 0;
    public static int dportElevatorSwitchBottom = 1;

    public static int portArmMotor = 6;
    
    public static int portClawMotor = 7;

}