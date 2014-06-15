package algorithm.sort;

public class DivideTwoIntegers {

/*ԭ������: http://oj.leetcode.com/problems/divide-two-integers/ 
�����������ֵ�������Ŀ������������������⣬��Reverse Integer�������ᵽ����
�Ƚ���Ҫ��ע������ڷ��źʹ���Խ������⡣���������Ŀ����Ϊ�����ó˳�����ȡ�����㣬
����ֻ��ʹ��λ����ͼӼ������Ƚ�ֱ�ӵķ������ñ�����һֱ��ȥ������ֱ��Ϊ0�����ַ����ĵ��������ǽ���Ĵ�С��
��������Ϊn���㷨���Ӷ���O(n)��
��ô��û�а취�Ż��أ� ������Ǿ͵�ʹ��λ���㡣����֪���κ�һ���������Ա�ʾ����2����Ϊ�׵�һ�����������ϣ�
��num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n���������������ʽ�Լ�����һλ�൱�ڳ���2��
�������ó�������ֱ�����ڱ�����֮ǰ�õ�һ�����Ļ���Ȼ�����������ÿ�γ��Լ�ȥ�������
��������������Ӽ�2^k,Ȼ����������Ƶ�����ֱ����Ϊ0Ϊֹ����Ϊ��������ĵ��������ǰ�2����֪�����������
����ʱ�临�Ӷ�ΪO(logn)����������*/
	    public int divide(int dividend, int divisor) {
	        
	    if(divisor==0)
	        return Integer.MAX_VALUE;
	    
	    int res = 0;
	    if(dividend==Integer.MIN_VALUE)
	    {
	        res = 1;
	        dividend += Math.abs(divisor);
	    }
	    if(divisor==Integer.MIN_VALUE)
	        return res;
	    boolean isNeg = ((dividend^divisor)>>>31==1)?true:false;
	    dividend = Math.abs(dividend);
	    divisor = Math.abs(divisor);
	    int digit = 0;
	    while(divisor<=(dividend>>1))
	    {
	        divisor <<= 1;
	        digit++;
	    }
	    while(digit>=0)
	    {
	        if(dividend>=divisor)
	        {
	            dividend -= divisor;
	            res += 1<<digit;
	        }
	        divisor >>= 1;
	        digit--;
	    }
	    return isNeg?-res:res;
	}
	    }
//������ֵ�������Ŀ�������л��ǱȽϳ����ģ����Ƶ���Ŀ��Sqrt(x)��Pow(x, n)�ȡ�
//�������������������������Ŀ��Ҳ�����õ�����Ҿ�����Ϥʵ����Щ����