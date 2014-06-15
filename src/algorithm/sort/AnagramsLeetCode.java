package algorithm.sort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
public class AnagramsLeetCode {
	/*原题链接: http://oj.leetcode.com/problems/anagrams/ 
	这是一道很经典的面试题了，在cc150里面也有，就是把一个数组按照易位构词分类。易位构词其实也很好理解，
	就是两个单词所包含的字符和数量都是一样的，只是顺序不同。
	这个题简单的版本是判断两个单词是不是anagram，一般来说有两种方法。第一种方法是用hashmap，key是字符，
	value是出现的次数，如果两个单词构成的hashmap相同，那么就是anagram。实现起来就是用一个构建hashmap，
	然后另一个在前面的hashmap中逐个去除，最后如果hashmap为空，即返回true。
	这个方法时间复杂度是O(m+n)，m，n分别是两个单词的长度。而空间复杂度是O(字符集的大小)。

	第二种方法是将两个单词排序，如果排序之后结果相同，就说明两个单词是anagram。
	这种方法的时间复杂度取决于排序算法，一般排序算法是O(nlogn)，如果字符集够小，也可以用线性的排序算法。
	不过总体来说，如果是判断两个单词的，第一种方法要直接简单一些。
	接下来我们看看这道题，是在很多字符串里面按照anagram分类，如果用hashmap的方法，然后两两匹配，
	在分组会比较麻烦。而如果用排序的方法则有一个很大的优势，就是排序后的字符串可以作为一个key，
	也就是某一个class的id，如此只要对每一个字符串排序，然后建立一个hashmap，key是排序后的串，
	而value是所有属于这个key类的字符串，这样就可以比较简单的进行分类。假设我们有n个字符串，
	字符串最大长度是k，那么该算法的时间复杂度是O(nklogk)，其中O(klogk)是对每一个字符串排序
	（如果用线性算法也可以提高）。空间复杂度则是O(nk)，即hashmap的大小。实现代码如下：*/
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
	//理清了思路，实现起来还是比较简单的，这道题考察排序，hashmap，字符串处理，
	//比较全面，在面试中非常常见，大家一定要熟悉哈。package algorithm.sort;

	
//===================================
/*思路：
建Hashtable，用排序过的string作为key，它的anagram作为ArrayList

这道题之前用暴力写的O(N^2)的TLE了，改用Hashtable来写
题目的意思是给一个String数组，找出其中由相同字母组成的单词。
例如：
S = ["abc", "bca", "bac", "bbb", "bbca", "abcb"]
答案为：
["abc", "bca", "bac", "bbca", "abcb"]
只有"bbb"没有相同字母组成的单词。*/


public ArrayList<String> anagrams2(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		
		// 用排序过的string作为key，它的anagram作为ArrayList
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
		
		// Hashtable的循环方法 keySet 
		Set<String> set = ht.keySet();
		
		// 把所有anagram添加到ret中
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