package adv1019;

import java.util.Scanner;

/**
 * @author zmj
 * @create 2018/11/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int b = in.nextInt();
        int[] num = new int[40];
        int index = 0;
        
        while (N != 0) {
            num[index++] = N % b;
            N /= b;
        }
        
        if (isPalindromic(num, index)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        for (int i = index-1; i >= 0; i--) {
            System.out.print(num[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

    public static boolean isPalindromic(int[] num, int index) {
        for (int i = 0; i < index / 2; i++) {
            if (num[i] != num[index - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
