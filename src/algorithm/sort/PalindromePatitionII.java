package algorithm.sort;

public class PalindromePatitionII {

	import java.util.ArrayList;
	import java.util.Hashtable;

	/**
	Palindrome Partitioning II 

	Given a string s, partition s such that every substring of the partition is a palindrome.

	Return the minimum cuts needed for a palindrome partitioning of s.

	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 */
	
		public static void main(String args[]) {
			System.out.println(minCut("a"));
		}
		
		// ����DP http://blog.csdn.net/fightforyourdream/article/details/17730939
		public static int minCut(String s) {
			int len = s.length();
			
			// minCuts[i]: s[0,i]��С��Ҫ���и�������ʹÿ���Ӷζ��ǻ���
			int[] minCuts = new int[len];
			
			//isPld[i][j]:true ���ҽ����Ӵ�s[i...j]�ǻ���ʱ
			boolean[][] isPld = new boolean[len][len];

			// ����isPld[][] 
			// isPld[i][j] = true if s[i]==s[j] and (isPld[i+1][j-1]==true or j-i<2 )  j-i<2: ��ֻ��1λ�ַ���ʱ�϶��ǻ���
			// ���ݵ��ƹ�ϵ,Ҫ�������������Ƶ�
			for(int i=len-1; i>=0; i--){	// �������� i����ʼ�±�
				for(int j=0; j<len; j++){	// �������� j����β�±�
					// �ǻ��� ���ҽ��� ͷβ�ַ���ͬ�����м�Ҳ�ǻ���
					if((s.charAt(i)==s.charAt(j)) && (j-i<2 || isPld[i+1][j-1])){
						isPld[i][j] = true;
					}else{
						isPld[i][j] = false;
					}
				}
			}
			
			// ����minCuts[]
			for(int i=0; i<len; i++){	// ����Ϊi���ִ�s[0,i]
				int mc = len;
				if(isPld[0][i]){		// ������ǻ��ģ���������и�
					minCuts[i] = 0;
				}else{
					for(int j=0; j<i; j++){	// �����иs[0,1]+s[2,i]; s[0,2]+s[3,i]; s[0,3]+s[4,i] ... s[0,i-1]+s[i,i]
						if(isPld[j+1][i]){	// ��������ǻ���
							mc = Math.min(mc, minCuts[j] + 1);
						}
					}
					minCuts[i] = mc;
				}
			}
			return minCuts[len-1];
		}
		
		
		
		// TLE ����DFS
		public static int minCut2(String s) {
			ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
			ArrayList<String> al = new ArrayList<String>();
			Hashtable<String, Boolean> ht = new Hashtable<String, Boolean>();
			int[] min = {Integer.MAX_VALUE};
			dfs(s, 0, ht, ret, al, 0, min);
			return min[0];
	    }
		
		public static void dfs(String s, int start, Hashtable<String, Boolean> ht, ArrayList<ArrayList<String>> ret, ArrayList<String> al, int cnt, int[] min){
			if(start == s.length()){
				ret.add(new ArrayList<String>(al));
				min[0] = Math.min(min[0], cnt-1);
				return;
			}
			
			for(int i=start; i<s.length(); i++){
				boolean isPalindrome = false;
				String substr = s.substring(start, i+1);
				if(ht.get(substr) != null){
					isPalindrome = ht.get(substr);
				}else{
					isPalindrome = checkPalindrome(substr);
					ht.put(substr, isPalindrome);
				}
				if(isPalindrome){
					al.add(substr);
					dfs(s, i+1, ht, ret, al, cnt+1, min);
					al.remove(al.size()-1);
				}
			}
		}

		public static boolean checkPalindrome(String s){
			if(s.length() == 0){
				return true;
			}
			for(int i=0; i<=s.length()/2; i++){
				if(s.charAt(i) != s.charAt(s.length()-1-i)){
					return false;
				}
			}
			return true;
		}
		
	}


