package algorithm.sort;

public class WildCardMatching {
//贪心的策略，能匹配就一直往后遍历，匹配不上了就看看前面有没有'*'来救救场，再从'*'后面接着试。
/*这道题目其实是Regular Expression Matching的简化版，在这里'?'相当于那边的'.'，
 * 而'*'相当于那边的'.*'，因为这里'*'就可以代替任何字符串，不需要看前面的字符，所以处理起来更加简单。
brute force的方法就不重新列举代码了，有兴趣实现的朋友可以参考一下Regular Expression Matching，
代码结构一样，只是处理情况变一下就可以，不过leetcode过不了（因为超时）。
我们主要还是说一下动态规划的方法。跟Regular Expression Matching一样，
还是维护一个假设我们维护一个布尔数组res[i],代表s的前i个字符和p的前j个字符是否匹配
(这里因为每次i的结果只依赖于j-1的结果，所以不需要二维数组，只需要一个一维数组来保存上一行结果即可），
递推公式分两种情况：
    (1)p[j]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'?'
    ，也是相同），并且res[i]==true，则更新res[i+1]为true，否则res[i+1]=false;  
    (2)p[j]是'*'。因为'*'可以匹配任意字符串，所以在前面的res[i]只要有true，那么剩下的         
     res[i+1], res[i+2],...,res[s.length()]就都是true了。
算法的时间复杂度因为是两层循环，所以是O(m*n), 而空间复杂度只用一个一维数组，所以是O(n)，
假设s的长度是n，p的长度是m。*/	
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}

}
