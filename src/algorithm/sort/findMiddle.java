package algorithm.sort;


	import java.util.Arrays;
	import java.util.Scanner;

	public class findMiddle {	

		public static void main(String[] args) {

			final Scanner scanner = new Scanner(System.in);
			
			int[] ary= new int[3];
			
			System.out.print("Please input first digit: ");
			ary[0] = scanner.nextInt();

			System.out.print("Please input second digit: ");
			ary[1] = scanner.nextInt();
			
			System.out.print("Please input third digit: ");
			ary[2] = scanner.nextInt();
			
			Arrays.sort(ary);
			
			System.out.println("Min: " + ary[0]);
			System.out.println("Medium: " + ary[1]);
			System.out.println("Max: " + ary[2]);
		}

	}


