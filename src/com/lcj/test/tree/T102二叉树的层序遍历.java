package com.lcj.test.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class T102二叉树的层序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> tree = new ArrayDeque<>();
        if (root != null) {
            tree.add(root);
        }
        while (!tree.isEmpty()) {
            int length = tree.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = tree.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    tree.add(poll.left);
                }
                if (poll.right != null) {
                    tree.add(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
