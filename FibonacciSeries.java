public class FibonacciSeries {

    public static void main(String[] args) {

        int x = 3, y = 0, s = 0;

        while (s <= 10)
        {
            int sum = x + y;
            x = y;
            System.out.print(x + " , ");
            y = sum;
            s++;

        }
    }
}