package frc.robot;

public enum RobotMap {
    // DriveTrain Ports
    DRIVE_TRAIN_MOTOR_RIGHT_1 (0),
    DRIVE_TRAIN_MOTOR_RIGHT_2 (1),
    DRIVE_TRAIN_MOTOR_LEFT_1 (2),
    DRIVE_TRAIN_MOTOR_LEFT_2 (3),

    // Elevator Ports
    ELEVATOR_MOTOR_LIFT_1 (4),

    // Claw Ports
    CLAW_ROTATION_MOTOR_1 (5),

    // Controller Ports
    CONTROLLER_PORT_1 (0);

    public int port;

    RobotMap(int port) {
        this.port = port;
    }
}