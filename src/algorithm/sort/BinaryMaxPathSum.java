package algorithm.sort;

public class BinaryMaxPathSum {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	int max; 
	
	    public int maxPathSum(TreeNode root) {
	      //store max value
	 
			max = (root == null) ? 0 : root.val;
			findMax(root);
			return max;
		}
	 
		public int findMax(TreeNode node) {
			if (node == null)
				return 0;
	 
			// recursively get sum of left and right path
			int left = Math.max(findMax(node.left), 0);
			int right = Math.max(findMax(node.right), 0);
	 
			//update maximum here
			max = Math.max(node.val + left + right, max);
	 
			// return sum of largest path of current node
			return node.val + Math.max(left, right);
	  
	    }
	}