package algorithm.sort;
import java.util.ArrayList;
public class CombinationOfNUm {


    public ArrayList<String> letterCombinations(String digits) {
        char[][] table = {{},{'a','b','c'},{'d','e','f'},
        		{'g','h','i'},{'j','k','l'},{'m','n','o'},
        		{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        ArrayList<String> res = new ArrayList<String>();
        dfs(digits,table," ",res);
        return res;
    }
    
    public void dfs(String digits, char[][] table, String tmp, ArrayList<String> res){
        if (digits.length()==0){
            res.add(tmp);
            return;
        }
        for(int i=0; i<table[digits.charAt(0) - '0' - 1].length;i++)
            dfs(digits.substring(1),table,tmp+table[digits.charAt(0)-'0'-1][i],res);
    }
}
