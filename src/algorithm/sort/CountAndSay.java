package algorithm.sort;

public class CountAndSay {

	 public String countAndSay(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if (n<=1){
	            return String.valueOf(1);
	        }
	        else{
	            
	            return say(countAndSay(n-1));
	        }
	        
	       
	    }
	    private String say(String s){
	        
	        int i=0;
	        int count=1;
	        StringBuffer sb=new StringBuffer();
	        
	        while(i<s.length()){
	            int j=i+1;
	            
	            while(j<s.length()&&s.charAt(j)==s.charAt(i)){
	                count++;
	                j++;
	            }
	            
	            sb.append(count);
	            sb.append(s.charAt(i));
	            
	            i=j;
	            count=1;
	        }
	        return sb.toString();
	        
	    }
	}
