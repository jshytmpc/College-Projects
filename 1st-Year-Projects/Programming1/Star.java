public class Star
{    
    public static void main(String[] args)
    {

            int  i = 5, j, n = 5;
              
	while(i>0)
               {
                j= n-i;

                while(j-->0)
                {
                    System.out.print(" "); 
                }
                j=0;
                     
                while(j++<i)
                {
                    System.out.print("*");
                }
                
                System.out.println(" ");
                i--;

               }             
    }
}