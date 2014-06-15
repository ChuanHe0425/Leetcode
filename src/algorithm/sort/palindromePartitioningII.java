package algorithm.sort;
/*�����������������ַ������л��֣�Ҫ�󻮷ֺ�����е����ַ������ǻ��Ĵ�������С���ֵĸ�����
�����ڣ�LeetCode Word Break�� Ҳ�����ö�̬�滮��
����״̬���飺cut_num_array[s.length()+1]�����У�cut_num_array[i]����string[i..n]�ַ�����i��ʼ��ĩβ����С�������� 
״̬ת�Ʒ��̣� cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);  i<j<n
״̬ת�Ʒ��̵���˼�ǣ�string[i..j]��һ�������ַ��������Բ����ٻ��֡����Դ�i��ʼ��ĩβ��jΪ���ֵ����С������Ϊ�� cut_num_array[j+1]+1 �� cut_num_array[i]�е���Сֵ��
cut_num_array[i]�ĳ�ֵ��Ϊ��s.length() - i; Ҳ���ǰ����ַ����е�ÿ����ĸ�����������������㡣
�ж�string[i..j]��һ�����Ĵ�����LeetCode Palindrome Partitioning�еķ�������AC���롣
*/
public class palindromePartitioningII {
	public int minCut(String s) {
	     
        if(s==null||s.length()==0||s.length()==1) {
            return 0;
        }
        int[][] palindrome_map = new int[s.length()][s.length()];
        int[] cut_num_array = new int[s.length() + 1];
        
        for(int i=s.length()-1;i>=0;i--) {
            cut_num_array[i] = s.length() - i;
            for(int j=i;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<2||palindrome_map[i+1][j-1]==1) {
                        palindrome_map[i][j]=1;
                        cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);
                    }
                }
            }
            
        }
    
        return cut_num_array[0] - 1;
    }

}
