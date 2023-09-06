package Prelim.Mod3;

public class TestInstanceOf {
    public static String instanceName(Object o) {
        if (o instanceof SubOverride)
            return "Sub";
        else
        if (o instanceof SuperOverride)
            return "Super";
        else
            return "Something Else";

    }
    public static void main(String[] args) {
        Object o = new SuperOverride();
        System.out.println(instanceName(o)); // prints ”Super”...
        o = new SubOverride();
        System.out.println(instanceName(o)); // prints ”Sub”...
        o = new Object();
        System.out.println(instanceName(o)); // prints ”Something Else”...
    }
}
