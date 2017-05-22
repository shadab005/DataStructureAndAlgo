package datastructure.linkedlist;

public class LList {
  public Node head;
  
  Node getNode(int data){
	  Node n = new Node(data);
	  return n;
  }
  
  //insert at end
  public void add(int data){
	  Node n = new Node(data);
	  if(head==null){
		  head=n;
		  return;
	  }
	  Node temp = head;
	  while(temp.next != null){
		  temp = temp.next;
	  }
	  temp.next = n;
  }
  
  int size(){ 
	  int size = 0;
	  if(head != null){
		  Node temp = head;
		  while(temp != null)size++;
	  }	  
	  return size;
  }
  
  //o(n) and s(1)
  void reverse(){
	  Node prev = null;
	  Node current = head;
	  Node next = head;
	  while(next != null){// 1 2 3 4
		  next = current.next;
		  current.next = prev;
		  prev = current;
		  current = next;
	  }
	  
	  head = prev;
  }
  
  void reverseRecursive(Node prev, Node current){
	  if(current == null) {head = prev; return;}
	  Node next = current.next;
	  current.next = prev;
	  reverseRecursive(current, next);
  }
  
  Node revList(Node head)
  {
	  if(head == null || head.next == null ) return head;
	  Node head1 = revList(head.next);
	  head.next.next = head;
	  head.next = null;
	  return head1;
  }
  
  void revListMain(Node head)
  {
	  if(head == null || head.next == null ){this.head = head; return; }
	  Node rest = head.next;
	  revListMain(rest);
	  rest.next = head;
	  head.next = null;
  }
  
  public Node getMid(){
	  Node slow = head;
	  Node fast = head;
	  if(fast == null) return fast;
	  while(fast.next != null && fast.next.next != null){
		  slow = slow.next;
		  fast = fast.next.next;
	  }
	  return slow;
  }
  
  public Node getLastNode(){
	  if(head.next == null) return head;
	  Node node = head;
	  while(node.next != null){
		  node=node.next;
	  }
	  return node;
  }
  
  public Node insertInBetween(Node current){
		if(current == null) return this.head;
		Node headFromLeft = insertInBetween(current.next);
		if(headFromLeft == null) return null;
		Node nextHeadFromLeft = headFromLeft;
		if(headFromLeft.next != current && headFromLeft != current){
			nextHeadFromLeft = headFromLeft.next;
			headFromLeft.next = current;
			current.next = nextHeadFromLeft;
			
		}else if(headFromLeft.next == current || headFromLeft == current ){
			current.next = null;
			return null;
		}
		return nextHeadFromLeft;
  }
  public void insertInBetweenIterative(){
	  //size odd index from n/2 + 1 after node will get inserted
	  
  }
  
  public static void traverse(Node head){
	  String ret = "";
	  Node temp = head;
	  while(temp != null){
		  ret = ret + "["+temp.data + "] -->"; 
		  temp = temp.next;
	  }
	  ret = ret + "NULL";
	  System.out.println(ret);
  }
  
  @Override
  public String toString(){
	  String ret = "";
	  Node temp = head;
	  while(temp != null){
		  ret = ret + "["+temp.data + "] -->"; 
		  temp = temp.next;
	  }
	  ret = ret + "null";
	  return ret;
  }
  
  public static void main(String args[]){
	  LList l1 = new LList();
	  l1.add(5);
	  l1.add(7);
	  l1.add(9);
	  l1.add(11);
	  l1.add(13);
	  l1.add(15);
	  System.out.println(l1);
	  l1.insertInBetween(l1.head);
	  System.out.println(l1); 
	  
  }
  
}
