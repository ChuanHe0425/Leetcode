package algorithm.sort;

public class Combination {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    
    // Start typing your Java solution below  
    // DO NOT write main() function  
    ArrayList<ArrayList<Integer>> rel = new ArrayList<ArrayList<Integer>>();    
    ArrayList<Integer> temp = new ArrayList<Integer>();    
      
    subsetsRec(rel, temp, n, k, 0);     
        
    return rel;    
}  
  
private void subsetsRec(ArrayList<ArrayList<Integer>> rel, ArrayList<Integer> temp, int n, int k, int level){  
    if(temp.size() == k) {  
        rel.add(new ArrayList<Integer>(temp) );  
        return;  
    }  
      
    for(int i=level; i<n; i++) {  
        temp.add( i+1 );  
          
        subsetsRec(rel, temp, n, k, i+1);  
          
        temp.remove(temp.size() -1);  
    }  
}  
//===================================================================
/* Ë®Ó¡ÈËÉú
Use iterations to generate different levels of solutions. 
The first level solution is the set of all first numbers in the final
 solution is {1,2,...,n-k+1}. To avoid duplicates, for the next level, 
 always add a larger number to the element in current level. */
public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(k==0) return res;
    res.add(new ArrayList<Integer>());
    for(int i=0;i<k;i++){
         ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
         for(ArrayList<Integer> temp:res){
            int a=0;
            if(temp.size()>0)
                a=temp.get(temp.size()-1);
            for(int j=a+1;j<=n-k+1+i;j++){
                ArrayList<Integer> b= new ArrayList<Integer>(temp);
                b.add(j);
                prev.add(b);
            }
         }
        res = new ArrayList<ArrayList<Integer>>(prev);
    }
    return res;
}


} 