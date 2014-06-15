package algorithm.sort;

public class PopulatingNextRightPointersinEachNodeII {
/*For example,
Given the following binary tree,
1
/  \
2    3
/ \    \
4   5    7
After calling your function, the tree should look like:
1 -> NULL
/  \
2 -> 3 -> NULL
/ \    \
4-> 5 -> 7 -> NULL*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
    public void connect(TreeLinkNode root) {
        
     if(root == null){
             return;
         }
         if(root.left != null){
             if(root.right == null){
                 TreeLinkNode p = root.next;
                 boolean flag = true;
                 while(p != null && flag){
                     if(p.left != null){
                         root.left.next = p.left;
                         flag = false;
                     } else if(p.right != null){
                         root.left.next = p.right;
                         flag = false;
                     } else {
                         p = p.next;
                     }
                 }
                 
             } else{
                 root.left.next = root.right;
             }
         }
         if(root.right != null){
             if(root.next == null){
                 root.right.next = null;
             } else {
                 TreeLinkNode p = root.next;
                 boolean flag = true;
                 while(p != null && flag){
                     if(p.left != null){
                         root.right.next = p.left;
                         flag = false;
                     } else if(p.right != null){
                         root.right.next = p.right;
                         flag = false;
                     } else {
                         p = p.next;
                     }
                 }
             }
         }
        connect(root.right);
         connect(root.left);
     }
 }