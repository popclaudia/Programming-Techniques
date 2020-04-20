package hw5.hw5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) throws ParseException {
		List<MonitoredData> monitoredData = new ArrayList<MonitoredData>();

		String file = "Activities.txt";

		/**
		 * Get data from file
		 */
		try (Stream<String> stream = Files.lines(Paths.get(file))) {

			monitoredData = stream.map(line -> line.split("\t\t")).map(a -> new MonitoredData(a[0], a[1], a[2]))
					.collect(Collectors.toList());

		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println("0.");
		for (MonitoredData m : monitoredData) {
			System.out.println(m);
		}

		/**
		 * count days
		 */
		long difDatesNr = monitoredData.stream().map(MonitoredData::getStartTime).map(line -> line.split(" "))
				.map(a -> new String(a[0])).distinct().count();
		System.out.println("1.There are " + difDatesNr + " days of monitored data.\n");

		/**
		 * Count different activities
		 */
		Map<String, Long> act = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting()));
		System.out.println("2.");
		for (Map.Entry<String, Long> i : act.entrySet())
			System.out.println("  " + i.getKey() + "  " + i.getValue());

		/**
		 * Count different activities / day
		 */
		Map<String, Map<String, Long>> map = monitoredData.stream().collect(Collectors.groupingBy(
				MonitoredData::getStartDate, Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting())));

		System.out.println("\n3.");
		for (Map.Entry<String, Map<String, Long>> i : map.entrySet())
			System.out.println("  " + i.getKey() + "  " + i.getValue());

		/**
		 * activity duration
		 */
		List<Object> dur = monitoredData.stream().flatMap(p -> Stream.of(p.getActivity(), p.getDuration()))
				.collect(Collectors.toList());

		System.out.println("\n4.");
		for (Object i : dur) {
			System.out.println("  " + i);
		}

		/**
		 * total duration
		 */
		Map<String, Long> tDuration = monitoredData.stream().collect(
				Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingLong(MonitoredData::getDuration)));
		System.out.println("\n5.");
		for (Entry<String, Long> i : tDuration.entrySet())
			System.out.println("  " + i.getKey() + "  " + i.getValue());

		/**
		 * filter
		 */
		System.out.println("\n6.");
		final List<MonitoredData> f = monitoredData;
		Iterator i;
		monitoredData.stream().filter(a -> a.filter(f, a.getActivity()) == 1).map(MonitoredData::getActivity).distinct()
				.forEach(System.out::println);

	}
}
