package algorithm.sort;

import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	    
	        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>> ();
	        
	        if (root==null ){
	            return result;
	        }
	        
	        boolean leftToRight=true;
	        
	        Stack<TreeNode> current=new Stack<TreeNode>();
	        Stack<TreeNode> next=new Stack<TreeNode>();
	        
	        current.push(root);
	        int level=0;
	        
	        while (!current.isEmpty()){
	            
	            if (result.size()==level){
	                ArrayList<Integer> temp=new ArrayList<Integer>();
	                result.add(temp);
	            }
	            
	            TreeNode currentNode=current.pop();
	            result.get(level).add(currentNode.val);
	            
	            if (leftToRight){
	                if (currentNode.left!=null) next.push(currentNode.left);
	                if (currentNode.right!=null) next.push(currentNode.right);
	                
	            }
	            else{
	                if (currentNode.right!=null) next.push(currentNode.right);
	                if (currentNode.left!=null) next.push(currentNode.left);
	                
	            }
	            
	            
	            // current level is empty, swap current level and next level
	            // reverse boolean leftToRight
	            // level++;
	            if (current.isEmpty()){
	                level++;
	                leftToRight=!leftToRight;
	                Stack<TreeNode> temp=current;
	                current=next;
	                next=temp;
	            }
	            
	        }
	        
	        return result;
	        
	    }
	}
	//======================================================================
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        boolean order = true;
        ArrayList<TreeNode> toVisit = new ArrayList<TreeNode>();
        toVisit.add(root);
        while(!toVisit.isEmpty()){
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(TreeNode node:toVisit){
                temp.add(node.val);
            }
            res.add(temp);
            for(int i=toVisit.size()-1;i>=0;i--){
                TreeNode node = toVisit.get(i);
                if(order){
                    if(node.right!=null) next.add(node.right);
                    if(node.left!=null) next.add(node.left);
                }else{
                    if(node.left!=null) next.add(node.left);
                    if(node.right!=null) next.add(node.right);
                }
            }
            order = order?false:true;
            toVisit = new ArrayList<TreeNode>(next);
        }
        return res;
    }
}

}
