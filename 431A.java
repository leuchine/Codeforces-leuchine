

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String weightLine = scan.nextLine();
		String sequence = scan.nextLine();
		String[] w = weightLine.split(" ");
		int[] weight = new int[4];
		for (int i = 0; i < 4; i++) {
			weight[i] = Integer.parseInt(w[i]);
		}
		long sum = 0;
		for (int i = 0; i < sequence.length(); i++) {
			switch (sequence.charAt(i)) {
			case '1':
				sum = sum + weight[0];
				break;
			case '2':
				sum = sum + weight[1];
				break;
			case '3':
				sum = sum + weight[2];
				break;
			case '4':
				sum = sum + weight[3];
				break;
			}
		}
		System.out.println(sum);
	}
}
