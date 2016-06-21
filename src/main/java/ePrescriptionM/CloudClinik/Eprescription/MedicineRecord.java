package ePrescriptionM.CloudClinik.Eprescription;

public class MedicineRecord {

	private String diagnosis;
	private String medicine;
	private String doze;
	private String frquency;
	private String Duration;
	private String Route;
	private String Refills;
	
	public MedicineRecord(String diag,String med,String doz,String freq,String dur,String rout,String ref){
		diagnosis=diag;
		medicine=med;
		doze=doz;
		frquency=freq;
		Duration=dur;
		Route=rout;
		Refills=ref;
	}
	
	public String getDiagnosis(){
		
		return diagnosis;
	}
	
	public String getMedicine(){
		return medicine;
		
	}

	public String getDoze(){
		return doze;
		
	}
	
	public String getfrquency(){
		return frquency;
	}
	
	public String getDuration(){
		return Duration;
	}
	
	public String getRefills(){
		return Refills;
	}
		
	public String getRoute(){
		return Route;
	}
		
}
