package algorithm.sort;

public class PlusOneInArray {
//实现给定一个十进制数，用数组表示每一位，要求返回加一后的结果
//从数组尾部到头部处理，用一个overflow flag来判断是否溢出，
	//如果溢出则需要新开一个array


	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry=0, i=digits.length-1;
        digits[i]+=1;
        while(digits[i]>=10){
            digits[i--]-=10;
            if(i>=0)
                digits[i]+=1;
            else{
                carry=1;
                break;
            }
        }
        if(carry==0) return digits;
        int[] res = new int[digits.length+1];
        for(i=0;i<digits.length;i++){
            res[i+1]=digits[i];
        }
        res[0]=1;
        return res;
    }
}
