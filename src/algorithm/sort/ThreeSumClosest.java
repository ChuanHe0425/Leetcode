package algorithm.sort;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
 
		Arrays.sort(num);
 
		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int diff = Math.abs(sum - target);
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
 
		return result;
	}
//=======================================
//Ë®Ó¡ÈËÉú

    public int threeSumClosestB(int[] num, int target) {
    	int res = Integer.MAX_VALUE;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                int temp = target-(num[i]+num[j]);
                int start=j+1, end=num.length-1, mid=0;
                while(start<=end){
                    mid=(start+end)/2;
                    if(num[mid]==temp){
                        break;
                    }else if(num[mid]>temp){
                        end=mid-1;
                    }else if(num[mid]<temp){
                        start=mid+1;
                    }
                }
                if(start<=end){
                    start=mid;
                    end=mid;
                }
                //while(start==i || start==j)
                   // start++;
                while(end==i || end==j)
                    end++;
                if(start<num.length)
                    res=Math.abs(num[start]-temp)<Math.abs(res-target)||res==Integer.MAX_VALUE?num[start]-temp+target:res;
                if(end>0 && end<num.length)
                    res=Math.abs(num[end]-temp)<Math.abs(res-target)||res==Integer.MAX_VALUE?num[end]-temp+target:res;
            }
        }        
        return res;
    }
}

