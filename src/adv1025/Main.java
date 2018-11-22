package adv1025;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Stu implements Comparable<Stu>{
        String id;
        int score;
        int finalRank;
        int locationNumber;
        int localRank;
        
        public Stu(String id, int score, int locationNumber) {
            this.id = id;
            this.score = score;
            this.locationNumber= locationNumber;
        }

        @Override
        public int compareTo(Stu o) {
            if (score == o.score) {
                return id.compareTo(o.id);
            } else if (score > o.score) {
                return -1;
            } else { 
                return 1;
            }
        }

        @Override
        public String toString() {
            return id + " " + finalRank + " " + locationNumber + " " + localRank;
        }
        
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(new BufferedInputStream(System.in));
        
        List<Stu> total = new ArrayList<Stu>();
        
        int n = read.nextInt();
        for (int i = 1; i <= n; i++) {
            int k = read.nextInt();
            List<Stu> list = new ArrayList<Stu>();
            for (int j = 1; j <= k; j++) {
                Stu stu = new Stu(read.next(), read.nextInt(), i); 
                list.add(stu);
                total.add(stu);
            }
            Collections.sort(list);
            
            list.get(0).localRank = 1;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j-1).score == list.get(j).score) {
                    list.get(j).localRank = list.get(j-1).localRank;
                } else {
                    list.get(j).localRank = j+1;
                }
            }
            
        }
        
        Collections.sort(total);
        total.get(0).finalRank = 1;
        System.out.println(total.size() + "\n" + total.get(0));
        for (int i = 1; i < total.size(); i++) {
            if (total.get(i-1).score == total.get(i).score) {
                total.get(i).finalRank = total.get(i-1).finalRank;
            } else {
                total.get(i).finalRank = i + 1;
            }
            System.out.println(total.get(i));
        }

    }
}
