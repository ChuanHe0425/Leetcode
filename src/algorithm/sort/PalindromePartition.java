package algorithm.sort;
import java.util.Arraylist;
public class PalindromePartition {

	/*Given a string s, partition s such that every substring of the partition is a palindrome.

	Return all possible palindrome partitioning of s.

	For example, given s = "aab",
	Return

	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]

		    public ArrayList<ArrayList<String>> partition(String s) {
	        

	          // Start typing your Java solution below
	          // DO NOT write main() function
	          ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	          ArrayList<String> output = new ArrayList<String>();
	          int depth = 0, len = s.length();
	          
	          palinPartition(s, 0, len, output, result);
	         return result;
	     }
	     
	     public void palinPartition(String s, int start, int len, ArrayList<String> output,
	                             ArrayList<ArrayList<String>> result){
	         if(start == len){
	             ArrayList<String> tmp = new ArrayList<String>();
	             tmp.add(output);
	             result.add(tmp);
	            return;
	         }
	            for(int i = start; i < len; i++){
	             if(isPalindrome(s, start, i)){
	                 output.add(s.substring(start, i + 1));
	                 palinPartition(s, i + 1, len, output, result);
	                 output.remove(output.size() - 1);
	             }
	         }
	         
	     }
	     
	     public boolean isPalindrome(String s, int start, int end){
	        while(start < end){
	            if(s.charAt(start) != s.charAt(end)){
	                 return false;
	             }
	             start ++;
	             end --;
	         }
	         return true;
	     }
	 }*/
	
	import java.util.ArrayList;


	public static void main(String args[]){

	String s = "aab";

	System.out.print("We get final result "+partition(s));


	}



	   public static ArrayList<ArrayList<String>> partition(String s) {

	       



	          // Start typing your Java solution below

	          // DO NOT write main() function

	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	          ArrayList<String> output = new ArrayList<String>();

	          int depth = 0, len = s.length();

	         

	          palinPartition(s, 0, len, output, result);

	        return result;

	    }

	     

	    public static void palinPartition(String s, int start, int len, ArrayList<String> output,ArrayList<ArrayList<String>> result){

	       

	                if(start == len){

	            System.out.print("get result yo!!");

	                 ArrayList<String> tmp = new ArrayList<String>();

	            tmp.addAll(output);

	            System.out.print("output "+output);

	            result.add(tmp);

	            System.out.print("result "+ result + "\n");

	            return;

	        }

	            for(int i = start; i < len; i++){

	            if(isPalindrome(s, start, i)){

	           	 System.out.print(" now i is "+i+" " );

	           	 output.add(s.substring(start, i + 1));

	                System.out.print("output add "+s.substring(start, i + 1)+" "+ "\n");

	                palinPartition(s, i + 1, len, output, result);

	                output.remove(output.size() - 1);

	                System.out.print("output after remove: "+ output + "\n");// this is for remove content in array list after get a result!!!

	            }

	        }

	         

	    }

	     

	    public static boolean isPalindrome(String s, int start, int end){

	        while(start < end){

	            if(s.charAt(start) != s.charAt(end)){

	                return false;

	            }

	            start ++;

	            end --;

	        }

	        return true;

	    }

	}
