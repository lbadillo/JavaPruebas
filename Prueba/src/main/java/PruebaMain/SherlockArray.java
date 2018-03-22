package PruebaMain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SherlockArray {

	public static void main(String[] args) {
		readExample();
	}

	static void readExample() {

		try {
			ClassLoader loader = Pairs.class.getClassLoader();
			@SuppressWarnings("resource")
			//Scanner in = new Scanner(new FileReader("C:\\LBD\\sherlock.txt"));
			 Scanner in = new Scanner(new FileReader(loader.getResource("sherlock.txt").getPath()));
			int T = in.nextInt();
			for (int a0 = 0; a0 < T; a0++) {
				int n = in.nextInt();
				int[] a = new int[n];
				for (int a_i = 0; a_i < n; a_i++) {
					a[a_i] = in.nextInt();
				}
				String result = solve(a);
				System.out.println(result);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	

	static String solve(int[] a) {
		int dif = 0;
		int center, inf = 0, sup = a.length - 1;
		String res = "NO";
		if (a.length == 1)
			res = "YES";
		else {
			while (inf <= sup) {
				center = (sup + inf) / 2;
				dif = difTwoArrays(center, a);
				if (dif == 0) {
					res = "YES";
					inf = sup + 2;
				} else if (dif > 0) {
					sup = center - 1;

				} else {
					inf = center + 1;
				}

			}
		}

		return res;
	}

	static int difTwoArrays(int pointDiv, int[] arr) {
		int res1 = 0;
		int res2 = 0;
		int res = 0;
		if (arr.length == 2 || pointDiv == arr.length)
			res = 1;
		else {
			for (int i = 0; i < arr.length; i++) {
				if (i < pointDiv - 1)
					res1 += arr[i];
				else if (i > pointDiv - 1)
					res2 += arr[i];
			}
			res = res1 - res2;
		}
		return res;

	}

}
