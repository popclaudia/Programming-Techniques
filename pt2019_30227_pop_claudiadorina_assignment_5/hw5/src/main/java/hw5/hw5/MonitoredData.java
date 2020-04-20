package hw5.hw5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonitoredData {
	String startTime;
	String endTime;
	String activity;

	public MonitoredData(String startTime, String endTime, String activity) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getStartDate() {
		return startTime.substring(0, 10);
	}


	public String getEndTime() {
		return endTime;
	}


	public String getActivity() {
		return activity;
	}

	public long getDuration() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime d1 = LocalDateTime.parse(startTime, format);
		LocalDateTime d2 = LocalDateTime.parse(endTime, format);

		long minutes = ChronoUnit.MINUTES.between(d1, d2);

		return minutes;
	}

	public int filter(List<MonitoredData> md,String s) {
		int a[] = new int[9];
		int b[] = new int[9];

		for (MonitoredData i : md) {
			switch (i.getActivity()) {
			case "Sleeping":
				a[0]++;
				if (i.getDuration() < 5)
					b[0]++;
				break;
			case "Toileting	":
				a[1]++;
				if (i.getDuration() < 5)
					b[1]++;
				break;
			case "Showering	":
				a[2]++;
				if (i.getDuration() < 5)
					b[2]++;
				break;
			case "Breakfast	":
				a[3]++;
				if (i.getDuration() < 5)
					b[3]++;
				break;
			case "Grooming	":
				a[4]++;
				if (i.getDuration() < 5)
					b[4]++;
				break;
			case "Spare_Time/TV":
				a[5]++;
				if (i.getDuration() < 5)
					b[5]++;
				break;
			case "Leaving	":
				a[6]++;
				if (i.getDuration() < 5)
					b[6]++;
				break;
			case "Lunch":
				a[7]++;
				if (i.getDuration() < 5)
					b[7]++;
				break;
			case "Snack	":
				a[8]++;
				if (i.getDuration() < 5)
					b[8]++;
				break;
			default:
				break;
			}
		}
		
			switch (s) {
			case "Sleeping":
				if(b[0]>=0.9*a[0])
					return 1;
				break;
			case "Toileting	":
				if(b[1]>=0.9*a[1])
					return 1;
				break;
			case "Showering	":
				if(b[2]>=0.9*a[2])
					return 1;
				break;
			case "Breakfast	":
				if(b[3]>=0.9*a[3])
					return 1;
				break;
			case "Grooming	":
				if(b[4]>=0.9*a[4])
					return 1;
				break;
			case "Spare_Time/TV":
				if(b[5]>=0.9*a[5])
					return 1;
				break;
			case "Leaving	":
				if(b[6]>=0.9*a[6])
					return 1;
				break;
			case "Lunch":
				if(b[7]>=0.9*a[7])
					return 1;
				break;
			case "Snack	":
				if(b[8]>=0.9*a[8])
					return 1;
				break;
			default:
				break;
			}

		return 0;

	}


	@Override
	public String toString() {
		return startTime + "       " + endTime + "       " + activity;
	}

}
