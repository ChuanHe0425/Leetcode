package algorithm.sort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
public class AnagramsLeetCode {
	/*ԭ������: http://oj.leetcode.com/problems/anagrams/ 
	����һ���ܾ�����������ˣ���cc150����Ҳ�У����ǰ�һ�����鰴����λ���ʷ��ࡣ��λ������ʵҲ�ܺ���⣬
	���������������������ַ�����������һ���ģ�ֻ��˳��ͬ��
	�����򵥵İ汾���ж����������ǲ���anagram��һ����˵�����ַ�������һ�ַ�������hashmap��key���ַ���
	value�ǳ��ֵĴ���������������ʹ��ɵ�hashmap��ͬ����ô����anagram��ʵ������������һ������hashmap��
	Ȼ����һ����ǰ���hashmap�����ȥ����������hashmapΪ�գ�������true��
	�������ʱ�临�Ӷ���O(m+n)��m��n�ֱ����������ʵĳ��ȡ����ռ临�Ӷ���O(�ַ����Ĵ�С)��

	�ڶ��ַ����ǽ��������������������֮������ͬ����˵������������anagram��
	���ַ�����ʱ�临�Ӷ�ȡ���������㷨��һ�������㷨��O(nlogn)������ַ�����С��Ҳ���������Ե������㷨��
	����������˵��������ж��������ʵģ���һ�ַ���Ҫֱ�Ӽ�һЩ��
	���������ǿ�������⣬���ںܶ��ַ������水��anagram���࣬�����hashmap�ķ�����Ȼ������ƥ�䣬
	�ڷ����Ƚ��鷳�������������ķ�������һ���ܴ�����ƣ������������ַ���������Ϊһ��key��
	Ҳ����ĳһ��class��id�����ֻҪ��ÿһ���ַ�������Ȼ����һ��hashmap��key�������Ĵ���
	��value�������������key����ַ����������Ϳ��ԱȽϼ򵥵Ľ��з��ࡣ����������n���ַ�����
	�ַ�����󳤶���k����ô���㷨��ʱ�临�Ӷ���O(nklogk)������O(klogk)�Ƕ�ÿһ���ַ�������
	������������㷨Ҳ������ߣ����ռ临�Ӷ�����O(nk)����hashmap�Ĵ�С��ʵ�ִ������£�*/
	public ArrayList<String> anagrams(String[] strs) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(strs == null || strs.length == 0)
	        return res;
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(int i=0;i<strs.length;i++)
	    {
	        char[] charArr = strs[i].toCharArray();
	        Arrays.sort(charArr);
	        String str = new String(charArr);
	        if(map.containsKey(str))
	        {
	            map.get(str).add(strs[i]);
	        }
	        else
	        {
	            ArrayList<String> list = new ArrayList<String>();
	            list.add(strs[i]);
	            map.put(str,list);
	        }
	    }
	    Iterator iter = (Iterator) map.values().iterator();
	    while(iter.hasNext())
	    {
	        ArrayList<String> item = (ArrayList<String>)iter.next();
	        if(item.size()>1)
	            res.addAll(item);
	    }
	    return res;
	}
	//������˼·��ʵ���������ǱȽϼ򵥵ģ�����⿼������hashmap���ַ�������
	//�Ƚ�ȫ�棬�������зǳ����������һ��Ҫ��Ϥ����package algorithm.sort;

	
//===================================
/*˼·��
��Hashtable�����������string��Ϊkey������anagram��ΪArrayList

�����֮ǰ�ñ���д��O(N^2)��TLE�ˣ�����Hashtable��д
��Ŀ����˼�Ǹ�һ��String���飬�ҳ���������ͬ��ĸ��ɵĵ��ʡ�
���磺
S = ["abc", "bca", "bac", "bbb", "bbca", "abcb"]
��Ϊ��
["abc", "bca", "bac", "bbca", "abcb"]
ֻ��"bbb"û����ͬ��ĸ��ɵĵ��ʡ�*/


public ArrayList<String> anagrams2(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		
		// ���������string��Ϊkey������anagram��ΪArrayList
		Hashtable<String, ArrayList<String>> ht =
				new Hashtable<String, ArrayList<String>>();
		
		for(int i=0; i<strs.length; i++){
			String sorted = sorted(strs[i]);
			ArrayList<String> val = ht.get(sorted);
			if(val != null){
				val.add(strs[i]);
			}else{
				val = new ArrayList<String>();
				val.add(strs[i]);
				ht.put(sorted, val);
			}
		}
		
		// Hashtable��ѭ������ keySet 
		Set<String> set = ht.keySet();
		
		// ������anagram��ӵ�ret��
		for(String s : set){
			ArrayList<String> val = ht.get(s);
			if(val.size() > 1){
				ret.addAll(val);
			}
		}
		
		return ret;
    }
	
	public String sorted(String a){
		char[] achar = a.toCharArray();
		Arrays.sort(achar);
		return new String(achar);
	}
	
}