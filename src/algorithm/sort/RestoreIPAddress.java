package algorithm.sort;

public class RestoreIPAddress {  
  
/** 
 *  
 * Restore IP Addresses 
 *  
 *  
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations. 
 
For example: 
Given "25525511135", 
 
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 * 
 */  
  
    public static void main(String[] args) {  
        System.out.println(restoreIpAddresses("25525511135"));  
    }  
  
    public static ArrayList<String> restoreIpAddresses(String s) {  
        ArrayList<String> al = new ArrayList<String>();  
        if(s.length() > 12){     // ��ʱ����  
            return al;  
        }  
        StringBuilder sb = new StringBuilder();  
        dfs(s, al, sb, 0);  
        return al;  
    }  
      
    public static boolean isValid(String s){  
        if(s.length()==0 || s.length()>3){  
            return false;  
        }  
        int val = Integer.parseInt(s);  
        if(!String.valueOf(val).equals(s)){     // ��ֹ������00.01.010.0���Ƶ����  
            return false;  
        }  
        if(val<0 || val>255){  
            return false;  
        }  
        return true;  
    }  
      
    public static void dfs(String s, ArrayList<String> al, StringBuilder sb, int level){  
    	 System.out.print("\n");
    	if(level == 3){     // ��3���ر��жϣ�����ȡʣ�µ�ȫ���ַ���  
            System.out.print(s+" "+"\n");
        	if(isValid(s)){  
                sb.append(s);  
            
                al.add(sb.toString());      // ���һ�β���.  
                sb.delete(sb.length()-s.length(), sb.length()); // ��������  
                return;  
            }  
        }  
          
        for(int i=0; i<s.length()-1; i++){  
            String substr = s.substring(0, i+1);  
            if(isValid(substr)){  
                sb.append(substr).append(".");      // ִ�ж���  
                System.out.print("level is  "+ level+"  ");
                System.out.print("sb is "+sb.toString()+"----");
                dfs(s.substring(i+1), al, sb, level+1);       
                sb.delete(sb.length()-1-substr.length(), sb.length());  // ��������  
            }  
        
        }  
       
    }  
}  