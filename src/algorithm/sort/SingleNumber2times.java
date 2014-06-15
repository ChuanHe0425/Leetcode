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
这个题的标准做法是利用异或运算的这两个法则：
 
 
1. a ^ b = b ^ a
2. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c;

举个例子：
1^2^3^4^4^3^2的结果是啥呢？
一眼大概开不出来。。
根据上面两个法则，改变一下顺序吧
改成2^2^3^3^4^4^1
现在，结果一目了然了吧~
显然是1*/