package adv1096;

import java.util.Scanner;

/**
 * @author zmj
 * @create 2019/4/3
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int sqr = (int)Math.sqrt(n) + 1;
        int left = 0, right = 0, max = 0;
        for (int i = 2; i <= sqr; i++) {
            if (n % i == 0) {
                int j = i;
                int m = n;
                while (m % j == 0 && n % j == 0) {
                    m /= j;
                    j++;
                }
                if (j - i > max) {
                    left = i;
                    right = j;
                    max = j - i;
                }
            }
        }
        
        if (max == 0) {
            System.out.println("1\n" + n);
        } else {
            System.out.println(max);
            for(int i = left; i < right; i++) {
                if (i != left) {
                    System.out.print("*");
                }
                System.out.print(i);
            }
        }
    }
}
