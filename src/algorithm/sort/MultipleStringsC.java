package algorithm.sort;

public class MultipleStringsC{

	import java.util.Scanner;  
	  
	
	  
	    /** 
	     * 实现两个大数相乘 
	     * @param args 
	     */  
	    public static final int MAX_LEN = 10000000;  
	    public static int[] tempArray1 = new int[MAX_LEN];  
	    public static int[] tempArray2 = new int[MAX_LEN];//这两个数组用来暂时存储局部结果  
	    //初始化数组函数  
	    public static void Init()  
	    {  
	        for(int i=0;i<MAX_LEN;i++)  
	        {  
	            tempArray1[i] = 0;  
	            tempArray2[i] = 0;  
	        }  
	    }  
	    //实现大数相乘的函数  
	    public static String mul(String num1,String num2)  
	    {  
	        String result = "";  
	        int len1 = num1.length();  
	        int len2 = num2.length();  
	        int tempNum1 = 0,tempNum2 = 0;//num1和num2里拆出来相乘的单个数  
	        int pre = 0;//进位，初始化为0  
	        int mulRes = 0;//乘积  
	        for(int i=0;i<len2;i++)  
	        {  
	            int loc_begin = 0;//往数组里存放一轮计算结果的开始位置  
	            tempNum2 = num2.charAt(i)-'0';  
	            for(int j=0;j<len1;j++)  
	            {  
	                tempNum1 = num1.charAt(j)-'0';  
	                mulRes = tempNum1*tempNum2+pre;  
	                if(i==0)  
	                {  
	                    if(j==len1-1){//一轮计算结束  
	                        tempArray1[loc_begin] = mulRes;  
	                        pre = 0;//一轮存储完毕，进位置0  
	                    }  
	                    else//一轮计算没有结束  
	                    {  
	                        pre = mulRes/10;//进位  
	                        tempArray1[loc_begin] = mulRes%10;//进位后保存结果   
	                          
	                    }  
	                    loc_begin++;  
	                }  
	                else  
	                {  
	                    if(j==len1-1){//一轮计算结束  
	                        tempArray2[loc_begin] = mulRes;  
	                        pre = 0;//一轮存储完毕，进位置0  
	                    }  
	                    else//一轮计算没有结束  
	                    {  
	                        pre = mulRes/10;//进位  
	                        tempArray2[loc_begin] = mulRes%10;//进位后保存结果   
	                    }  
	                    loc_begin++;  
	                }  
	            }  
	            if(i>0)  
	            {  
	                  
	                posSum(i,loc_begin-1);//错位求和，结果存放在tempArray1中,i是错位数   
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
	    //错位求和  
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
	        boolean boo = true;//标记结果是否是正数，初始化假设是正数  
	        String result = null;//存放两个大数相乘的结果。  
	        //判断两个大数均为负数  
	        if(num1.charAt(0)=='-' && num2.charAt(0)=='-')  
	        {  
	            num1 = (String)num1.subSequence(1, num1.length());  
	            num2 = (String)num2.subSequence(1, num2.length());  
	        }  
	        else if(num1.charAt(0)=='-' || num2.charAt(0)=='-')//其中一个为负数  
	        {  
	            boo = false;//一正一负，结果为负数。  
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
	        if(!boo&&!result.equals("0"))//如果结果为负数，则在前面加‘-’号  
	            result = "-"+result;  
	        return result;  
	    }  
	    //字符串取反,如：(123-->321),方便之后求积  
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
	        System.out.println("请输入第一个大数：");  
	        while(in.hasNext())  
	        {     
	            Init();//初始化,数组置0  
	            String strNum1 = in.next();  
	            System.out.println("请输入第二个大数：");  
	            String strNum2 = in.next();  
	            System.out.println(strNum1+"*"+strNum2+" = "+multiply.getMulRes(strNum1,strNum2));  
	            System.out.println("请输入第一个大数：");  
	        }  
	          
	  
	    }  
	  
	}  
