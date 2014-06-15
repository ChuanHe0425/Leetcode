package algorithm.sort;

public class reverseWord {
    public String reverseWords(String s) {
    if(s == null && s.length() == 0) return "";
    StringBuilder sb = new StringBuilder();
    int end = s.length();
    for(int i = end - 1; i >=0; i--){
        if(s.charAt(i)== ' ' ){
            sb.append(s.substring(i+1,end));
            
        }
    }
    return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);  
    }
}
