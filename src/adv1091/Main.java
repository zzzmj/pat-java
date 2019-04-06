package adv1091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * @author zmj
 * @create 2019/4/6
 */
public class Main {
    static class Node {
        int x, y, z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static int M, N, L, T; // M, N, T对应数组中的x, y, z
    static int[][][] map = new int[1300][130][65];
    static boolean[][][] vis = new boolean[1300][130][65];
    static int[] px = {0, 0, 0, 0, 1, -1}, 
                 py = {0, 0, 1, -1, 0, 0}, 
                 pz = {1, -1, 0, 0, 0, 0};
    
    static boolean judge(int nx, int ny, int nz) {
        if (nx < M && nx >= 0 && 
            ny < N && ny >= 0 &&
            nz < L && nz >= 0 && 
            map[nx][ny][nz] == 1 && !vis[nx][ny][nz]) {
            return true;
        } else {
            return false;
        }
    }
    
    static int bfs(int x, int y, int z) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Node t = new Node(x, y, z);
        vis[x][y][z] = true;
        queue.push(t);
        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cnt++;
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + px[i];
                int ny = cur.y + py[i];
                int nz = cur.z + pz[i];
                if (judge(nx, ny, nz)) {
                    vis[nx][ny][nz] = true;
                    Node s = new Node(nx, ny, nz);
                    queue.push(s);
                }
            }
        }
        if (cnt >= T) {
            return cnt;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        L = Integer.parseInt(line[2]);
        T = Integer.parseInt(line[3]);
        
        for (int z = 0; z < L; z++) {
            for (int x = 0; x < M; x++) {
                String[] num = br.readLine().split(" ");
                for (int y = 0; y < N; y++) {
                    map[x][y][z] = Integer.parseInt(num[y]);
                }
            }
        }
        int sum = 0;
        for (int z = 0; z < L; z++) {
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (!vis[x][y][z] && map[x][y][z] == 1) {
                        int cnt = bfs(x, y, z);
                        sum += cnt;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}

/*
c++解法能过。

#include<iostream>
#include<cstdio>
#include<queue> 
using namespace std; 
struct Node {
    int x, y, z;
};
int M, N, L, T; // M, N, T对应数组中的x, y, z
int map[1300][130][65];
bool vis[1300][130][65];
int px[] = {0, 0, 0, 0, 1, -1}; 
int py[] = {0, 0, 1, -1, 0, 0};
int pz[] = {1, -1, 0, 0, 0, 0};
Node t;

bool judge(int nx, int ny, int nz) {
    if (nx < M && nx >= 0 && 
        ny < N && ny >= 0 &&
        nz < L && nz >= 0 && 
        map[nx][ny][nz] == 1 &&
        !vis[nx][ny][nz]) {
        return true;
    } else {
        return false;
    }
}

int bfs(int x, int y, int z) {
    queue<Node> q;
    t.x = x; t.y = y; t.z = z;
    vis[x][y][z] = true;
    q.push(t);
    int cnt = 0;
    while (!q.empty()) {
        Node cur = q.front();
        q.pop();
        cnt++;
        for (int i = 0; i < 6; i++) {
            int nx = cur.x + px[i];
            int ny = cur.y + py[i];
            int nz = cur.z + pz[i];
            if (judge(nx, ny, nz)) {
                vis[nx][ny][nz] = true;
                t.x = nx; t.y = ny; t.z = nz;
                q.push(t);
            }
        }
    }
    if (cnt >= T) {
        return cnt;
    } else {
        return 0;
    }
}


int main(){
    scanf("%d%d%d%d", &M, &N, &L, &T); 
    
    for (int z = 0; z < L; z++) {
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                scanf("%d", &map[x][y][z]);
            }
        }
    }
    int sum = 0;
    for (int z = 0; z < L; z++) {
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (!vis[x][y][z] && map[x][y][z] == 1) {
                    int cnt = bfs(x, y, z);
                    sum += cnt;
                }
            }
        }
    }

    printf("%d\n", sum);
}
*/
