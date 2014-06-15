package algorithm.sort;

public class StringToInteger{
public int atoi(String s) {
		s = s.trim();
		long value = 0;
		boolean isPositive = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				//首先访问字符串的第一个字符时 判断是否为加号或减号

			{
				if (s.charAt(i) == '-') {
					isPositive = false;  //如果是减号 flag标志 isPositive 设为 flase 

		}
				continue;
	}
		if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
		// 若果有非 0~9 的字符 那么break 我们就只转换到这 break 全部停止

value = 10 * value + s.charAt(i) - '0';
		}// 如果是0～9  我们就要得到当前的int 值 ， 方法是用之前的值*10 加上

        //   当前字符与字符‘0’的ASC码的差值 就是当前的字符的int 值

		value = isPositive == true ? value : value *( -1);
		// 如果是负数 value*-1 变成负数 

		if (value < -2147483648) {
		return -2147483648;// int 值必须只在 -2147483648 到 2147483648 之间

		} else if (value > 2147483647) {
		return 2147483647;
		} 
		else 
			return（int）value；
					// 如果在范围内 返回value			
		
}
		}
		

