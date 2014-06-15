package algorithm.sort;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
	int len = s1.length();
    if(len!=s2.length()){
        return false;
    }
    if(len==0){
        return true;
    }
    
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    
    boolean[][][] result = new boolean[len][len][len];
    //这里我使用了一个三维数组boolean result[len][len][len],其中第一维为子串的长度，
    //第二维为s1的起始索引，第三维为s2的起始索引。
   // result[k][i][j]表示s1[i...i+k]是否可以由s2[j...j+k]变化得来。
    for(int i=0;i<len;++i){
        for(int j=0;j<len;++j){
            result[0][i][j] = (c1[i]==c2[j]);
        }
    }
    
    for(int k=2;k<=len;++k){
        for(int i=len-k;i>=0;--i){
          for(int j=len-k;j>=0;--j){
              boolean r = false;
              for(int m=1;m<k && !r;++m){
                  r = (result[m-1][i][j] && result[k-m-1][i+m][j+m]) || (result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
              }
              result[k-1][i][j] = r;
          }
        }
    }
    
    return result[len-1][0][0];
}
}
