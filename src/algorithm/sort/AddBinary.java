package algorithm.sort;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a==null ||a.length()==0){
            return b;
        }
        
        if (b==null || b.length()==0){
            return a;
        }
        
       StringBuilder sb=new StringBuilder();
       
        
        int lastA=a.length()-1;
        int lastB=b.length()-1;
        int carry=0;
        
        
        while (lastA>=0 ||lastB>=0 ||carry>0){
            int num1=lastA>=0?a.charAt(lastA--)-'0':0;
            int num2=lastB>=0?b.charAt(lastB--)-'0':0;
            int current=(num1+num2+carry)%2;
            carry=(num1+num2+carry)/2;
            
            sb.insert(0, current);
            
            
        }
        
        return sb.toString();
    }
//============================================================
	 public static void main(String[] args) {
	        String a = "1111";
	        String b = "1111";
	        System.out.println(addBinaryB
	        		(a, b));
	    }
	     
	    public static String addBinaryB(String a, String b) {
	        int i = a.length() - 1;     // i指向a的末尾
	        int j = b.length() - 1;     // j指向b的末尾
	        int c = 0;      // carry 进位
	        // 先把String转为char数组便于处理
	        char[] achar = a.toCharArray();
	        char[] bchar = b.toCharArray();
	        // 结果数组
	        char[] reschar = new char[Math.max(achar.length, bchar.length)+2];
	        int k = 0;      // k指向结果数组的开头
	         
	        while(true){
	            if(i<0 && j<0 && c==0){
	                break;
	            }
	             
	            int aint = 0;
	            int bint = 0;
	             
	            if(i >= 0){
	                aint = achar[i] - '0';
	            }
	            if(j >= 0){
	                bint = bchar[j] - '0';
	            }
	            if(aint + bint + c > 1){
	                reschar[k] = (char) ('0' + aint + bint + c - 2);
	                c = 1;
	            }else{
	                reschar[k] = (char) ('0' + aint + bint + c);
	                c = 0;
	            }
	            k++;
	            i--;
	            j--;
	        }
	         // char数组转string，然后翻转
	        return new StringBuffer(new String(reschar, 0, k)).reverse().toString();
	    }
	 
	}


