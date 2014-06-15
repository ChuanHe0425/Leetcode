package algorithm.sort;
import java.util.ArrayList;
public class TextVerify {

	public static void main(String[] args) {
		 String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		 String[] words = {""};
//		 String[] words = {"What","must","be","shall","be."};
//		String[] words = { "" };
		int L = 16;
		System.out.println(fullJustify(words, L));
	}

	
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int wordsLen = words.length;	// ��������ĳ���
		int curWordIdx = 0;		// �����i������
		while(curWordIdx < wordsLen){		// ���������е��ʺ��˳�
			int charLen = 0;  // ��ǰ���ۻ����ַ�����
			int probeWordIdx = curWordIdx;
			while(probeWordIdx<wordsLen && charLen+words[probeWordIdx].length()<=L){	// ̰�����뾡���ܶ�ĵ���
				charLen += ((words[probeWordIdx++]).length()+1);		// �ۻ����ʳ��Ⱥ�����Ҫ��һ���ո�
			}
			if(probeWordIdx-curWordIdx == 1){		// tmpWordIdx-curWordIdx: ���з��뵥�ʵ���Ŀ�����ֻ��һ������Ҫ���⴦��
				String tmp = words[curWordIdx];	// Ψһ���Ǹ�����
				tmp = addSpace(tmp, L-words[curWordIdx].length());	// �Ǹ����ʺ��涼���Ͽո�
				ret.add(tmp);
				curWordIdx = probeWordIdx;		// ����curWordIdx����Ϊ�Ѿ�����õ�ǰ����
				continue;
			}
			
			// tmpWordIdx-curWordIdx: ���з��뵥�ʵ���Ŀ��Ҳ���ǽ��ӵĿո����������Ϊÿ�����ʺ��һ���ո�
			// wordCharLen����ǰ�������ɵ�����ɵ��ַ��������������ո�
			int wordCharLen = charLen - (probeWordIdx-curWordIdx);		
			//meanSpace: ƽ��ÿ�����ʺ�Ŀո�,tmpWordIdx<wordsLen ��ʾ�������һ��
			int meanSpace = probeWordIdx<wordsLen ? (L-wordCharLen)/(probeWordIdx-curWordIdx-1) : 1;
			//leftSpace: ����Ŀո�
			int leftSpace = probeWordIdx<wordsLen ? (L-wordCharLen)%(probeWordIdx-curWordIdx-1) : L-wordCharLen-(probeWordIdx-curWordIdx-1);
			String tmp = new String();
			for(int k=curWordIdx; k<probeWordIdx-1; k++){	// �Ե�ǰ�����һ���������⴦��
				tmp += words[k];
				tmp = addSpace(tmp, meanSpace);
				if(probeWordIdx<wordsLen && leftSpace>0){	// ��Ϊ���ж���
					tmp += " ";
					leftSpace--;
				}
			}
			tmp += words[probeWordIdx-1];		// ����ǰ�е����һ������
			if(leftSpace > 0){		// ��Ϊ����룬�����������ʣ�µĿո�
				tmp = addSpace(tmp, leftSpace);
			}
			ret.add(tmp);
			curWordIdx = probeWordIdx;		// ������һ�е�Ҫ����ĵ���
		}
		return ret;
	}
	
	public static String addSpace(String s, int count){
		for(int i=1; i<=count; i++){
			s += " ";
		}
		return s;
	}

//===============ˮӡ����=====================

    public ArrayList<String> fullJustify2(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = words.length, start=0;
        ArrayList<String> res = new ArrayList<String>();

        while(start<n){  
            int cur=start, 
                count=words[cur].length();
            StringBuilder s = new StringBuilder(words[cur]);
            while(count<=L && cur<n){
                cur++;
                if(cur<n) count+=1+words[cur].length();
            }
        
            if(cur<n){
                count-=1+words[cur].length();
                cur--;
                if(cur>start){
                int a = (L-count+cur-start)/(cur-start),
                    b = (L-count+cur-start)%(cur-start);
                for(int i=start+1;i<start+1+b;i++){
                    for(int j=0;j<a+1;j++)
                        s.append(" ");
                    s.append(words[i]);
                }
                for(int i=start+1+b;i<=cur;i++){
                    for(int j=0;j<a;j++)
                        s.append(" ");
                    s.append(words[i]);
                }}else{
                    for(int i=0;i<L-count;i++)
                     s.append(" ");
                } 
            }else{
                
                for(int i=start+1;i<cur;i++){
                    s.append(" ");
                    s.append(words[i]);
                } 
                for(int i=0;i<L-count;i++)
                     s.append(" ");
            }     
            start = cur+1;           
            res.add(s.toString());
        }
        return res;
        
    }
}

	