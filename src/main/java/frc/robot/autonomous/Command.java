package frc.robot.autonomous;

/**
 * A base Command class for {@link Command}s to be used in the {@link ComandQueue}.
 * To add a new Command, it is best to create a new class that entend this class.
 * <p>
 *  - All code that needs to be run at the start of a command should be called in the
 * constructor.
 * <p>
 *  - All code that needs to be run every Update should be put in {@link #Periodic}.
 * <p>
 *  - All code that needs to be run at the end of the command's life should be put int
 * {@link #Finish}.
 */
public class Command {
    /**
     * A boolean value that tells the {@link CommandQueue} if the Command is finished.
     * <p>
     * Set this to true in the extended class when the command should finish.
     */
    public boolean isFinished;
    
    /**
     * A method that runs every robot update until the Command is finished.
     */
    public void periodic() { }
    /**
     * A method that runs when the command is finished.
     */
    public void finish() { }
}