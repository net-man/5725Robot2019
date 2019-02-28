package frc.robot.autonomous.commands;

import frc.robot.autonomous.Command;

/**
 * An example for the {@link Command} base class.
 * <p>
 * Use this class for reference when creating new {@link Command} extensions.
 */
public class ExampleCommand extends Command {
    private int index = 0;

    /*
    * Command constructor should be used for initializing this at the start of
    * the commands life-time.
    */
    public ExampleCommand() {
        System.out.printf("Example command created.");
    }

    /*
    * Periodic is called every robot update.
    */
    @Override
    public void periodic() {
        // Prints to console 20 times and then ends.
        index++;
        if(index == 20) isFinished = true;

        System.out.printf("Example command periodic.");
    }

    /*
    * Finish is called when the command ends.
    */
    @Override
    public void finish() {
        System.out.printf("Example command finished.");
    }
}