import java.util.HashMap;

/**
 1. 两数之和
 */
public class Test1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
        if (nums == null){
            return new int[2];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
        }
    }
}
