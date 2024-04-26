package com.example.hash;

import org.apache.catalina.util.ManifestResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM51数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,2,2,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }

    public static int MoreThanHalfNum_Solution (int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = numbers.length;
        for (int i = 0 ; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                map.put(numbers[i], map.get(numbers[i])+1);
            }else {
                map.put(numbers[i], 1);
            }
        }
        //寻找HashMap中元素超过数组长度的一半的key值
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            if (map.get(key) > length / 2) {
                return key;
            }
        }
        return -1;
    }
}
