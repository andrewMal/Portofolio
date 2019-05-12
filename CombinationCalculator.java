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
	public static Scanner in;
	public static PrintWriter pw;
	
	/**
	 * @param arr its an array which contains the user's input of 
	 * calculate all the possible combination(group of six) from the user input 
	 */
	public static void findAllCombination(int[] arr) {
		try(PrintWriter pw=new PrintWriter(new FileOutputStream(file),true)){
			int n=arr.length-1;
			int v=1;
			for(int i = 0;i<=n-5;i++) {//iterate all the possible nums of first place
				for(int j=i+1;j<=n-4;j++) {//second
					for(int x=j+1;x<=n-3;x++) {//third
						for (int y=x+1;y<=n-2;y++) {
							for(int z=y+1;z<=n-1;z++) {
								for(int c=z+1;c<=n;c++) {
									pw.print(v+". ");//Enumerate the groups
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
	 * enable filters for odd,even or in a row numbers
	 * @param plenty is maximum number of even,odd or nums in a row which we want to have in every group of six
	 * @param option define which filter will applied 1 is for even 2 for odd and 3 for nums in a row
	 */
	public static void oddEvenRowFilter(int plenty,int option) throws IOException {
		in=new Scanner(file);
		pw=new PrintWriter(new FileOutputStream(tempFile),true);
		
		int[] lotteryComb=new int[6];//array which contains group of six
		String num;//nums from txt file 
		int counter=0;//counter to compare with a plenty
		int n=1;//Enumerate the groups of six
		while(in.hasNext()){
			num=in.next();//read the enum(1.,2.) or -1 
			if(num.equals("-1")) break;//the end of the file
			for(int i=0;i<lotteryComb.length;i++) {//read every number in line
				lotteryComb[i]=in.nextInt();
				if(option==1) {
					if(lotteryComb[i]%2==0) counter++;//even filter
				}
				else if(option==2) {
					if(lotteryComb[i]%2!=0) counter++;//odd filter
				}
				else{
					if(i>=1 && lotteryComb[i]-lotteryComb[i-1]==1) counter++;//num in row filter
				}
			}
			if(counter<=plenty) {//if this group fulfills the requirements write it
				pw.print(n+". ");
				for(int j=0;j<lotteryComb.length;j++) {
					pw.print(lotteryComb[j]+" ");
				}
				pw.println();
				counter=0;
				n++;
			}
			else counter=0;
		}
		pw.print("-1"); //write -1 in the of filtered txt file
		in.close();
		pw.close();
		copyFile();//copy filtered temp file in original file 
	}
	
	/**
	 * filter for checking if every group of six have max (param) number with a same ending
	 * @param plenty number for max value
	 */
	public static void digitsFilters(int plenty,int option) throws FileNotFoundException{
		
		in=new Scanner(file);
		pw=new PrintWriter(new FileOutputStream(tempFile),true);
		int[] lotteryComb=new int[6];//array which contains group of six
		int[] digits=new int[10];//group of decades or last digit
		boolean higherToMax=false;//flag to check if numbers with same decade is more than value which allowed
		String num;//nums from txt file 
		int n=1;//Enumerate the groups of six
		while(in.hasNext()){
			num=in.next();//read the enum(1.,2.) or -1 
			if(num.equals("-1")) break;//the end of the file
			for(int i=0;i<lotteryComb.length;i++) {//read every number in line
				lotteryComb[i]=in.nextInt();
			}
			for(int i=0;i<lotteryComb.length;i++) {
				if(option==1) {//decade filter
					digits[lotteryComb[i]/10]++;//counter for every decade
				}
				else {//last digit filter
					digits[lotteryComb[i]%10]++;
				}
			}
			for(int i=0;i<digits.length;i++) {
				if(digits[i]>plenty) higherToMax=true;//compare counter with input of user(plenty)
				
				digits[i]=0; //turn to zero the cells of array (counters)
			}
			if(!higherToMax) {//if isnt higher write the group in txt file
				pw.print(n+". ");
				for(int j=0;j<lotteryComb.length;j++) {
					pw.print(lotteryComb[j]+" ");
				}
				pw.println();
				n++;
			}
			higherToMax=false;
		}
		pw.print("-1");//write -1 in the of filtered txt file
		in.close();
		copyFile();//copy filtered temp file in original file 
		
	}
	/**
	 * print original txt file to console
	 */
	public static void printFile() throws FileNotFoundException{
		in=new Scanner(file);
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
		in.close();
	}
	/**
	 * copy filtering tempfile to original file 
	 */
	private static void copyFile(){
		 try{
			 
			 Path from = tempFile.toPath(); //convert from File to Path
			 Path to = Paths.get(file.getPath()); //convert from String to Path
			 Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);  
  
		    }catch(IOException e3) {
		    	e3.printStackTrace();
		    }catch(NullPointerException e4) {
		    	e4.printStackTrace();
		    }
		   
	}
}
