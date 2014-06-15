package algorithm.sort;

public class MultiplyStringsB {
	/** 
	 * 计算大数相乘 
	 * @author zhoujianghai 
	 * zhoujiangbohai@163.com 
	 */  
	
	  
	     public static void main(String agrs[]){  
	     String number1 = "1234567891011121314151617181920";  
	     String number2 = "2019181716151413121110987654321";  
	      String result = multipBigNumber(number1,number2);  
	      System.out.println("计算结果："+result+"; length="+result.length());  
	      System.out.println("验证结果："+Double.parseDouble(number1) * Double.parseDouble(number2));  
	     }  
	      
	     public static String multipBigNumber(String s1,String s2){  
	          int longArray[] = null;  
	          int shortArray[] = null;  
	          int s1Length = s1.length();  
	          int s2Length = s2.length();  
	          int longLength = s1Length > s2Length ? s1Length : s2Length;  
	          int shortLength = s1Length == longLength ? s2Length : s1Length;  
	          longArray = new int[longLength];  
	          shortArray = new int[shortLength];  
	          String longString = s1Length >= s2Length ? s1 : s2;   
	          String shortString = s1.equals(longString) ? s2 : s1;  
	          System.out.println("longString="+longString+"; shortString="+shortString);   
	          //低位在前，高位在后  
	          for(int i = longLength - 1; i >= 0; i --){  
	              longArray[longLength - 1 - i] = longString.charAt(i) - 48;   
	          }  
	          for(int i = shortLength - 1; i >= 0; i --){  
	              shortArray[shortLength - 1 - i] = shortString.charAt(i) - 48;  
	          }  
	           
	          StringBuffer results[] = new StringBuffer[longLength];  
	          for(int i = 0; i < results.length; i++) {  
	              results[i] = new StringBuffer();  
	            }  
	          StringBuffer resultBuffer = new StringBuffer();  
	         
	          /** 
	           * 把被乘数的每一位与乘数逐位相乘 
	           * 如：5607 * 2256,被乘数5607，乘数2256 
	           * 7 * 6 + 0 = 42 ：0表示低位向高位的进位 
	             7 * 5 + 4 = 39 
	             7 * 2 + 3 = 17 
	             7 * 2 + 1 = 15 
	             29751 
	             0 * 6 + 0 = 0 
	             0 * 5 + 0 = 0 
	             0 * 2 + 0 = 0 
	             0 * 2 + 0 = 0 
	             00000 
	             6 * 6 + 0 = 36 
	             6 * 5 + 3 = 33 
	             6 * 2 + 3 = 15 
	             6 * 2 + 1 = 13 
	             63531 
	             5 * 6 + 0 = 30 
	             5 * 5 + 3 = 28 
	             5 * 2 + 2 = 12 
	             5 * 2 + 1 = 11 
	             08211 
	           *  results：29751， 00000，63531，08211 
	           * */  
	          for(int i = 0; i < longLength; i ++){  
	           int temp = 0;  
	           int tempCarry = 0;//低位向高位的进位  
	           int currentValue = 0; //当前位乘积的值  
	               for(int j = 0; j < shortLength; j ++){  
	                    
	                    temp = longArray[i] * shortArray[j] + tempCarry;  
	                    //System.out.println("longArray[i]="+longArray[i]+" * "+"shortArray[j]="+shortArray[j]+" + "+tempCarry+" = "+temp);   
	                    tempCarry = temp / 10;  
	                    currentValue = temp % 10;  
	                    results[i].append(currentValue);  
	                    if(j == shortLength - 1){  
	                     results[i].append(tempCarry);//最高位有进位则进位，无进位则补0  
	                    }  
	               }  
	              System.out.println( results[i].toString());   
	          }  
	         /**低位补0，results[i]低位补i个0(低位在前，高位在后) 
	          * 29751 
	            000000 
	            0063531 
	            00008211 
	          *  */  
	          for(int i = 0,length = results.length;i < length; i++){  
	           String temp = "";  
	           for(int j = 0; j < i; j ++){  
	            temp += "0";  
	           }  
	           results[i].insert(0, temp);  
	           System.out.println( results[i].toString());   
	          }  
	  
	           /**把每一行相加(低位在前，高位在后,从左往右 加) 
	          * 29751 
	            000000 
	            0063531 
	            00008211 
	          ------------- 
	            29394621  
	            *  
	            * */  
	          int tempCarry = 0;  
	          int currentValue = 0;   
	          StringBuffer lastBuffer = results[results.length - 1];  
	         //需要循环的次数    
	        int times =  lastBuffer.length();    
	         
	        for(int i = 0; i < times; i ++ ){    
	            int temp = 0;    
	            for(int j = 0,length2 = results.length; j < length2; j ++){    
	                if(results[j].length() > i){    
	                    temp += (results[j].charAt(i) - 48);//把第j行的第i位的字符转换成int    
	                }    
	            }    
	            temp += tempCarry;    
	            tempCarry = temp / 10;    
	            currentValue = temp % 10;    
	            resultBuffer.append(currentValue);    
	        }    
	  
	        StringBuffer finalResult = new StringBuffer();    
	  
	        boolean hasNumNotZero = false;  
	        //因为低位在前，高位在后，所以把29394621 转换成最终结果：12649392    
	        for(int i = resultBuffer.length() - 1; i >= 0; i --) {    
	            int temp  = resultBuffer.charAt(i) - 48;    
	            if(temp != 0) hasNumNotZero = true;  
	            if (hasNumNotZero) finalResult.append(temp);      
	        }    
	        if (finalResult.length() == 0) finalResult.append(0);  
	        return finalResult.toString();    
	  
	    }    
	}  

