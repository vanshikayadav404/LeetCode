/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class TreeInfo {
        int height;
        int diam;

        TreeInfo(int height, int diam) {
            this.height = height;
            this.diam = diam;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diam;
    }

    public TreeInfo diameter(TreeNode root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTI = diameter(root.left);
        TreeInfo rightTI = diameter(root.right);

        // Height of current node
        int myHeight = Math.max(leftTI.height, rightTI.height) + 1;

        // Diameter through current node (in edges)
        int diam1 = leftTI.height + rightTI.height;

        // Diameter in left subtree
        int diam2 = leftTI.diam;

        // Diameter in right subtree
        int diam3 = rightTI.diam;

        // Maximum diameter
        int myDiam = Math.max(diam1, Math.max(diam2, diam3));

        return new TreeInfo(myHeight, myDiam);
    }
}