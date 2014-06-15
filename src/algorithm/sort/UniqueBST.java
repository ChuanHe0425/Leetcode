package algorithm.sort;

public class UniqueBST{
/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 
For example,
Given n = 3, there are a total of 5 unique BST's.
 
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */
	public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

//=========================================================================
public int numTrees2(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    int[] dp = new int[n + 1];
    return count(n, dp);
}

private int count(int n, int[] dp){
    if(n == 0) return 1;
    if(dp[n] != 0) return dp[n];
    int sum = 0;
    for(int i = 0; i <= n - 1; i++)
        sum += count(i, dp) * count(n - 1 - i, dp);
    dp[n] = sum;
    return sum;
}
}
