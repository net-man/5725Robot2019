package frc.robot.autonomous.commands;

import frc.robot.autonomous.Command;

public class ExampleCommand implements Command {
    private boolean isFinished = false;

    private int index = 0;

    public ExampleCommand() {
        System.out.printf("Example command created.");
    }

    @Override
    public void Periodic() {
        index++;
        if(index == 20) isFinished = true;

        System.out.printf("Example command periodic.");
    }

    @Override
    public void Finish() {
        System.out.printf("Example command finished.");
    }

    @Override
    public boolean IsFinished() {
        return isFinished;
    }
}