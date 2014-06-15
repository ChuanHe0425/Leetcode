package algorithm.sort;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(null);
        ArrayList<Integer> list = new ArrayList<Integer>(list);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.offer(root);
        int leftCount = 0;
        while(!queue.isEmpty()){
            if(leftCount == 0){
                list = new ArrayList<Integer>(list);
                res.add(list);
                leftCount = queue.size();
            }
            TreeNode node = queue.poll();
            list.add(node.val);
            leftCount--;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return res;
    }
}
 