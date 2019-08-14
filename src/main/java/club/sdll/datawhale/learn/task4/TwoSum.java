package club.sdll.datawhale.learn.task4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shandianlala@gmail.com
 * @description TODO
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @url https://leetcode.com/problems/two-sum/
 * @since 2019-08-14 23:10
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> valueAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer subValue = target - nums[i];
            if (valueAndIndex.containsKey(subValue)) {
                result[0] = valueAndIndex.get(subValue);
                result[1] = i;
                break;
            }
            valueAndIndex.put(nums[i], i);
        }
        return result;
    }

}
