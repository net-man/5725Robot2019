package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;

public class Controller {
    public Joystick joystick = new Joystick(RobotMap.CONTROLLER_PORT_1);
    public JoystickButton joystickButton = new JoystickButton(joystick, 0);

    public double[] snapValues = new double[] { 0.0, 0.3, 1.0 };

    public double GetX() {
        return joystick.getRawAxis(0);
    }

    public double GetY() {
        return joystick.getRawAxis(1);
    }

    public double GetRightTrigger() {
        // TODO: get if a trigger is pressed
        return 0.0f;
    }

    public double GetLeftTrigger() {
        // TODO: get if a trigger is pressed
        return 0.0f;
    }
}