import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private double x[];
	private int trials;
	private Percolation percs[];

	public PercolationStats(int n, int trials){
		if (n <= 0 || trials <= 0) throw new java.lang.IllegalArgumentException();
		x = new double[trials];
		this.trials = trials;
		percs = new Percolation[trials];
		for(int i = 0; i < trials ; i++) percs[i] = new Percolation(n);
		// perform trials independent experiments on an n-by-n grid
	}

	public double mean() {
		// sample mean of percolation threshold
		return StdStats.mean(x);
	}

	public double stddev() {
		// sample standard deviation of percolation threshold
		return StdStats.stddev(x);
	}

	public double confidenceLo() {
		// low endpoint of 95% confidence interval
		return mean() - 1.96 * stddev() / (Math.sqrt(trials));
	}

	public double confidenceHi() {
		// high endpoint of 95% confidence interval
		return mean() + 1.96 * stddev() / (Math.sqrt(trials));
	}

	public static void main(String[] args) {
		// test client (described below)
		int n = Integer.parseInt(args[0]); // n-by-n percolation system
		int trials = Integer.parseInt(args[1]); // n-by-n percolation system
		if (n <= 0 || trials <=0) throw new java.lang.IllegalArgumentException();
		PercolationStats pcs = new PercolationStats(n, trials);
		int k = 0, i = 0, j = 0;		
		for(Percolation perc: pcs.percs){
			while (!perc.percolates()) {
				i = StdRandom.uniform(n) + 1;
				j = StdRandom.uniform(n) + 1;
				if (!perc.isOpen(i, j)) {
					perc.open(i, j);
				}
			}
			pcs.x[k++] = perc.numberOfOpenSites() * 1.0 / (n * n);
		}
		StdOut.println("mean                    = " + pcs.mean());
		StdOut.println("stddev                  = " + pcs.stddev());
		StdOut.println("95% confidence interval = " + pcs.confidenceLo() + ", " + pcs.confidenceHi());

	}
}