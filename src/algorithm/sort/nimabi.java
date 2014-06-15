

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
		 ������Щinterval�������,�ϲ�[a, b]��[c, d]�����ȣ�������ĵ�һ����Ա���մ�С�������У�
		 a <= c����ˣ���Ҫ���ǵľ���b��c�Ĵ�С��ϵ��
				 ���b < c����ô��������ض����ص�����˺ϲ��Ľ������[a, b]��[c, d]��
				 ������ô��������ض��ص�����ʱ���ϲ��ĵ�һ����Ա����a���ڶ�����Ա����max(b, d)��
				 ��ôʣ�µ����������θ�interval������javaʵ���о���Ҫ��interval�Զ���һ��Comparator��
				 �����ǰ���ʼ������Ȼ�������ʼ����ͬ�Ͱ����������������㷨��������Ȼ������һ�����Ա�����
				 ʱ�临�Ӷ���O(nlogn+n)=O(nlogn)���ռ临�Ӷ���O(1)����Ϊ����Ҫ����ռ䣬ֻ�н�����Ŀռ䡣
				 �Զ���Comparator��ʱ����������Ҳ��Ҫ��ʵ�֣�����Ϥ�����ѻ���Ҫ��Ϥһ�¹���
				 LeetCode�й���interval����Ŀ����Insert Interval.
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
