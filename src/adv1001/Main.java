package adv1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        Integer sum = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
        String string = sum.toString();
        
        int len = string.length();
        for (int i = 0; i < len; i++) {
            System.out.print(string.charAt(i));
            if (string.charAt(i) == '-') {
                continue;
            }
            if ((i+1) % 3 == len % 3 && (i+1) != len) {
                System.out.print(',');
            }
        }
        System.out.println();
    }
}
