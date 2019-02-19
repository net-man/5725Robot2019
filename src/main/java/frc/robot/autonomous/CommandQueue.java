package frc.robot.autonomous;

import java.util.List;
import java.util.ArrayList;

/**
 * A queue of {@link Command}s that get called every robot update until the command
 * is complete.
 */
public class CommandQueue {
    /**
     * A list of {@link Command}s that will dynamically grow and shrink when commands
     * start and finish.
     */
    public List<Command> commands = new ArrayList<Command>();

    /**
     * Runs each robot update. This method will update {@link Command}s and detect
     * if a command is finished.
     */
    public void Periodic() {
        for(Command command : commands) {
            // Update eaach command that is still running.
            if(command.isFinished == false) {
                command.Periodic();
            }
            // Remove the commands that have finished.
            else {
                command.Finish();
                commands.remove(command);
            }
        }
    }
}