package algorithm.sort;
public class PowXN {
	//n O(logn). We have a relation that x^n = x^(n/2) * x^(n/2) * x^(n%2).
	//By using this relation, a recursive solution can easily be written.
	
	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}
	} 
//=========================
public class PowXN {
	double pow1(double x, int n)
	{
		if(n==0)
			return 1.0;
		if(n<0)
			return 1.0/pow1(x,-n);
		return x*pow1(x,n-1);
	}



//���ǵ�n��x���ʽ�ӵĶԳƹ�ϵ�����Զ������������иĽ����Ӷ��õ�һ��ʱ�临�Ӷ�ΪO(logn)�ķ������ݹ��ϵ���Ա�ʾΪpow(x,n) = pow(x,n/2)*pow(x,n-n/2)
double pow2(double x, int n)
{
	if(n==0)
		return 1.0;
	if(n<0)
		return 1.0/pow2(x,-n);
	double half = pow2(x,n>>1);
	if(n%2==0)
		return half*half;
	else
		return half*half*x;
}
//2)���ǵ�n��x���ʽ�ӵĶԳƹ�ϵ�����Զ������������иĽ����Ӷ��õ�һ��ʱ�临�Ӷ�ΪO(logn)�ķ������ݹ��ϵ���Ա�ʾΪpow(x,n) = pow(x,n/2)*pow(x,n-n/2)
double pow3(double x, int n)
{
	if(n==0)
		return 1.0;
	if(n<0)
		return 1.0/pow3(x,-n);
	double half = pow3(x,n>>1);
	if(n%2==0)
		return half*half;
	else
		return half*half*x;
}
//3)�����������������ﻹ�ᵽ��һ��ʮ������ҿ��ٵķ�����ԭ���������£�

//Consider the binary representation of n. For example, if it is "10001011", then x^n = x^(1+2+8+128) = x^1 * x^2 * x^8 * x^128. Thus, we don't want to loop n times to calculate x^n. To speed up, we loop through each bit, if the i-th bit is 1, then we add x^(1 << i) to the result. Since (1 << i) is a power of 2, x^(1<<(i+1)) = square(x^(1<<i)). The loop executes for a maximum of log(n) times.
//�÷���ͨ��ɨ��n�Ķ����Ʊ�ʾ��ʽ�ﲻͬλ���ϵ�1��������x���ݴ�


double my_pow(double x, int n)
{
	if(n==0)
        	return 1.0;
	if(n<0)
		return 1.0 / pow(x,-n);
	double ans = 1.0 ;
	for(; n>0; x *= x, n>>=1)
	{
		if(n&1>0)
			ans *= x;
	}
	return ans;
}
/*Ϊ����ȷ����x��n���ݣ�����Ҫ���ǵ�����һЩ�����

1) xȡֵΪ0ʱ��0������������1��������������û������ģ��ж�x�Ƿ����0����ֱ���á�==����

2) ����nȡֵINT_MINʱ��-n������INT_MAX����ʱ��Ҫ����С�ġ�

3) ����ʹ����λ����������������㣬�ӿ��㷨ִ�е��ٶȡ�

������Լ���LeetCode��Accepted�Ĵ��룺*/

class Solution {
public
    double pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(n<0)
		{
			if(n==INT_MIN)
				return 1.0 / (pow(x,INT_MAX)*x);
			else
				return 1.0 / pow(x,-n);
		}
        if(n==0)
            return 1.0;
		double ans = 1.0 ;
		for(;n>0; x *= x, n>>=1)
		{
			if(n&1>0)
				ans *= x;
		}
		return ans;
    }
}






