package algorithm.sort;
import java.util.HashMap;
public class MinimumWindowSubstring {
/*这道题是字符串处理的题目，和Substring with Concatenation of All Words思路非常类似，
 * 同样是建立一个字典，然后维护一个窗口。区别是在这道题目中，因为可以跳过没在字典里面的字符
 * （也就是这个串不需要包含且仅仅包含字典里面的字符，有一些不在字典的仍然可以满足要求），
 * 所以遇到没在字典里面的字符可以继续移动窗口右端，而移动窗口左端的条件是当找到满足条件的串之后，
 * 一直移动窗口左端直到有字典里的字符不再在窗口里。在实现中就是维护一个HashMap，
 * 一开始key包含字典中所有字符，value就是该字符的数量，然后遇到字典中字符时就将对应字符的数量减一。
 * 算法的时间复杂度是O(n),其中n是字符串的长度，因为每个字符再维护窗口的过程中不会被访问多于两次。
 * 空间复杂度则是O(字典的大小)，也就是代码中T的长度。代码如下：*/	
	    public String minWindow(String S, String T) {
	     
	    if(S == null || T == null || S.length()==0 || T.length()==0)
	        return "";
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0;i<T.length();i++)
	    {
	        if(map.containsKey(T.charAt(i)))
	        {
	            map.put(T.charAt(i), map.get(T.charAt(i))+1);
	        }
	        else
	            map.put(T.charAt(i), 1);
	    }
	    int count = 0;
	    int pre = 0;
	    String res = "";
	    int minLen = S.length()+1;
	    for(int i=0;i<S.length();i++)
	    {
	        if(map.containsKey(S.charAt(i)))
	        {
	            map.put(S.charAt(i),map.get(S.charAt(i))-1);
	            if(map.get(S.charAt(i))>=0)
	                count++;
	            while(count == T.length())
	            {
	                if(map.containsKey(S.charAt(pre)))
	                {
	                    map.put(S.charAt(pre),map.get(S.charAt(pre))+1);
	                    if(map.get(S.charAt(pre))>0)
	                    {
	                        if(minLen>i-pre+1)
	                        {
	                            res = S.substring(pre,i+1);
	                            minLen = i-pre+1;
	                        }
	                        count--;
	                    }
	                }
	                pre++;
	            }
	        }
	    }
	    return res;
	}  
	    }


