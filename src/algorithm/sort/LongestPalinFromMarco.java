package algorithm.sort;


	public String longestPalindrome(String s) {
		        // IMPORTANT: Please reset any member data you declared, as
		        // the same Solution instance will be reused for each test case.
		           int len = s.length();
		   int longestBegin = 0;
		   int maxlen =  1;
		   boolean table [][] = new boolean[1000][1000];
		   
		   for(int i = 0 ; i < len ; i++){
		  table[i][i] = true;
		   }
		       
		   for(int i = 0 ; i < len-1 ; i++){
		   if(s.charAt(i)==s.charAt(i+1)){
		table[i][i+1] = true;
		maxlen = 2 ;
		longestBegin = i;
		} 
		       }
	
		  
		   for(int i = 3 ; i <= len ; i++){
		   for(int j = 0 ; j < len - i +1 ; j++){
		   int k = i+j -1;
		   if(s.charAt(j) == s.charAt(k)&&table[j+1][k-1]){
		   table[j][k] = true;
		   longestBegin = j;
		   maxlen = i;
		   
		   }
		   
		   }
		   
		}

		  
		   return s.substring(longestBegin, maxlen+longestBegin);
		    }
	}
