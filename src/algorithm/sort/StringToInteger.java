package algorithm.sort;

public class StringToInteger{
public int atoi(String s) {
		s = s.trim();
		long value = 0;
		boolean isPositive = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				//���ȷ����ַ����ĵ�һ���ַ�ʱ �ж��Ƿ�Ϊ�ӺŻ����

			{
				if (s.charAt(i) == '-') {
					isPositive = false;  //����Ǽ��� flag��־ isPositive ��Ϊ flase 

		}
				continue;
	}
		if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
		// �����з� 0~9 ���ַ� ��ôbreak ���Ǿ�ֻת������ break ȫ��ֹͣ

value = 10 * value + s.charAt(i) - '0';
		}// �����0��9  ���Ǿ�Ҫ�õ���ǰ��int ֵ �� ��������֮ǰ��ֵ*10 ����

        //   ��ǰ�ַ����ַ���0����ASC��Ĳ�ֵ ���ǵ�ǰ���ַ���int ֵ

		value = isPositive == true ? value : value *( -1);
		// ����Ǹ��� value*-1 ��ɸ��� 

		if (value < -2147483648) {
		return -2147483648;// int ֵ����ֻ�� -2147483648 �� 2147483648 ֮��

		} else if (value > 2147483647) {
		return 2147483647;
		} 
		else 
			return��int��value��
					// ����ڷ�Χ�� ����value			
		
}
		}
		

