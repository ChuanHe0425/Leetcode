package algorithm.sort;

public class RomantoInteger {
	/*思路
	首先，学习一下罗马数字，参考罗马数字

	罗马数字是最古老的数字表示方式，比阿拉伯数组早2000多年，起源于罗马

	罗马数字有如下符号：

	基本字符	I	V	X	L	C	D	M
	对应阿拉伯数字	1	5	10	50	100	500	1000
	计数规则：
	相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
	小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
	小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
	正常使用时，连续的数字重复不得超过三次
	在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

	其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

	从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
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
