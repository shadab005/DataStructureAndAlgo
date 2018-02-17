class Node{
	public int data;
	public Node next;
	public Node(int data){
		this.data=data;
	}
}

public class LinkedList {
	
	Node head=null;
	Node tail=null;
	
	public  void insertAtEnd(int data)
	{
		if(head==null)
		{
			head=new Node(data);
			tail=head;
		}
		else
		{
			tail.next=new Node(data);
			tail=tail.next;
		}
	}
	
	public void displayLinkedList()
	{
		for(Node temp=head;temp!=null;temp=temp.next)
		{
			System.out.print(temp.data+"->");
		}
		System.out.print("NULL");
		System.out.println();
	}

	public void deleteNode(int data)
	{
		if(head==null)return;//empty
		else
		{
			if(head.data==data)
			{
				head=head.next;
			}
			else
			{
				Node prev=head;
				Node curr=head.next;
				while(curr!=null && curr.data!=data)
				{
					prev=curr;
					curr=curr.next;
				}
				if(curr==null)
					return; //not found
				if(curr.data==data)
				{
					prev.next=curr.next;
				}
			}
		}
	}
	
	public void search(int data)
	{
		int found=-1;
		if(head==null)System.out.println("empty");
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				if(temp.data==data)
				{
					found=0;
					temp=null;
				}
				else
					temp=temp.next;
			}
			if(found!=0)System.out.println("not found");
			else System.out.println("found");
		}
	}
	
	public void printReverse(Node head)
	{
		if(head==null)return;
		if(head.next==null)System.out.print(head.data+" ");
		else
		{
			printReverse(head.next);
			System.out.print(head.data+" ");
		}
	}
	
	public void reverseLinkedList()
	{
		Node temp=null;
		Node curr=head;
		if(curr!=null)
		{
			while(curr.next!=null)
			{
				head=curr.next;
				curr.next=temp;
				temp=curr;
				curr=head;
			}
			curr.next=temp;
		}
		else return ;
		
	}
	public void insertAtPosition(int data,int pos)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=null;
		}
		else
		{
			Node prev=null;
			Node curr=head;
			for(int i=0;i<pos;++i)
			{
				prev=curr;
				curr=curr.next;
			}
			if(pos==0)
			{
				newNode.next=curr;
				head=newNode;
			}
			else
			{
				newNode.next=prev.next;
				prev.next=newNode;
			}
		}
	}
	
	public void deleteAtPosition(int pos)
	{
		if(pos==0)
		{
			head=head.next;
		}
		else
		{
			Node prev=head;
			Node dnode=head.next;
			for(int i=1;i<pos;++i)
			{
				prev=dnode;
				dnode=dnode.next;
			}
			prev.next=dnode.next;
			dnode.next=null;
		}
	}
	
	
	public Node reversetry2()
	{
		if(head==null)return head;
		if(head.next==null)return head;
		else
		{
			Node temp=head;
			head=head.next;
			Node curr=reversetry2();
			curr.next=temp;
			return temp;
		}
	}
	
	public Node reverseLinkedListRecursively()
	{
		Node temp=reversetry2();
		temp.next=null;
		head=tail;
		tail=temp;
		return head;
	}
	
	public static void main(String[] args) {
		
		LinkedList obj=new LinkedList();
		obj.insertAtEnd(2);
		obj.insertAtEnd(3);
		obj.insertAtEnd(4);
		obj.displayLinkedList();
		
		LinkedList l2 = new LinkedList();
		l2.insertAtEnd(7);
		l2.insertAtEnd(8);
		l2.insertAtEnd(9);
		l2.displayLinkedList();
		
		obj.displayLinkedList();
		//obj.deleteNode(3);
		
		
		
		
		
		
				
	}

}
