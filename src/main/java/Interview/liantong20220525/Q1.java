package Interview.liantong20220525;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Acui
 * @date 2022年05月25日 16:03
 */
@Slf4j
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        int ret = 0;
        for (int i = 0;i < primeList.size() / 2 + 1; i++) {
            int num = primeList.get(i);
            if (primeList.contains(n - num)) {
                log.info("[{},{}]",num, n -num);
                ret++;
            }
        }
        System.out.println(ret);


    }



    private static boolean isPrime(int x) {
        for (int i = 2; i < x - 1; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


}
