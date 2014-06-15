package algorithm.sort;

public class WildCardMatching {
//̰�ĵĲ��ԣ���ƥ���һֱ���������ƥ�䲻���˾Ϳ���ǰ����û��'*'���Ⱦȳ����ٴ�'*'��������ԡ�
/*�����Ŀ��ʵ��Regular Expression Matching�ļ򻯰棬������'?'�൱���Ǳߵ�'.'��
 * ��'*'�൱���Ǳߵ�'.*'����Ϊ����'*'�Ϳ��Դ����κ��ַ���������Ҫ��ǰ����ַ������Դ����������Ӽ򵥡�
brute force�ķ����Ͳ������оٴ����ˣ�����Ȥʵ�ֵ����ѿ��Բο�һ��Regular Expression Matching��
����ṹһ����ֻ�Ǵ��������һ�¾Ϳ��ԣ�����leetcode�����ˣ���Ϊ��ʱ����
������Ҫ����˵һ�¶�̬�滮�ķ�������Regular Expression Matchingһ����
����ά��һ����������ά��һ����������res[i],����s��ǰi���ַ���p��ǰj���ַ��Ƿ�ƥ��
(������Ϊÿ��i�Ľ��ֻ������j-1�Ľ�������Բ���Ҫ��ά���飬ֻ��Ҫһ��һά������������һ�н�����ɣ���
���ƹ�ʽ�����������
    (1)p[j]����'*'������Ƚϼ򵥣�ֻҪ�ж������ǰs��i��p��j�ϵ��ַ�һ���������p��j�ϵ��ַ���'?'
    ��Ҳ����ͬ��������res[i]==true�������res[i+1]Ϊtrue������res[i+1]=false;  
    (2)p[j]��'*'����Ϊ'*'����ƥ�������ַ�����������ǰ���res[i]ֻҪ��true����ôʣ�µ�         
     res[i+1], res[i+2],...,res[s.length()]�Ͷ���true�ˡ�
�㷨��ʱ�临�Ӷ���Ϊ������ѭ����������O(m*n), ���ռ临�Ӷ�ֻ��һ��һά���飬������O(n)��
����s�ĳ�����n��p�ĳ�����m��*/	
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}

}
