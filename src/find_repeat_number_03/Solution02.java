package find_repeat_number_03;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度和空间复杂度均为O(n)
 * 使用set集合进行求解
 *
 * @author fujiangnan
 * @version 1.0
 * @date 2020-08-11
 */
class Solution02 {
    public int findRepeatNumber02(int[] nums) {

        // 判断数组长度是否符合要求
        if (nums.length <= 0) {
            return -1;
        }

        // 判断数组内容是否符合要求
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 0 || nums[j] > nums.length - 1) {
                return -1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}

