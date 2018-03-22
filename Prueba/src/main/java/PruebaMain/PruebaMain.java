package PruebaMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PruebaMain {

	public static void main(String[] args) {
		PruebaMain p = new PruebaMain();
		ClassLoader loader = PruebaMain.class.getClassLoader();
	
		String filepath = loader.getResource("ejemplo.txt").getPath();
	
		try {
			FileInputStream fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			ArrayList<String> l = new ArrayList<String>();

			// Read File Line By Line

			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				l.add(strLine);
			}
			br.close();
			p.printNodeDegrees(l);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printNodeDegrees(List<String> values) {
		int[] f = new int[Integer.parseInt(values.get(0))];
		int key = 0, i = 0;
		String[] val;
		for (String a : values) {
			if (i > 0) {
				val = a.split(" ");
				key = Integer.parseInt(val[0]) - 1;
				f[key] = f[key] + 1;
				key = Integer.parseInt(val[1]) - 1;
				f[key] = f[key] + 1;
			}
			i++;

		}
		i = 0;
		for (int repeat : f) {
			System.out.println("Node " + (i + 1) + " Has a degree of " + repeat);
			i++;

		}
	}

	/*
	 * *************************************************************************
	 * **************
	 * 
	 * public static void main(String[] args){ PruebaMain pr= new PruebaMain();
	 * int[] f = new int[Integer.parseInt(args[0])];
	 * System.out.println(f.length); ArrayList<Integer> l = new
	 * ArrayList<Integer>(); l.add(new Integer("1")); l.add(new Integer("2"));
	 * l.add(new Integer("2")); l.add(new Integer("9")); l.add(new
	 * Integer("1")); l.add(new Integer("6"));
	 * 
	 * pr.printDuplicatedIndexes(l); }
	 * 
	 * public void printDuplicatedIndexes(List<Integer> values) { //{1,3,5,1,6}
	 * //1->0,3 Map<Integer, List<Integer>> totalValues = new HashMap();
	 * ArrayList<Integer> rep = new ArrayList<Integer>(); int i=0; for (Integer
	 * a: values){
	 * 
	 * if(totalValues.containsKey(a)){ rep =
	 * (ArrayList<Integer>)totalValues.get(a); rep.add(new Integer(i));
	 * totalValues.put(a, rep); } else{ rep = new ArrayList<Integer>();
	 * rep.add(new Integer(i)); totalValues.put(a, rep); } i++; } i=0; for(
	 * Integer val: totalValues.keySet()){ ArrayList<Integer> ltmp =
	 * (ArrayList<Integer>) totalValues.get(val); if (ltmp.size()>1)
	 * System.out.println(val.intValue()+ ":"+ltmp.toString());
	 * //System.out.println("Repeticiones:"+totalValues.get(values.get(i))); } }
	 * 
	 */

}
