package algorithm.sort;

public class PlusOneInArray {
//ʵ�ָ���һ��ʮ���������������ʾÿһλ��Ҫ�󷵻ؼ�һ��Ľ��
//������β����ͷ��������һ��overflow flag���ж��Ƿ������
	//����������Ҫ�¿�һ��array


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
