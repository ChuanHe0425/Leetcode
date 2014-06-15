package algorithm.sort;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
				
			        
					if(head==null|| head.next == null) return head;
					        
					        ListNode n1= head;
					        while(n1.next!=null){
					            if(n1.next.val==n1.val){
					                n1.next=n1.next.next;
					            }else{
					                n1=n1.next;   
					            }
					        }
					        return head;
					    }
//====================================================================
	/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
	 * 
	 * 
	 *	 */
	public ListNode deleteDuplicates2(ListNode head) {

        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        
        ListNode n1=head;
        while(n1.next!=null){
            ListNode n2=n1.next;
            while(n2.next!=null && n2.next.val==n2.val){
                n2=n2.next;
            }
            if(n2!=n1.next){
                n1.next=n2.next;
            }else{
                n1=n1.next;   
            }
        }
        return head.next;
    }
}


