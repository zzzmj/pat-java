package adv1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zmj
 * @create 2018/11/26
 */
public class Main {
    static String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();

        long sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += (n[i] - '0');
        }
        
        String s = String.valueOf(sum);
        
        
        for (int i = 0; i < s.length(); i++) {
            System.out.print(num[s.charAt(i)-'0']);
            if (i != s.length()-1) {
                System.out.print(" ");
            }
        }
        
    }
}
