import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataPrep {
	public static void main(String[] args) {
		
		// Date d1 = new Date(2000, 11, 21); 

        String pattern = "yyyy-MM-dd";
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        int y = 2010;
        int m = 1;
        int d = 15;
        
        List<String> finalData = new ArrayList<>();

       List<String> assetIds = getData();
       for(int counter = 0; counter <140; counter++) {
           int randomYearIncrement = random(0, 10);
    	   int randomMonthIncrement = random(0,8);
    	   int randomDateIncrement = random(0,15);
    	   
    	   int year = y+randomYearIncrement;
    	   int month = m + randomMonthIncrement;
    	   int date = d + randomDateIncrement;
		   
    	   String s = assetIds.get(counter);
    	   int monthlyRecurringAmount = (int)(100*Math.random());
    	   StringBuilder sbI = new StringBuilder();
		   sbI.append(s).append(","); //assetId
		   sbI.append(random(1, 10)).append(","); //asset action amount
		   sbI.append(parseDate(year, month, date)).append(","); //custom date
		   sbI.append(parseDate(year, month, date)).append(",");  //action date
		   sbI.append(monthlyRecurringAmount).append(",");
		   sbI.append("Initial Sale").append(","); //Category
		   sbI.append("NO").append(","); //Notification
		   sbI.append("POSTED").append(","); //Status
		   sbI.append(random(1, 10)).append(","); //quantity change
		   sbI.append("GENERATE"); //type
		   System.out.println(sbI.toString());
		   
    	   for(int i = 0 ; i< 5; i++) {
        	   randomMonthIncrement = random(0,8);
        	   randomDateIncrement = random(0,15);
        	   month = m + randomMonthIncrement;
        	   date = d + randomDateIncrement;
    		   StringBuilder sb = new StringBuilder();
    		   sb.append(s).append(","); //assetId
    		   sb.append(random(1, 10)).append(","); //asset action amount
    		   sb.append(parseDate(year, month, date)).append(",");  //custom date
    		   sb.append(parseDate(year, month, month)).append(",");  //action date
    		   sb.append(monthlyRecurringAmount).append(",");
    		   sb.append("UpSells").append(","); //Category
    		   sb.append("YES").append(","); //Notification
    		   sb.append("POSTED").append(","); //Status
    		   sb.append(random(1, 10)).append(","); //quantity change
    		   sb.append("CHANGE"); //type
    		   System.out.println(sb.toString());
    	   }
       }
       
       for(int counter = 0; counter <60; counter++) {
    	   int randomYearIncrement = random(0, 10);
    	   int year = y+randomYearIncrement;
    	   int randomMonthIncrement = random(0,8);
    	   int randomDateIncrement = random(0,15);
    	   int month = m + randomMonthIncrement;
    	   int date = d + randomDateIncrement;
    	   
    	   String s = assetIds.get(counter + 140);
    	   int monthlyRecurringAmount = (int)(100*Math.random());
    	   StringBuilder sb = new StringBuilder();
    	   sb.append(s).append(","); //assetId
    	   sb.append(random(1, 10)).append(","); //asset action amount
    	   sb.append(parseDate(year, month, date)).append(",");  //custom date
    	   sb.append(parseDate(year, month, date)).append(",");  //action date
    	   sb.append(monthlyRecurringAmount).append(",");
    	   sb.append("Initial Sale").append(","); //Category
    	   sb.append("No").append(","); //Notification
    	   sb.append("Posted").append(","); //Status
    	   sb.append(random(1, 10)).append(","); //quantity change
    	   sb.append("GENERATE"); //type
		   System.out.println(sb.toString());
		   
    	   for(int i = 0 ; i< 5; i++) {
    		   month = m + randomMonthIncrement;
        	   date = d + randomDateIncrement;
        	   
    		   sb = new StringBuilder();
    		   sb.append(s).append(","); //assetId
    		   sb.append(random(1, 10)).append(","); //asset action amount
    		   sb.append(parseDate(year, month, date)).append(","); //custom date
    		   sb.append(parseDate(year, month, date)).append(",");  //action date
    		   sb.append(monthlyRecurringAmount).append(",");
    		   sb.append("UpSells").append(","); //Category
    		   sb.append("Yes").append(","); //Notification
    		   sb.append("Draft").append(","); //Status
    		   sb.append(random(1, 10)).append(","); //quantity change
    		   sb.append("CHANGE"); //type
    		   System.out.println(sb.toString());
    	   }
       }
  

    }
	
	//2020-01-24T10:50:25.000Z
	public static String parseDate(int year, int month, int day) {
		if (day > 28)
			day = 28;
		String dayX = "" + day;
		if (day < 10) {
			dayX = "0" + day;
		}
		String monthX = "" + month;
		if (month < 10) {
			monthX = "0" + month;
		}
		return year + "-" + monthX + "-" + dayX + "T10:50:25.000Z";
	}
	
	private static int random(int min, int max) {
		max++;
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	
	
	static List<String> getData() {
		String csvFile = "/Users/shassan/Downloads/assetId.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<String> data = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				data.add(line.split(cvsSplitBy)[0]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	
	
	
}
