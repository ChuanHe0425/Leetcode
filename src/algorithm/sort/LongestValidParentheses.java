package algorithm.sort;

import java.util.Stack;

/*解法二：来自leetcode讨论组的写法。本来人有O(n)的解法，被楼主活生生地卖弄成了O(n3)。
 * 楼主真想挖个坑把自己埋了！！！

大家首先看，这个解法里面的stack，不是用来存左右括号的。人是来存左括号的index。本来么，
右括号也不用存。遍历S。遇到'('，放入lefts。如果遇到')'，如果lefts是空，说明这是一个无法匹配的')'，
记录下last。last里面存放的其实是最后一个无法匹配的')'。为啥要保存这个值呢？主要是为了计算后面完整的
表达式的长度。可以这样理解： “所有无法匹配的')'”的index其实都是各个group的分界点。*/
public class LongestValidParentheses {
	public static int longestValidParentheses2(String s) {
        int maxLen = 0, last = -1;
        Stack<Integer> lefts = new Stack<Integer>();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i)=='(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.isEmpty()) {//有一个完整的valid的group。计算该group的长度
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        //栈内还有‘(',一个最外层完整的group还没有匹配完成，
                        //但是通过查询下一个即将匹配还未匹配的"("的index来更新maxLen。
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }

/*翻译：给定一个包含‘（’和‘）’的字符串，找出最长的有效括号匹配子串的长度。
解法：
这道题可以用一维动态规划逆向求解。假设输入括号表达式为String s，维护一个长度为s.length的一维数组dp[]，
数组元素初始化为0。 dp[i]表示从s[i]到s[s.length - 1]最长的有效匹配括号子串长度。则存在如下关系：
dp[s.length - 1] = 0;
从i - 2 -> 0逆向求dp[]，并记录其最大值。若s[i] == '('，则在s中从i开始到s.length - 1计算s[i]的值。

这个计算分为两步，通过dp[i + 1]进行的（注意dp[i + 1]已经在上一步求解）：
在s中寻找从i + 1开始的有效括号匹配子串长度，即dp[i + 1]，跳过这段有效的括号子串，查看下一个字符，
其下标为j = i + 1 + dp[i + 1]。若j没有越界，并且s[j] == ‘)’，则s[i ... j]为有效括号匹配，
dp[i] =dp[i + 1] + 2。
在求得了s[i ... j]的有效匹配长度之后，若j + 1没有越界，则dp[i]的值还要加上从j + 1开始的最长有效匹配，
即dp[j + 1]。
*/

	  public int longestValidParentheses(String s) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    int n = s.length();
	    int[] dp = new int[n];
	    java.util.Arrays.fill(dp, 0);
	    int max = 0;
	    for (int i = n - 2; i >= 0; i--) {
	      if (s.charAt(i) == '(') {
	        int j = i + 1 + dp[i + 1];
	        if (j < n && s.charAt(j) == ')') {
	          dp[i] = dp[i + 1] + 2;
	          int k = 0;
	          if (j + 1 < n) {
	            k = dp[j + 1];
	          }
	          dp[i] += k;
	        }
	        max = Math.max(max, dp[i]);
	      }
	    }
	    return max;
	  }
	}
