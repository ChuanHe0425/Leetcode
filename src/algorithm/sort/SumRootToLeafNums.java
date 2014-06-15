package algorithm.sort;

public class SumRootToLeafNums {
/*
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

	An example is the root-to-leaf path 1->2->3 which represents the number 123.

	Find the total sum of all root-to-leaf numbers.

	For example,

	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25.

	====================
	Analysis:

	1. Recursive approach, each recursive call focus on only one node

	For each recursive call:

	2. Construct the number up to this node <- num*10+ current node value

	3. If reached the leaf node (means a complete number constructed), add the number to sum

	4. Otherwise, add the sum of left subtree and right subtree.

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
		    public int sumNumbers(TreeNode root) {
	        if(root == null) return 0;
	        return helper(root, 0, 0);
	    }
	    
	    public int helper(TreeNode node, int num, int sum){
	        if(node == null) return sum;
	        
	        num = num*10 + node.val;
	        
	        // leaf reached
	        if(node.left == null && node.right == null) {
	            sum += num;
	            return sum;
	        }
	        
	        // sum of left subtree + right subtree
	        sum = helper(node.left, num, sum) + helper(node.right, num, sum);
	        return sum;
	    }
	
//===============================================================================
public int sumNumbersB(TreeNode root) {

    // Start typing your Java solution below
    // DO NOT write main() function
    return dfs(root,0);
}
    public int dfs(TreeNode node, int sum){
    if(node == null) return 0;
    int res =node.val+sum*10;
    if(node.left==null && node.right==null) return res;
    return dfs(node.left,res) + dfs(node.right, res);

}
}

	 