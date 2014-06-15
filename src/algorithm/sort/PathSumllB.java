package algorithm.sort;


  
	  
	import java.util.ArrayList;  
	  
	import Utility.TreeNode;  
	  
	/** 
	 * Path Sum II   
	 *  
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
	 
	For example: 
	Given the below binary tree and sum = 22, 
	              5 
	             / \ 
	            4    8 
	           /     / \ 
	          11  13  4 
	         /  \      / \ 
	        7    2   5   1 
	return 
	[ 
	   [5,4,11,2], 
	   [5,8,4,5] 
	] 
	 */  
	  
	  
	public class PathSumllB {

	  
	    public static void main(String[] args) {  
	        TreeNode root = new TreeNode(5);  
	        TreeNode n1 = new TreeNode(4);  
	        TreeNode n2 = new TreeNode(8);  
	        root.left = n1;  
	        root.right = n2;  
	        TreeNode n3 = new TreeNode(11);  
	        TreeNode n4 = new TreeNode(13);  
	        TreeNode n5 = new TreeNode(4);  
	        n1.left = n3;  
	        n2.left = n4;  
	        n2.right = n5;  
	        TreeNode n6 = new TreeNode(7);  
	        TreeNode n7 = new TreeNode(2);  
	        n3.left = n6;  
	        n3.right = n7;  
	        TreeNode n8 = new TreeNode(5);  
	        TreeNode n9 = new TreeNode(1);  
	        n5.left = n8;  
	        n5.right = n9;  
	          
	        ArrayList<ArrayList<Integer>> list = pathSum(root, 22);  
	        System.out.println(list);  
	    }  
	      
	    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {  
	        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();  
	        ArrayList<Integer> l =new ArrayList<Integer>();  
	        dfs(root, sum, list, l);  
	        return list;  
	    }  
	      
	    // 经典递归回溯  
	    private static void dfs(TreeNode root, int sum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> l){  
	        if(root == null){  
	            return;  
	        }  
	      
	        // 找到最后一个合适的叶子节点  
	        if(root.val==sum && root.left==null && root.right==null){  
	            l.add(root.val);  
	              
	            // 注意！在把结果加入结果集时，必须深拷贝一份！  
	            // 否则被加进去的集合之后可能会变动  
	            ArrayList<Integer> clone = new ArrayList<Integer>(l);  
	            list.add(clone);  
	              
	            l.remove(l.size()-1);       // 恢复全局变量//回溯部分  
	            return;  
	        }  
	      
	        l.add(root.val);  
	        dfs(root.left, sum-root.val, list, l);  
	        dfs(root.right, sum-root.val, list, l);  
	        l.remove(l.size()-1);       // 恢复全局变量//回溯部分  
	    }  
	}  

}
