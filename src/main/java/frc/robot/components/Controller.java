package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Controller {
    public Joystick joystick = new Joystick(RobotMap.CONTROLLER_PORT_1.port);

    public double x = 0.0;
    public double y = 0.0;

    public void Update() {
        x = (joystick.getX() - 0.5) * 2;
        y = (joystick.getY() - 0.5) * 2;

        // TODO: Add ramping sensitivity.
    }
}