package adv1077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zmj
 * @create 2018/12/2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        StringBuilder bd = new StringBuilder();
        int pos = 0;
        while (compareEndChar(s, pos, n)) {
            int index = s[0].length() - pos - 1;
            bd.append(s[0].charAt(index));
            pos++;
        }
        if (pos == 0) {
            System.out.println("nai");
        } else {
            System.out.println(bd.reverse());
        }
    }

    public static boolean compareEndChar(String[] s, int pos, int n) {
        for (int i = 1; i < n; i++) {
            int a = s[i - 1].length() - 1 - pos;
            int b = s[i].length() - 1 - pos;
            if (a < 0 || b < 0 || (s[i - 1].charAt(a) != s[i].charAt(b))) {
                return false;
            }
        }
        return true;
    }
}
