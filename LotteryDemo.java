package lottery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LotteryDemo {

	public static void main(String[] args) {
		int[] arr= {2,8,15,26,32,39,46,48};
		
		CombinationCalculator.findAllCombination(arr);
		
		File file =new File("D://LotterySystem.txt");
		
		CombinationCalculator.checkForEven(file,1);
		
//		Scanner in;
//		try {
//			in = new Scanner(file);
//			int[] lotteryComb=new int[6];
//			String num;
//			num=in.next();
//			lotteryComb[0]=in.nextInt();
//			lotteryComb[1]=in.nextInt();
//			lotteryComb[2]=in.nextInt();
//			lotteryComb[3]=in.nextInt();
//			lotteryComb[4]=in.nextInt();
//			lotteryComb[5]=in.nextInt();
//			
//			System.out.println(num);
//			System.out.println(lotteryComb[0]);
//			System.out.println(lotteryComb[1]);
//			System.out.println(lotteryComb[2]);
//			System.out.println(lotteryComb[3]);
//			System.out.println(lotteryComb[4]);
//			System.out.println(lotteryComb[5]);
//			System.out.println(in.next());
//			System.out.println(in.next());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
