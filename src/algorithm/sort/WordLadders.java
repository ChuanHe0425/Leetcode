package algorithm.sort;
import java.util.LinkedList;
import java.util.HashSet;
/*So we quickly realize that this looks like a tree searching problem for which
 *  breath first guarantees the optimal solution.

Assuming we have all English words in the dictionary, and the start is "hit" as
 shown in the diagram below.
We can use two queues to traverse the tree, one stores the nodes, the other stores 
the step numbers. Before starting coding,
we can visualize a tree in mind and come up with the following solution.*/
public class WordLadders {
	public int ladderLength(String start, String end, HashSet<String> dict) {
	      if (dict.size() == 0)  
	            return 0; 
	 
	        LinkedList<String> wordQueue = new LinkedList<String>();
	        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	 
	        wordQueue.add(start);
	        distanceQueue.add(1);
	 
	 
	        while(!wordQueue.isEmpty()){
	            String currWord = wordQueue.pop();
	            Integer currDistance = distanceQueue.pop();
	 
	            if(currWord.equals(end)){
	                return currDistance;
	            }
	 
	            for(int i=0; i<currWord.length(); i++){
	                char[] currCharArr = currWord.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	 
	                    String newWord = new String(currCharArr);
	                    if(dict.contains(newWord)){
	                        wordQueue.add(newWord);
	                        distanceQueue.add(currDistance+1);
	                        dict.remove(newWord);
	                    }
	                }
	            }
	        }
	 
	        return 0;
	}
}
//Use breath-first or depth-first search to solve problems
//Use two queues, one for words and another for counting