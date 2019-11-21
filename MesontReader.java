import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesontReader {
	public String subStringforMesonet(String rawData) {
		String stationName = "";
		char[] rawDataCharArray = rawData.toCharArray();
		for (int i =0; i < rawDataCharArray.length; ++i) {
			int startIndex;
			if (Character.isWhitespace(rawDataCharArray[i]) ==false) { 
				startIndex = i;
				stationName = rawData.substring(startIndex,startIndex+4);
				break;
			}
		}
		return stationName; 
	}
	public ArrayList<String> fileReader() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		br.readLine();
		br.readLine();
		String currentLine = br.readLine();
		ArrayList<String> stationNames = new ArrayList();
		while (currentLine != null) {
			String stationName = subStringforMesonet(currentLine);
			stationNames.add(stationName);
			
			currentLine = br.readLine();
			 
		}
		return stationNames;
	}
}
