import java.util.Arrays;

/*Given a set of distinct integers, S, return all possible subsets.

Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]

Solve the problem on leetcode

������

�������Ҫ�����������Ӽ�����ô����������һ���ܷ��������Ӽ���ArrayList res, ��һ����ʱ����ArrayList tmp, ��tmp����һ��������ʱ����res������ӽ��

Subset�����������Ƚ�ֱ�ۣ�����ÿ�����������һ��Ԫ�أ�����һ���µ��Ӽ�����ô������ô��֤��������ظ������ء���������һ��int pos������¼���Ӽ���������ģ����統pos = 1��ʱ����Ǵӵڶ���Ԫ������ѭ�����Ԫ�أ�0 base��,ÿ�ε��˲����˵�i��Ԫ�أ���ô��һ����Ҫ������һ��Ԫ�ص�λ��i+1 ����֮�⣬��ѭ������Ҫ������һ��dfs��ʱ��������Ҫ����һ������Ԫ��ɾȥ��

�������뼯��Ϊ��1��2��3��Ӧ������ô���У�

[]

[1]

[1,2]

[1,2,3] //��ײ���ѭ����ͷ����ɾȥ3����һ�����ѭ��Ҳ��ͷɾȥ2

          //����ʱ����һ��ѭ���յ�2��ɾȥ�󻹿������һ��3

[1,3] //ɾ��3��ɾ��1

[2]

[2,3] //ɾ��3��ɾ��2

[3]


*/
public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {  
	       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	       ArrayList<Integer> tmp = new ArrayList<Integer>();  
	       Arrays.sort(S);  
	       res.add(tmp);  
	       dfs(res,tmp,S,0);  
	       return res;  
	    }  
	      
	    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){  
	        for(int i=pos; i<=S.length-1;i++){  
	            tmp.add(S[i]);  
	            res.add(new ArrayList<Integer>(tmp));  
	            dfs(res,tmp,S,i+1);  
	            tmp.remove(tmp.size()-1);  
	        }  
	    }  
	}  

/*����ע��ĵط�

1. ���Ҫ�������������У������ʼ��ʱ��������ҪSortһ��

2. ��res������ӵ�ʱ��Ҫ new ArrayList(tmp);

3. �����˿ռ�Ҳ���Ӽ�*/

///====================================================
/*������

��һ��������Subset I�����죬����һ���֣����뼯�����ظ���Ԫ���ˣ�����Ҫ���������������ظ���Set

���磬���輯��Ϊ��2��3��3�ݣ��������Subset I�ĳ������Ķ��������ʲô�����

[]

[2]

[2,3]

[2,3,3]

[2,3] //�����һ��3ɾȥ���ٰѵ����ڶ���3ɾȥ����ʱ����ʣ�£�2�ݣ��˲��ѭ����û�꣬
������ȡ���һ����3�������������ظ��ļ��ϣ�2��3��

[3]

[3,3]

[3] //ͬ�������һ��3ɾȥ���ٰѵ����ڶ���3ɾȥ����һ��ѭ��������ȡ���һ����3��
�����������ظ��ļ���[3]
��ô��������Ҫ�����ǣ���ɾȥԪ�غ���ȡԪ�ص�ʱ�򣬲�Ҫȡ�͸ո�ȡ����Ԫ����ȵ�Ԫ�� 
��������ôһ�����
 while(i < num.length-1 && num[i] == num[i+1]) i++;  */
public class Solution2{  
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        ArrayList<Integer> tmp = new ArrayList<Integer>();  
        Arrays.sort(num);  
        res.add(tmp);  
        dfs(res,tmp,num,0);  
        return res;  
     }  
       
     public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int pos){  
         for(int i=pos;i<=num.length-1;i++){  
             tmp.add(num[i]);  
             res.add(new ArrayList<Integer>(tmp));  
             dfs(res,tmp,num,i+1);  
             tmp.remove(tmp.size()-1);  
             while(i<num.length-1 && num[i]==num[i+1]) i++;   //Ψһ�����������һ��  
         }  
     }  

}
/*����ע��ĵط���

1. ��һ��д��д�� while(i < num.length-1) if(num[i] == num[i+1]) i++; ������������������ֲ����ˣ�������ѭ�������while����

2. i < num.length - 1 i ����ȡ���һ��Ԫ�أ���Ϊ���ж�����num[i+1] �����*/




	