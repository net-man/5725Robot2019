package frc.utils;

public enum ControllerButtons {
    BUTTON_A(0),
    BUTTON_B(1),
    BUTTON_X(2),
    BUTTON_Y(3),
    
    BUTTON_LEFT(5),
    BUTTON_RIGHT(6),

    JOYSTICK_LEFT_X(0),
    JOYSTICK_LEFT_Y(1),

    TRIGGER_RIGHT(2),
    TRIGGER_LEFT(3),

    JOYSTICK_RIGHT_X(4),
    JOYSTICK_RIGHT_Y(5),

    NONE(99);
    
    int id = 0;
    private ControllerButtons(int id) {
        this.id = id;
    }
}