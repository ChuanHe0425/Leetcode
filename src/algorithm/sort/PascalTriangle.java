package algorithm.sort;

public class PascalTriangle {
	/*[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

		    public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        
	      ArrayList<ArrayList<Integer>> triangleContain = new ArrayList<ArrayList<Integer>>();
	        if(numRows == 0){
	            return (triangleContain);
	        }
	        
	        ArrayList<Integer> level1 = new ArrayList<Integer>();
	        level1.add(new Integer(1));
	        triangleContain.add(level1);
	        if(numRows == 1){
	            return triangleContain;
	        }
	        
	        ArrayList<Integer> level2 = new ArrayList<Integer>();
	        level2.add(new Integer(1));
	        level2.add(new Integer(1));
	        triangleContain.add(level2);
	        if(numRows == 2){
	            return triangleContain;
	        }
	        
	       if(numRows > 2){
	            for(int i = 2; i < numRows; i++){
	                ArrayList<Integer> list = new ArrayList<Integer>();
	                list.add(new Integer(1));
	               for(int j = 0; j < i - 1; j++){
	                    Integer value1 = triangleContain.get(i - 1).get(j); 
	                    Integer value2 = triangleContain.get(i - 1).get(j + 1);
	                    int value = value1.intValue() + value2.intValue();
	                    list.add(new Integer(value));
	                } 
	                  list.add(new Integer(1));
	                  triangleContain.add(list);
	            }
	        }
	    
	        return triangleContain;
	    }
	}



