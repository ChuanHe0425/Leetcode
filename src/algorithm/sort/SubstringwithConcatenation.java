package algorithm.sort;
import java.util.ArrayList;
import java.util.HashMap;
/*����⿴�ƱȽϸ��ӣ���ʵ˼·��Longest Substring Without Repeating Characters��ࡣ
 * ��Ϊ��Щ�����Ƕ����ģ����Ա����Ϻ͵�һ���ַ�һ������Longest Substring Without Repeating Characters
 * ������ֻ����������Ҫά��һ���ֵ䣬Ȼ��֤Ŀǰ�Ĵ������ֵ�����ĵ������ҽ���һ�Ρ�
 * ˼·��Ȼ��ά��һ�����ڣ������ǰ�������ֵ��У�������ƶ������Ҷˣ����򴰿���˿��������ַ���
 * ��һ�������ˡ�����Դ�ַ����ĳ���Ϊn���ֵ��е��ʵĳ���Ϊl����Ϊ����һ���ַ���
 * ����������Ҫ��Դ�ַ������г���Ϊl���Ӵ������жϡ�������i��0��l-1���ַ���ʼ��
 * �õ���ʼindex�ֱ�Ϊi, i+l, i+2*l, ...�ĳ���Ϊl�ĵ��ʡ������Ϳ��Ա�֤�жϵ����е����������Ĵ���
 * ��Ϊÿ��ɨ���ʱ�临�Ӷ���O(2*n/l)(ÿ�����ʲ��ᱻ���ʶ������Σ�һ���Ǵ����Ҷˣ�һ���Ǵ������)��
 * �ܹ�ɨ��l�Σ�i=0, ..., l-1)�������ܸ��Ӷ���O(2*n/l*l)=O(n)����һ�������㷨��
 * �ռ临�Ӷ����ֵ�Ĵ�С����O(m*l)������m���ֵ�ĵ����������������£�*/
//�����ƶ����ڵķ������ַ�������������зǳ���������һ�ֿ��԰�ʱ�临�ӶȽ��͵����Ե���Ч�㷨����ҿ�����Ϥһ�¡�
//���зǳ����Ƶ���ĿMinimum Window Substring��˼·��ȫһ����ֻ���ƶ����ڵĹ�����΢��ͬ���ѡ�
public class SubstringwithConcatenation {

	
	    public ArrayList<Integer> findSubstring(String S, String[] L) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(S==null || S.length()==0 || L==null || L.length==0)
	        return res;
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    for(int i=0;i<L.length;i++)
	    {
	        if(map.containsKey(L[i]))
	        {
	            map.put(L[i],map.get(L[i])+1);
	        }
	        else
	        {
	            map.put(L[i],1);
	        }
	    }
	    for(int i=0;i<L[0].length();i++)
	    {
	        HashMap<String,Integer> curMap = new HashMap<String,Integer>();
	        int count = 0;
	        int left = i;
	        for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())
	        {
	            String str = S.substring(j,j+L[0].length());
	            
	            if(map.containsKey(str))
	            {
	                if(curMap.containsKey(str))
	                    curMap.put(str,curMap.get(str)+1);
	                else
	                    curMap.put(str,1);
	                if(curMap.get(str)<=map.get(str))
	                    count++;
	                else
	                {
	                    while(curMap.get(str)>map.get(str))
	                    {
	                        String temp = S.substring(left,left+L[0].length());
	                        curMap.put(temp,curMap.get(temp)-1);
	                        if(curMap.get(temp)<map.get(temp))
	                            count--;
	                        left += L[0].length();
	                    }
	                }
	                if(count == L.length)
	                {
	                    res.add(left);
	                    //if(left<)
	                    String temp = S.substring(left,left+L[0].length());
	                    curMap.put(temp,curMap.get(temp)-1);
	                    count--;
	                    left += L[0].length();
	                }
	            }
	            else
	            {
	                curMap.clear();
	                count = 0;
	                left = j+L[0].length();
	            }
	        }
	    }
	    return res;
	}  
	    }
