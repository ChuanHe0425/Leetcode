package algorithm.sort;

public class BuyangSellb {

	public int maxProfit(int[] prices) {
	     int base = Integer.MAX_VALUE, profit=0;
	        for(int i=0;i<prices.length;i++){
	            if(prices[i]>base){
	                profit+=prices[i]-base;
	            }
	            base=prices[i];
	        }
	        return profit;
	    }
	}
	   
	    