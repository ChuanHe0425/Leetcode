package algorithm.sort;

import java.util.ArrayList;

import algorithm.sort.SameTree.TreeNode;

public class PathSumII {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
		    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        
	    /*ArrayList <Integer> current=new ArrayList<Integer>();
	     
	     ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	     
	     pathSumHelper(root, sum, current, result);
	     return result;
	    }
	public void pathSumHelper
	(TreeNode root, int sum, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result)
	    {
	        if (root==null){
	            return;
	        }
	        current.add(root.val);
	        int current_sum=sum-root.val;
	        
	        if (current_sum==0&& root.left==null && root.right==null){
	            ArrayList<Integer> temp=new ArrayList<Integer>();
	            for(int i:current){
	                temp.add(i);
	            }
	            result.add(temp);
	        }
	        pathSumHelper(root.left, current_sum, current, result);
	        pathSumHelper(root.right, current_sum, current, result);
	        
	        current.remove(current.size()-1);
	    }
	}*/
	ArrayList <Integer> current=new ArrayList<Integer>();
	     
	     ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	     
	     pathSumHelper(root, sum, current, result);
	     return result;
	    }
	public void pathSumHelper
	(TreeNode root, int sum, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result)
	    {
	        if (root==null){
	            return;
	        }
	        current.add(root.val);
	        int current_sum=sum-root.val;
	        
	        if (current_sum==0&& root.left==null && root.right==null){
	            ArrayList<Integer> temp=new ArrayList<Integer>();
	            for(int i:current){
	                temp.add(i);
	            }
	            result.add(temp);
	        }
	        pathSumHelper(root.left, current_sum, current, result);
	        pathSumHelper(root.right, current_sum, current, result);
	        
	        current.remove(current.size()-1);
	    }
	}




