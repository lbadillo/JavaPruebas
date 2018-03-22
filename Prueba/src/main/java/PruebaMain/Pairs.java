package PruebaMain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {

		System.out.println(readExample());
	}

	static int readExample() {
		int[] arr = null;
		int res = 0;
		try {
			ClassLoader loader = Pairs.class.getClassLoader();
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new FileReader(loader.getResource("pares.txt").getPath()));
			int n = in.nextInt();
			int k = in.nextInt();
			arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			System.out.println("Empieza: " + new Date());
			res = pairs(k, arr);
			System.out.println("Termina: " + new Date());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return res;

	}

	static int pairs(int k, int[] arr) {
		int i = arr.length - 1;
		int j;
		int res = 0;
		int vtmp = 0;
		boolean sig = true;
		Arrays.sort(arr);
		while (i >= 0) {
			if (arr[i] >= k) {
				j = i;
				while (sig && j >= 0) {
					vtmp = solveMeFirst(arr[i], arr[j]);
					if (vtmp > k) {
						sig = false;
					} else if (vtmp == k) {
						res++;
						sig = false;
						j = -2;
					}
					j--;
				}
				sig = true;
				i--;
			} else
				i = -2;
		}
		return res;

	}

	static int solveMeFirst(int x, int y) {
		return x - y;
	}

}
