package adv1046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zmj
 * @create 2018/11/22
 */
public class Main {
    static int[] arr, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        
        int N = Integer.parseInt(first[0]);
        arr = new int[N+1];
        dis = new int[N+1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(first[i]);
            sum += arr[i];
            dis[i] = sum;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            if (s > e) {
                int t = s;
                s = e;
                e = t;
            }
            int pre = dis[e-1] - dis[s-1];
            int next = sum - dis[e-1] + dis[s-1];
            System.out.println(Math.min(pre, next));
        }
    }
}
