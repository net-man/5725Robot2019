package frc.robot.extra.settings;

public class RobotSettings {
    public DriveTrainSettings driveTrain;
    public ElevatorSettings elevator;
    public ArmSettings arm;
    public ClawSettings claw;

    public RobotSettings() {
        driveTrain = new DriveTrainSettings();
        elevator = new ElevatorSettings();
        arm = new ArmSettings();
        claw = new ClawSettings();
    }
}