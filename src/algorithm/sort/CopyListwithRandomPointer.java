package algorithm.sort;
import java.util.Random;
public class CopyListwithRandomPointer {

	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * };
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
	 
		RandomListNode p = head;
		RandomListNode q = newHead;
		map.put(head, newHead);
	 
		p = p.next;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			map.put(p, temp);
			q.next = temp;
			q = temp;
			p = p.next;
		}
	 
		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
	 
			p = p.next;
			q = q.next;
		}
	 
		return newHead;
	}
//============================================
	    public RandomListNode copyRandomList(RandomListNode head) {
	      
		if (head == null)
			return null;
	 
		RandomListNode p = head;
	 
		// copy every node and insert to list
		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
	 
		// break list to two
		p = head;
		RandomListNode newHead = head.next;
		while (p != null) {
			RandomListNode temp = p.next;
			p.next = temp.next;
			if (temp.next != null)
				temp.next = temp.next.next;
			p = p.next;
		}
	 
		return newHead;
	}
	  
	    }
