package algorithm.sort;
public class SwapNodesInPairs {
	/**
	 * Definition for singly-linked list.*/
	 public class ListNode {
	    int val;
	      ListNode nextNode;
		public ListNode next;
	     ListNode(int x) {
	         val = x;
	          nextNode = null;
	      }
	  }
	 
		    public ListNode swapPairs(ListNode head) {
	  
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ListNode helper = new ListNode(0);
	        helper.next = head;
	        ListNode n1 = helper, n2 = head;
	        
	        while(n2!=null && n2.next!=null){
	            ListNode temp = n2.next.next;
	            n2.next.next=n1.next;
	            n1.next=n2.next;
	            n2.next=temp;
	            n1=n2;
	            n2=n1.next;
	        }
	        
	        return helper.next;
	    }
	}
	   
	    

