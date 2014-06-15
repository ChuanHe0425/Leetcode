package algorithm.sort;

public class PopulatingNextRightPointersinEachNode{
	public void connect(TreeLinkNode root) {

	 if(root==null) return;
     if(root.right!=null&& root.next!=null && root.next.left!=null)
         root.right.next = root.next.left;
     if(root.left!=null)
         root.left.next = root.right;
     connect(root.left);
     connect(root.right);
 }

//===========================================================
public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(root==null) return;
    TreeLinkNode cur=root, 
                 top=root, 
                 first=root.left;
    cur.next = null;
    
    while(top!=null && top.left!=null){
        while(top!=null){
            cur=top.left;
            cur.next=top.right;
            cur=cur.next;
            top=top.next;
            cur.next=(top==null)?null:top.left;
        }
        top=first;
        first=(top==null)?null:top.left;
    }
    
}
