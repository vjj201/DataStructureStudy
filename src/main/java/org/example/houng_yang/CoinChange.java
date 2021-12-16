package org.example.houng_yang;

import java.util.Arrays;

/**
 * @author YuCheng
 * @date 2021/12/17 - 上午 02:35
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(CoinChange.change(5, new int[]{1, 5, 10, 50}));
    }


    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
