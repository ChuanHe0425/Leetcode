package algorithm.sort;

import algorithm.sort.SameTree.TreeNode;

public class RecoverBinarySearchTree {
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
	     
	    public void recoverTree(TreeNode root) {
	        TreeNode n1=null, n2 =null;
	    
	            TreeNode current=root,prev=null,a=null;
	            boolean first=true;
	            while(current!=null){
	                if(current.left==null){
	                    if(a!=null && a.val>current.val) {
	                        if(first){
	                            n1=a;
	                            first=false;
	                        }else{
	                            n2=current;
	                        }
	                    }
	                    if(n1!=null && a==n1) n2=current;
	                    a=current;
	                    current=current.right;
	                }else{
	                    prev=current.left;
	                    while(prev.right!=null && prev.right!=current)
	                        prev=prev.right;
	                    if(prev.right==null){
	                        prev.right=current;
	                        current = current.left;
	                    }else{
	                        if(a!=null && a.val>current.val) {
	                            if(first){
	                                n1=a;
	                                first=false;
	                            }else{
	                                n2=current;
	                            }
	                        }
	                        if(n1!=null && a==n1) n2=current;
	                        a=current;
	                        prev.right=null;
	                        current=current.right;
	                    }
	                }
	            }
	            assert(n1!=null && n2!=null);
	            int temp =n1.val;
	            n1.val=n2.val;
	            n2.val=temp;
	        }
	        
	}
}

	        
