package adv1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zmj
 * @create 2018/11/24
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        int len = s.length;
        int n = (len + 2) / 3;
        int m = (len + 2) - 2 * n;
        StringBuilder bd = new StringBuilder();
        for (int i = 2; i < m; i++) {
            bd.append(" ");
        }
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                bd.setLength(0);
                for (int j = n; j < m + n - 2; j++) {
                    bd.append(s[j]);
                }
            }
            System.out.println(s[i] + bd.toString() + s[len - i - 1]);
        }
    }
}
