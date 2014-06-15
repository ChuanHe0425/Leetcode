package algorithm.sort;
/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2*/

public class GrayCode {
	 public ArrayList<Integer> grayCode(int n) {
	        
		    ArrayList<Integer> prev = new ArrayList<Integer>();
		        for(int i=0;i<n;i++){
		            ArrayList<Integer> cur = new ArrayList<Integer>();
		            for(Integer temp:prev){
		                cur.add(temp);
		            }
		            cur.add(i+1);
		            for(Integer temp:prev){
		                cur.add(temp);
		            }
		            prev=new ArrayList<Integer>(cur);
		        }
		        
		        int start =0;
		        ArrayList<Integer> res = new ArrayList<Integer>();
		        res.add(start);
		        
		        for(Integer temp:prev){
		            start=flipAtPosition(start,temp);
		            res.add(start);
		        }
		        return res;
		    }
		    
		    public int flipAtPosition(int a,int k){
		        int temp = (a>>(k-1))&1;
		        if(temp==1) return a-(1<<(k-1));
		        else return a+(1<<(k-1));
		    }
}
