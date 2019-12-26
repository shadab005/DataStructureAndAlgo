package leetcode;

import algo.util.Util;

public class _838_PushDominoes {

	public static void main(String[] args) {
		System.out.println(pushDominoes("RR.L"));

	}

	
	static public String pushDominoes(String dominoes) {
		//System.out.println(dominoes.length());
		//Util.printArray(dominoes.toCharArray());
        int n = dominoes.length();
        if(n==0) return "";
        if(n==1) return dominoes;
        
        int i = 0, j = 0;
        char c[] = new char[n];
        int lastSeenR = Integer.MIN_VALUE;
        int nextSeenL = Integer.MAX_VALUE;
        while(j < n && dominoes.charAt(j) == '.') j++;
        if(j == n) return dominoes;
        if(j == i) j++;
        
        if(dominoes.charAt(j) == 'L') {
        	nextSeenL = j;
        }
        
        while(j<n) {
        	//System.out.println("Loop i = " + i + " j = " + j);
        	if(dominoes.charAt(i) == '.') {
        		if(nextSeenL == Integer.MAX_VALUE && lastSeenR == Integer.MIN_VALUE) {
        			c[i] = '.';
        		} else if(nextSeenL == Integer.MAX_VALUE) {
        			c[i] = 'R';
        		} else if(lastSeenR == Integer.MIN_VALUE) {
        			c[i] = 'L';
        		} else  {
        			if(nextSeenL-i < i-lastSeenR) {
        				c[i] = 'L';
        			} else if(nextSeenL-i > i-lastSeenR) {
        				c[i] = 'R';
        			} else {
        				c[i] = '.';
        			}
        		}
        	} else {
        		c[i] = dominoes.charAt(i);
        		if(c[i] == 'L') {
        			lastSeenR = Integer.MIN_VALUE;
        		} else {
        			lastSeenR = i;
        		}
        	}
        	i++;
        	if(i==j) {
        		j++;
        		while(j < n && dominoes.charAt(j) == '.') j++;
        		if(j<n) {
        			if(dominoes.charAt(j) == 'L') {
        	        	nextSeenL = j;
        	        } else {
        	        	nextSeenL = Integer.MAX_VALUE;
        	        }
        		} else {
        			nextSeenL = Integer.MAX_VALUE;
        		}
        	}
        }
        // Util.printArray(c);
       // System.out.println("i=" + i + " j = " + j + " lastSeenR = " + lastSeenR + " nextSeenL = " + nextSeenL);
        if(i<n) {
        	if(dominoes.charAt(i) == 'R') lastSeenR = i;
        	else if(dominoes.charAt(i) == 'L') lastSeenR = Integer.MIN_VALUE;
        	if(lastSeenR == Integer.MIN_VALUE) {
        		while(i<n) {
        			c[i] = dominoes.charAt(i);
        			i++;
        		}
        	} else {
        		while(i<n) {
        			c[i] = 'R';
        			i++;
        		}
        	}
        }
        return String.valueOf(c);
    }
}
