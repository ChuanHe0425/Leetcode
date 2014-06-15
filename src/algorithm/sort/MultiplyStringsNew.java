package algorithm.sort;

public class MultiplyStringsNew {
			 public static String multipleString(String num1, String num2) {
				 int[] num = new int[num1.length()+num2.length()];
				 for(int i=0;i<num1.length();i++){
					 int carry = 0;
					 int a = num1.charAt(num1.length()-1-i)-'0';
					 for(int j=0;j<num2.length();j++){
						 int b = num2.charAt(num2.length()-1-j)-'0';
						 num[i+j]+=carry+a*b;
						 carry=num[i+j]/10;
		                num[i+j]%=10;
		            }
		            num[i+num2.length()]+=carry;
		            
		        }
		        int i=num.length-1;
		        while(i>0 && num[i]==0) i--;
		        
		        StringBuilder temp = new StringBuilder("");
		        while(i>=0)
		            temp.append((char)('0'+num[i--]));
		        
		        return temp.toString();
		        }

		public static void main(String agrs[]){
		     String s1 = "12246";
		     String s2 = "456";
		     String result = multipleString(s1,s2);
		       System.out.println("¼ÆËã½á¹û£º"+result);
		       //System.out.println(num[1]);
		       } 
		}

