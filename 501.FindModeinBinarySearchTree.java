package cn.shgx.easy;

import java.util.LinkedList;
import java.util.List;

/**
 *Given a binary search tree (BST) with duplicates, 
 *find all the mode(s) (the most frequently occurred element) in the given BST.
 *Assume a BST is defined as follows:
 *The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 *The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 *Both the left and right subtrees must also be binary search trees.
 *For example:
 *Given BST [1,null,2,2],
   1
    \
     2
    /
   2
 *return [2].
 *Note: If a tree has more than one mode, you can return them in any order.
 *Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeinBinarySearchTree {
	private int count = -1;
	private int lastVal = Integer.MAX_VALUE;
	private int maxCount = 0;
	private List<Integer> list  = new LinkedList<>();
    public int[] findMode(TreeNode root) {
        find(root);
        if(count>maxCount) {
        	list.clear();
        	list.add(lastVal);
        }else if(count == maxCount) {
        	list.add(lastVal);
        }
        int[] result = new int[list.size()];
        for(int i =0;i<list.size();i++) {
        	result[i] = list.get(i);
        }
        return result;
    }
    private void find (TreeNode root) {
    	if(root == null) return ;
    	find(root.left);
    	if(root.val!=lastVal) {
    		if(count > maxCount) {
    			maxCount = count;
    			list.clear();
    			list.add(lastVal);
    		}else if(count == maxCount) {
    			list.add(lastVal);
    		}
    		count = 1;
    		lastVal = root.val;
    	}else {
    		count++;
    	}
    	find(root.right);
    }
}
