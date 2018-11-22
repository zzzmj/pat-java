package adv1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author zmj
 * @create 2018/11/22
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");
            BigInteger a = new BigInteger(line[0]);
            BigInteger b = new BigInteger(line[1]);
            BigInteger c = new BigInteger(line[2]);
            if (a.add(b).compareTo(c) == 1) {
                System.out.println("Case #" + (i+1) + ": true");
            } else {
                System.out.println("Case #" + (i+1) + ": false");
            }
        }
        
    }
}
