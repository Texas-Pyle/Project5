
public class MesoAsciiCal {
	private String StID;
	public MesoAsciiCal (String StID) {
		this.StID = StID;
	}


public	int calAverage() {
		char[] StIdCharArray = StID.toCharArray();
		double asciiAverage = 0;
		for (int i = 0; i < StIdCharArray.length; ++i) {
			asciiAverage += (int)StIdCharArray[i];
		}
		asciiAverage = asciiAverage/4;
		if ((asciiAverage) - Math.floor(asciiAverage ) >= 0.25) {
			asciiAverage = Math.ceil( asciiAverage );
		}else {
			asciiAverage = Math.floor(asciiAverage );
		} 
		return (int)(asciiAverage + 79)/2; 
	}
}
