package algorithm.sort;

public class ZigzagConversation {
/*原题链接: http://oj.leetcode.com/problems/zigzag-conversion/ 
这道题是cc150里面的题目了，其实比较简单，只要看出来他其实每个zigzag是2*m-1个字符，
这里m是结果的行的数量。接下来就是对于每一行先把往下走的那一列的字符加进去，
然后有往上走的字符再加进去即可。时间复杂度是O(n),空间复杂度是O(1),代码如下： 
 *
 */
	
	    public String convert(String s, int nRows) {
	        
	    if(s == null || s.length()==0 || nRows <=0)  
	        return "";  
	    if(nRows == 1)  
	        return s;  
	    StringBuilder res = new StringBuilder();  
	    int size = 2*nRows-2;  
	    for(int i=0;i<nRows;i++)  
	    {  
	        for(int j=i;j<s.length();j+=size)  
	        {  
	            res.append(s.charAt(j));  
	            if(i!=0 && i!=nRows-1 && j+size-2*i<s.length())  
	                res.append(s.charAt(j+size-2*i));  
	        }                  
	    }  
	    return res.toString();  
	}
	}