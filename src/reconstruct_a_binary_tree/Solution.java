package reconstruct_a_binary_tree;

import java.util.HashMap;

/**
 * @author fujiangnan
 * @create 2020-12-03 20:54:42
 * @desc 根据前序遍历和中序遍历的结果进行二叉树的重建
 * 注意：本文方法只适用于 “无重复节点值” 的二叉树。
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    int[] preorder;
    // 建立一个hash表用于快速查找根节点对应的坐标
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preRoot]);
        // 根节点在中序遍历中的位置
        int inRoot = dic.get(preorder[preRoot]);
        //左子树递归
        node.left = recur(preRoot + 1, inLeft, inRoot - 1);

        //inRoot-inLeft+preRoot+1，其实就是右子树根节点=(中序根节点坐标-中序左边界）+先序根节点坐标+1，其中括号内=左子树长度。
        node.right = recur(inRoot - inLeft + preRoot + 1, preRoot + 1, inRight);
        return node;

    }
}
