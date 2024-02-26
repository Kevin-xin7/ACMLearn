import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Test15_1 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //思路1：先排序，双指针法 + 快速跳过
            //思路2：哈希法 先排序，遍历一遍全添加进去，再双指针法，看是否containskey
            //[-4,-1,-1,0,1,2]
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                //先过滤无效解
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int j = i + 1, k = nums.length-1;
                while (j < k) {
                    if (j < k && nums[i] + nums[j] + nums[k] < 0) {
                        //快速跳过重复值
                        j++;
                        while (j < k && nums[j] == nums[j-1]) j++;
                    }else if (j < k && nums[i] + nums[j] + nums[k] > 0) {
                        //快速跳过重复值
                        k--;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    }else {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j++]);
                        list.add(nums[k--]);
                        result.add(list);
                        while (j < k && nums[j] == nums[j-1]) j++;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    }
                }
            }
            return result;
        }
    }
}
