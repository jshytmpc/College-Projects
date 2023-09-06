package Prelim.Mod3;

public class TestMethod {
    public static void main(String[] args) {
        SuperOverride sp;
        sp = new SubOverride();
        sp.methodTwo();
        sp = new SubOverride();
        sp.methodTwo();
    }
}
