package algorithm.sort;

import java.util.LinkedList;

import algorithm.sort.SameTree.TreeNode;

public class PathSum {

	 public boolean hasPathSum(TreeNode root, int sum) {
	        
	        if(root == null) return false;
	 
	        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
	        LinkedList<Integer> values = new LinkedList<Integer>();
	 
	        nodes.add(root);
	        values.add(root.val);
	 
	        while(!nodes.isEmpty()){
	            TreeNode curr = nodes.poll();
	            int sumValue = values.poll();
	 
	            if(curr.left == null && curr.right == null && sumValue==sum){
	                return true;
	            }
	 
	            if(curr.left != null){
	                nodes.add(curr.left);
	                values.add(sumValue+curr.left.val);
	            }
	 
	            if(curr.right != null){
	                nodes.add(curr.right);
	                values.add(sumValue+curr.right.val);
	            }
	        }
	 
	        return false;
	    }
	
//============================================================================
//another recursive method

public boolean hasPathSum1(TreeNode root, int sum) {

if(root==null) return false;

if(root.val==sum &&(root.left==null && root.right==null))

return true;

return hasPathSum(root.left,sum-root.val) ||
		hasPathSum(root.right,sum-root.val);

}
//==============================================
//BFS
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
                   return dfs(root , sum , 0);
    }
 public boolean dfs(TreeNode root , int sum ,int current){
        if(root == null) return false;
         if(root.left == null&& root.right==null)
         {
           return (current + root.val) == sum;  }
return dfs(root.left, sum, current+root.val) || 
		dfs(root.right, sum, current + root.val);
     }
} 
}
