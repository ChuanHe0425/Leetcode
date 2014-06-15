package algorithm.sort;

public class BuyandSellc {

	    public int maxProfit(int[] prices) {
	      int min = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	        int [] forward = new int[prices.length], 
	               backward = new int[prices.length];
	        
	        for(int i=0;i<prices.length;i++){
	            if(prices[i]>min){
	                forward[i]=Math.max(prices[i]-min,forward[i-1]);
	            }else{
	                if(i>0) forward[i]=forward[i-1];
	            }
	            min=Math.min(prices[i],min);
	            
	            if(prices[prices.length-1-i]<max){
	                backward[prices.length-1-i]=Math.max(max-prices[prices.length-1-i],backward[prices.length-i]);
	            }else{
	               if(i>0) backward[prices.length-1-i]=backward[prices.length-i];
	            }
	            max=Math.max(prices[prices.length-1-i],max);
	        }
	        
	        int res = 0;
	        
	        for(int i=0;i<prices.length;i++){
	            res=Math.max(forward[i]+backward[i],res);
	        }
	        return res;
	    }
	}
	  
	    
	    