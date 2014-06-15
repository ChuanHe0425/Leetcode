
//Sort a linked list in O(n log n) time using constant space complexity
//using insertion sort 的话 我用了insertion sort has O(n^2) time complexity。 不符合条件




	package algorithm.sort;
	 
	class ListNode {
		int val;
		ListNode next;
	 
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	 
	public class SortLIstinOnlogn {
		public static ListNode insertionSortList(ListNode head) {
	 
			if (head == null || head.next == null)
				return head;
	 
			ListNode newHead = new ListNode(head.val);
			ListNode pointer = head.next;
	 
			// loop through each element in the list
			while (pointer != null) {
				// insert this element to the new list
	 
				ListNode innerPointer = newHead;
				ListNode next = pointer.next;
	 
				if (pointer.val <= newHead.val) {
					ListNode oldHead = newHead;
					newHead = pointer;
					newHead.next = oldHead;
				} else {
					while (innerPointer.next != null) {
	 
						if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
							ListNode oldNext = innerPointer.next;
							innerPointer.next = pointer;
							pointer.next = oldNext;
						}
	 
						innerPointer = innerPointer.next;
					}
	 
					if (innerPointer.next == null && pointer.val > innerPointer.val) {
						innerPointer.next = pointer;
						pointer.next = null;
					}
				}
	 
				// finally
				pointer = next;
			}
	 
			return newHead;
		}
	 
		public static void main(String[] args) {
			ListNode n1 = new ListNode(2);
			ListNode n2 = new ListNode(3);
			ListNode n3 = new ListNode(4);
	 
			ListNode n4 = new ListNode(3);
			ListNode n5 = new ListNode(4);
			ListNode n6 = new ListNode(5);
	 
			n1.next = n2;
			n2.next = n3;
			n3.next = n4;
			n4.next = n5;
			n5.next = n6;
	 
			n1 = insertionSortList(n1);
	 
			printList(n1);
	 
		}
	 
		public static void printList(ListNode x) {
			if(x != null){
				System.out.print(x.val + " ");
				while (x.next != null) {
					System.out.print(x.next.val + " ");
					x = x.next;
				}
				System.out.println();
			}
	 
		}
	}
//O（nlogn）
	
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
	public class Solution {
	    public ListNode sortList(ListNode head) {
	        
	    if (head==null || head.next==null){
		            return head;
		        } 
		        
		        ListNode counter=head;
		        int len=0;
		        while(counter!=null){
		            counter=counter.next;
		            len++;
		        }
		        ListNode[] headArray={head};
		        return mergeSort(headArray, len);
		        
		                 
		     }
		     private ListNode mergeSort(ListNode[] headArray, int len){
		         if (len==1){
		             
		             ListNode temp=headArray[0];
		             headArray[0]=headArray[0].next;
		             
		             temp.next=null;
		             
		             return temp;
		         }
		         
		         ListNode left=mergeSort(headArray, len/2);
		         ListNode right=mergeSort(headArray, len-len/2);
		         
		         return merge(left, right);
		         
		         
		     }
		     
		     private ListNode merge(ListNode left, ListNode right){
		         if (left==null)
		             return right;
		         
		         
		         if (right==null)
		             return left;
		         
		         
		         ListNode preHead=new ListNode (-1);
		         
		         ListNode end=preHead;
		         
		         while(left!=null && right !=null){
		             if (left.val<right.val){
		                 end.next=left;
		                 left=left.next;
		             }
		             else{
		                 end.next=right;
		                 right=right.next;
		             }
		             
		             end=end.next;
		         }
		         
		         if (left!=null){
		             end.next=left;
		         }
		         
		         if (right!=null){
		             end.next=right;
		         }
		         
		         
		         return preHead.next;
		     }
	  
	  
	  }
