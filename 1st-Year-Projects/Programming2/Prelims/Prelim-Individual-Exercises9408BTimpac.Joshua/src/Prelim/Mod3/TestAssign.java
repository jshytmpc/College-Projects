package Prelim.Mod3;

public class TestAssign {
    public static void main(String[] args) {
        SuperOverride sp;
        SubOverride sb;
        sp = new SubOverride();
        Object o = new SuperOverride();
        sp = (SuperOverride) o;
    }
}