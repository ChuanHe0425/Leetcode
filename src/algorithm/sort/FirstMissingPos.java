package algorithm.sort;

public class FirstMissingPos {
/*�����Ҫ��������ʱ��ͳ����ռ䣬˼��������Counting sort�еķ�����
	���˽�����ѿ��Բμ�Counting sort - Wikipedia����Ȼ�����ö���ռ䣬
	�Ǿ�ֻ���������鱾����Counting sortһ�������������index����Ϊ���ֱ����������
	���������յ���˳�����ηŵ������С�����A[0]=1, A[1]=2, A[2]=3, ... , 
	����һ�����������ĸ�����Ԫ��Υ����A[i]=i+1��˵��i+1��������Ҫ��ĵ�һ��ȱʧ��������
	������Щ���ڷ�Χ�ڵ����֣����ǿ���ֱ������������˵������0�����߳������鳤�ȵ�������
	��Щ�����������ǵĴ𰸡�*/
	    public int firstMissingPositive(int[] A) {
	        
	    if (A == null || A.length == 0) return 1;  
	          
	        for (int i = 0; i < A.length; i++) {  
	            while (A[i] != i + 1) {  
	                //A[i] == A[A[i] - 1] handles the case where there are two identical values  
	                // like A = [1, 1]  
	                if (A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1]) 
	                	break;  
	                int temp = A[i];  
	                A[i] = A[temp - 1];  
	                A[temp -1]= temp;  
	            }  
	        }  
	          
	        for (int i = 0; i < A.length; i++) {  
	            if (A[i] != i + 1) {  
	                return i+1;  
	            }  
	        }  
	        return A.length + 1;          
	    }  
	}  
/*ʵ���л���Ҫע��һ��ϸ�ڣ����������ǰ����������Ӧ���±��Ѿ��Ƕ�Ӧ�����ˣ���ô����Ҳ��Ҫ������
��Ϊ�Ǹ�λ�õ������Ѿ�����Ҫ���ˣ���������һֱ���ؽ�������ѭ��������һ������ֻ��Ҫɨ���������飬
ʱ�临�Ӷ���O(2*n)=O(n)�������������鱾��ռ䣬ֻ��Ҫһ��������������Կռ临�Ӷ���O(1)��*/

