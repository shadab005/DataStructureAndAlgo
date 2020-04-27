import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AssetDataGenerator {

	static List<String> notifications = Arrays.asList("YES", "NO");
	static List<Integer> notificationDistributionPercentage = Arrays.asList(50, 50);
	
	static List<String> status = Arrays.asList("POSTED", "DRAFT");
	static List<Integer> statusDistributionPercentage = Arrays.asList(50, 50);
	
	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		int year = 2010;
		int month = 1;
		int day = 1;
		int y,m,d;
		List<String> assetIds = getData();
		for(String id : assetIds) {
			y = year;
			m = month;
			d = day;
			String initialSaleData = getInitialSaleData(id, y, m ,d);
			data.add(initialSaleData);
			//System.out.println(initialSaleData);
			int total = random(10,50);
			List<String> dates = getRandomdatesInOrder(total, 2011, 2019);
			for(int i = 0; i < total; i++) {
				String randomData = getRandomAssetData(id, dates.get(i)); 
				data.add(randomData);
				//System.out.println(randomData);
			}
			String predictionData = getPredictionData(id, y+10, m+random(1, 10) ,d+random(1, 15));
			data.add(predictionData);
			//System.out.println(predictionData);
		}
		
		System.out.println("Total data = " + data.size());
		writeData(data);

	}
	
	private static List<String> getRandomdatesInOrder(int total, int minYear, int maxYear) {
		List<String> dates = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			int randomYear = random(minYear, maxYear);
			int randomMonth = random(1, 12);
			int randomDate = random(1, 28);
			dates.add(parseDate(randomYear, randomMonth, randomDate));
		}
		dates.sort(null);
		return dates;
	}

	static String getRandomValue(List<String> values, List<Integer> probablilityDistribution) {
		int randomValue = random(1, 100);
		int sum = 0;
		for(int i =0; i<values.size();i++) {
			sum += probablilityDistribution.get(i);
			if(sum>=randomValue) return values.get(i);
		}
		System.out.println(values);
		System.out.println(probablilityDistribution);
		System.out.println(randomValue);
		System.out.println(sum);
		throw new RuntimeException("Wrong probability distribution is given");
	}

	private static String getRandomAssetData(String id, String date) {
		StringBuilder sbI = new StringBuilder();
		sbI.append(id).append(","); //assetId
		sbI.append(random(1, 10)).append(","); //asset action amount
		sbI.append(date).append(","); //custom date
		sbI.append(date).append(",");  //action date
		sbI.append(random(1, 100)).append(",");
		sbI.append("UpSells").append(","); //Category
		int notificationPercentageYes =  random(1, 100);
		int notificationPercentageNo = 100-notificationPercentageYes;
		String notificaltionValue = getRandomValue(notifications, Arrays.asList(notificationPercentageYes, notificationPercentageNo));
		sbI.append(notificaltionValue).append(","); //Notification
		if(notificaltionValue.equals("YES")) {
			int statusPercentageYes = random(60, 100);
			int statusPercentageNo = 100-statusPercentageYes;
			sbI.append(getRandomValue(status,  Arrays.asList(statusPercentageYes, statusPercentageNo))).append(","); //Status
		} else {
			int statusPercentageYes = random(1, 40);
			int statusPercentageNo = 100-statusPercentageYes;
			sbI.append(getRandomValue(status,  Arrays.asList(statusPercentageYes, statusPercentageNo))).append(","); //Status
		}
		sbI.append(random(1, 10)).append(","); //quantity change
		sbI.append("CHANGE").append(","); //type
		sbI.append("TRUE"); //is training data
		return sbI.toString();
	}
	
	private static String getPredictionData(String id, int year, int month, int day) {
		StringBuilder sbI = new StringBuilder();
		sbI.append(id).append(","); //assetId
		sbI.append(random(1, 10)).append(","); //asset action amount
		sbI.append(parseDate(year, month, day)).append(","); //custom date
		sbI.append(parseDate(year, month, day)).append(",");  //action date
		sbI.append(random(1, 100)).append(",");
		sbI.append("UpSells").append(","); //Category
	    sbI.append("YES").append(","); //Notification
	    sbI.append("POSTED").append(","); //Status
		sbI.append(random(1, 10)).append(","); //quantity change
		sbI.append("CHANGE").append(","); //type
		sbI.append("FALSE"); //is training data
		return sbI.toString();
	}
	
	
	
	
	private static String getInitialSaleData(String id, int year, int month, int day) {
		StringBuilder sbI = new StringBuilder();
		sbI.append(id).append(","); //assetId
		sbI.append(random(1, 10)).append(","); //asset action amount
		sbI.append(parseDate(year, month, day)).append(","); //custom date
		sbI.append(parseDate(year, month, day)).append(",");  //action date
		sbI.append(random(1, 100)).append(",");
		sbI.append("Initial Sale").append(","); //Category
		sbI.append(getRandomValue(notifications, notificationDistributionPercentage)).append(","); //Notification
		sbI.append("POSTED").append(","); //Status
		sbI.append(random(1, 10)).append(","); //quantity change
		sbI.append("GENERATE").append(","); //type
		sbI.append("TRUE"); //is training data
		return sbI.toString();
	}




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
	
	static void writeData(List<String> data) {
		try {
			Files.write(Paths.get("output.csv"), data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
