package frc.robot.autonomous;

import java.util.List;
import java.util.ArrayList;

public class CommandQueue {
    
    public List<Command> commands = new ArrayList<Command>();

    public void Periodic() {
        for(Command command : commands) {
            if(command.IsFinished() == false) {
                command.Periodic();
            }
            else {
                command.Finish();
                commands.remove(command);
            }
        }
    }
}