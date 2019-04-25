package lottery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CombinationCalculator {
	public static File file =new File("D://LotterySystem.txt");
	public static File tempFile=new File("D://temp.txt");
	
	public static void findAllCombination(int[] arr) {
		try(PrintWriter pw=new PrintWriter(new FileOutputStream(file),true)){
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
			pw.print(-1);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * filter for group of six with maximum 4 odd numbers 
	 * @param file with group of six numbers
	 * @param int i is maximum number of even which want to have in every group of six
	 */
	
	public static void checkForEven(int maxEven) {
		try(Scanner in=new Scanner(file);PrintWriter pw=new PrintWriter(new FileOutputStream(tempFile),true)){
			int[] lotteryComb=new int[6];
			String num;
			int counter=0;
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				for(int i=0;i<lotteryComb.length;i++) {
					lotteryComb[i]=in.nextInt();
					if(lotteryComb[i]%2!=0) counter++;
				}
				if(counter<=maxEven) {
					for(int j=0;j<lotteryComb.length;j++) {
						pw.print(lotteryComb[j]+" ");
					}
					pw.println();
					counter=0;
				}
				else counter=0;
			}
			pw.print("-1");
			copyFile();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * filter for group of six with maximum 4 odd numbers 
	 * @param file with group of six numbers
	 */
	public static void checkForOdd(int maxOdd) {
		try(Scanner in=new Scanner(file);PrintWriter pw=new PrintWriter(new FileOutputStream(tempFile),true)){
			int[] lotteryComb=new int[6];
			String num;
			int counter=0;
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				for(int i=0;i<lotteryComb.length;i++) {
					lotteryComb[i]=in.nextInt();
					if(lotteryComb[i]%2==0) counter++;
				}
				if(counter<=maxOdd) {
					for(int j=0;j<lotteryComb.length;j++) {
						pw.print(lotteryComb[j]+" ");
					}
					pw.println();
					counter=0;
				}
				else counter=0;
			}
			pw.print("-1");
			copyFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * filter which catch if the group of six contains numbers in a row
	 * @param file with group of six numbers
	 */
	public static void checkForNumInRow(int maxNumRow) {
		try(Scanner in=new Scanner(file);PrintWriter pw=new PrintWriter(new FileOutputStream(tempFile),true)){
			int[] lotteryComb=new int[6];
			String num;
			int counter=0;
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				for(int i=0;i<lotteryComb.length;i++) {
					lotteryComb[i]=in.nextInt();
					if(i>=1 && lotteryComb[i]-lotteryComb[i-1]==1) counter++;
				}
				if(counter<=maxNumRow) {
					for(int j=0;j<lotteryComb.length;j++) {
						pw.print(lotteryComb[j]+" ");
					}
					pw.println();
					counter=0;
				}
				else counter=0;
			}
			pw.print("-1");
			in.close();
			copyFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * filter for checking if every group of six have max (param) number with in same decade
	 * @param maxSameDecade number for max value
	 */
	public static void filterForDecade(int maxSameDecade) {
		try(Scanner in=new Scanner(file);PrintWriter pw=new PrintWriter(new FileOutputStream(tempFile),true)){
			int[] lotteryComb=new int[6];
			int[] decades=new int[10];
			boolean higherToMax=false;//flag to check if numbers with same decade is more than value which allowed
			String num;
			//int counter=0;
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				for(int i=0;i<lotteryComb.length;i++) {
					lotteryComb[i]=in.nextInt();
				}
				for(int i=0;i<lotteryComb.length;i++) {
					decades[lotteryComb[i]/10]++;
				}
				for(int i=0;i<decades.length;i++) {
					if(decades[i]>maxSameDecade) {
						higherToMax=true;
					}
					decades[i]=0; //turn to zero the cells of array (counters)
				}
				if(!higherToMax) {
					for(int j=0;j<lotteryComb.length;j++) {
						pw.print(lotteryComb[j]+" ");
					}
					pw.println();
					//counter=0;
				}
				//else counter=0;
			}
			pw.print("-1");
			copyFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * filter for checking if every group of six have max (param) number with a same ending
	 * @param maxSameEnding number for max value
	 */
	public static void filterForEnding(int maxSameEnding) {
		try(Scanner in=new Scanner(file);PrintWriter pw=new PrintWriter(new FileOutputStream(tempFile),true)){
			int[] lotteryComb=new int[6];
			int[] decades=new int[10];
			boolean higherToMax=false;//flag to check if numbers with same decade is more than value which allowed
			String num;
			//int counter=0;
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				for(int i=0;i<lotteryComb.length;i++) {
					lotteryComb[i]=in.nextInt();
				}
				for(int i=0;i<lotteryComb.length;i++) {
					decades[lotteryComb[i]%10]++;
				}
				for(int i=0;i<decades.length;i++) {
					if(decades[i]>maxSameEnding) {
						higherToMax=true;
					}
					decades[i]=0; //turn to zero the cells of array (counters)
				}
				if(!higherToMax) {
					for(int j=0;j<lotteryComb.length;j++) {
						pw.print(lotteryComb[j]+" ");
					}
					pw.println();
				}
			}
			pw.print("-1");
			copyFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * print original txt file to console
	 */
	public static void printFile() {
		try(Scanner in=new Scanner(file)){
			String num;
		
			while(in.hasNext()){
				num=in.next();
				if(num.equals("-1")) break;
				System.out.print(num);
				for(int i=0;i<6;i++) {
					System.out.print(in.nextInt()+" ");
				}
				System.out.println();
			}
		}catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * copy filtering tempfile to original file 
	 */
	private static void copyFile() {
		 try{
			 
			 Path from = tempFile.toPath(); //convert from File to Path
			 Path to = Paths.get(file.getPath()); //convert from String to Path
			 Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);  
			// Files.copy( tempFile.toPath(), file.toPath() );
		        
		    }catch(IOException e3) {
		    	e3.printStackTrace();
		    }
		   
	}
}
