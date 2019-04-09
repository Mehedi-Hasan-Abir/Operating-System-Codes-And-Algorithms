package os;

import java.util.HashMap;
import java.util.Scanner;

public class PseudoRandom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Long Z = sc.nextLong();
            Long I = sc.nextLong();
            Long M = sc.nextLong();
            Long L = sc.nextLong();
            int count = 0;
            Long result = 0l;
            HashMap<Long, Integer> map = new HashMap();
            while (true) {
                result = ((Z * L) + I) % M;
                if (map.containsKey(result)) {
                    break;
                }
                map.put(result, count);
                L = result;
                count++;
            }
            System.out.println(count);
        }

    }
}
