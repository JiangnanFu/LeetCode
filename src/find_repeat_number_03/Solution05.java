package find_repeat_number_03;

/**
 *
 *
 * @author fujiangnan
 * @version 1.0
 * @date 2020-08-11
 */
class Solution05 {
    public int findRepeatNumber05(int[] nums) {

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


        return -1;
    }
}

