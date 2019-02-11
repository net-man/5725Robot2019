package frc.utils;

public class Position {
    public int x;
    public int y;
    public float rotation;

    // FIXME: Choose either to use doubles or floats.
    // I think this comes down to speed as doubles are faster but take up around 2x
    // what floats take up and floats are slower but take up less space.

    // I think memory might be more important to us then cycles so I'm in favor of 
    // floats but I might be overlooking something.
    public float GetDistance() {
        return Math.sqrt(x*x + y*y);
    }
}