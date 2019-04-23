package lottery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CombinationCalculator {
	
	public void findAllCombination(int[] arr) {
		try(PrintWriter pw=new PrintWriter(new FileOutputStream("D://LotterySystem.txt"),true)){
			int n=arr.length-1;
			int v=1;
			for(int i = 0;i<=n-5;i++) {
				for(int j=i+1;j<=n-4;j++) {
					for(int x=j+1;x<=n-3;x++) {
						for (int y=x+1;y<=n-2;y++) {
							for(int z=y+1;z<=n-1;z++) {
								for(int c=z+1;c<=n;c++) {
									pw.print(v+". ");
									pw.print(arr[i]+" ");
									pw.print(arr[j]+" ");
									pw.print(arr[x]+" ");
									pw.print(arr[y]+" ");
									pw.print(arr[z]+" ");
									pw.print(arr[c]+" ");
									pw.println();
									v++;
								}
							}
						}
					}
				}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * filter for group of six with maximum 4 odd numbers 
	 * @param file with group of six numbers
	 */
	public void checkForEven(File file) {
		
	}
	/**
	 * filter for group of six with maximum 4 odd numbers 
	 * @param file with group of six numbers
	 */
	public void checkForOdd(File file) {
		
	}
	/**
	 * filter which catch if the group of six contains three (or more) numbers in a row
	 * @param file with group of six numbers
	 */
	public void checkForNumInRow(File file) {
		
	}
	
	public void filterForDecade(File file) {
		
	}
}
