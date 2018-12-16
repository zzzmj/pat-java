package adv1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zmj
 * @create 2018/12/16
 */
public class Main {
    private static final int MAX = 100005;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[MAX];
        int[] b = new int[MAX];
        int n = Integer.parseInt(br.readLine());
        String[] al = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] bl = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(al[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(bl[i]);
        }
        Arrays.sort(a, 0, n);
        Arrays.sort(b, 0, m);
        int ans = 0;
        int i = n-1, j = m-1;
        while(i >= 0 && j >= 0 && a[i] > 0 && b[j] > 0) {
            ans += a[i] * b[j];
            i--;
            j--;
        }
        i = 0;
        while (i < n && i < m && a[i] < 0 && b[i] < 0) {
            ans += a[i]*b[i];
            i++;
        }
        System.out.println(ans);
    }
}
//#include<algorithm>
//#include<cstdio>
//#include<iostream>
//using namespace std;
//int maxn = 100005;
//int main() {
//    int a[maxn];
//    int b[maxn];
//    
//    int n, m;
//    scanf("%d", &n);
//    for (int i = 0; i < n; i++) {
//        scanf("%d", &a[i]);
//    }
//    scanf("%d", &m);
//    for (int i = 0; i < m; i++) {
//        scanf("%d", &b[i]);
//    }
//    sort(a, a+n);
//    sort(b, b+m);
//    int i = n - 1, j = m - 1, ans = 0;
//    while (i >= 0 && j >= 0 && a[i] > 0 && b[j] > 0) {
//        ans += a[i]*b[j];
//        i--, j--;
//    }
//    i = 0;
//    while (i < n && i < m && a[i] < 0 && b[i] < 0) {
//        ans += a[i]*b[i];
//        i++;
//    }
//    printf("%d\n", ans);
//} 