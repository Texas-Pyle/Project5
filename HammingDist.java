//Complete this...
import  java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HammingDist{
	
	
	public HammingDist()  {
		
	}
	
	public static int distCalculator(String stationA ,String stationB) {
		final int stationLength = 4;
		char[] stationOne = stationA.toCharArray();
		char[]  stationTwo = stationB.toCharArray();
		int hammingDistance = 0;
		for (int i = 0; i < stationLength; ++i) { 
				if (stationOne[i] != stationTwo[i]) 
					hammingDistance += 1;
		}
		return hammingDistance;

	}
	


	public static int simmilarDistance(String stationA ,String stationB , int desieredHammingDistance) {
		int numStations = 0;
		if (distCalculator(stationA, stationB) == desieredHammingDistance)
			numStations++;
		return numStations;
	}
	
	
}