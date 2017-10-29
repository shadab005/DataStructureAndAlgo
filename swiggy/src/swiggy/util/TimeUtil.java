package swiggy.util;

import java.util.Date;

public class TimeUtil {
	
	private final static long SECOND_MILLIS = 1000;
    private final static long MINUTE_MILLIS = SECOND_MILLIS*60;
    private final static long HOUR_MILLIS = MINUTE_MILLIS*60;
    
    
    public static int hoursDiff(Date earlierDate, Date laterDate) {
		if (earlierDate == null || laterDate == null)
			return 0;

		return (int) ((laterDate.getTime() / HOUR_MILLIS) - (earlierDate.getTime() / HOUR_MILLIS));
    }

}
