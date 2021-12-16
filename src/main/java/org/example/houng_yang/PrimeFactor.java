package org.example.houng_yang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author YuCheng
 * @date 2021/12/17 - 上午 02:12
 */
public class PrimeFactor {
    public static void main(String[] args) {
        List<Integer> prime = PrimeFactor.getPrime(new String[]{"98"});
        System.out.println(Collections.max(prime));
    }

    public static List<Integer> getPrime(String[] array) {
        int nums = Integer.valueOf(array[0]);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= nums ; ) {
            if(nums % i == 0) {
                list.add(i);
                nums = nums / i;
                continue;
            }
            if(nums == i){
                list.add(i);
                break;
            }
            i++;
        }
        return list;
    }
}
