package algorithm.sort;

import java.util.ArrayList;

public class GenerateParentheses{

	 
	  
	/** 
	 * Generate Parentheses 
	 *  
	 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
	 
	For example, given n = 3, a solution set is: 
	 
	"((()))", "(()())", "(())()", "()(())", "()()()" 
	 * 
	 */  
	
	
	    public static void main(String args[]) {  
	        System.out.println(generateParenthesis(3));  
	    }  
	      
	    public static ArrayList<String> generateParenthesis(int n) {  
	        ArrayList<String> list = new ArrayList<String>();  
	        rec(n, 0, 0, "", list);  
	        return list;  
	    }  
	      
	    public static void rec(int n, int left, int right, String s, ArrayList<String> list){  
	        // invariant����������������ĿҪ�������������Ŀ  
	        if(left < right){  
	            return;  
	        }  
	          
	        // �������������Ŀ�������ӵ�list  
	        if(left==n && right==n){  
	            list.add(s);  
	            return;  
	        }  
	          
	        // ������������ֻ�����������  
	        if(left == n){  
	            rec(n, left, right+1, s+")", list);  
	            return;  
	        }  
	          
	        rec(n, left+1, right, s+"(", list);     // �������������  
	        rec(n, left, right+1, s+")", list);     // �������������  
	    }  
	  
	 
//===============================================
//ˮӡ����
public ArrayList<String> generateParenthesisB(int n) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> res = new ArrayList<String>();
    ArrayList<Integer> diff = new ArrayList<Integer>();
    res.add("");
    diff.add(0);
    
    
    for(int i=0;i<2*n;i++){
        ArrayList<String> temp1 = new ArrayList<String>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        for(int j=0;j<res.size();j++){
            String s = res.get(j);
            int k = diff.get(j);   
            if(i<2*n-1){
                temp1.add(s+"(");
                temp2.add(k+1);
            }
            if(k>0 && i<2*n-1 || k==1 && i==2*n-1){
                temp1.add(s+")");
                temp2.add(k-1);
            }
        }
        res = new ArrayList<String>(temp1);
        diff = new ArrayList<Integer>(temp2);
    }
    
    return res;
}
}



