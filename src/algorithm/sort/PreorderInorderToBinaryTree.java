package algorithm.sort;

public class PreorderInorderToBinaryTree {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 *//*1）后根遍历的最后一个节点是该树的根；
	 （2）在中根遍历中找到该节点，下标记为index，该节点将树左右分开
	 （3）后根遍历中［0,index-1]就是左子树的节点，[index,lenth-1]就是右子树的节点
	 （4）分别对左子树和右子树进行递归求解
	 */
		    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        
	    
	        if (preorder==null||preorder.length==0|| inorder==null ||inorder.length==0){
	            return null;
	        }
	      int pSt=0;
	      int pEd=preorder.length-1;
	      
	      int iSt=0;
	      int iEd=inorder.length-1;
	      
	      return buildTree(preorder, pSt, pEd, inorder, iSt, iEd);
	        
	        
	    }
	    
	    private  TreeNode buildTree(int[] preorder, int pSt, int pEd, int[] inorder, int iSt, int iEd){
	        if (pSt>pEd || iSt>iEd){
	            return null;
	        }
	        
	       TreeNode root=new TreeNode (preorder[pSt]);
	       
	       int index=0;
	       for (int i=iSt; i<=iEd; i++){
	           if (inorder[i]==root.val){
	                index=i;
	                 break;
	           }
	           
	       }
	       // length of left tree
	       int len=index-iSt;
	       
	       // pay attention to bounds of preorder and inorder
	       root.left=buildTree(preorder, pSt+1, pSt+1+len-1, inorder, iSt, index-1);
	       root.right=buildTree(preorder, pSt+1+len-1+1, pEd, inorder, index+1, iEd);
	        
	        return root;
	    }
	    
	}
