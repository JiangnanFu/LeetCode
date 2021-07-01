package find_repeat_number_03;

import java.lang.reflect.Array;

/**
 * 原地置换：该方法的时间复杂度为O(n),空间复杂度为O(1),但是会变了原数组
 *
 * @author fujiangnan
 * @version 1.0
 * @date 2020-08-11
 */

class Solution01 {
    public int findRepeatNumber01(int[] nums) {
        int temp = 0;

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

        for (int i = 0; i < nums.length; i++) {
            // 交换过程中发现重复元素
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                return nums[i];

            } else {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;

    }
}
