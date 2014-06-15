package algorithm.sort;

public class SameTree {
	/**
	 * Definition for binary tree*/
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	       TreeNode(int x) { val = x; }
	  }
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p==null&&q==null) return true;
	        if(p!=null&&q==null) return false;
	        if(p==null&&q!=null) return false;
	        if(p.val==q.val){
	            
	            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	        }
	        else return false;
	    }
	}
/*题目要求：

给定两个二叉树，写一个函数来检查它们是否相投。

如果两个二叉树的结构相同并且结点有相同的值，我们就认为两个二叉树相同。

解题思路：

这类问题可以使用递归的方法来解决很简单，先检查结点是否同时为空，是则相同，
否则不同，然后分别以左结点和右结点作为结点递归的调用自己，都相同则相同，否则不同。
*/