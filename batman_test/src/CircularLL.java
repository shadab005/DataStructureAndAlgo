class CNode{
	public int data;
	public CNode next;
	public CNode(int data){
		this.data=data;
	}
}
public class CircularLL {

	CNode head=null;
	CNode tail=null;
	
	public void insert(int data)
	{
		if(head==null)
		{
			head=new CNode(data);
			tail=head;
			tail.next=head;
			
		}
		else
		{
			CNode temp=new CNode(data);
			tail.next=temp;
			temp.next=head;
			tail=temp;
			
			
		}
	}
	public void alive(CNode head)
	{
		CNode t1=head;
		CNode prev=null;
		CNode curr=null;
		while(t1.next!=t1)
		{
			prev=t1;
			curr=t1.next;
			prev.next=curr.next;
			//curr.next=null;
			t1=prev.next;
		}
		System.out.println(t1.data);
	}
	public static void main(String[] args) {
		
		CircularLL c1=new CircularLL();
		for(int i=1;i<=100;++i)
		{
			c1.insert(i);
		}
		c1.alive(c1.head);
	}

}