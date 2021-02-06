package kr.seok.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 */
public class Hash_1 {
    public int[] twoSum_TwoPass_HashTable(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++) {
            result.put(nums[i], i);
        }

        for(int i = 0 ; i < nums.length ; i++) {
            int complement = target - nums[i];
            if(result.containsKey(complement) && result.get(complement) != i) {
                // 충족하는 인덱스를 리턴
                return new int[] { i, result.get(complement) };
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_OnePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // 값을 넣는 도중에 충족하는 결과 값이 존재하는 경우 반환
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
