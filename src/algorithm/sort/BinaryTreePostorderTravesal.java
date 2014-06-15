package algorithm.sort;

import java.util.Stack;

import algorithm.sort.SameTree.TreeNode;

public class BinaryTreePostorderTravesal {


	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	  public ArrayList<Integer> postorderTraversal(TreeNode root) {
	       
	        ArrayList<Integer> lst = new ArrayList<Integer>(null);
	 
	        if(root == null)
	            return lst; 
	 
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	 
	        TreeNode prev = null;
	        while(!stack.empty()){
	            TreeNode curr = stack.peek();
	 
	            // go down the tree.
	            //check if current node is leaf, if so, process it and pop stack,
	            //otherwise, keep going down
	            if(prev == null || prev.left == curr || prev.right == curr){
	                //prev == null is the situation for the root node
	                if(curr.left != null){
	                    stack.push(curr.left);
	                }else if(curr.right != null){
	                    stack.push(curr.right);
	                }else{
	                    stack.pop();
	                    lst.add(curr.val, 0);
	                }
	 
	            //go up the tree from left node    
	            //need to check if there is a right child
	            //if yes, push it to stack
	            //otherwise, process parent and pop stack
	            }else if(curr.left == prev){
	                if(curr.right != null){
	                    stack.push(curr.right);
	                }else{
	                    stack.pop();
	                    lst.add(curr.val, 0);
	                }
	 
	            //go up the tree from right node 
	            //after coming back from right node, process parent node and pop stack. 
	    
	            }else if(curr.right == prev){
	                stack.pop();
	                lst.add(curr.val, 0);
	            }
	 
	            prev = curr;
	        }
	 
	        return lst;
	    }
	
	
	public static void main(String[] args) {
		BinaryTreePostorderTravesal lst = new BinaryTreePostorderTravesal();
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		TreeNode root6 = new TreeNode(6);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		
		ArrayList<Integer> list = lst.postorderTraversal(root1);
		System.out.println(list);


}
}

