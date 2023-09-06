package midgroup01;

public class NoDenominatorException extends Exception {
    public NoDenominatorException(){
        super("Error: No Numerator specified. Please enter a numerator");
    }
    public NoDenominatorException(String errorMessage) {
        super(errorMessage);
    }
}
