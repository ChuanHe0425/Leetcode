package algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {  
        int[] num = {0,0};  
        System.out.println(longestConsecutive(num));  
    }  
  
    // 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度，用hashset或者hashtable  
    public static int longestConsecutive(int[] num) {  
        Set<Integer> set = new HashSet<Integer>();  
          
        for (int i : num) {  
            set.add(i);  
        }  
        int max = 0;  
          
        for(int i=0; i<num.length; i++){  
            if(set.contains(num[i])){  
                int next = num[i] - 1;      // 找比num[i]小一个的值  
                int count = 1;  
                set.remove(num[i]);         // 及时的移除，减少之后的查找时间  
                while(set.contains(next)){  
                    set.remove(next);  
                    next--;  
                    count++;  
                }  
                next = num[i] + 1;      // 找比num[i]大一个的值  
                while(set.contains(next)){  
                    set.remove(next);  
                    next++;  
                    count++;  
                }  
                max = Math.max(max, count);  
            }  
        }
		return max;
    }
}