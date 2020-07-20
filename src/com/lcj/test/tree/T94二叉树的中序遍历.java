package com.lcj.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class T94二叉树的中序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> re = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null)
        inorder(root);
        return re;
    }
    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            re.add(root.val);
            inorder(root.right);
        }
    }
}
