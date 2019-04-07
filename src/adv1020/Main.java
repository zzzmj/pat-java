package adv1020;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author zmj
 * @create 2019/4/6
 */
public class Main {
    static int[] post = new int[105];
    static int[] mid = new int[105];
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    
    static Node createTree(int posLeft, int posRight, int midLeft, int midRight) {
        if (posLeft >= posRight) {
            return null;
        }
        
        int num = post[posRight-1];
        int j = 0;
        for (int i = midLeft; i < midRight; i++) {
            if (mid[i] == num) {
                j = i;
                break;
            }
        }
        
        int leftSize = j - midLeft;
        int rightSize = midRight - j - 1;
        Node t = new Node(num);
        t.left = createTree(posLeft, posLeft + leftSize, midLeft, j);
        t.right = createTree(posRight - rightSize - 1, posRight-1, j+1, midRight);
        return t;
    }
    
    static void level(Node t) {
        ArrayDeque<Node> queue= new ArrayDeque<>();
        queue.push(t);
        while (!queue.isEmpty()) {
            Node s = queue.poll();
            if (s.left != null) {
                queue.add(s.left);
            }
            if (s.right != null) {
                queue.add(s.right);
            }
            System.out.printf("%d%s", s.data, queue.isEmpty() ? "\n" : " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
           post[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
           mid[i] = sc.nextInt(); 
        }
        Node t = createTree(0, n, 0, n);
        level(t);
    }
}

/*
#include<cstdio>
#include<iostream>
#include<queue>
#include<vector>
using namespace std;
struct Node {
    int data;
    Node* left;
    Node* right;
};

void createTree(Node* &root, int* last, int* mid, int len) {
    if (len == 0) {
        root = NULL;
        return ;
    }
    int v = last[len-1];
    int pos = 0;
    while(mid[pos] != v) pos++;
    root = new Node;

    root -> data = v;
    createTree(root->left, last, mid, pos);
    createTree(root->right, last+pos, mid+pos+1, len-pos-1);
}

void midOrder(Node* root) {
    if (root == NULL) {
        return ;
    }
    midOrder(root -> left);
    printf("%d ", root -> data);
    midOrder(root -> right);
}

void bfs(Node* root, vector<int> &v) {
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        Node* t = q.front();
        q.pop();
        v.push_back(t -> data);
        if (t -> left != NULL) {
            q.push(t->left);
        }
        if (t -> right != NULL) {
            q.push(t->right);
        }
    }
}

int main() {
    int last[105], mid[105];
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &last[i]);
    }
    for (int i = 0; i < n; i++) {
        scanf("%d", &mid[i]);
    }
    
    Node* root;
    createTree(root, last, mid, n);
    vector<int> v;
    bfs(root, v);
    
    for (int i = 0; i < v.size(); i++) {
        if (i == 0) {
            printf("%d", v[i]);
            continue;
        }
        printf(" %d", v[i]);
    }
}
 */
