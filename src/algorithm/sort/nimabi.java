

public class nimabi {
	package algorithm.sort;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;


	import java.util.Comparator;

	

		/**
		 * Definition for an interval.
		 * public class Interval {
		 *     int start;
		 *     int end;
		 *     Interval() { start = 0; end = 0; }
		 *     Interval(int s, int e) { start = s; end = e; }
		 * }
		 假设这些interval是有序的,合并[a, b]和[c, d]，首先，将区间的第一个成员按照从小到大排列，
		 a <= c，因此，需要考虑的就是b和c的大小关系。
				 如果b < c，那么两个区间必定不重叠，因此合并的结果就是[a, b]和[c, d]。
				 否则，那么两个区间必定重叠，此时，合并的第一个成员就是a，第二个成员就是max(b, d)。
				 那么剩下的问题就是如何给interval排序，在java实现中就是要给interval自定义一个Comparator，
				 规则是按起始点排序，然后如果起始点相同就按结束点排序。整个算法是先排序，然后再做一次线性遍历，
				 时间复杂度是O(nlogn+n)=O(nlogn)，空间复杂度是O(1)，因为不需要额外空间，只有结果集的空间。
				 自定义Comparator有时候在面试中也会要求实现，不熟悉的朋友还是要熟悉一下哈。
				 LeetCode中关于interval的题目还有Insert Interval.
	*/
			
		    
		
			
			import java.util.ArrayList;
			import java.util.Collections;
			import java.util.Comparator;

			
			    
				
				public static void main(String args[]){
					
					
					Interval i1 = new Interval(1,3);
					Interval i2 = new Interval(2,6);
					Interval i3 = new Interval(8,10);
					Interval i4 = new Interval(15,18);
					ArrayList<Interval> al = new ArrayList<Interval>();
					al.add(i1);
					al.add(i2);
					al.add(i3);
					al.add(i4);
					System.out.println("before merge");
			        for(int i = 0 ; i< al.size();i++){
						
						System.out.println(al.get(i).start+" "+al.get(i).end);
						
						
					}
					
					ArrayList<Interval> res = merge(al);
					System.out.println("after merge");
					
					for(int i = 0 ; i< res.size();i++){
						
						System.out.println(res.get(i).start+" "+res.get(i).end);
					}
				}
				
				public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
			                Collections.sort(intervals, new Comparator<Interval>(){public int compare(Interval a, Interval b){return a.start>b.start?1:(a.start==b.start?0:-1);}});
			        
			        ArrayList<Interval> res = new ArrayList<Interval>();
			        
			        int i=0;
			        while(i<intervals.size()){
			            int j=i+1;
			            int end = intervals.get(i).end;
			            while(j<intervals.size() && end>=intervals.get(j).start){
			                end=Math.max(end, intervals.get(j).end);
			                j++;
			            }                
			            res.add(new Interval(intervals.get(i).start,end));
			            i=j;
			           
			        }
			        return res;
			    }
			}
