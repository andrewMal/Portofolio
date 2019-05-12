package lottery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Generator for all possible combination for group of six 
 * you can also apply filter like to limit the number of even,odd,in a row...etc for your result
 * 
 * @author andreas
 * @version 0.2
 */
public class LotteryDemo {

	static Scanner in =new Scanner(System.in);
	static int[] userNums; //array for input numbers of user
	
	public static void main(String[] args) {
		try {
			doFindAllCombOtherNums();
			doAll();
		}catch(Exception e3) {
			e3.printStackTrace();
		}
		
		
		
	}
	/**
	 * method which call all the proxy methods
	 */
	public static void doAll() {
		int choice;
		try {
			do {
				printMenu();
				
				while(!in.hasNextInt()) {
					System.out.println("Please give a number (from 0 to 8)");
					in.next();
				}
				choice=in.nextInt();
				switch(choice) {
				case 0:in.close();System.out.println("Goodbye!!!");break;
				case 1:CombinationCalculator.printFile();break;
				case 2:doCheckForEven();break;
				case 3:doCheckForOdd();break;
				case 4:doCheckForNumInRow();break;
				case 5:doDecadeFilter();break;
				case 6:doEndingFilter();break;
				case 7:doFindAllCombAgain();break;
				case 8:doFindAllCombOtherNums();break;
				default:System.out.println("Please type a number from 0 to 8");
				}
				
			}while(choice!=0);
		}catch(InputMismatchException e4) {
			in.nextLine();
			System.out.println("Please give a number");
		}catch(FileNotFoundException e5) {
			System.out.println("The file not found");
		}
		
	}
	/**
	 * menu print 
	 */
	public static void printMenu() {
		System.out.println("******************** MENU ********************");
		System.out.println("Press (0) for EXIT ");
		System.out.println("Press (1) to print group of six in console");
		System.out.println("Press (2) to apply the Even filter(limit the number of even numbers for every group of six)");
		System.out.println("Press (3) to apply the Odd filter(limit the number of odd numbers for every group of six)");
		System.out.println("Press (4) to apply the NumInRow filter(limit the number of in a row numbers for every group of six");
		System.out.println("Press (5) to apply the SameDecades filter(limit the numbers which is in same decade for every group of six");
		System.out.println("Press (6) to apply the SameEnding filter(limit the numbers which have same ending for every group of six");
		System.out.println("Press (7) to deactivate the filters");
		System.out.println("Press (8) to generate group of six with other set of numbers");
	}
	//********************proxy methods
	
	/**
	 * proxy method which call checkForEven()
	 */
	public static void doCheckForEven(){
		try {
			System.out.println("Please give the max value of even number which you want for every group of six");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			int maxEven=in.nextInt();
			CombinationCalculator.oddEvenRowFilter(maxEven,1);
			System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * proxy method which call checkForOdd()
	 */
	public static void doCheckForOdd() {
		try {
			System.out.println("Please give the max value of odd number which you want for every group of six");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			int maxOdd=in.nextInt();
			CombinationCalculator.oddEvenRowFilter(maxOdd,2);
			System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * proxy method which call checkForNumInRow()
	 */
	public static void doCheckForNumInRow() {
		try {
			System.out.println("Please give the max numbers in a row which you want for every group of six");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			int maxInRow=in.nextInt();
			CombinationCalculator.oddEvenRowFilter(maxInRow,3);
			System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * proxy method which call filterForDecade()
	 */
	public static void doDecadeFilter() {
		try {
			System.out.println("Please give the max numbers in a same decade which you want for every group of six");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			int maxSameDecade=in.nextInt();
			CombinationCalculator.digitsFilters(maxSameDecade,1);
			System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
			doDecadeFilter();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * proxy method which call filterForEnding()
	 */
	public static void doEndingFilter() {
		try{
			System.out.println("Please give the max numbers with a same ending which you want for every group of six");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			int maxSameEnding=in.nextInt();
			CombinationCalculator.digitsFilters(maxSameEnding,2);
			System.out.println("The filter applied successfully, you can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
		}catch(FileNotFoundException e) {
			System.out.println("The file not found");
		}
		
	}
	/**
	 * proxy method which call findAllCombination()
	 */
	public static void doFindAllCombAgain() {
		CombinationCalculator.findAllCombination(userNums);
		System.out.println("The filters deactivated,you can check the groups of six in txt file or you can print in console");
	}
	/**
	 * proxy method which call findAllCombination()
	 */
	public static void doFindAllCombOtherNums() {
		try {
			int sizeOfArray;
			int insertion=0;
			System.out.println("You have to give 7 numbers at least from 1-49 with ascending order");
			System.out.println("How many numbers you want (Please type number)?");
			while(!in.hasNextInt()) {
				System.out.println("Please give a number...");
				in.next();
			}
			sizeOfArray=in.nextInt();
			while(sizeOfArray<6) {
				System.out.println("Please give number bigger than 6 ");
				sizeOfArray=in.nextInt();
			}
			userNums=new int[sizeOfArray];
			System.out.println("Please give "+sizeOfArray+" numbers from 1-49 with ascending order :");

			while(insertion<userNums.length) {
				while(!in.hasNextInt()) {
					System.out.println("Please give a number...");
					in.next();
				}
				int tempNum=in.nextInt();
				if (tempNum<50 && tempNum>0) {
					userNums[insertion]=tempNum;
					insertion++;
				}
				else System.out.println("The numbers must be from 1-49");
			}
			System.out.println("The numbers inserted successfully");
			CombinationCalculator.findAllCombination(userNums);
			System.out.println("You can check the groups of six in txt file or you can print in console");
		}catch(InputMismatchException e5) {
			in.nextLine();
			System.out.println("Please give a number");
		}
		
	}
	
}
