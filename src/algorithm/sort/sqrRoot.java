package algorithm.sort;

public class sqrRoot {

//二分法Dichotomy和牛顿迭代法Newton iterative method
	//http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
	    public int sqrt(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        long low = 0, high = x;
	        long mid;
	        while(low <= high){
	            mid = (low+high)/2;
	            if(mid*mid == x) return (int)mid;
	            else if(mid*mid < x) low = mid+1;
	            else high = mid-1;
	        }
	        mid = (low+high)/2;
	        return (int)mid;
	    }
	}