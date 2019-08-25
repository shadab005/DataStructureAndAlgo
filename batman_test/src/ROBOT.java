import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ROBOT {

	// out : (chance-1)%c[i].length
	static HashMap<Character, Character> winner = new HashMap<>();

	public static void main(String[] args) {
		winner.put('R', 'P');
		winner.put('P', 'S');
		winner.put('S', 'R');
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int a = in.nextInt();
			String[] c = new String[a];
			int maxLength = 0;
			for (int i = 0; i < a; i++) {
				c[i] = in.next();
				maxLength = Math.max(c[i].length(), maxLength);
			}
			solve(caseNo, c, maxLength);
			caseNo++;
		}
		in.close();

	}

	private static void solve(int caseNo, String[] c, int maxLength) {

		int chance = 1;
		String ans = "";
		boolean isDead[] = new boolean[c.length];
		while (chance <= 1000) {
			HashSet<Character> s = new HashSet<>();
			for (int i = 0; i < c.length; i++) {
				if (!isDead[i]) {
					s.add(c[i].charAt((chance - 1) % c[i].length()));
				}
			}
			if (s.size() == 3) {
				System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");
				return;
			} else if (s.size() == 1) {
				ans += winner.get(s.toArray()[0]);
				System.out.println("Case #" + caseNo + ": " + ans);
				return;
			} else {
				if (s.contains('R') && s.contains('P')) {
					//all those entries with R are dead now
					kill(c,'R', isDead, chance);
					ans += 'P';
				} else if (s.contains('R') && s.contains('S')) {
					//all those entries with R are dead now
					kill(c,'S', isDead, chance);
					ans += 'R';
				} else if (s.contains('S') && s.contains('P')) {
					//all those entries with R are dead now
					kill(c,'P', isDead, chance);
					ans += 'S';
				}
			}
			chance++;
		}
		System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");
	}

	private static void kill(String[] c, char ch, boolean[] isDead, int chance) {
		for (int i = 0; i < c.length; i++) {
			if (!isDead[i]) {
				if(c[i].charAt((chance - 1) % c[i].length()) == ch) {
					isDead[i] = true;
				}
			}
		}
		
	}

}
