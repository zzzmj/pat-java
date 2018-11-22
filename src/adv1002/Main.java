package adv1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static double[] a, b, sum;
    static int maxn = 1005;

    public static void main(String[] args) throws IOException {
        int count = 0;
        a = new double[maxn];
        b = new double[maxn];
        sum = new double[maxn];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] aLine = br.readLine().split(" ");
        String[] bLine = br.readLine().split(" ");
        int K = Integer.parseInt(aLine[0]);
        int M = Integer.parseInt(bLine[0]);


        for (int i = 1, j = 1; i <= K; i++) {
            int n = Integer.parseInt(aLine[j++]);
            double p = Double.parseDouble(aLine[j++]);
            sum[n] += p;
        }

        for (int i = 1, j = 1; i <= M; i++) {
            int n = Integer.parseInt(bLine[j++]);
            double p = Double.parseDouble(bLine[j++]);
            sum[n] += p;
        }

        for (int i = 0; i < maxn; i++) {
            if (sum[i] != 0) {
                count++;
            }
        }
        System.out.print(count);
        for (int i = maxn - 1; i >= 0; i--) {
            if (sum[i] != 0) {
                System.out.print(" " + i + " " + String.format("%.1f", sum[i]));
            }
        }
    }
}
