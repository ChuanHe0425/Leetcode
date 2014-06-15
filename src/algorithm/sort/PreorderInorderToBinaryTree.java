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
	 *//*1��������������һ���ڵ��Ǹ����ĸ���
	 ��2�����и��������ҵ��ýڵ㣬�±��Ϊindex���ýڵ㽫�����ҷֿ�
	 ��3����������У�0,index-1]�����������Ľڵ㣬[index,lenth-1]�����������Ľڵ�
	 ��4���ֱ�������������������еݹ����
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
