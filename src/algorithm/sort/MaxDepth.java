package algorithm.sort;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        
        
   if(root == null)
    return 0;

    return getDepth(root, 1);
}

        public int getDepth(TreeNode node, int depth) {
        int left = depth, right = depth;
        if(node.left != null) left = getDepth(node.left, depth + 1);
     if(node.right != null) right = getDepth(node.right, depth + 1);

    return left > right ? left : right;
}
}
