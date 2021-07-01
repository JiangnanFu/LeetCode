package find_repeat_number_03;

/**
 * 将数组视为哈希表
 * 这里我们可以申请一个临时数组temp，因为nums元素中的每个元素的大小都在0~n-1之间，
 * 所以我们可以把nums中元素的值和临时数组temp建立映射关系，就是nums中元素的值是几，
 * 我们就把temp中对应的位置值加1，当temp某个位置的值大于1的时候，就表示出现了重复，我们直接返回即可
 *
 * @author fujiangnan
 * @version 1.0
 * @date 2020-08-11
 */
class Solution04 {
    public int findRepeatNumber04(int[] nums) {

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

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}

