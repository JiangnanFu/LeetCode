package find_repeat_number_03;

import java.util.Arrays;

/**
 * 时间复杂度为O(NlogN)，空间复杂度为O(1)，修改了原数组
 * 先排序在查找，排序之后有重复的肯定是挨着的，然后前后两两比较，如果有重复的直接返回
 *
 * @author fujiangnan
 * @version 1.0
 * @date 2020-08-11
 */
class Solution03 {
    public int findRepeatNumber03(int[] nums) {

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
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++){
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }

        return -1;
    }
}

