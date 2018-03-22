package PruebaMain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubArraySum {

	public static void main(String[] args) {
		ClassLoader loader = SubArraySum.class.getClassLoader();
		Scanner in;
		try {
			in = new Scanner(new FileReader(loader.getResource("subarray.txt").getPath()));
			int q = in.nextInt();
			for (int a0 = 0; a0 < q; a0++) {
				int n = in.nextInt();
				long m = in.nextLong();
				long[] a = new long[n];
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextLong();
				}
				long result = maximumSum(a, m);
				System.out.println(result);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static long maximumSum(long[] arr, long m) {
		int n = arr.length;
		long maxSum = 0;
		TreeSet<Long> prefix = new TreeSet<Long>();
		long currentSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum = (currentSum + arr[i] % m) % m;
			SortedSet<Long> set = prefix.tailSet(currentSum + 1);
			Iterator<Long> itr = set.iterator();
			if (itr.hasNext()) {

				maxSum = Math.max(maxSum, (currentSum - itr.next() + m) % m);
			}

			maxSum = Math.max(maxSum, currentSum);
			prefix.add(currentSum);
		}
		return maxSum;
	}

}
