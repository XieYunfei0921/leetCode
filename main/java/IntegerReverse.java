import java.util.Scanner;
import java.util.Stack;

/**
 * IntegerReverse
 */
public class IntegerReverse {

    public static int reverse(int x){

        Stack<Integer> s=new Stack<>();
        int sign=x<0?-1:1;
        int ops=x<0?-x:x;
        while (ops!=0) {
            s.push(ops%10);
            ops/=10;
        }
        long res=0;
        long factor=1;
        int size=s.size();
        while (!s.empty()) {
            res+=s.pop()*factor;
            factor*=10;
        }
        if (res>Integer.MAX_VALUE || res<Integer.MIN_VALUE)
            return 0;
        return (int) res*sign;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x= scanner.nextInt();

        System.out.println(reverse(x));
    }
}