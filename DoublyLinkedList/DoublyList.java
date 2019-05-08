package doublyLinkedList;

public class DoublyList {
	
	private ListNode head;
	private ListNode tail;
	int listSize = 0;
	
	public DoublyList() {
		this.head=null;
		this.tail=null;
	}
	
	public void insertFirst(char c) {
		ListNode  node = new ListNode();
		node.data=c;
		node.n++;
		node.next=head;
		node.prev=null;
		
		if(isEmpty()) {
			tail=node;
			head=node;
		}
		else head=node;
		
		listSize++;
	}
	//deference****************
	public void removeFirst() {
		if(isEmpty())System.out.println("The List is Empty");
		else {
			head=head.next;
			head.prev=null;
		}
		listSize--;
	}
	
	public void insertLast(char c) {
		if(isEmpty()) insertFirst(c);
		else {
			ListNode node = new ListNode();
			
			tail.next=node;
			
			node.data=c;
			node.n++;
			node.prev=tail;
			node.next=null;
			
			tail=node;
			
			listSize++;
		}
		
	}
	
	public void removeLast() {
		if(isEmpty()) System.out.println("The list is Empty");
		else if(head.next==null) removeFirst();
		else {
			tail=tail.prev;
			tail.next=null;
		}
		listSize--;
	}
	public ListNode charExists(char c,ListNode pivot) {
		boolean found=false;
		pivot=null;
		if(!isEmpty()) {
			ListNode node=head;
			while(!found && node!=null) {
				if(node.data==c) {
					found=true;
					pivot=node;
				}
				else node=node.next;
			}
		}
		return pivot;
	}
	
	public void traverse(float plentyChars) {
		for(ListNode i=head; i!=null; i=i.next) {
			if(!(i.data==' ')) System.out.print(i.data+" ");
			else System.out.print("space"+" ");
			System.out.printf("%.2f",(i.n/plentyChars)*100 );
			System.out.println(" %");
		}
	}
	//************
	public void increaseCharNum(ListNode listNode) {
		listNode.n++;
	}
	
	public void bubbleChars() {
		ListNode j=null;
		ListNode piv=null;
		char min;
		
		for(ListNode i=head; i!=null; i=i.next) {
			min= (char) 127;
			for(j=i;j!=null;j=j.next) {
				if(j.data<min) {
					min=j.data;
					piv=j;
				}
			}
			swap(i,piv);
		}
	}
	
	public void bubbleFrequencies() {
		ListNode j=null;
		ListNode piv=null;
		
		for (ListNode i=head;i!=null;i=i.next) {
			int max =Integer.MIN_VALUE;
			
			for(j=i;j!=null;j=j.next) {
				
				if(j.n>max) {
					max=j.n;
					piv=j;
				}
			}
			swap(i,piv);
		}
	}
	
	static void swap(ListNode i,ListNode j) {
		try {
			char tmpChar=i.data;
			int tmpNum=i.n;
			
			i.data=j.data;
			i.n=j.n;
			j.data=tmpChar;
			j.n=tmpNum;
		}catch(NullPointerException e1) {
			e1.printStackTrace();
		}
		
	}
	
	private boolean isEmpty() {
		
		if(head==null && tail==null) return true;
		return false;
	}
	
	public int size() {
		return listSize;
	}
	
}


class ListNode{
	public char data;
	public int n;
	public ListNode next;
	public ListNode prev;
}
