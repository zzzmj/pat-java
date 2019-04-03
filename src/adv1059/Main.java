package adv1059;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zmj
 * @create 2019/4/3
 */
public class Main {
    static class Factor {
        long x;
        long cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Factor> list = new ArrayList<>();
        long n = sc.nextLong();
        long m = n;

        if (n == 1) {
            System.out.println("1=1");
        } else {
            long sqr = (long) Math.sqrt(n) + 1;
            for (long i = 2; i <= sqr; i++) {
                if (n % i == 0) {
                    Factor fac = new Factor();
                    fac.x = i;
                    fac.cnt = 0;
                    while (n % i == 0) {
                        fac.cnt++;
                        n /= i;
                    }
                    list.add(fac);
                }
            }
            
            System.out.print(m + "=");
            int len = list.size();
            if (len == 0) {
                System.out.print(m);
            }
            for (int i = 0; i < len; i++) {
                Factor fac = list.get(i);
                if (i != 0) {
                    System.out.print("*");
                }
                System.out.print(fac.x);
                if (fac.cnt > 1) {
                    System.out.print("^" + fac.cnt);
                }
            }
            System.out.println();
        }
    }
}
