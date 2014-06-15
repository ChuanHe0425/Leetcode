package algorithm.sort;

public class ReverseLinkedLIstII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null){
            return head;
        }
        
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        
        ListNode pre=preHead;
        ListNode current=head;
        ListNode end=head;
        
        int countM=1;
        int countN=1;
        // find M point and N point
        while (countM<m || countN<n ){
            if (countM<m){
                pre=pre.next;
                current=current.next;
                countM++;
            }
            
            if (countN<n){
                end=end.next;
                countN++;
            }
        }
        
        // reverse from M point to N Point
        reverse(pre, end.next);
        return preHead.next;
        
    }
    
    private void reverse(ListNode pre, ListNode endNext){
        ListNode cur=pre.next;
        
        while (cur.next!=endNext){
            
            ListNode next=cur.next;
            ListNode temp=pre.next;
            pre.next=next;
            cur.next=next.next;
            
            next.next=temp;
            
        }
    }
    //==========================================
 /*Analysis:
One of the key tricks is to set up 2 pointers, distance between which equal to n-m.
 Therefore, when the left pointer reached m position, the right pointer would reach n position as wee.  
After we got the node at position m and the node at position n, 
we move node at position m to the position after node n one by one, 
until all the nodes before node n processed. For example:
Original linked list:       1->2->3->4->5->6->7; m = 3, n =6
Step1:        1->2->4->5->6->3->7    
Step2:      1->2->5->6->4->3->7           
......
Result:      1->2->6->5->4->3->7
Note that pointer m is switching to right one by one in each step, but pointer n remains no change.
Finally, we need to consider about the case that reverse range started from the 
very beginning of the linked list.  In this case, we should return the pointer n 
rather than return the original head of the linked list.

*/   
public ListNode reverseBetween2(ListNode head, int m, int n) {
        
        // init m node and n node  
        ListNode mNode = head;  
        ListNode nNode = head;  
          
        // previous node of node m  
        ListNode mPreNode = new ListNode(0);  
        mPreNode.next = head;  
          
        // set up the distance between node m and node n  
        for (int i=0; i<n-m; i++) nNode = nNode.next;  
          
        // locate node m and node n  
        for (int i=0; i<m-1; i++){  
            mPreNode = mNode;  
            mNode = mNode.next;  
            nNode = nNode.next;  
        }  
          
        // check if case of reversing from head  
        boolean fromHead = false;  
        if(mNode == head) fromHead = true;  
          
        // reverse node range  
        while(mNode!=nNode){  
            ListNode temp = nNode.next;  
            nNode.next = mNode;  
            mPreNode.next = mNode.next;  
            mNode.next = temp;  
            mNode = mPreNode.next;  
        }  
          
        // case of reverse started from head  
        if(fromHead == true) return nNode;  
          
        // other cases  
        return head;  
    }  
    
    }
