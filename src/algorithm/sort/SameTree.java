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
/*��ĿҪ��

����������������дһ����������������Ƿ���Ͷ��

��������������Ľṹ��ͬ���ҽ������ͬ��ֵ�����Ǿ���Ϊ������������ͬ��

����˼·��

�����������ʹ�õݹ�ķ���������ܼ򵥣��ȼ�����Ƿ�ͬʱΪ�գ�������ͬ��
����ͬ��Ȼ��ֱ���������ҽ����Ϊ���ݹ�ĵ����Լ�������ͬ����ͬ������ͬ��
*/