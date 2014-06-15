package algorithm.sort;

public class ReorderList {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	
	    public void reorderList(ListNode head) {
	        
	     int n = 0;
	     ListNode start = head; 
	     while (head != null) { 
	         head = head.next; 
	         n++; 
	         } 
	         if (n <= 2) return; 
	         int t = n/2;
	         head = start;
	         for (int i=0; i <n-t-1; i++) {
	             head = head.next;
	             }
	             ListNode prev = head.next;
	             ListNode cur = prev.next;
	              while (cur != null) {
	                  prev.next = cur.next;
	                  cur.next = head.next;
	                  head.next = cur;
	                  cur = prev.next;
	                  } 
	                  
	                  cur = head.next;
	                  while (cur != null && start != null) {
	                      head.next = cur.next;
	                      cur.next = start.next;
	                    start.next = cur;
	                    start = start.next.next;
	                    cur = head.next;
	      }
	     }
	}
