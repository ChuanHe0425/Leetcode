package algorithm.sort;

public class RomantoInteger {
	/*˼·
	���ȣ�ѧϰһ���������֣��ο���������

	��������������ϵ����ֱ�ʾ��ʽ���Ȱ�����������2000���꣬��Դ������

	�������������·��ţ�

	�����ַ�	I	V	X	L	C	D	M
	��Ӧ����������	1	5	10	50	100	500	1000
	��������
	��ͬ��������д������ʾ����������Щ������ӵõ����������磺III = 3
	С�������ڴ�������ұߣ�����ʾ����������Щ������ӵõ����������磺VIII = 8
	С�����֣����ڣ�I��X��C���ڴ��������ߣ�����ʾ�������ڴ�����ȥС�����õ��������磺IV = 4
	����ʹ��ʱ�������������ظ����ó�������
	��һ���������滭���ߣ���ʾ���������1000��������ֻ����3999���ڵ����������ò�����������

	��Σ���������ת���������ֹ��򣨽�����3999���ڣ���

	��ǰ�������������֣����ĳ������ǰһ����С������ϸ�������֮����ȥǰһ����������Ȼ����ϸ���
*/import java.util.Scanner;


import java.util.Scanner;


    public static int charToInt(char c) {
        int data = 0;

        switch (c) {
            case 'I':
                data = 1;
                break;
            case 'V':
                data = 5;
                break;
            case 'X':
                data = 10;
                break;
            case 'L':
                data = 50;
                break;
            case 'C':
                data = 100;
                break;
            case 'D':
                data = 500;
                break;
            case 'M':
                data = 1000;
                break;
        }

        return data;
    }

    public static int romanToInt(String s) {
        int i, total, pre, cur;

        total = charToInt(s.charAt(0));

        for (i = 1; i < s.length(); i++) {
            pre = charToInt(s.charAt(i - 1));
            cur = charToInt(s.charAt(i));

            if (cur <= pre) {
                total += cur;
            } else {
                total = total - pre * 2 + cur;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String s;
        int d;
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            s = cin.nextLine();

            d = romanToInt(s);

            System.out.println(d);
        }

        cin.close();
    }
}
}
