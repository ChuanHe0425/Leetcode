import java.util.Arrays;

/*Given a set of distinct integers, S, return all possible subsets.

Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.

For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]

Solve the problem on leetcode

分析：

这道题是要求生成所有子集，那么首先我们有一个能返回所有子集的ArrayList res, 和一个临时变量ArrayList tmp, 当tmp满足一定条件的时候，往res里面添加结果

Subset这道题的条件比较直观，就是每当我们添加了一个元素，都是一个新的子集。那么我们怎么保证不会出现重复集合呢。我们引入一个int pos用来记录此子集的起点在哪，比如当pos = 1的时候就是从第二个元素往后循环添加元素（0 base）,每次当此层用了第i个元素，那么下一层需要传入下一个元素的位置i+1 除此之外，当循环结束要返回上一层dfs的时候我们需要把这一层刚添加元素删去。

比如输入集合为［1，2，3］应当是这么运行，

[]

[1]

[1,2]

[1,2,3] //最底层子循环到头返回删去3，上一层的子循环也到头删去2

          //而此时，这一层循环刚到2，删去后还可以添加一个3

[1,3] //删除3，删除1

[2]

[2,3] //删除3，删除2

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

/*几点注意的地方

1. 结果要求生成升序排列，所以最开始的时候我们需要Sort一下

2. 往res里面添加的时候要 new ArrayList(tmp);

3. 别忘了空集也是子集*/

///====================================================
/*分析：

这一题是上面Subset I的延伸，在这一题种，输入集合有重复的元素了，但是要求输出结果不能有重复的Set

例如，假设集合为［2，3，3］，如果按照Subset I的程序不做改动，会出现什么情况呢

[]

[2]

[2,3]

[2,3,3]

[2,3] //把最后一个3删去，再把倒数第二个3删去，此时集合剩下［2］，此层的循环还没完，
还可以取最后一个，3，所以生成了重复的集合［2，3］

[3]

[3,3]

[3] //同理，把最后一个3删去，再把倒数第二个3删去，第一层循环还可以取最后一个数3，
所以生成了重复的集合[3]
那么，我们需要做的是，在删去元素后，再取元素的时候，不要取和刚刚取过的元素相等的元素 
即加上这么一条语句
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
             while(i<num.length-1 && num[i]==num[i+1]) i++;   //唯一的区别就在这一行  
         }  
     }  

}
/*几点注意的地方：

1. 有一次写错写成 while(i < num.length-1) if(num[i] == num[i+1]) i++; 所犯的问题是如果发现不等了，它会死循环在这个while里面

2. i < num.length - 1 i 不能取最后一个元素，因为在判断里有num[i+1] 会溢出*/




	