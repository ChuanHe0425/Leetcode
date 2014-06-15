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
		int wordsLen = words.length;	// 单词数组的长度
		int curWordIdx = 0;		// 处理第i个单词
		while(curWordIdx < wordsLen){		// 处理完所有单词后退出
			int charLen = 0;  // 当前行累积的字符数量
			int probeWordIdx = curWordIdx;
			while(probeWordIdx<wordsLen && charLen+words[probeWordIdx].length()<=L){	// 贪婪加入尽可能多的单词
				charLen += ((words[probeWordIdx++]).length()+1);		// 累积单词长度和至少要有一个空格
			}
			if(probeWordIdx-curWordIdx == 1){		// tmpWordIdx-curWordIdx: 该行放入单词的数目，如果只有一个单词要特殊处理
				String tmp = words[curWordIdx];	// 唯一的那个单词
				tmp = addSpace(tmp, L-words[curWordIdx].length());	// 那个单词后面都接上空格
				ret.add(tmp);
				curWordIdx = probeWordIdx;		// 更新curWordIdx，因为已经处理好当前行了
				continue;
			}
			
			// tmpWordIdx-curWordIdx: 该行放入单词的数目，也就是紧接的空格的数量（因为每个单词后接一个空格）
			// wordCharLen：当前行所有由单词组成的字符数量（不包括空格）
			int wordCharLen = charLen - (probeWordIdx-curWordIdx);		
			//meanSpace: 平均每个单词后的空格,tmpWordIdx<wordsLen 表示不是最后一行
			int meanSpace = probeWordIdx<wordsLen ? (L-wordCharLen)/(probeWordIdx-curWordIdx-1) : 1;
			//leftSpace: 多余的空格
			int leftSpace = probeWordIdx<wordsLen ? (L-wordCharLen)%(probeWordIdx-curWordIdx-1) : L-wordCharLen-(probeWordIdx-curWordIdx-1);
			String tmp = new String();
			for(int k=curWordIdx; k<probeWordIdx-1; k++){	// 对当前行最后一个单词特殊处理
				tmp += words[k];
				tmp = addSpace(tmp, meanSpace);
				if(probeWordIdx<wordsLen && leftSpace>0){	// 因为居中对齐
					tmp += " ";
					leftSpace--;
				}
			}
			tmp += words[probeWordIdx-1];		// 处理当前行的最后一个单词
			if(leftSpace > 0){		// 因为左对齐，所以在最后补上剩下的空格
				tmp = addSpace(tmp, leftSpace);
			}
			ret.add(tmp);
			curWordIdx = probeWordIdx;		// 处理下一行的要处理的单词
		}
		return ret;
	}
	
	public static String addSpace(String s, int count){
		for(int i=1; i<=count; i++){
			s += " ";
		}
		return s;
	}

//===============水印人生=====================

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

	