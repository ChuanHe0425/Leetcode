package algorithm.sort;
/*First, need to understand the problem correctly,
 *  the pointer simply means a sub string.
Second, make sure the loop does not exceed the boundaries
 of two strings.
这是算法中比较经典的问题，判断一个字符串是否是另一个字符串的子串。
这个题目最经典的算法应该是KMP算法，不熟悉的朋友可以参见Knuth–Morris–Pratt algorithm。
KMP算法是最优的线性算法，复杂度已经达到这个问题的下限。但是KMP算法比较复杂，
很难在面试的短时间里面完整正确的实现。所以一般在面试中并不要求实现KMP算法。
下面我们先说说brute force的算法，假设原串的长度是n，匹配串的长度是m。思路很简单，
就是对原串的每一个长度为m的字串都判断是否跟匹配串一致。总共有n-m+1个子串，
所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)。
*/
public class ImplementStrstr {

	public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert(haystack!=null && needle!=null);
        if(needle.length()==0) return haystack;
        
        int i=0;
        while(i<haystack.length()){
            if(haystack.length()-i<needle.length()) 
                break;
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=i;
                while(j-i<needle.length() && haystack.charAt(j)==needle.charAt(j-i))
                    j++;
                if(j-i==needle.length()) 
                    return haystack.substring(i);
            }
            i++;
        }
        return null;
    }
}