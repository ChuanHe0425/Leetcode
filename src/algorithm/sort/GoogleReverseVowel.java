package algorithm.sort;
import java.util.HashMap;
public class GoogleReverseVowel {
	public static String reverseVowel(String s){
		
			// first we have to check if  the charactor is a  vowel WE CAN use hashmap
			HashMap<Character , Boolean>  h = new HashMap<Character , Boolean>();
			h.put('a' , true);
			h.put('e' , true);
			h.put('i' , true);
			h.put('o' , true);
			h.put('u' ,  true);
			char[] res = s.toCharArray();
			int start = 0 ;
			int end = s.length() - 1;




			while(start<=end){
			if(h.containsKey(res[start])&&h.containsKey(res[end])){
			char temp = res[end];
			res[end] = res[start];
			res[start] = temp;
			start++;
			end--;
			}else if((!h.containsKey(res[start]))&&(h.containsKey(res[end]))){
				start++;
			}else if(h.containsKey(res[start])&&!h.containsKey(res[end])){
			end--;
			}else{
			start++;
			end--;
			}
			
			}
			String a = String.valueOf(res); 

			return a;
		}

			public static void main(String[] args){
		String s = "aeiou";
		System.out.println(reverseVowel(s));
	}
	}
