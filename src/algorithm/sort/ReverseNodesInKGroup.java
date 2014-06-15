package algorithm.sort;

public class ReverseNodesInKGroup {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	     if(k<=1 || head==null || head.next==null) return head;
	        
	        ListNode prev = new ListNode(0);
	        prev.next = head;
	        head = prev;
	        
	        ListNode cur=prev.next;
	        while(cur!=null){
	            int counter = k;
	            while(cur!=null && counter>1){
	                cur = cur.next;
	                counter--;
	            }
	            
	            if(cur!=null){
	                cur=prev.next;
	                counter=k;
	                while(counter>1){
	                    ListNode temp = cur.next;
	                    cur.next=temp.next;
	                    temp.next=prev.next;
	                    prev.next=temp;
	                    counter--;
	                }
	                prev = cur;
	                cur = prev.next;
	            }
	        }
	        
	        return head.next;
	    }
	   
	    }
	//==============================================
	//http://rleetcode.blogspot.com/2014/01/reverse-nodes-in-k-group-java.html
	public ListNode reverseKGroup(ListNode head, int k) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (head ==null || k==1){
	            return head;
	        }
	        
	        ListNode dummy =new ListNode (0);
	        dummy.next=head;
	        
	        ListNode pre=dummy;
	        
	        int i=0;
	        while (head!=null){
	            i++;
	            
	            if (i%k==0){
	                pre=reverse(pre,head.next);
	                head=pre.next;
	            }
	            else {
	                head=head.next;
	                
	            }
	        }
	        return dummy.next;
	        
	    }
	    /**
	     * Reverse a link list between pre and next exclusively
	     * an example:
	     * a linked list:
	     * 0->1->2->3->4->5->6
	     * |           |   
	     * pre        next
	     * after call pre = reverse(pre, next)
	     * 
	     * 0->3->2->1->4->5->6
	     *          |  |
	     *          pre next
	     * @param pre 
	     * @param next
	     * @return the reversed list's last node, which is the precedence of parameter next
	     */
	    public ListNode reverse(ListNode pre, ListNode next){
	        
	        
	        ListNode last=pre.next;
	        ListNode cur=last.next;
	        
	        while (cur!=next){
	            
	            last.next=cur.next;
	            cur.next=pre.next;
	            pre.next=cur;
	            
	            cur=last.next;
	        }
	        return last;
	    }
	}

