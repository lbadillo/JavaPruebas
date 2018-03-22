package PruebaMain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LotteryTicket {

	public static void main(String[] args) {
		
		System.out.println(winningLotteryTicket(readExample()));
	}

	static String[] readExample() {
		ClassLoader loader = PruebaMain.class.getClassLoader();
		String[] l = new String[100000];
		String filepath = loader.getResource("lottery.txt").getPath();
		try {
			FileInputStream fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;

			int i = 0;
			while ((strLine = br.readLine()) != null) {
				l[i] = strLine;
				i++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return l;

	}

	static long winningLotteryTicket(String[] tickets) {
		long res = 0;
		long restmp = 0;
		int ini = tickets.length;
		int i = 1022, j;
		long[] valuesBit = getAllBitChar(tickets);
		res = getPerm(ini, valuesBit[1023]);
		while (i >= 0) {
			restmp = 0;
			for (j = i-1; j >= 0; j--) {
				if ((i | j) == 1023 && valuesBit[j] > 0) {
					restmp+= (valuesBit[j]*valuesBit[i]);
				}
			}
			res += restmp;
			i--;
		}
		
		return res;
	}

	static long[] getAllBitChar(String[] tickets) {
		long[] valuesBit = new long[1024];
		for (String line : tickets) {
			valuesBit[getShort(line)]++;
		}
		
		
		return valuesBit;

	}

	static long getPerm(long total, long ocu) {
		long res = 0;
		long i = (total - ocu);
		while (i < total) {
			res += i;
			i++;
		}
		return res;

	}

	static int getShort(String number) {
		int res = 0;
		int exp = 0;
		int exp2 = 0;
		for (int i = 9; i >= 0; i--) {
			if (number.contains(i + "")) {
				exp = (int) Math.pow(2, exp2);
				res += exp;
			}
			exp2++;
		}
		return res;

	}

}
