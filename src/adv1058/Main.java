package adv1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zmj
 * @create 2018/11/25
 */
public class Main {
    static final int length = 3;
    static int[] num = {Integer.MAX_VALUE, 17, 29};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        br.close();
        
        String[] a = line[0].split("\\.");
        String[] b = line[1].split("\\.");
        int carry = 0;
        int[] res = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int sum = Integer.parseInt(a[i]) + Integer.parseInt(b[i]) + carry;
            res[i] = sum % num[i];
            carry = sum / num[i];
        }
        System.out.print(res[0] + "." + res[1] + "." + res[2]);
    }
}
