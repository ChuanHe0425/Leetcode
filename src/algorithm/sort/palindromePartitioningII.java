package algorithm.sort;
/*题意分析：对输入的字符串进行划分，要求划分后的所有的子字符串都是回文串。求最小划分的个数。
类似于：LeetCode Word Break， 也是利用动态规划。
定义状态数组：cut_num_array[s.length()+1]，其中：cut_num_array[i]代表：string[i..n]字符串从i开始到末尾的最小划分数。 
状态转移方程： cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);  i<j<n
状态转移方程的意思是，string[i..j]是一个回文字符串，所以不用再划分。所以从i开始到末尾以j为划分点的最小划分数为： cut_num_array[j+1]+1 和 cut_num_array[i]中的最小值。
cut_num_array[i]的初值设为：s.length() - i; 也就是按照字符串中的每个字母都单独被划分来计算。
判断string[i..j]是一个回文串，用LeetCode Palindrome Partitioning中的方法，上AC代码。
*/
public class palindromePartitioningII {
	public int minCut(String s) {
	     
        if(s==null||s.length()==0||s.length()==1) {
            return 0;
        }
        int[][] palindrome_map = new int[s.length()][s.length()];
        int[] cut_num_array = new int[s.length() + 1];
        
        for(int i=s.length()-1;i>=0;i--) {
            cut_num_array[i] = s.length() - i;
            for(int j=i;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<2||palindrome_map[i+1][j-1]==1) {
                        palindrome_map[i][j]=1;
                        cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);
                    }
                }
            }
            
        }
    
        return cut_num_array[0] - 1;
    }

}
