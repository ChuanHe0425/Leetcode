package algorithm.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
public class FourSum {

	 
	   public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		   Arrays.sort(num);
		   
			HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 
			for (int i = 0; i < num.length; i++) {
				for (int j = i + 1; j < num.length; j++) {
					int k = j + 1;
					int l = num.length - 1;
		 
					while (k < l) {
						int sum = num[i] + num[j] + num[k] + num[l];
		 
						if (sum > target) {
							l--;
						} else if (sum < target) {
							k++;
						} else if (sum == target) {
							ArrayList<Integer> temp = new ArrayList<Integer>(null);
							temp.add(num[i], sum);
							temp.add(num[j], sum);
							temp.add(num[k], sum);
							temp.add(num[l], sum);
		 
							if (!hashSet.contains(temp)) {
								hashSet.add(temp);
								result.add(temp);
							}
		 
							k++;
							l--;
						}
					}
				}
			}
		 
			return result;
		}
}