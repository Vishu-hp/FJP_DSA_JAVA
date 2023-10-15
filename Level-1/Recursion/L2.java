package recursion;

public class L2 {
    public static void main(String[] args) {
        int n = 4;
//        toh(n, 1, 2, 3);

//        printZigZag(3);

        System.out.println(fib(5));

    }

    public static void toh(int n, int src, int des, int helper){
        if(n == 0){
            return;
        }

        toh(n-1, src, helper, des);
        System.out.println(n + "[" + src + " -> " + des + "]");
        toh(n-1, helper, des, src);
    }

    public static void printZigZag(int n){
        if(n == 0){
            return;
        }

        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
    }

    public static int fib(int n){
        if(n==1){
            return 0;
        }

        if(n == 2){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }
}
