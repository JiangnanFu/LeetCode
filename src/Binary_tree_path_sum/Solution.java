package Binary_tree_path_sum;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 @author fujiangnan
 @create 2021-02-11-12-11
 @desc 求二叉树中根节点到叶子结点和为sum的路径
 */

public class Solution {
    //private static Integer[] array = {5,4,8,11,null,13,4,7,2,null,null,5,1};
    private static Integer[] array = {1,3,2,1,0,2,0};
    private static List<TreeNode> nodeList = null;

    /**
     * Definition for a binary tree node
     * */
    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null) {
            return;
        }
        //把当前节点值加入到list中
        list.add(root.val);
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val) {
                result.add(new ArrayList<Integer>(list));
            }
            //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
            //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
            //一个结点的值给remove掉。
            list.remove(list.size() - 1);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);

        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        //我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }

    public static TreeNode createBinaryTree() {
        nodeList = new LinkedList<>();
        //将一个数组依次转化为node节点
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(array[i]));
            }
        }
        TreeNode root = nodeList.get(0);
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length/ 2 -1; parentIndex++) {

            if (nodeList.get(parentIndex) != null) {
                // 左孩子
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 +1);
                // 右孩子
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2+2);
            }
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 -1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        // 右孩子
        if (array.length % 2 == 1){
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2+2);
        }
        return root;

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }


        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> array = new ArrayList<>();

            for (int i=0; i<len; ++i) {
                TreeNode temp = queue.poll();
                array.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            }
            list.add(array);
        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = createBinaryTree();
        List<List<Integer>> levelRes = levelOrder(root);
        System.out.println(levelRes);
        List<List<Integer>> res = pathSum(root, 5);
        System.out.println(res);

    }
}





