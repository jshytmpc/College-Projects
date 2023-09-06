package Prelim.Mod2.Exercise2;

/**
 * Name of Student/Programmer: JOSHUA TIMPAC
 * CLASS CODE & Schedule: 9408 / 9:00-10:30AM Mon&Thur
 * Date: February 10, 2023,
 */

class Fan {
    /**
     *  Three variables named slow, medium and fast with values 1, 2, and 3 to
     * denote the fan speed.
     *  A private int data field named speed that specifies the speed of the fan
     * (default slow).
     *  A private boolean data field named on that specifies whether the fan is on
     * (default false).
     *  A private double data field named radius that specifies the radius of the
     * fan (default 5).
     *  A string data field color that specifies the color of the fan (default blue).
     *  The accessor and mutator methods for all four data fields.
     *  A constructor that creates a default fan.
     *  A method named toString() that returns a string description for the fan. If
     * the fan is on, the method returns the fan color, radius, and speed in one
     * combined string. If the fan is not on, the method returns fan color and
     * radius along with the string “fan is off” in one combined string.
     */

    // These are the 3 variables declared as the slow, medium and fast
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;

    // These are the fan specifications
    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";


    // Constructor for a fan that is turned on, has a radius of 7, colored red, and has a fast speed.
    public Fan() {
        speed = 3;
        on = true;
        radius = 12;
        color = "Indigo";
    }

    // Fan Constructor for the default fan (Used for making an arraylist of objects)
    public Fan(int s, boolean on, double rad, String c) {
        speed = s;
        this.on = on;
        radius = rad;
        color = c;
    }

    // Returns the speed of the fan
    public int getSpeed() {
        return speed;
    }

    // Sets the speed of the fan
    public void setSpeed(int s) {
        this.speed = s;
    }

    // Returns switch value of fan if true or false
    public boolean getOn() {
        return on;
    }

    // Sets the switch of the fan
    public void setOn(boolean on) {
        this.on = on;
    }


    // Returns the radius of the fan
    public double getRadius() {
        return radius;
    }

    // Sets the radius of the fan
    public void setRadius(double rad) {
        this.radius = rad;
    }

    // Returns the color of the fan
    public String getColor() {
        return color;
    }

    // Sets the color of the fan
    public void setColor(String c) {
        this.color = c;
    }

    public void printSpeed(int s) {
        if (s == slow) {
            System.out.println("Speed: Slow");

        }
        else if (s == medium) {
            System.out.println("Speed: Medium");
        } else if (s == fast) {
            System.out.println("Speed: Fast");
        }
    }

    public void print() {
        System.out.println("Speed: " + getSpeed());
        System.out.println("Switch: " + getOn());
        System.out.println("Radius of fan: " + getRadius());
        System.out.println("Color of fan: " + getColor());
    }

    @Override
    public String toString() {
        if (on) {
        return "The fan is ON: " +
                "Speed = " + speed +
                ", On = " + true +
                ", Radius = " + radius +
                ", Color = " + color
                ;
        } else
            return "The fan is OFF: " +
                    ", Radius = " + radius +
                    ", Color = " + color
                    ;
    }

    public String toString(String color) {
        return "Fan{" +
                "color='" + color + '\'' +
                '}';
    }
}
