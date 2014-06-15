package algorithm.sort;

public class BuyandSella {
	//use valuable min to record current min value, 
	//a valuable diff to record current max profits. see code below
//��¼֮ǰ�Ĺ�Ʊ���ֵ���жϽ��յĹ�Ʊֵ-֮ǰ�����ֵ�Ƿ������������
	//�������ֵ��
	public int maxProfit(int[] prices){
	     int min = prices[0], profit = 0;  
	        for (int i = 1; i < prices.length; i++) {  
	            profit = prices[i] - min > profit ? prices[i] - min : profit;  
	            min = prices[i] < min ? prices[i] : min;  
	        }  
	        return profit;  
	}
	//======================================
	public int maxProfit4(int[] prices) {
        if (prices==null||prices.length<2){
            return 0;
        }
      
       int min=Integer.MAX_VALUE;
       int diff=0;
       
       for (int i=0; i<prices.length; i++){
           if (prices[i]<min){
               min=prices[i];
           }    
           
           if (diff<prices[i]-min){
               diff=prices[i]-min;
           }
       }
       
       return diff;
       
    }
//==================================================
	public int maxProfit2(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
//==================================================
	public int maxProfit3(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length==0) return 0; 
        int min=prices[0], max=prices[0];
        int profit=0; 
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]>max)
            {
                max=prices[i];
            }
            if(prices[i]<min)
            {
                min=prices[i];
                max=prices[i]; 
            }
            profit=Math.max(profit, max-min);
        }
        return profit; 
    }
}

}
