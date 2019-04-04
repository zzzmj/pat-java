package adv1103;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zmj
 * @create 2019/4/4
 */
public class Main {
    static int n, k, p, sqr, max = -1;
    static int[] num = new int[500];
    static int[] vis = new int[500];
    static ArrayList<Integer> list = new ArrayList<>();
    // sum是选中数之和，baseSum是底数之和, cnt是选中的个数，index是下标
    static void dfs(int sum, int baseSum, int cnt, int index) {
        if (cnt == k && sum == n) {
            if (baseSum > max) {
                max = baseSum;
                for (int i = 0; i < k; i++) {
                    vis[i] = list.get(i);
                }
            }
            return ;
        }
        if (sum > n || cnt > k) return ;
        if (index - 1 >= 0) {
            list.add(index);
            dfs(sum + num[index], baseSum + index, cnt + 1, index); // 选中
            list.remove(list.size()-1);
            dfs(sum, baseSum, cnt, index - 1); // 不选
        }
    }
    
    static int power(int n, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= n;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();
        
        sqr = (int)Math.sqrt(n) + 1;
        for (int i = 0; i <= sqr; i++) {
            num[i] = power(i, p);
        }
        
        dfs(0, 0, 0, sqr);
        if (max != -1) {
            System.out.print(n + " = ");
            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    System.out.print(" + ");
                }
                System.out.print(vis[i] + "^" + p);
            }
            System.out.println();
        } else {
            System.out.println("Impossible");
        }
    }
}
