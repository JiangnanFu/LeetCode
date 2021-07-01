package find_in_partially_sorted_matrix_04;

/**
 * 由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。
 *
 * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
 *
 * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，
 * 因此往下查找不可能找到目标值，往左查找可能找到目标值。
 * 如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
 *
 *    若数组为空，返回 false
 *     初始化行下标为 0，列下标为二维数组的列数减 1
 *     重复下列步骤，直到行下标或列下标超出边界
 *         获得当前下标位置的元素 num
 *         如果 num 和 target 相等，返回 true
 *         如果 num 大于 target，列下标减 1
 *         如果 num 小于 target，行下标加 1
 *     循环体执行完毕仍未找到元素等于 target ，说明不存在这样的元素，返回 false
 *
 * 复杂度分析
 *  时间复杂度：O(n+m) 访问到的下标的行最多增加 n 次，列最多减少 m 次，因此循环体最多执行 n + m 次。
 *  空间复杂度：O(1)
 *
 */
public class Solution01 {
    public boolean findNumberIn2DArray(int[][] matrix, int target){

        // 注意：直接调用matrix.length获得是数组的行数，调用matrix[0].length获得是0行的长度
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = 0;
        int j = columns - 1;

        while (i < rows && j >=0){
            if (target == matrix[i][j]){
                return true;
            }else if (target > matrix[i][j]){
                i++;
            }else{
                j--;
            }
        }




        return false;
    }
}
