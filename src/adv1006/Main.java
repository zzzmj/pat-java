package adv1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author zmj
 * @create 2018/11/23
 */
public class Main {
    static class Node {
        String mId;
        String mOpen;
        String mClose;

        public Node(String mId, String mOpen, String mClose) {
            this.mId = mId;
            this.mOpen = mOpen;
            this.mClose = mClose;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < M; i++) {
            String[] mCase = br.readLine().split(" ");
            Node mCaseNode = new Node(mCase[0], mCase[1], mCase[2]);
            list.add(mCaseNode);
        }
        
        int mOpenIndex = 0;
        int mCloseIndex = 0;
        String mOpenTime = list.get(0).mOpen;
        String mCloseTime = list.get(0).mClose;
        for (int i = 1; i < M; i++) {
            if (mOpenTime.compareTo(list.get(i).mOpen) > 0) {
                mOpenTime = list.get(i).mOpen;
                mOpenIndex = i;
            }
            if (mCloseTime.compareTo(list.get(i).mClose) < 0) {
                mCloseTime = list.get(i).mClose;
                mCloseIndex = i;
            }
        }
        System.out.println(list.get(mOpenIndex).mId + " " + list.get(mCloseIndex).mId);
        
    }
}
