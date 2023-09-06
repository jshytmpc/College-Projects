package midgroup01;

/**
 * The Fraction class
 * A template for a fraction that has the form numerator/denominator
 */

public class Fraction {
    // object fields
    private int numerator; // holds the numerator of this fraction
    private int denominator; // holds the denominator of this fraction

    /**
     * Constructs a fraction with numerator = 0 and denominator = 1
     * Default constructor (since it has no arguments)
     **/
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * This constructor creates a Fraction with the specified whole number
     * Example of usage: Fraction fraction = new Fraction(10);
     */
    public Fraction(int wholeNumVal) {
        this.numerator = wholeNumVal;
        denominator = 1;
    }

    /**
     * This constructor creates a Fraction using the explicit numerator and denominator values…
     * Example of usage: Fraction frac = new Fraction(5, 2);
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Accessor/Getter Method
     * Returns the value of the numerator of this fraction
     */
    public int getNumerator() {
        return numerator; }

    /**
     * Accessor/Getter Method
     * Returns the value of the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }


    /**
     * Mutator/Setter Method
     * Sets the value of the numerator of this fraction to numerator
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Mutator/Setter Method
     * Sets the value of the denominator of this fraction to denom
     */
    public void setDenominator(int denom) {
        denominator = denom;
    }

    /**
     * Returns a string form of the fraction following the format numerator/denominator
     **/
    public String toString()
    {  // this is an overridden method from the Object class
        return (numerator + "/" + denominator);
    } // UNUSED/UNECESSARY

    /**
     * Returns the equivalent value of the fraction in double format
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Reduces this fraction to its simplest form
     */
    public void reduce() {
        int gcd = computeGCD(numerator, denominator); // determine the greatest common divisor of numerator and denominator
        int newNumerator = numerator / gcd; //compute newNumerator, the numerator of the simplest form of this fraction
        int newDenominator = denominator / gcd; //compute newDenominator, the denominator of the simplest form of this fraction
        setNumerator(newNumerator); // set the value of the new numerator for this fraction
        setDenominator(newDenominator); // set the value of the new denominator for this fraction
    }

    /**
     * Returns the sum of this fraction and another fraction
     */
    public Fraction add(Fraction other) {
        Fraction result = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator + den / other.getDenominator() * other.getNumerator();
        result.setNumerator(num);
        result.setDenominator(den);
        result.reduce();
        return result;
    }

    /**
     * Returns the difference of this fraction and another fraction
     */
    public Fraction subtract(Fraction other) {
        Fraction diff = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator - den / other.getDenominator() * other.getNumerator();
        diff.setNumerator(num);
        diff.setDenominator(den);
        diff.reduce();
        return diff;
    }

    /**
     * Returns the product of this fraction and another fraction
     */
    public Fraction multiply(Fraction other){
        Fraction product = new Fraction();
        int den = denominator * other.getDenominator();
        int num = numerator * other.getNumerator();
        product.setDenominator(den);
        product.setNumerator(num);
        product.reduce();
        return product;
    }

    /**
     * Returns the quotient of this fraction and another fraction
     */
    public Fraction divide(Fraction other){
        Fraction quotient = new Fraction();
        int den = denominator * other.getDenominator();
        int num = numerator * other.getDenominator();
        quotient.setNumerator(num);
        quotient.setDenominator(den);
        quotient.reduce();
        return quotient;
    }

    /**
     * Computes the greatest common divisor of the numerator and denominator
     */
    private int computeGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }

        return computeGCD(denominator, numerator % denominator);
    }
}
