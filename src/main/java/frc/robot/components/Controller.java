package frc.robot.components;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

public class Controller {
    public Joystick joystick = new Joystick(RobotMap.CONTROLLER_PORT_1);

    public double GetX() {
        return joystick.getRawAxis(0);
    }

    public double GetY() {
        return joystick.getRawAxis(1);
    }

    public double GetRightX() {
        return joystick.getRawAxis(4);
    }

    public double GetRightY() {
        return joystick.getRawAxis(5);
    }

    public double GetRightTrigger() {
        return joystick.getRawAxis(3);
    }

    public double GetLeftTrigger() {
        return joystick.getRawAxis(2);
    }

    public double GetRightButtonTrigger() {
        return joystick.getRawButton(5) ? 1 : 0;
    }

    public double GetLeftButtonTrigger() {
        return joystick.getRawButton(6) ? 1 : 0;
    }

    public boolean GetButtonA() {
        return joystick.getRawButton(0);
    }
    
    public boolean GetButtonB() {
        return joystick.getRawButton(1);
    }

    public boolean GetButtonX() {
        return joystick.getRawButton(2);
    }

    public boolean GetButtonY() {
        return joystick.getRawButton(3);
    }
}