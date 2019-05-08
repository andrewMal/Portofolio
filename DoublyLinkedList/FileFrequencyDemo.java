package doublyLinkedList;

import java.io.File;
import java.io.FileReader;

public class FileFrequencyDemo {

	public static void main(String[] args) {
		try {
			File file=new File("D://data.txt");
			if(!file.exists()) {
				System.out.println("File not found");
				System.exit(-1);
			}
			FileReader in = new FileReader(file);
			DoublyList myList=new DoublyList();
			ListNode pivot=null;
			char ch;
			int intTemp;
			float totalChars = 0;
			while((intTemp=in.read())!=-1) {
				if(intTemp!=13) {
					ch=(char) intTemp;
					if(myList.charExists(ch, pivot)!=null) myList.increaseCharNum(myList.charExists(ch, pivot));
					else myList.insertLast(ch);
					totalChars++;
				}
				else in.read();
				
				
				//***************
			}
			
			
			
			System.out.println("---Sort by chars---");
			myList.bubbleChars();
			myList.traverse(totalChars);
			
			System.out.println();
			
			System.out.println("---Sort by frequency---");
			myList.bubbleFrequencies();
			myList.traverse(totalChars);
			
			in.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
