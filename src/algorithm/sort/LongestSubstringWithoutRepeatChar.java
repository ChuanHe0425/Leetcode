package algorithm.sort;

public class LongestSubstringWithoutRepeatChar {

	
	    public int lengthOfLongestSubstring(String s) {
	     boolean[] flag = new boolean[256]; 
	     
	 
		int result = 0;
		int j = 0;
		
		char[] arr = s.toCharArray();
	 
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (flag[c]) {
				result = Math.max(result, i - j);
				for (int k = j; k < i; k++) {
					if (arr[k] == c) {
						j = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}	
			} else {
				flag[c] = true;
			}
		}
	 
		result=Math.max(arr.length-j,result);
	 
		return result;
	}
	   //======================================================
	  //http://rleetcode.blogspot.com/2014/01/longest-substring-without-repeating.html
	    public class LongestSuStringWithoutRepeatCharacter {
	        public int lengthOfLongestSubstring(String s) {
	            if (s==null ||s.length()==0){
	                return 0;
	            }
	            
	            // record which char has been visited
	            boolean [] checker=new boolean[256];
	            
	            // two pointers used to maintain longest distance without repeat
	            int st=0;
	            int ed=0;
	            // max length
	            int max=0;
	            
	            while(ed<s.length()){
	                char c=s.charAt(ed);
	                
	                // no repeat, up date checker and max length
	                if (!checker[c]){
	                    checker[c]=true;
	                    max=Math.max(ed-st+1,max);
	                }
	                else{
	                    // repeat happened, update checker, and make st pointer point to first unrepeat position
	                    
	                    while (s.charAt(st)!=c){
	                        checker[s.charAt(st)]=false;
	                        st++;
	                    }
	                    
	                    // skip the char cause repeat
	                    st++;
	                }
	                
	                ed++;
	            }
	            
	            return max;
	            
	        }
	    }
	    }
