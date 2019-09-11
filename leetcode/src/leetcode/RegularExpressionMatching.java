package leetcode;


/*
 * ab*.bbc , abbbbc
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		String p  = "ab*c*bbd";
		DFA dfa = DFA.creataDFA(p);
		
		System.out.println(dfa);
		System.out.println(dfa.canAccept("abbd"));
		System.out.println(dfa.canAccept("abbcbbd"));

	}


}

class DFA {
	private State start;
	private State terminal;
	
	private DFA() {
		start = new State();
		terminal = new State();
	}
	
	/*
	 * Creatiing DFA for simple regular expression only with * and .
	 * No bracket or any other character
	 */
	public static DFA creataDFA(String s) {
		DFA dfa = new DFA();
		State current = dfa.start;
		for(int i = 0; i <s.length();i++) {
			char c = s.charAt(i);
			String input = String.valueOf(c);
			if(i < s.length()-1 && s.charAt(i+1) == '*') {
				input+="*";
				i++;
			}
			State next = new State();
			current.addTransitionRule(input, next);
			current = next;
		}
		dfa.terminal = current;
		return dfa;
	}
	
	public boolean canAccept(String input) {
		State current = start;
		final char empty = '\0';
		char starChar = empty;
		int i=0;
		for(;i<input.length();i++) {
			System.out.println("Iteration = "+i +  " Input = " + input.charAt(i) + " state = " + current);
			if(current.isStarred()) {
				starChar = current.getCurrentChar();
				int j = i;
				while(j<input.length() && input.charAt(j) == starChar)j++;
				int countStarCharInput = j-i;
				int fixedStartChar = 0;
				while(current!=null && current.getCurrentChar() == starChar) {
					if(!current.isStarred())fixedStartChar++;
					current = current.nextState;
				}
				if(fixedStartChar > countStarCharInput)return false;
				if(j==input.length() && current == terminal) return true;
				i=j-1;				
			} else {
				current = current.apply(String.valueOf(input.charAt(i)));
				if(current == null) {
					return false;
				}
			}
		}
		System.out.println("End " + current);
		return i>=input.length() && current == terminal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		State current = start;
		//for(int i=0; i<size;i++)
		while(current!=terminal)
		{
			sb.append(current);
			current = current.nextState;
		}
		sb.append(current);
		return sb.toString();
	}
}

class State {
	private static int id = 0;
	private String label;
	String input;
	State nextState;
	public State() {
		label = "q"+id;
		id++;
	}
	boolean isStared;
	char currentChar;
	
	public State apply(String s) {
		return (s.equals(input) || currentChar == '.')?nextState:null;
	}
	
	public void addTransitionRule(String s, State next) {
		isStared = s.contains("*");
		input = s;
		currentChar = s.charAt(0);
		nextState = next;
	}
	
	public String getInput() {
		return input;
	}
	
	public State getNextState() {
		return nextState;
	}
	
	public boolean isStarred() {
		return isStared;
	}
	
	public char getCurrentChar() {
		return currentChar;
	}
	
	@Override
	public String toString() {
		return label + " --" +"[" + input +  "]--> ";
	}
}
