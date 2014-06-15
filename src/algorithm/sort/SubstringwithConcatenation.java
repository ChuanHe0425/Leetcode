package algorithm.sort;
import java.util.ArrayList;
import java.util.HashMap;
/*这道题看似比较复杂，其实思路和Longest Substring Without Repeating Characters差不多。
 * 因为那些单词是定长的，所以本质上和单一个字符一样。和Longest Substring Without Repeating Characters
 * 的区别只在于我们需要维护一个字典，然后保证目前的串包含字典里面的单词有且仅有一次。
 * 思路仍然是维护一个窗口，如果当前单词在字典中，则继续移动窗口右端，否则窗口左端可以跳到字符串
 * 下一个单词了。假设源字符串的长度为n，字典中单词的长度为l。因为不是一个字符，
 * 所以我们需要对源字符串所有长度为l的子串进行判断。做法是i从0到l-1个字符开始，
 * 得到开始index分别为i, i+l, i+2*l, ...的长度为l的单词。这样就可以保证判断到所有的满足条件的串。
 * 因为每次扫描的时间复杂度是O(2*n/l)(每个单词不会被访问多于两次，一次是窗口右端，一次是窗口左端)，
 * 总共扫描l次（i=0, ..., l-1)，所以总复杂度是O(2*n/l*l)=O(n)，是一个线性算法。
 * 空间复杂度是字典的大小，即O(m*l)，其中m是字典的单词数量。代码如下：*/
//这种移动窗口的方法在字符串处理的问题中非常常见，是一种可以把时间复杂度降低到线性的有效算法，大家可以熟悉一下。
//还有非常类似的题目Minimum Window Substring，思路完全一样，只是移动窗口的规则稍微不同而已。
public class SubstringwithConcatenation {

	
	    public ArrayList<Integer> findSubstring(String S, String[] L) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(S==null || S.length()==0 || L==null || L.length==0)
	        return res;
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    for(int i=0;i<L.length;i++)
	    {
	        if(map.containsKey(L[i]))
	        {
	            map.put(L[i],map.get(L[i])+1);
	        }
	        else
	        {
	            map.put(L[i],1);
	        }
	    }
	    for(int i=0;i<L[0].length();i++)
	    {
	        HashMap<String,Integer> curMap = new HashMap<String,Integer>();
	        int count = 0;
	        int left = i;
	        for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())
	        {
	            String str = S.substring(j,j+L[0].length());
	            
	            if(map.containsKey(str))
	            {
	                if(curMap.containsKey(str))
	                    curMap.put(str,curMap.get(str)+1);
	                else
	                    curMap.put(str,1);
	                if(curMap.get(str)<=map.get(str))
	                    count++;
	                else
	                {
	                    while(curMap.get(str)>map.get(str))
	                    {
	                        String temp = S.substring(left,left+L[0].length());
	                        curMap.put(temp,curMap.get(temp)-1);
	                        if(curMap.get(temp)<map.get(temp))
	                            count--;
	                        left += L[0].length();
	                    }
	                }
	                if(count == L.length)
	                {
	                    res.add(left);
	                    //if(left<)
	                    String temp = S.substring(left,left+L[0].length());
	                    curMap.put(temp,curMap.get(temp)-1);
	                    count--;
	                    left += L[0].length();
	                }
	            }
	            else
	            {
	                curMap.clear();
	                count = 0;
	                left = j+L[0].length();
	            }
	        }
	    }
	    return res;
	}  
	    }
