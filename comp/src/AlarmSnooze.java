import java.util.Scanner;

public class AlarmSnooze {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int hh = in.nextInt();
		int mm = in.nextInt();
		Time t = new Time(hh, mm);
		int ans = 0;
		while(!t.containsSeven()) {
			ans++;
			t.reduceTime(x);
		}
		System.out.println(ans);
		in.close();

	}

	static class Time {
		int hh;
		int mm;

		Time(int h, int m) {
			hh = h;
			mm = m;
		}

		public boolean containsSeven() {
			String s = hh+""+mm;
			if(s.contains("7"))return true;
			return false;
		}

		public void reduceTime(int x) {
			if (x == 60) {
				reduceHourByOne();
			} else if (mm >= x) {
				mm = mm - x;
			} else {
				int d = x - mm;
				mm = 60 - d; // 23:02 - 4 min = 23 : 58 , 00:02
				reduceHourByOne();
			}
		}

		private void reduceHourByOne() {
			if (hh == 0) {
				hh = 23;
			} else {
				hh--;
			}
		}
	}

}
