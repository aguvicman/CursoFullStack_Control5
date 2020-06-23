package cl.icap.cursofullstack.Control5.service;

public class AvgService {
	private String values[];
	
	public AvgService() {
	}
	
	public int computeAvg(String s) {
		int vret = 0;
		int acum = 0;
		String[] arrOfStr = s.split(",");
		
	    for (int i=0; i<arrOfStr.length; i++) {
	    	acum+=Integer.parseInt(arrOfStr[i]);
	    }

	    vret = Math.round(acum/arrOfStr.length);
		
		return vret;
	}
	
}
