package org.example.houng_yang;

/**
 * @author YuCheng
 * @date 2021/12/17 - 上午 05:45
 */
public class CountPrimes {

        public int countPrimes(int n) {
            int count = 0;
            boolean[] notPrime = new boolean[n];
            for (int i = 2; i < n; i++)
                if (!notPrime[i]) {
                    count++;
                    for (int j = 2; i * j < n; j++) notPrime[i * j] = true;
                }
            return count;
        }

}
