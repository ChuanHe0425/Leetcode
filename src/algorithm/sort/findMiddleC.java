package algorithm.sort;

public class findMiddleC {
	



		public static void main(String args[]){

int a = 7 , b = 12 , c = -9;
int mid = findMiddle(a,b,c);
		System.out.print("The midde is " + mid);

		}

		private static int findMiddle(int a, int b, int c) {
		if(((a-b)*(a-c))<0) return a;

		if(((c-b)*(c-a))<0) return c;

		if(((b-a)*(b-c))<0) return b;



		return 0;

		}

		}

