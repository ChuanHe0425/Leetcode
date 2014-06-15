package algorithm.sort;


	import java.util.ArrayList;
	import java.util.Comparator;
	import java.util.PriorityQueue;
	 
	//  Definition for singly-linked list.
	
	 
	public class MergekSortedLists {
		class ListNode {

			protected int val;
			public algorithm.sort.MergekSortedLists.ListNode next;
	}
		int val;
		ListNode next;
	 
		void ListNode(int x) {
			val = x;
			next = null;
		}
	
		public ListNode mergeKLists(ArrayList<ListNode> lists) {
			if (lists.size() == 0)
				return null;
	 
			//PriorityQueue is a sorted queue
			PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
					new Comparator<ListNode>() {
						public int compare(ListNode a, ListNode b) {
							if (a.val > b.val)
								return 1;
							else if(a.val == b.val)
								return 0;
							else 
								return -1;
						}
					});
	 
			//add first node of each list to the queue
			for (ListNode list : lists) {
				if (list != null)
					q.add(list);
			}
	 
			ListNode head = new ListNode();
			ListNode prev = head;
	 
			while (q.size() > 0) {
				ListNode temp = q.poll();
				prev.next = temp;
	 
				//keep adding next element of each list
				if (temp.next != null)
					q.add(temp.next);
	 
				prev = prev.next;
			}
	 
			return head.next;
		}
	}


