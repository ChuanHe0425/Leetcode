package algorithm.sort;

public class PalindromePatitionB {

	
	import java.util.ArrayList;
	import java.util.Hashtable;

	/**
	 *  Palindrome Partitioning
	 *  
	 *  Given a string s, partition s such that every substring of the partition is a palindrome.

	Return all possible palindrome partitioning of s.

	For example, given s = "aab",
	Return

	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
	 *
	 */
	
		public static void main(String[] args) {
			String s = "aab";
			System.out.println(partition(s));
		}
		
		public static ArrayList<ArrayList<String>> partition(String s) {
			ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
			ArrayList<String> al = new ArrayList<String>();
			Hashtable<String, Boolean> ht = new Hashtable<String, Boolean>();
			dfs(s, 0, ht, ret, al);
			return ret;
	    }
		
		public static void dfs(String s, int start, Hashtable<String, Boolean> ht, ArrayList<ArrayList<String>> ret, ArrayList<String> al){
			if(start == s.length()){			// 返回条件
				ret.add(new ArrayList<String>(al));
				return;
			}
			
			for(int i=start; i<s.length(); i++){				// 拓展状态
				boolean isPalindrome = false;
				String substr = s.substring(start, i+1);		// 子字符串
				if(ht.get(substr) != null){				// 先尝试在hashtable中查找，避免重复查找
					isPalindrome = ht.get(substr);
				}else{										// 判断是否palindrome，放入ht
					isPalindrome = checkPalindrome(substr);
					ht.put(substr, isPalindrome);
				}
				if(isPalindrome){		
					al.add(substr);				// 执行拓展动作
					dfs(s, i+1, ht, ret, al);
					al.remove(al.size()-1);	// 撤销动作
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
}
