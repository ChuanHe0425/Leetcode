package algorithm.sort;

public class SingleNumeber3times {

		    public int singleNumber(int[] A) {
	        
	    
	        int once=0;  //save the bit only appears once
			int twice=0; //save the bit appears twice
			int xthree=0; //save the bit not appears three times
			for(int i=0;i<A.length;i++)
			{
				int val=A[i];
				twice = twice|(once&val);
				once = once^val; 

	                        //if both once and twice(once &twice) saved a certain bit,it means this bit appears three times.

	                       xthree=~(once&twice);
	                       //clear the bit locations which appear three times
	            once&=xthree;
				twice&=xthree;
			}
			return once;
	    }
	}

