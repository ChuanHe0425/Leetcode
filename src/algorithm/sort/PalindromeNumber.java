package algorithm.sort;

public class PalindromeNumber {
	 public static boolean isPalindrome(int x) {
		  int latter = 0,former = x;
		  if(x ==0 ) return true;
		  if (x<0)  return false;
          while( x !=0){
              
          
              latter = latter *10 + former%10;
              x = x/10;
          }
              if( former == latter){
            	  return true;
  	} 
              else return false;
              
	 }
              
  public static void main(String[] args) {
int x = 123321;
System.out.println(isPalindrome(x) );
  	}
	}
	   

