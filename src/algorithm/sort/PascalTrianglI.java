package algorithm.sort;

public class PascalTrianglI {

/*For each iteration, replace the i-th element with
 *  the sum of i-th and i+1-th elements.
 *   
 *  (Notice that the k-th element in the k-th iteration will not be replaced.) 
 * 
 *  At the end of the iteration, add 1 in front of the arraylist by calling ans.add(0, 1).

	After k iterations, we will get the result.

	This algorithm is almost the same with 'Pascal's Triangle'. The only difference is I replaced the elements in space.(because the question only asks for the k-th row instead of the whole triangle*/

	    public ArrayList<Integer> getRow(int rowIndex) {
	        
	     ArrayList<Integer> ans = new ArrayList<Integer>();

	    for(int j=0;j<=rowIndex;j++){

	        for(int i=1;i<ans.size();i++){

	            ans.set(i-1, ans.get(i-1)+ans.get(i));

	        }

	        ans.add(0,1);

	    }

	    return ans;

	}
	}


