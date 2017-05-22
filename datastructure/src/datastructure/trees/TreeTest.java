package datastructure.trees;

public class TreeTest {

	public static void main(String[] args) {
		testBTree2();
	}
	
	public static void testBTree3(){
		BTree b = new BTree();
		b.insert(3 );
		b.insert(7 );
		b.insert(9 );
		b.insert(23);
		b.insert(45);
		b.insert(1 );
		b.insert(5 );
		b.insert(14);
		b.insert(25);
		b.insert(24);
		b.insert(13);
		b.insert(11);
		b.insert(8 );
		b.insert(19);
		b.insert(4 );
		b.insert(31);
		b.insert(35);
		b.insert(56);
		b.insert(2);
		b.insert(6);
		b.insert(12);
		//2, 6,12

	}
	public static void testBTree2() {

		BTree b = new BTree();
		b.insert(0);
		b.insert(5);
		b.insert(6);
		b.insert(1);
		b.insert(10);
		b.insert(3);
		b.insert(7);
		b.insert(12);
		b.insert(9);
		b.insert(4);
		b.insert(18);
		b.insert(8);
		b.insert(17);
		b.insert(23);
		b.insert(2);
		b.insert(11);
		b.insert(13);
		b.insert(19);
		b.insert(20);
		b.insert(15);

		// 9 2 5 12 17 0 1 3 4 6 7 8 10 11 13 15 18 19 20 23
		b.traverse();
		b.delete(7);
		b.delete(17);
		b.delete(15);
		b.delete(3);
		b.delete(4);
		b.delete(6);
		b.delete(5);
		b.delete(8);
		b.delete(20);
		b.delete(10);
		b.delete(9);
		b.delete(12);
		b.delete(2);
		b.delete(18);
		b.delete(19);
		b.delete(11);
		b.delete(23);
		b.delete(1);
		b.delete(0);
		b.delete(13);
		b.traverse();
		BTree.Node search = b.search(b.root, 13);
		b.traverseNodeData(search);

		/*
		                9
		       2        5                   12          19
		       0 1      3  4     6 8        10 11       13 18   20 23 
		*/
		
	}

	public static void testBTree1() {

		BTree b = new BTree();
		b.insert(0);
		b.insert(5);
		b.insert(6);
		b.insert(1);
		b.insert(10);
		b.insert(3);
		b.insert(7);
		b.insert(12);
		b.insert(9);
		b.insert(4);
		b.insert(18);
		b.insert(8);
		b.insert(17);
		b.insert(23);
		b.insert(2);
		b.insert(11);
		b.insert(13);
		b.insert(19);
		b.insert(20);
		b.insert(15);
		/*
		b.delete(7);
		b.delete(17);
		b.delete(15);
		b.delete(3);
		*/

		// 9 2 5 12 17 0 1 3 4 6 7 8 10 11 13 15 18 19 20 23
		b.traverse();
		BTree.Node search = b.search(b.root, 5);
		b.traverseNodeData(search);
		/*
		                       9
		       2        5                   12       17
		   0 1    3  4     6 7 8     10 11    13  15     18 19 20 23 
		*/
	}

}
