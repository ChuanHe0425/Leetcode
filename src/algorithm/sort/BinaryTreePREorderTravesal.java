package algorithm.sort;




import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class BinaryTreePREorderTravesal {


	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
        if (root == null)
        	return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.size() != 0){
        	TreeNode top = stack.peek();
        	if (top.left == null && top.right == null){
        		list.add(top.val);
        		stack.pop();
        	}
        	if (top.right != null){
        		stack.push(top.right);
        		top.right = null;
        		continue;
        	}
        	if (top.left != null){
        		stack.push(top.left);
        		top.left = null;
        		continue;
        	}
        }
        for (int i=0; i<list.size(); ++i){
        	list2.add(list.get(list.size()-1-i));
        }
        return list2;
    }
	public static void main(String[] args) {
		BinaryTreePREorderTravesal  sl = new BinaryTreePREorderTravesal();
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
		
		ArrayList<Integer> list = sl.preorderTraversal(root1);
		System.out.println(list);
	}
}
