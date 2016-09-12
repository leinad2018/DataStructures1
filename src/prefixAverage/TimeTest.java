package prefixAverage;

import java.util.Scanner;

public class TimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter n");
		int n = input.nextInt();
		double[] test = new double[n];
		for(int i  = 0; i < test.length; i ++){
			test[i] = i * 100;
		}
		double startTime = System.currentTimeMillis();
		PrefixAverage.prefixAverage1(test);
		double endTime = System.currentTimeMillis() ;
		System.out.println(endTime - startTime + " Test 1");
		
		startTime = System.currentTimeMillis() ;
		PrefixAverage.prefixAverage2(test);
		endTime = System.currentTimeMillis() ;
		System.out.println(endTime - startTime + " Test 2");
		
	}
}
