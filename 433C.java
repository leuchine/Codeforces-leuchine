import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] nums = scan.nextLine().split(" ");
		int n = Integer.parseInt(nums[0]);
		int m = Integer.parseInt(nums[1]);
		String[] ps = scan.nextLine().split(" ");
		int pages[] = new int[m];
		for (int i = 0; i < m; i++) {
			pages[i] = Integer.parseInt(ps[i]);
		}
		long sum = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(
				n + 1);
		for (int i = 0; i < n + 1; i++)
			list.add(new ArrayList<Integer>(50));
		for (int i = 1; i < m; i++) {
			sum = sum + Math.abs(pages[i] - pages[i - 1]);
			if (pages[i] == pages[i - 1])
				continue;
			list.get(pages[i]).add(pages[i - 1]);
			list.get(pages[i - 1]).add(pages[i]);
		}
		long delta = 0;
		for (int i = 1; i < n + 1; i++) {
			if (list.get(i).size() == 0)
				continue;
			ArrayList<Integer> current = list.get(i);
			Collections.sort(current);
			Integer median = current.get(current.size() / 2);
			long d = 0;
			for (int j = 0; j < current.size(); j++) {
				d = d + Math.abs(current.get(j) - median)
						- Math.abs(current.get(j) - i);
			}
			if (d < delta)
				delta = d;
		}
		System.out.println(sum + delta);
	}
}
