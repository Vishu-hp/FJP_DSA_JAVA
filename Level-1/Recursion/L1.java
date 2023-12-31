package recursion;

public class Main {
    public static void printIncreasing(int n){
        if(n==0){
            return;
        }

        printIncreasing(n-1);
        System.out.println(n);
    }

    public static void printDecreasing(int n){
        if(n==0){
            return;
        }

        System.out.println(n);
        printDecreasing(n-1);
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }

        int faith = factorial(n-1);
        return n * faith;
    }

    public static int powerLinear(int x,int n){
        if(n==0){
            return 1;
        }

        return x * powerLinear(x,n-1);
    }

    public static int powerLog(int x,int n){
        if(n==0){
            return 1;
        }

        int powby2 = powerLog(x, n/2);
        int ans = powby2 * powby2 ;

        if(n%2 != 0){
            ans = ans * x;
        }

        return ans;
    }



    public static void main(String[] args) {
        printIncreasing(5); // 1 2 3 4 5
        System.out.print("\n");
        printDecreasing(5); // 5 4 3 2 1
        System.out.print("\n");

        System.out.println(factorial(5)); // 5! = 5.4.3.2.1 = 120 , 0! = 1
        System.out.println(powerLinear(5,3));
        System.out.println(powerLog(3,4));
    }
}
