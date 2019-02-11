package frc.robot.autonomous;

public interface Command {
    public boolean IsFinished();
    
    public void Periodic();
    public void Finish();
}