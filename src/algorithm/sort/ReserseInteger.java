package algorithm.sort;

public class ReserseInteger {

	    public static int reverse(int x) {
	            /*
	             if(x == 0) {
	             return x;
	             }
	            int temp = 0;
	             if(x >0){
	            	 {
	             
	                 int digit = x%10;
	                
	                 temp = temp*10 +digit;
	                 x = x/10;
	             }
	             return temp;
	             }
	    
	    if(x<0) {
	    	int temp1 = 0;
	        {
	        x=-x;
	        int digit1 = x%10;
	        
	        temp1 = temp1*10 +digit1;

	        x = x/10;
	    }
	      x=-x;
	      return temp1;
	             
	    
	    }
				return x;
	}
	
	*/
	    	
	            int afterNum = 0,temp = 0;
	            while( x !=0){
	                
	                temp = x%10;
	                afterNum = afterNum *10 + temp;
	                x = x/10;
	            }
	                return afterNum;
	    	} 
	    public static void main(String[] args) {
	int x = -1234;
	System.out.println(reverse(x) );
}
}



