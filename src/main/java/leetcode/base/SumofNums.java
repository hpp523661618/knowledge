package leetcode.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumofNums {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        for (int i = 0; i < size -1 ; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }
        return result;

    }

    /**
     * map方法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByMap(int[] nums, int target) {

        int size = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int a = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }else {
                map.put(a,i);
            }
        }

        return null;


    }




        public static void main(String[] args) {

        int[] nums = new int[]{2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(twoSumByMap(nums, target)));
    }
}
