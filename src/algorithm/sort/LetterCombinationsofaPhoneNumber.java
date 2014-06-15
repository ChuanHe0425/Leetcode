package algorithm.sort;
import java.util.ArrayList;
/*Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class LetterCombinationsofaPhoneNumber {
	
	    public ArrayList<String> letterCombinations(String digits) {
	     ArrayList<String> res = new ArrayList<String> ();
	        res.add("");
	        if(digits==null) return res;
	        String[] table = digitToString();
	        for(int i=0;i<digits.length();i++){
	            ArrayList<String> cur = new ArrayList<String>();
	            char c = digits.charAt(i);
	            if(c>='2' && c<='9'){
	                for(String temp:res){
	                    for(int j=0;j<table[c-'2'].length();j++){
	                        cur.add(temp + table[c-'2'].charAt(j));
	                    }
	                }
	            }
	            res= new ArrayList<String>(cur);
	        }
	        return res;    
	    }
	    public String[] digitToString(){
	      String[] res = new String[8];
	      char start = 'a';
	      
	      for(int i=0;i<8;i++){
	        int count = (i==5||i==7)?4:3;
	        StringBuilder temp = new StringBuilder("");
	        for(int j=0;j<count;j++){
	            temp.append((char)(start+j));
	        }
	        start=(char)(start+count);
	        res[i] = temp.toString(); 
	      }
	      return res;
	    }
	    /*还是最基本的DFS，但是有一点需要注意，输入有可能为""，这个比较变态，感觉这个不应该是考点之一。
        将数字和字符的对应关系组成了一个数组
        String array[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        这样处理起来相对要方便些。特别要注意digits中为数字的再转换，否则的话继续。
*/
	    
	        public String array[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        public ArrayList<String> letterCombinationsB(String digits) {
	            ArrayList<String> list = new ArrayList<String>();
	            if(digits == null){
	                return list;
	            }
	            char numArr[] = digits.toCharArray();
	            int len = digits.length();
	            StringBuffer sb = new StringBuffer();
	            dfs(list,sb,0,numArr,len);
	            return list;
	        }
	        public void dfs(ArrayList<String> list,StringBuffer sb,
	                    int tempLen,char numArr[],int len){
	            if(tempLen == len){
	                list.add(sb.toString());
	                return;
	            }
	            if(numArr[tempLen] >= '0' && numArr[tempLen] <= '9' ){
	                String tempStr = array[numArr[tempLen] - '0'];
	                int strLen = tempStr.length();
	                for(int i = 0; i < strLen; i++){
	                    StringBuffer newsb = new StringBuffer(sb);
	                    newsb.append(String.valueOf(tempStr.charAt(i)));
	                    dfs(list,newsb,tempLen+1,numArr,len);
	                }
	            }else{
	                StringBuffer newsb = new StringBuffer(sb);
	                newsb.append(String.valueOf(numArr[tempLen]));
	                dfs(list,newsb,tempLen+1,numArr,len);   
	            }
	        }
	    }
	
	    
	    

