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
        return joystick.getRawAxis(99);
    }

    public double GetRightY() {
        return joystick.getRawAxis(99);
    }

    public double GetRightTrigger() {
        return joystick.getRawAxis(2);
    }

    public double GetLeftTrigger() {
        return joystick.getRawAxis(3);
    }

    public boolean GetRightButtonTrigger() {
        return joystick.getRawButton(99);
    }

    public boolean GetLeftButtonTrigger() {
        return joystick.getRawButton(99);
    }

    public boolean GetButtonA() {
        // TODO: Check if this is the correct id.
        return joystick.getRawButton(0);
    }
    
    public boolean GetButtonB() {
        // TODO: Check if this is the correct id.
        return joystick.getRawButton(1);
    }

    public boolean GetButtonX() {
        // TODO: Check if this is the correct id.
        return joystick.getRawButton(2);
    }

    public boolean GetButtonY() {
        // TODO: Check if this is the correct id.
        return joystick.getRawButton(3);
    }
}