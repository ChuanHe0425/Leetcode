package algorithm.sort;

import java.util.HashMap;

//http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
public class LRUcache {

		    
	    public void LRUCache(int capacity) {
	      this.capacity = capacity;
	this.cacheList = new CacheNodeList(capacity);
	this.cacheMap = new HashMap<Integer, CacheNode>();  
	    }
	    
	    public int get(int key) {
	       CacheNode request = cacheMap.get(key);
	    if( request == null ) return -1;
	    cacheList.shiftToFirst(request);
	    return request.val;
	 
	    }
	    
	    public void set(int key, int value) {
	      if( cacheMap.containsKey(key) ){
	    CacheNode request = cacheMap.get(key);
	    request.val = value;
	    cacheList.shiftToFirst(request);
	}
	else{
	    if( cacheMap.size() == capacity ){
	        CacheNode node = cacheList.removeLast();
	        cacheMap.remove(node.key);
	    }
	    CacheNode newCache = new CacheNode(key, value);
	    cacheList.insertFirst(newCache);
	    cacheMap.put(key, newCache);
	}
	  
	    }
	private	 int	 capacity;
	private CacheNodeList cacheList;
	private HashMap<Integer, CacheNode> cacheMap;
	private	 class CacheNodeList {
	        private CacheNodeList(int capacity){
	            head = new	 CacheNode(0,0);
	            tail = new	 CacheNode(0,0);
	            head.next = tail;
	            tail.prev = head;
	        }
	        
	        private	 void insertFirst(CacheNode node){
	            node.next = head.next;
	            head.next.prev = node;
	            head.next = node;
	            node.prev = head;
	        }
	        
	        private	 CacheNode removeLast( ){
	            CacheNode lastNode = tail.prev;
	            tail.prev = tail.prev.prev;
	            tail.prev.next = tail;        
	            return lastNode;
	        }
	        
	        private	 void shiftToFirst( CacheNode node ){
	            node.prev.next = node.next;
	            node.next.prev = node.prev;
	            this.insertFirst(node);
	        }
	        
	        private	 CacheNode	 head;
	        private	 CacheNode	 tail;
	    }
	    
	    private	 class	 CacheNode {
	        
	        int	 key;
	        int	 val;
	        CacheNode	 prev;
	        CacheNode	 next;
	        
	        private CacheNode( int key, int val ){
	            this.key = key;
	            this.val = val;
	            this.prev = null;
	            this.next = null;
	        }
	    }
	}
