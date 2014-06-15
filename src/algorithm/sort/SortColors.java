package algorithm.sort;

public class SortColors {
	public void sortColors(int[] A) {
        
	    
	    if(A == null || A.length == 0 || A.length == 1)
	    return;
	    int red = 0, white = 0, blue = 0;
	    for(int i = 0; i < A.length; i++) {
	    if(A[i] == 0)
	    red++;
	    else if(A[i] == 1)
	    white++;
	    else
	    blue++;
	    }
	    for(int i = 0; i < red; i++) 
	        A[i] = 0;
	        for(int i = red; i < red + white; i++)
	        A[i] = 1;
	        for(int i = red + white; i < A.length; i++)
	        A[i] = 2;
	    }
	
	//===========================================================

    public class Solution {
public void sortColors(int[] A) {
if(A == null || A.length == 0 || A.length == 1)
return;

// one-pass solution
int red = 0, blue = A.length - 1, tmp, i = 0;
// stop looping when current >= blue
while(i <= blue) {
            // if color is red, move to the front
            if(A[i] == 0) {
                // when cur > red, switch
            if(i > red) {
                    tmp = A[red];
                    A[red] = A[i];
                    A[i] = tmp;
                    red++;
            }
// when cur <= red, no need to switch, just move both to next
                else {
                    i++;
                    red++;
            }
        }
// if color is blue, move to the end
            else if(A[i] == 2) {
// when cur < blue, switch
            if(i < blue) {
                tmp = A[blue];
                A[blue] = A[i];
                A[i] = tmp;
                blue--;
        }
        // when cur >= blue, end the loop
            else {
            return;
        }
        }
        // if color is white, skip
        else {
            i++;
        }
    }

}
}
    }