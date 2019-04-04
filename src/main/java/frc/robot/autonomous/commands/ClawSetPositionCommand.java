package frc.robot.autonomous.commands;

import frc.robot.Robot;
import frc.robot.autonomous.Command;
import frc.utils.RobotMath;

/**
 * A command that sets the claw position.
 */
public class ClawSetPositionCommand extends Command {
    private double position = 0.0;
    private double speed = 0.0;

    private double error = 0.0;

    public ClawSetPositionCommand(double position, double speed) {
        this.position = position;
        this.speed = speed;
    }

    @Override
    public void periodic() {
        // double clawPosition = Robot.claw.getPosition();
        double clawPosition = 0;
        if(Math.hypot(clawPosition, position) <= error) isFinished = true;
        else {
            Robot.claw.rotate(RobotMath.Direction(clawPosition, position) * speed);
        }
    }

    /*
    * Finish is called when the command ends.
    */
    @Override
    public void finish() {
        System.out.printf("Example command finished.");
    }
}