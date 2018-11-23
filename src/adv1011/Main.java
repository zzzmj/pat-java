package adv1011;

import java.util.Scanner;

/**
 * @author zmj
 * @create 2018/11/23
 */
public class Main {
    public static void main(String[] args) {
        char[] ch = {'W', 'T', 'L'};
        double mul = 1.0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            double max = 0.0;
            int n = 0;
            for (int j = 0; j < 3; j++) {
                double t = in.nextDouble();
                if (t > max) {
                    max = t;
                    n = j;
                }
            }
            System.out.print(ch[n] + " ");
            mul *= max;
        }
        System.out.println(String.format("%.2f", (mul*0.65 - 1) * 2));
    }
}
