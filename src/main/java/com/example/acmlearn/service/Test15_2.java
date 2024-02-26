import java.util.*;

/**
 * 三数之和哈希法错误示范
 */
public class Test15_2 {
        public static List<List<Integer>> threeSum(int[] nums) {
            //思路1：先排序，双指针法 + 快速跳过
            //思路2：哈希法 先排序，遍历一遍全添加进去，再双指针法x，看是否containskey
            //哈希法只能双重循环遍历，无法双指针，双指针无法覆盖所有解
            //[-4,-1,-1,0,1,2,6]
            //[0,1,1]
            //[-1,0,1,2,-1,-4]
            //[-4,-1,-1,0,1,2]

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int count = map.getOrDefault(nums[i],0);
                map.put(nums[i], ++count);
            }
            int i = 0, j = nums.length -1;
            while (i < j) {
                if (nums[i] > 0) break;
                if (nums[j] < 0) break;
                int count = -(nums[i] + nums[j]);
                if(map.containsKey(count)) {
                    if (!(nums[i] == count && map.get(count) == 1 ||
                            nums[j] == count && map.get(count) == 1)) {
                        result.add(Arrays.asList(nums[i], nums[j], count));
                    }
                    i++;
                    while (i < j && nums[i] == nums[i-1]) i++;
                }else if ((nums[i] + nums[j]) < 0) {
                    i++;
                    while (i < j && nums[i] == nums[i-1]) i++;
                }else if ((nums[i] + nums[j]) > 0) {
                    j--;
                    while (i < j && nums[j] == nums[j+1]) j--;
                }
            }

            return result;
        }

    public static void main(String[] args) {
        int[] array = new int[]{-4,-1,-1,0,1,2,6};
        System.out.println(threeSum(array));
    }
}
