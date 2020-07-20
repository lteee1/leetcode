package com.lcj.test.tree;


import java.util.*;
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class T105从前序与中序遍历序列构造二叉树 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return bt(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode bt(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pleft]);
        Integer index = map.get(preorder[pleft]);
        int size = index - ileft;
        root.left = bt(preorder, inorder, pleft + 1, pleft + size, ileft, ileft + size);
        root.right = bt(preorder, inorder, pleft + size + 1, pright, ileft + size + 1, iright);
        return root;
    }
}
