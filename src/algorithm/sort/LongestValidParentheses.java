package algorithm.sort;

import java.util.Stack;

/*�ⷨ��������leetcode�������д������������O(n)�Ľⷨ����¥������������Ū����O(n3)��
 * ¥�������ڸ��Ӱ��Լ����ˣ�����

������ȿ�������ⷨ�����stack�������������������ŵġ��������������ŵ�index������ô��
������Ҳ���ô档����S������'('������lefts���������')'�����lefts�ǿգ�˵������һ���޷�ƥ���')'��
��¼��last��last�����ŵ���ʵ�����һ���޷�ƥ���')'��ΪɶҪ�������ֵ�أ���Ҫ��Ϊ�˼������������
���ʽ�ĳ��ȡ�����������⣺ �������޷�ƥ���')'����index��ʵ���Ǹ���group�ķֽ�㡣*/
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
                    if (lefts.isEmpty()) {//��һ��������valid��group�������group�ĳ���
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        //ջ�ڻ��С�(',һ�������������group��û��ƥ����ɣ�
                        //����ͨ����ѯ��һ������ƥ�仹δƥ���"("��index������maxLen��
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }

/*���룺����һ�������������͡��������ַ������ҳ������Ч����ƥ���Ӵ��ĳ��ȡ�
�ⷨ��
����������һά��̬�滮������⡣�����������ű��ʽΪString s��ά��һ������Ϊs.length��һά����dp[]��
����Ԫ�س�ʼ��Ϊ0�� dp[i]��ʾ��s[i]��s[s.length - 1]�����Чƥ�������Ӵ����ȡ���������¹�ϵ��
dp[s.length - 1] = 0;
��i - 2 -> 0������dp[]������¼�����ֵ����s[i] == '('������s�д�i��ʼ��s.length - 1����s[i]��ֵ��

��������Ϊ������ͨ��dp[i + 1]���еģ�ע��dp[i + 1]�Ѿ�����һ����⣩��
��s��Ѱ�Ҵ�i + 1��ʼ����Ч����ƥ���Ӵ����ȣ���dp[i + 1]�����������Ч�������Ӵ����鿴��һ���ַ���
���±�Ϊj = i + 1 + dp[i + 1]����jû��Խ�磬����s[j] == ��)������s[i ... j]Ϊ��Ч����ƥ�䣬
dp[i] =dp[i + 1] + 2��
�������s[i ... j]����Чƥ�䳤��֮����j + 1û��Խ�磬��dp[i]��ֵ��Ҫ���ϴ�j + 1��ʼ�����Чƥ�䣬
��dp[j + 1]��
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
