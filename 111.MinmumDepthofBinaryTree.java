package cn.shgx.easy;
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 */
public class MinmumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
        if(root==null) {
        	return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0||right==0)
        	return left+right+1;
        return Math.min(left, right)+1;
    }
}
