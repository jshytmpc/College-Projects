public class seriesSumPH
{
    public static void main(String[] args){
        double sVar=0.0, nTerms=1;
        while(sVar<3.1)
        {
            sVar=sVar+(1/nTerms);
            System.out.print("nTerms=" +nTerms+ " , " );
            System.out.format(" %.4f\n" ,sVar);
            nTerms++;
        }
        System.out.println("The number of terms before s exceeds 3.1 is " + (nTerms-2));
    }
}   

