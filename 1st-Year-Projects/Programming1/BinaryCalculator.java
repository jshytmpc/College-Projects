/**
 * Computers encode numbers in a numbering system called BINARY
 * which uses only two digits: 0 and 1
 *
 * This statement:
 *         System.out.println(Integer.toBinaryString(83));
 *
 * converts 83 to its BINARY form and outputs:
 *         1010011
 *
 * To decode 1010011, read the digits from left-to-right:
 *         1  --> 0  --> 1  --> 0  --> 0  --> 1  --> 1
 *
 * Starting from 1 on the left, go to the next digit:
 *        - if the transition is: "--> 0"
 *          then multiply by 2
 *
 *        - if the transition is: "--> 1"
 *          then multiply by 2 plus 1
 *
 * Therefore:
 *        1  --> 0  --> 1  --> 0  --> 0  --> 1  --> 1
 * is:
 *        1  x2     x2+1   x2     x2     x2+1   x2+1
 *
 * When computed from left-to-right, the result should be 83
 *
 * Your task is to provide the correct sequence of method invocations
 * to compute for the desired number in METHOD_01() up to METHOD_05()
 *
 *
 *
 * INSTRUCTIONS:
 * 1. Go to the run() method and change the method invocation to
 *    METHOD_01(), METHOD_02(), METHOD_03(), METHOD_04() or METHOD_05()
 *
 * 2. Execute the program and observe the output to see the BINARY equivalent
 *    of the number you should be generating.
 *
 * 3. Based on the output observed, supply the sequence of invocations in the
 *    method to generate the desired number.
 *
 *    This will be a combination of invocations to the methods:
 *            one(), timesTwo() and timesTwoPlusOne()
 *
 *    See METHOD_00() as an example.
 *
 * @author <JOSHUA C TIMPAC>, <NOVEMBER 15, 2020>
 */

public class BinaryCalculator {
    int answer;

    public void one() {
    	answer = 1;
    	System.out.println("1        = " + answer);
    }

    public void timesTwoPlusOne() {
    	answer = answer * 2 + 1;
    	System.out.println("x 2 + 1  = " + answer);
    }

    public void timesTwo() {
    	answer = answer * 2;
    	System.out.println("x 2      = " + answer);
    }

    public void METHOD_00() {
    	System.out.println("Generate 83 from " + Integer.toBinaryString(83));
    	// prints Generate 83 from 1010011

        // calculate to produce EIGHTY-THREE (83)

    	one();	// always invoke this method first!
    	timesTwo();
    	timesTwoPlusOne();
    	timesTwo();
    	timesTwo();
    	timesTwoPlusOne();
    	timesTwoPlusOne();
    }

    public void METHOD_01() {
    	System.out.println("Generate 6 from " + Integer.toBinaryString(6));

    	// calculate to produce SIX(6) (binary code 0110)

		one(); // supply the rest of the method invocations
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwo();


    }

    public void METHOD_02() {
    	System.out.println("Generate 23 from " + Integer.toBinaryString(23));

    	// calculate to produce TWENTY-THREE (23)

		one(); // supply the rest of the method invocations
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwo();

    }


    public void METHOD_03() {
    	System.out.println("Generate 32 from " + Integer.toBinaryString(32));

    	// calculate to produce THIRTY-TWO (32)

		one(); // supply the rest of the method invocations
		timesTwo();
		timesTwo();
		timesTwo();
		timesTwo();

    }

    public void METHOD_04() {
    	System.out.println("Generate 93 from " + Integer.toBinaryString(93));

    	// calculate to produce NINETY-THREE (93)

		one(); // supply the rest of the method invocations
		timesTwo();
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwo();
		timesTwoPlusOne();

    }


    public void METHOD_05() {
    	System.out.println("Generate 109 from " + Integer.toBinaryString(109));

    	// calculate to produce ONE-HUNDRED NINE (109)

		one(); // supply the rest of the method invocations
		timesTwoPlusOne();
		timesTwo();
		timesTwoPlusOne();
		timesTwoPlusOne();
		timesTwo();
		timesTwoPlusOne();

    }


    public void run() {
		METHOD_01();
		METHOD_02(); 
		METHOD_03(); 
		METHOD_04();
		METHOD_05(); // <--- change this to invoke METHOD_01(), METHOD_02(), METHOD_03(), METHOD_04(), and METHOD_05()
    }

    public static void main(String[] args) {
    	BinaryCalculator myProgram = new BinaryCalculator();
    	myProgram.run();
    }
}