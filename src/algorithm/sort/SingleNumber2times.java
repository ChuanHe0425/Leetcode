package algorithm.sort;

public class SingleNumber2times {
	public int singleNumber(int [] A){
		int res = 0;
		for(int i:A){
			res = res^i;
		}
		 return res;
	}

}
//,it could be solved by XOR operation easily,
//notice that a number XOR itself equal zero.So just iterate the array,do XOR for each integer.


/*
�����ı�׼����������������������������
 
 
1. a ^ b = b ^ a
2. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c;

�ٸ����ӣ�
1^2^3^4^4^3^2�Ľ����ɶ�أ�
һ�۴�ſ�����������
���������������򣬸ı�һ��˳���
�ĳ�2^2^3^3^4^4^1
���ڣ����һĿ��Ȼ�˰�~
��Ȼ��1*/