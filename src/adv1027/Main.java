package adv1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author zmj
 * @create 2018/11/25
 */
public class Main {
    static final int length = 3;
    static char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rgb = br.readLine().split(" ");

        System.out.print("#");
        for (int i = 0; i < length; i++) {
            StringBuilder bd = new StringBuilder();
            int n = Integer.parseInt(rgb[i]);
            do {
                bd.append(num[n % 13]);
                n /= 13;
            } while (n != 0);
            if (bd.length() <= 1) {
                System.out.print(num[0]);
            }
            System.out.print(bd.reverse().toString());
        }

    }
}
