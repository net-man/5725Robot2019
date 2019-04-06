package frc.robot.extra.settings;

public class RobotSettings {
    // --- Robot Drive Train Settings --- //
    public static double driveTrainSpeed = 0.6;
    public static double driveTrainDriveSpeed = 1.0;
    public static double driveTrainTurnSpeed = 0.7;

    public static double driveTrainRightSpeed = 1.0;
    public static double driveTrainLeftSpeed = 1.0;

    public static boolean driveTrainIsDriveSquared = true;
    public static boolean driveTrainIsDriveSnapped = true;

    public static double[] driveTrainSnapValuesX = { -1.0, -0.5, -0.3, 0.0, 0.3, 0.5, 1.0 };
    public static double[] driveTrainSnapValuesY = { -1.0, -0.5, -0.3, 0.0, 0.3, 0.5, 1.0 };
    
    // --- Robot Elevator Settings --- //
    public static double elevatorSpeed = 0.9;
    public static double elevatorSpeedAscending = 1.0;
    public static double elevatorSpeedDescending = 1.0;

    public static boolean elevatorLimitAscending = true;
    public static boolean elevatorLimitDescending = true;

    // --- Robot Arm Settings --- //
    public static double armSpeed = 0.45;
    public static double armSpeedBall = 0.8;
    public static double armSpeedHatch = 0.9;
    public static double armSpeedUpRotation = 0.7;
    public static double armSpeedDownRotation = 0.3;
    
    public static boolean armIsArmSquared = true;
    public static boolean armIsArmSnapped = true;

    public static double[] armSnapValues = { -1.0, -0.5, 0, 0.5, 1.0 };

    // --- Robot Claw Settings --- //
    public static double clawSpeed = 1.0f;
    public static double clawSpeedOpen = 1.0f;
    public static double clawSpeedClose = 1.0f;

    public static boolean clawIsConstantClampForceEnabled = false; // TODO: Make do something.
    public static double clawSpeedConstantClampForce = 0.3;

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