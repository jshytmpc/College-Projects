public class EvenNumAdd {
    public static void main(String[] args){
        int sum = 0, evenNum = 2, i = 0;
        
        while(i < 9)
        {
            sum = sum + evenNum;
            evenNum = evenNum + 2;
            i ++;
            System.out.println("Sum of " + i + " even numbers: " + sum);
        }
        System.out.println(i + " Even numbers is added before it exceeds 100");
    }
}   