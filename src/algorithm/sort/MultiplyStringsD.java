package algorithm.sort;

public class MultiplyStringsD {
	public static int[] multipleString(char[] arr1, char[] arr2)
    {
         assert(arr1.length>0&&arr2.length>0);
         int[] result = new int[arr1.length+arr2.length];
         for(int i=arr2.length-1;i>=0;i--) {
          int carry = 0;
          int startIndex = arr2.length-1-i;
          for(int j=arr1.length-1;j>=0;j--){
           int temp = (arr2[i]-'0')*(arr1[j]-'0')
             +result[result.length-1-startIndex-(arr1.length-1-j)]+carry;
           result[result.length-1-startIndex-(arr1.length-1-j)] = temp%10;
           carry = temp/10;
          }
          int index = result.length-1-startIndex-arr1.length;
          while(carry!=0){
           int temp = result[index]+carry;
           result[index] = temp%10;
           carry = temp/10;
           index--;
          }
         }
         return result;       
    }
	public static void main(String agrs[]){  
	     char[] arr1 = {1,2,3};  
	     char[] arr2 = {3,4,5};  
	      int[] result = multipleString(arr1,arr2);  
	      System.out.println("¼ÆËã½á¹û£º"+result);

	     } 
}
