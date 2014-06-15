package algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {  
        int[] num = {0,0};  
        System.out.println(longestConsecutive(num));  
    }  
  
    // ��������������Ҫ���Ӷ�O(n)��������⣬ֻ�����ӿռ临�Ӷȣ���hashset����hashtable  
    public static int longestConsecutive(int[] num) {  
        Set<Integer> set = new HashSet<Integer>();  
          
        for (int i : num) {  
            set.add(i);  
        }  
        int max = 0;  
          
        for(int i=0; i<num.length; i++){  
            if(set.contains(num[i])){  
                int next = num[i] - 1;      // �ұ�num[i]Сһ����ֵ  
                int count = 1;  
                set.remove(num[i]);         // ��ʱ���Ƴ�������֮��Ĳ���ʱ��  
                while(set.contains(next)){  
                    set.remove(next);  
                    next--;  
                    count++;  
                }  
                next = num[i] + 1;      // �ұ�num[i]��һ����ֵ  
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