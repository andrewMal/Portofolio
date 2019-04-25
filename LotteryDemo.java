package lottery;

import java.io.File;
import java.util.Scanner;

public class LotteryDemo {

	static Scanner in =new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] arr= {1,2,4,8,15,26,32,33,39,46,48};
		
		CombinationCalculator.findAllCombination(arr);
		
		//File file =new File("D://LotterySystem.txt");
		
		//CombinationCalculator.checkForEven(file,1);
		
		CombinationCalculator.checkForNumInRow(1);
		
		//CombinationCalculator.printFile(file);
		
		
	}
	
	public static void printMenu() {
		System.out.println("******************** MENU ********************");
		System.out.println("Press (0) for EXIT ");
		System.out.println("Press (1) for print group of six in console");
		System.out.println("Press (2) for apply the Even filter(limit the number of even numbers for every group of six)");
		System.out.println("Press (3) for apply the Odd filter(limit the number of odd numbers for every group of six)");
		System.out.println("Press (4) for apply the NumInRow filter(limit the number of in a row numbers for every group of six");
		System.out.println("Press (5) for apply the SameDecades filter(limit the numbers which is in same decade for every group of six");
		System.out.println("Press (6) for apply the SameEnding filter(limit the numbers which have same ending for every group of six");
	}
	
	public static void doCheckForEven() {
		System.out.println("Please give the max value of even number which you want for every group of six");
		int maxEven=in.nextInt();
		CombinationCalculator.checkForEven(maxEven);
		System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
	}
	
	public static void doCheckForOdd() {
		System.out.println("Please give the max value of odd number which you want for every group of six");
		int maxOdd=in.nextInt();
		CombinationCalculator.checkForOdd(maxOdd);
		System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
	}
	
	public static void doCheckForNumInRow() {
		System.out.println("Please give the max numbers in a row which you want for every group of six");
	}

	public static void doDecadeFilter() {
		System.out.println("Please give the max numbers in a same decade which you want for every group of six");
	}
	
	public static void doEndingFilter() {
		System.out.println("Please give the max numbers with a same ending which you want for every group of six");
	}
	
}
