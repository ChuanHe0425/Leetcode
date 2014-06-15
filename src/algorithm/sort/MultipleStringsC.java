package algorithm.sort;

public class MultipleStringsC{

	import java.util.Scanner;  
	  
	
	  
	    /** 
	     * ʵ������������� 
	     * @param args 
	     */  
	    public static final int MAX_LEN = 10000000;  
	    public static int[] tempArray1 = new int[MAX_LEN];  
	    public static int[] tempArray2 = new int[MAX_LEN];//����������������ʱ�洢�ֲ����  
	    //��ʼ�����麯��  
	    public static void Init()  
	    {  
	        for(int i=0;i<MAX_LEN;i++)  
	        {  
	            tempArray1[i] = 0;  
	            tempArray2[i] = 0;  
	        }  
	    }  
	    //ʵ�ִ�����˵ĺ���  
	    public static String mul(String num1,String num2)  
	    {  
	        String result = "";  
	        int len1 = num1.length();  
	        int len2 = num2.length();  
	        int tempNum1 = 0,tempNum2 = 0;//num1��num2��������˵ĵ�����  
	        int pre = 0;//��λ����ʼ��Ϊ0  
	        int mulRes = 0;//�˻�  
	        for(int i=0;i<len2;i++)  
	        {  
	            int loc_begin = 0;//����������һ�ּ������Ŀ�ʼλ��  
	            tempNum2 = num2.charAt(i)-'0';  
	            for(int j=0;j<len1;j++)  
	            {  
	                tempNum1 = num1.charAt(j)-'0';  
	                mulRes = tempNum1*tempNum2+pre;  
	                if(i==0)  
	                {  
	                    if(j==len1-1){//һ�ּ������  
	                        tempArray1[loc_begin] = mulRes;  
	                        pre = 0;//һ�ִ洢��ϣ���λ��0  
	                    }  
	                    else//һ�ּ���û�н���  
	                    {  
	                        pre = mulRes/10;//��λ  
	                        tempArray1[loc_begin] = mulRes%10;//��λ�󱣴���   
	                          
	                    }  
	                    loc_begin++;  
	                }  
	                else  
	                {  
	                    if(j==len1-1){//һ�ּ������  
	                        tempArray2[loc_begin] = mulRes;  
	                        pre = 0;//һ�ִ洢��ϣ���λ��0  
	                    }  
	                    else//һ�ּ���û�н���  
	                    {  
	                        pre = mulRes/10;//��λ  
	                        tempArray2[loc_begin] = mulRes%10;//��λ�󱣴���   
	                    }  
	                    loc_begin++;  
	                }  
	            }  
	            if(i>0)  
	            {  
	                  
	                posSum(i,loc_begin-1);//��λ��ͣ���������tempArray1��,i�Ǵ�λ��   
	            }  
	        }  
	        boolean boo = true;  
	        for(int k=tempArray1.length-1;k>=0;k--)  
	        {  
	              
	            if(tempArray1[k]==0 && boo)  
	            {  
	                    continue;  
	            }     
	            else  
	            {  
	                boo = false;  
	                result = result+tempArray1[k];  
	            }  
	        }  
	        if(result=="")  
	            result = "0";  
	        return result;  
	    }  
	    //��λ���  
	    public static void posSum(int n,int len)  
	    {  
	        int pre = 0;  
	        int sum = 0;  
	        int i=0;  
	        int j=0;  
	        while(true)  
	        {  
	            if(i>=n)  
	            {  
	                sum = tempArray1[i] + tempArray2[j] + pre;  
	                if(j<len)  
	                {  
	                    tempArray1[i] = sum%10;  
	                    pre = sum/10;  
	                }  
	                if(j==len)  
	                {  
	                    tempArray1[i] = sum;  
	                    break;  
	                }  
	                j++;  
	            }  
	            i++;  
	        }  
	    }  
	    public String getMulRes(String num1,String num2)  
	    {  
	        boolean boo = true;//��ǽ���Ƿ�����������ʼ������������  
	        String result = null;//�������������˵Ľ����  
	        //�ж�����������Ϊ����  
	        if(num1.charAt(0)=='-' && num2.charAt(0)=='-')  
	        {  
	            num1 = (String)num1.subSequence(1, num1.length());  
	            num2 = (String)num2.subSequence(1, num2.length());  
	        }  
	        else if(num1.charAt(0)=='-' || num2.charAt(0)=='-')//����һ��Ϊ����  
	        {  
	            boo = false;//һ��һ�������Ϊ������  
	            if(num1.charAt(0)=='-')  
	            {  
	                num1 = (String)num1.subSequence(1, num1.length());  
	            }  
	            else if(num2.charAt(0)=='-')  
	            {  
	                num2 = (String)num2.subSequence(1, num2.length());  
	            }  
	        }  
	        num1 = reverse(num1);  
	        num2 = reverse(num2);  
	        if(num1.length()<=num2.length())  
	            result = mul(num2,num1);  
	        else  
	            result = mul(num1,num2);  
	        if(!boo&&!result.equals("0"))//������Ϊ����������ǰ��ӡ�-����  
	            result = "-"+result;  
	        return result;  
	    }  
	    //�ַ���ȡ��,�磺(123-->321),����֮�����  
	    public static String reverse(String str)  
	    {  
	        char[] strarray = str.toCharArray();  
	        StringBuffer sbf = new StringBuffer();  
	        for (int i = strarray.length - 1; i >= 0; i--)  
	            sbf.append(strarray[i]);  
	        return sbf.toString();  
	    }  
	    public static void main(String[] args) {  
	        Scanner in = new Scanner(System.in);  
	        bigNumMultiply multiply = new bigNumMultiply();  
	        System.out.println("�������һ��������");  
	        while(in.hasNext())  
	        {     
	            Init();//��ʼ��,������0  
	            String strNum1 = in.next();  
	            System.out.println("������ڶ���������");  
	            String strNum2 = in.next();  
	            System.out.println(strNum1+"*"+strNum2+" = "+multiply.getMulRes(strNum1,strNum2));  
	            System.out.println("�������һ��������");  
	        }  
	          
	  
	    }  
	  
	}  
