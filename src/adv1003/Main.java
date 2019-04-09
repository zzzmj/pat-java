package adv1003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zmj
 * @create 2019/4/9
 */
public class Main {
    static int n, m, start, end;
    static int INF = Integer.MAX_VALUE;
    static int[][] G = new int[505][505]; 
    static int[] weight = new int[505]; 
    static int[] w = new int[505]; // 记录最大救援队金额
    static int[] num = new int[505]; // 记录最短路径条数
    static int[] dis = new int[505]; 
    static boolean[] vis = new boolean[505]; 
    
    static void dijkstra(int s) {
        Arrays.fill(vis, false);
        Arrays.fill(dis, INF);
        Arrays.fill(num, 0);
        Arrays.fill(w, 0);
        dis[s] = 0;
        num[s] = 1;
        w[s] = weight[s];
        for (int i = 0; i < n; i++) {
            int u = -1, min = INF;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dis[j] < min) {
                    u = j;
                    min = dis[j];
                }
            }
            if (u == -1) return ;
            vis[u] = true;
            for (int v = 0; v < n; v++) {
                if (!vis[v] && G[u][v] != INF) {
                    if (dis[u] + G[u][v] < dis[v]) {
                        dis[v] = dis[u] + G[u][v];
                        w[v] = w[u] + weight[v];
                        num[v] = num[u];
                    } else if (dis[u] + G[u][v] == dis[v]) {
                        if (w[u] + weight[v] > w[v]) {
                            w[v] = w[u] + weight[v];
                        }
                        num[v] += num[u];
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        for (int i = 0; i < n; i++) {
            weight[i]= sc.nextInt();
        }
        for (int i = 0; i < 505; i++) {
            Arrays.fill(G[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            G[a][b] = c;
            G[b][a] = c;
        }
        dijkstra(start);
        System.out.println(num[end] + " " + w[end]);
    }
}
