import java.util.*;

/**
 * 三数之和哈希法正确解法
 */
public class Test15_3 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    break; // 如果第一个元素(最小的)就大于0, 显然整个三元数组的和大于0
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue; // 第一个元素的选择是不能重复的, 但是nums[j]可以和nums[i]相等
                }
                Set<Integer> set = new HashSet<>(); // 第一个元素已经确定, 对后两个元素的选择进行去重
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 2 && nums[j] == nums[j - 1] && nums[j - 1] == nums[j - 2]) {
                        continue; // 如果连续三个元素相等, 则只有nums[j - 1]和nums[j - 2]是有用的, 详细解释见解答
                    }
                    int c = 0 - (nums[i] + nums[j]);
                    if (set.contains(c)) {
                        res.add(Arrays.asList(nums[i], nums[j], c));
                        set.remove(c); // 对于一个nums[i]和nums[j], c只可以用一次, 因此将其从set移除, 后面没用了
                    } else {
                        set.add(nums[j]); // 目前set无法找到满足条件的c, 那么将num加入, 同时移动j向后找
                    }
                }
            }
            return res;
        }
    }
}
