import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int n;
	private int size;
	private WeightedQuickUnionUF wqu;
	private int a[][]; // value = 0 => closed site and 1 => open site
	private int numOpenSites;

	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		this.n = n;
		size = 2 + n * n;
		a = new int[n][n];
		numOpenSites = 0;
		wqu = new WeightedQuickUnionUF(size);
	}

	public void open(int row, int col) {
		validateIndices(row, col);
		if (a[row - 1][col - 1] == 0) {
			a[row - 1][col - 1] = 1;
			numOpenSites++;
			connectTop(row , col);
			connectRight(row , col);
			connectBottom(row , col);
			connectLeft(row , col);
			if(row == 1)
				wqu.union(0 , xyTo1D(row , col));
			if(row == n)
				wqu.union(size - 1 , xyTo1D(row , col));
		}
	}

	public boolean isOpen(int row, int col) {
		validateIndices(row, col);
		// is site (row, col) open?
		return a[row - 1][col - 1] == 1;
	}

	public boolean isFull(int row, int col) {
		validateIndices(row, col);
		return wqu.connected(0 , xyTo1D(row , col)) && isOpen(row , col);
	}

	public int numberOfOpenSites() {
		return numOpenSites;
	}

	public boolean percolates() {
		return wqu.connected(0 , size - 1);
	}

	private int xyTo1D(int x, int y) {
		return (x - 1) * n + y;
	}

	private void connectTop(int x , int y) {
		int aX = x - 1;
		int aY = y - 1;
		if (aX > 0) {
			if (a[aX - 1][aY] == 1)
				wqu.union(xyTo1D(x - 1, y), xyTo1D(x, y));
		}

	}

	private void connectRight(int x , int y) {
		int aX = x - 1;
		int aY = y - 1;
		if (aY < n - 1) {
			if (a[aX][aY + 1] == 1)
				wqu.union(xyTo1D(x, y + 1), xyTo1D(x, y));
		}
	}

	private void connectBottom(int x, int y) {
		int aX = x - 1;
		int aY = y - 1;
		if (aX < n - 1) {
			if (a[aX + 1][aY] == 1)
				wqu.union(xyTo1D(x + 1, y), xyTo1D(x, y));
		}
	}

	private void connectLeft(int x, int y) {
		int aX = x - 1;
		int aY = y - 1;
		if (aY > 0) {
			if (a[aX][aY - 1] == 1)
				wqu.union(xyTo1D(x, y - 1), xyTo1D(x, y));
		}
	}

	private void validateIndices(int row, int col) {
		if (row < 1 || row > n || col < 1 || col > n)
			throw new IndexOutOfBoundsException();
	}

	public static void main(String[] args) {
		// test client (optional)
	}
}