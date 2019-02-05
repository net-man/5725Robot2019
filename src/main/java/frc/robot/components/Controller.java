package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Controller {
    public Joystick joystick = new Joystick(RobotMap.CONTROLLER_PORT_1);

    public double x = 0.0;
    public double y = 0.0;

    public void Update() {
        // x = (joystick.getX() - 0.5) * 2;
        // y = (joystick.getY() - 0.5) * 2;

        // x = (joystick.getRawAxis(0)+1)/2;
        // y = (joystick.getRawAxis(1)+1)/2;

        x = joystick.getRawAxis(0);
        y = joystick.getRawAxis(1);
    }
}