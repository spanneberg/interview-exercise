package process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Process {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		if ( args.length != 3 ) {
			System.err.printf("Not enough arguments!\n");
			System.err.printf("Example usage: %s myInputFile.txt 5\n", Process.class.getCanonicalName());
			System.exit(1);
		}
		
		String inputFile = args[1];
		int numberOfResults = Integer.valueOf(args[2]);
		// let's trust the java map implementation to take care of sorting most efficiently
		SortedMap<Long, String> result = new TreeMap<>(Collections.reverseOrder());

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				// split current line into URL and long value
				String[] urlValue = currentLine.split("\\s");

				// disregard lines that don't fit the format
				if (urlValue.length == 2) {

					String url = urlValue[0];
					long value = Long.parseLong(urlValue[1]);

					// fill the set while we are below the number of expected results
					if (result.size() < numberOfResults) {
						result.put(value, url);
					} else {
						// lastKey() is always the smallest item in the set due to reverse order
						// this allows for easily outputting descending order later
						long minValue = result.lastKey();
						// if the current value is bigger then the smallest one, replace smallest one w/ current value
						if ( value > minValue ) {
							result.remove(minValue);
							result.put(value, url);
						}
					}
				}
			}
			
			result.keySet().forEach(n -> { System.out.println(result.get(n)); } );
		}

	}
}
