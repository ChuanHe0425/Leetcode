package algorithm.sort;

public class DecodeWord {

/**
 * LeetCode
 * Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
 
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 
The number of ways decoding "12" is 2.
 
 * solution by zingshow on June 27, 2013
 * two algorithms to solve this problem
 * 1. graph + depth-first search (DFS) + recursion
 * 2. dynamic programming (DP) (current code). it is very similar to "Climbing 
 * Stairs" question. Find the solution to sub-problem first and grow sub-problem.
 * 
 * algorithm 2:
 * 1) find the number of ways to decode the first char: 1 if the first char 
 * (char 1) is between "1" and "9", 0 if else (and return 0). 
 * we can assume a virtual char (char 0)
 * is before the first char and the number of ways to decode it is 1.
 * 2) decode the string until second char (char 2) 
 * and the rest with four situations: 
 * 
 * a) if char n is ("1" to "9") and char n-1 + char n is ("10" to "26"), 
 * the number of ways to decode 
 * the string until char n is the sum of the number of ways of 
 * decoding the string until char n-1 and decoding the string until char n-2: 
 * for string until char 2, it is number of ways for char 0 
 * plus number of ways for char 1;
 * 
 * b) if char n is ("1" to "9") but char n-1 + char n is not ("10" to "26"), 
 * the number of ways to decode the string until char n
 * is equal to the number of ways to decode the string until char n-1:
 * for string until char 2, it is equal to the number of ways for char 1;
 * 
 * c) if char n is not ("1" to "9") but char n-1 + char n is ("10" to "26"), 
 * the number of ways to decode the string until char n
 * is equal to the number of ways to decode the string until char n-2:
 * for string until char 2, it is equal to number of ways for char 0;
 * 
 * d) if neither char n is ("1" to "9") nor char n-1 + char n is ("10" to "26"), 
 * the number of ways to decode the string until char n is zero and zero can 
 * be returned immediately
 * 
 * comments: DP has less time and space complexity O(1).
 * 
 */
 
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.equals("")) return 0;
        char[] cc = s.toCharArray(); //conver to char array
        int n = s.length(); //number of chars
        int numEn[] = new int[n+1];
        numEn[0] = 1;
        if (cc[0] >= '1' && cc[0] <= '9') numEn[1] = 1;
        else return 0;
         
        for (int i = 1; i < n; i ++) {
            if (cc[i] >= '1' && cc[i] <= '9') {
                if (s.substring(i-1,i+1).compareTo("10") >= 0
                        && s.substring(i-1,i+1).compareTo("26") <= 0) {
                    numEn[i+1] = numEn[i] + numEn[i-1];
                } else {
                    numEn[i+1] = numEn[i];
                }
            } else {
                if (s.substring(i-1,i+1).compareTo("10") >= 0
                        && s.substring(i-1,i+1).compareTo("26") <= 0) {
                    numEn[i+1] = numEn[i-1];
                } else {
                    return 0;
                }
            }
        }
         
        return numEn[n];
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DecodeWord x = new DecodeWord();
        System.out.println(x.numDecodings("26"));
        System.out.println(x.numDecodings("226"));
        System.out.println(x.numDecodings("1203040"));
        System.out.println(x.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
         
    }
 
}
//==========================================
/*1.为了避免麻烦，开数组时可以开大一些，如int[] ways = new int[len+10];
2. 这道题实际上是和计算要几步走完台阶的那道题本质是一样的。同样要用动态规划
3. 在拆分时，之前我一直在纠结如何处理0的为题，特别是对于输入是01,101，1001这样的数。后来才发现可以用10来判断，而不用对0去判断！
具体过程:
要求当前的index为i位置的decode ways，f[i+1]: 
每次对于当前的字符判断是否属于1-9（0肯定不行，因为0不在1-26中），如果属于，那么当前的字符可以被decode，并且和f[i]组合，f[i+1] += f[i]
然后对于当前字符和前一个字符组成的字符串判断是否属于10-26，如果属于，那么这两个字符可以被decode，并且和f[i-1]组合，f[i+1] += f[i-1]

*/

public static void main(String[] args) {
	String s = "123";
	System.out.println(numDecodings(s));
	}

	public static int numDecodings(String s) {
		int len = s.length();
		if(len == 0){		// 长度为0
			return 0;
		}
		
		int[] ways = new int[len+10];	
		// 技巧：适当开大一些，这样可以免去一些特殊情况的麻烦！
		ways[0] = 1;			
		// 为了两位数时的情况：ways[2-2] = ways[0]
		ways[1] = s.charAt(0)!='0' ? 1 : 0;	// 在s，index为0的位置
		for(int i=1; i<len; i++){		// 从string的第二位(index=1)开始计算
			int parsed = Integer.parseInt(s.substring(i, i+1));
			if(parsed>=1 && parsed<=9){		// 就当前字符必须满足1-9
				ways[i+1] += ways[i];
			}
			parsed = Integer.parseInt(s.substring(i-1, i+1));
			if(parsed>=10 && parsed<=26){	// 对于当前字符和前一个字符组成的字符串判断是否属于10-26
				ways[i+1] += ways[i-1];
}
		}
		return ways[len];
}

}
