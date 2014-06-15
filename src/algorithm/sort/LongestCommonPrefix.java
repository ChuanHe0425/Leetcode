package algorithm.sort;

public class LongestCommonPrefix {
	
	    public String longestCommonPrefix(String[] strs) {
	        String prefix = new String();
	        if(strs.length > 0)
	            prefix = strs[0];
	        for(int i = 1; i < strs.length; ++i) {
	            String s = strs[i];
	            int j = 0;
	            for(j=0;j < Math.min(prefix.length(), s.length()); ++j) {
	                if(prefix.charAt(j) != s.charAt(j)) {
	                    break;
	                }
	            }
	            prefix = prefix.substring(0, j);
	        }
	        return prefix;
	    }
	//======================================
	    public String longestCommonPrefixB(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = strs.length;
        if(n==0) return "";
        int i=0;
        for(i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,i);
    }

	    
}

