package midgroup01;

public class MixedFraction extends Fraction {
        private int whole;
        Fraction f1;
        MixedFraction(){
            super();
            whole = 0;
        }

        //This constructor creates a Mixed Fraction with the specified whole number as its initial value
        MixedFraction(int whole, Fraction fraction){
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
            this.whole = whole;
        }

        //This constructor creates a Mixed Fraction using the explicit whole number, numerator and denominator values
        MixedFraction(int whole, int numerator, int denominator){
            super(numerator, denominator);
            this.whole = whole;
        }

        /**
         * Accessor/Getter Method
         * Returns the value of the whole number of the mixed fraction
         */

        public void setWholePart(int whole){
            this.whole = whole;
        }

        /**
         * Accessor/Getter Method
         * Returns the value of the numerator and denominator of the mixed fraction
         */
        public void setFractionPart(Fraction fraction) {
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
        }

        /**
         * Accessor/Getter Method
         * Returns the value of the whole number of the mixed fraction
         */
        public int getWhole(){
            return whole;
        }

        /**
         * Accessor/Getter Method
         * Returns the value of the numerator and denominator of the mixed fraction
         */
        public Fraction getFractionPart(){

            return f1 = new Fraction(getNumerator(),getDenominator());
        }


        public void toFraction(){
            int num;
            int den;
            num = whole * getDenominator() + getNumerator();
            den = getDenominator();
            whole = 0;
            setNumerator(num);
            setDenominator(den);
        }


        public MixedFraction toMixedFraction(){
            int num;
            int den = getDenominator();
            int whole;
            whole = getNumerator() % getDenominator();
            num = getNumerator() - (whole * getDenominator());
            MixedFraction mf = new MixedFraction(num,den,whole);
            return mf;
        }


        // Override
        /**
         * Returns a string form of the mixed fraction following the format numerator and denominator
         **/
        public String toString() {
            if (getNumerator() == 0 && whole != 0)
                return whole + " ";
            else if (whole != 0)
                return whole + " " + super.toString();
            else
                return super.toString();

        }

        /**
         * Returns the decimal value of this mixed number
         **/
        //Override
        public double toDouble(){
            return (whole + 1.0 * getNumerator() / getDenominator());
        }


        /**
         * Returns the sum of two mixed fractions
         */
        public MixedFraction add(MixedFraction other) {
            MixedFraction result = new MixedFraction();
            Fraction f;
            int wl = 0;
            other.toFraction();
            int den = getDenominator() * other.getDenominator();
            int num = den / getDenominator() * getNumerator() + den / other.getDenominator() * other.getNumerator();
            return getMixedFraction(result, wl, den, num);
        }


        /**
         * Returns the difference of two mixed fractions
         */
        public MixedFraction subtract(MixedFraction other) {
            MixedFraction diff = new MixedFraction();
            Fraction f;
            int wl;
            other.toFraction();
            int den = getDenominator() * other.getDenominator();
            int num = other.getDenominator() * getNumerator() - getDenominator() * other.getNumerator();
            wl = num / den;
            int num2 = num % den;
            f = new Fraction(num2, den);
            diff.setFractionPart(f);
            diff.setWholePart(wl);
            diff.reduce();
            return diff;
        }


        /**
         * Returns the product of two mixed fractions
         */
        public MixedFraction multiply(MixedFraction other){
            MixedFraction product = new MixedFraction();
            Fraction f;
            int wl = 0;
            other.toFraction();
            int den = getDenominator() * other.getDenominator();
            int num = getNumerator() * other.getNumerator();
            return getMixedFraction(product, wl, den, num);
        }

    private MixedFraction getMixedFraction(MixedFraction product, int wl, int den, int num) {
        Fraction f;
        while (num / den != 0){
            wl++;
            num = num - (den);
        }
        f = new Fraction(num,den);
        product.setFractionPart(f);
        product.setWholePart(wl);
        product.reduce();
        return product;
    }


    /**
         * Returns the quotient of two mixed fractions
         */
        public MixedFraction divide(MixedFraction other){
            MixedFraction quotient = new MixedFraction();
            Fraction f;
            int wl = 0;
            other.toFraction();
            int den = getDenominator() * other.getNumerator();
            int num = getNumerator() * other.getDenominator();
            return getMixedFraction(quotient, wl, den, num);
        }

        /**
         * Computes the greatest common divisor of the numerator and denominator of this fraction and another fraction
         */
        private int computeGCD(int numerator, int denominator) {

            if (denominator == 0) {
                return numerator;
            }

            return computeGCD(denominator, numerator % denominator);
        }

    }


